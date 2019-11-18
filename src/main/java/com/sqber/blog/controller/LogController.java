package com.sqber.blog.controller;

import com.sqber.blog.base.Response;
import com.sqber.blog.base.SQLHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;


@Controller
public class LogController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SQLHelper sqlHelper;

    @ResponseBody
    @GetMapping("/log")
    public String index() {
        return "日志接口";
    }

    @ResponseBody
    @PostMapping("/log/add")
    public Response<String> add(String projectName, String level, String content, HttpServletRequest request) {
        Response response = new Response();

        try {
            validateAdd(projectName, level, content);

            String ip = getIP(request);
            String sql = "insert into loginfo(projectname,level,content,ip,createtime) values(?,?,?,?,now())";
            List<Object> params = new ArrayList<>();
            params.add(projectName);
            params.add(level);
            params.add(content);
            params.add(ip);
            int recordId = sqlHelper.add(sql, params);
            response.setCode(200);
            response.setMsg("保存成功");
        } catch (IllegalArgumentException ex) {
            response.setCode(401);
            response.setMsg(ex.getMessage());
        } catch (Exception ex) {
            response.setCode(500);
            logger.error(ex.toString());
            response.setMsg("处理发生错误");
        }

        return response;
    }

    private void validateAdd(String projectName, String level, String content) {
        if (StringUtils.isEmpty(projectName))
            throw new IllegalArgumentException("projectName不能为空");
        else {
            if (projectName.length() > 255)
                throw new IllegalArgumentException("projectName不能超过255个字符");
        }
        if (StringUtils.isEmpty(level))
            throw new IllegalArgumentException("level不能为空");
        else {
            if (level.length() > 255)
                throw new IllegalArgumentException("level不能超过255个字符");
        }
        if (StringUtils.isEmpty(content))
            throw new IllegalArgumentException("content不能为空");
        else {
            if (content.length() > 3000)
                throw new IllegalArgumentException("content不能超过3000个字符");
        }
    }

    private String getIP(HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        String headerIP = request.getHeader("x-real-ip");
        if (headerIP == null || "".equals(headerIP) || "null".equals(headerIP)) {
            headerIP = request.getHeader("x-forwarded-for");
        }
        if (headerIP != null && !"".equals(headerIP) && !"null".equals(headerIP)) {
            ip = headerIP;
        }
        return ip;
    }

}