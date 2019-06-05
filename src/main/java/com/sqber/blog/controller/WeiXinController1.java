package com.sqber.blog.controller;

import com.sqber.blog.base.Message;
import com.sqber.blog.base.MessageUtil;
import com.sqber.blog.base.PageResult;
import com.sqber.blog.base.SQLHelper;
import com.sqber.blog.dto.ResourceItem;
import com.sqber.blog.dto.Sites;
import com.sqber.blog.model.ActiveCode;
import com.sqber.blog.model.PagedResponse;
import com.sqber.blog.model.Pic;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


@Controller
public class WeiXinController1 {

    @Autowired
    private SQLHelper SQLHelper;

    @ResponseBody
    @GetMapping("/weixin")
    public String index(String signature, String timestamp, String nonce, String echostr) {

        String token = "";

        String sql = "SELECT url,name FROM javablog.pic where status = 1 ORDER BY  RAND() LIMIT 10";
        List<Pic> list = SQLHelper.query(sql, null, Pic.class);

        List<String> sortlist = new ArrayList<>();
        sortlist.add(token);
        sortlist.add(timestamp);
        sortlist.add(nonce);

        Collections.sort(sortlist);

        String str = String.join("", sortlist);
        String sign = DigestUtils.sha1Hex(str);

        if (sign.equals(signature))
            return echostr;
        else
            return "not equal";
    }

    @ResponseBody
    @PostMapping("/weixin")
    public String index(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("weixin post");

        Map<String, String> map = null;
        String str = "";

        try {
            map = MessageUtil.xmlToMap(request);

            //从集合中，获取XML各个节点的内容

            String ToUserName = map.get("ToUserName");
            String FromUserName = map.get("FromUserName");
            String CreateTime = map.get("CreateTime");
            String MsgType = map.get("MsgType");

            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            }

            //这里只处理文本消息
            if (MsgType.equalsIgnoreCase("text")) {

//                String Content = map.get("Content");
//                String MsgId = map.get("MsgId");
//
//                Message message = new Message();
//                message.setFromUserName(ToUserName);
//                message.setToUserName(FromUserName);
//                message.setContent("你说啥");
//                message.setMsgId(MsgId);
//                message.setMsgType("text");
//                message.setCreateTime(new Date().getTime());
//
//                str = MessageUtil.objectToXml(message);

            } else if (MsgType.equalsIgnoreCase("event")) {

                String Event = map.get("Event");

                String replay = "none";
                if (Event.equalsIgnoreCase("subscribe")) {
                    replay = "订阅";
                    replay = getReplayContent(FromUserName,ToUserName);
                } else if (Event.equalsIgnoreCase("unsubscribe")) {
                    replay = "取消订阅";
                }

                System.out.println(replay);

                Message message = new Message();
                message.setFromUserName(ToUserName);
                message.setToUserName(FromUserName);
                message.setContent(replay);
                //message.setMsgId(MsgId);
                message.setMsgType("text");
                message.setCreateTime(new Date().getTime());

                str = MessageUtil.objectToXml(message);
            }

            //response.setCharacterEncoding("UTF-8");
            //response.getWriter().print(str);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return str;

    }

    private String getReplayContent(String fromUserName,String toUserName){

        // fromUesrName -- 用户
        // toUserName -- 公众号

        //先从库中查一遍，是否已经有了。
        String code = getCode(fromUserName,toUserName);

        if(StringUtils.isEmptyOrWhitespace(code)){
            String sql = "SELECT id,code FROM javablog.activecode where status = 1 and publicAccount = ? and ISNULL(user) LIMIT 1";

            log(sql + toUserName);

            List<Object> params = new ArrayList<Object>();
            params.add(toUserName);

            List<ActiveCode> models = SQLHelper.query(sql, params, ActiveCode.class);
            if(models.size()==1){

                code = models.get(0).getCode();
                int id = models.get(0).getId();

                String updateSql = String.format("update activecode set user = '%s',userGetCodeTime=now() where id = %s and ISNULL(user)",fromUserName,id);

                log(updateSql);

                int result = SQLHelper.update(updateSql,null);
                log(updateSql + " 更新结果： "+result);
            }
        }


        if(StringUtils.isEmptyOrWhitespace(code)){
            return "欢迎订阅";
        }else{
            return "欢迎订阅：赠送激活码一枚 "+ code;
        }

    }

    private String getCode(String fromUserName,String toUserName){
        String sql = "SELECT id,code FROM javablog.activecode where status = 1 and publicAccount = ? and user = ? LIMIT 1";
        List<Object> params = new ArrayList<Object>();
        params.add(toUserName);
        params.add(fromUserName);

        List<ActiveCode> models = SQLHelper.query(sql, params, ActiveCode.class);
        if(models.size()==1){
            return  models.get(0).getCode();
        }else{
            return null;
        }
    }

    private void log(String content){

        String sql = "insert log(content,time) values(?,now())";

        List<Object> params = new ArrayList<Object>();
        params.add(content);

        SQLHelper.add(sql,params);
    }

}