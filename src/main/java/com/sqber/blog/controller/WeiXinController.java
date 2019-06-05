package com.sqber.blog.controller;

import com.mysql.jdbc.StringUtils;
import com.sqber.blog.base.PageResult;
import com.sqber.blog.base.SQLHelper;
import com.sqber.blog.dto.ResourceItem;
import com.sqber.blog.dto.Sites;
import com.sqber.blog.model.PagedResponse;
import com.sqber.blog.model.WeChatContant;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


@RestController
public class WeiXinController {

    @Autowired
    private SQLHelper SQLHelper;

    /*
    * 微信请求地址demo：
    * weixin?signature=7ae459e571257c69d7889c56caf98b708055fe94&timestamp=1559737769&nonce=1498373320&openid=ou2PCuGa--dDUSlmYmShuDoAPIEM
    * */
    @GetMapping("/weixin")
    public String index(@RequestParam("signature") String signature,
                        @RequestParam("timestamp") String timestamp,
                        @RequestParam("nonce") String nonce,
                        @RequestParam("echostr") String echostr) {
        System.out.println("weixin");
        System.out.println(signature);
        System.out.println(timestamp);
        System.out.println(nonce);
        System.out.println(echostr);

        String[] arr = new String[]{WeChatContant.TOKEN, timestamp, nonce};
        // 将token、timestamp、nonce三个参数进行字典序排序
         //Arrays.sort(arr);
        sort(arr);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }
        MessageDigest md = null;
        String tmpStr = null;

        try {
            md = MessageDigest.getInstance("SHA-1");
            // 将三个参数字符串拼接成一个字符串进行sha1加密
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        if (tmpStr != null && tmpStr.equals(signature.toUpperCase())) {
            return echostr;
        }
        return "";
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param byteArray
     * @return
     */
    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
     * 将字节转换为十六进制字符串
     *
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte) {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];

        String s = new String(tempArr);
        return s;
    }

    private static void sort(String a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[i]) < 0) {
                    String temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    @PostMapping("/weixin")
    public String processMsg(HttpServletRequest request) {
        String responseXml = "";
        // 调用核心服务类接收处理请求
        try {
            Map<String, String> requestMap = parseXml(request);

            for(Map.Entry<String, String> entry : requestMap.entrySet()){
                String mapKey = entry.getKey();
                String mapValue = entry.getValue();
                System.out.println(mapKey+":"+mapValue);
            }

            String msgType = (String) requestMap.get(WeChatContant.MsgType);
            String mes = null;
            // 文本消息
            if (msgType.equals(WeChatContant.REQ_MESSAGE_TYPE_TEXT)) {
                mes = requestMap.get(WeChatContant.Content).toString();
                System.out.println(mes);

                responseXml = sendTextMsg(requestMap, "我说："+mes);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseXml;
    }

    public String sendTextMsg(Map<String, String> requestMap, String content) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ToUserName", requestMap.get(WeChatContant.FromUserName));
        map.put("FromUserName", requestMap.get(WeChatContant.ToUserName));
        map.put("MsgType", WeChatContant.RESP_MESSAGE_TYPE_TEXT);
        map.put("CreateTime", new Date().getTime());
        map.put("Content", content);
        return mapToXML(map);
    }

    @SuppressWarnings({"unchecked"})
    public Map<String, String> parseXml(HttpServletRequest request) throws Exception {
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<String, String>();

        // 从request中取得输入流
        InputStream inputStream = request.getInputStream();
        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();
        // 遍历所有子节点
        for (Element e : elementList)
            map.put(e.getName(), e.getText());

        // 释放资源
        inputStream.close();
        return map;
    }

    public String mapToXML(Map map) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        mapToXML2(map, sb);
        sb.append("</xml>");
        try {
            return sb.toString();
        } catch (Exception e) {
        }
        return null;
    }

    private void mapToXML2(Map map, StringBuffer sb) {
        Set set = map.keySet();
        for (Iterator it = set.iterator(); it.hasNext(); ) {
            String key = (String) it.next();
            Object value = map.get(key);
            if (null == value)
                value = "";
            if (value.getClass().getName().equals("java.util.ArrayList")) {
                ArrayList list = (ArrayList) map.get(key);
                sb.append("<" + key + ">");
                for (int i = 0; i < list.size(); i++) {
                    HashMap hm = (HashMap) list.get(i);
                    mapToXML2(hm, sb);
                }
                sb.append("</" + key + ">");

            } else {
                if (value instanceof HashMap) {
                    sb.append("<" + key + ">");
                    mapToXML2((HashMap) value, sb);
                    sb.append("</" + key + ">");
                } else {
                    sb.append("<" + key + "><![CDATA[" + value + "]]></" + key + ">");
                }

            }

        }
    }
}