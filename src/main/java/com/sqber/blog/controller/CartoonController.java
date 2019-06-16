package com.sqber.blog.controller;

import com.mysql.jdbc.StringUtils;
import com.sqber.blog.base.PageResult;
import com.sqber.blog.base.SQLHelper;
import com.sqber.blog.dto.ResourceItem;
import com.sqber.blog.dto.Sites;
import com.sqber.blog.model.Cartoon;
import com.sqber.blog.model.CartoonJi;
import com.sqber.blog.model.PagedResponse;
import com.sqber.blog.model.Pic;
import com.sqber.blog.service.CartoonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


@Controller
public class CartoonController {


    @Autowired
    private CartoonService cartoonService;


    @GetMapping(value = {"/cartoon/{id}"})
    public String watch(Model model, @PathVariable String id) throws Exception {

        if (StringUtils.isNullOrEmpty(id))
            id = "0";
        cartoonService.makeItNew(id);
        Cartoon cartoon = cartoonService.getById(Integer.parseInt(id));
        if (cartoon == null) {
            throw new Exception("id not found");
        }

        List<CartoonJi> CartoonJis = cartoonService.getByCartoonId(Integer.parseInt(id));

        LinkedHashMap<String, List<CartoonJi>> groupJis = new LinkedHashMap<>();

        int index = 0;
        String firstJi = "";
        for (CartoonJi ji : CartoonJis) {
            if (ji.getTrueSrc() != null && (!ji.getTrueSrc().startsWith("http") || ji.getTrueSrc().endsWith(".mp4"))) {
                String src = "http://jexi.a0296.cn/?url=" + ji.getTrueSrc();
                ji.setTrueSrc(src);
            }
            if (index == 0)
                firstJi = ji.getTrueSrc();

            String lineName = ji.getLinename();
            if (!groupJis.containsKey(lineName)) {
                groupJis.put(lineName, new ArrayList<>());
            }

            groupJis.get(lineName).add(ji);
            index++;
        }

        model.addAttribute("title", cartoon.getName());
        model.addAttribute("mapmy", groupJis);
        model.addAttribute("lineNum", groupJis.size());
        model.addAttribute("firstJi", firstJi);

        return "cartoon/watch";
    }
}