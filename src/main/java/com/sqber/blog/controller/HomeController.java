package com.sqber.blog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sqber.blog.base.*;
import com.sqber.blog.dto.ResourceItem;


@Controller
public class HomeController {
		
	@GetMapping("/")
	public String index(Model model) {
		
//		List<ResourceItem> items = new ArrayList<>();
//		
//		items.add(new ResourceItem("官方Java教程","https://www.ibm.com/developerworks/cn/java"));
//		items.add(new ResourceItem("精选内容：developerWorks 上最受欢迎的 Java 内容","https://www.ibm.com/developerworks/cn/java/j-top-java-content-2017/index.html"));
//		items.add(new ResourceItem("Java快速入门","http://www.cnblogs.com/happyframework/p/3332243.html"));
//		items.add(new ResourceItem("W3C School 的 Java 基础教程","http://www.runoob.com/java/java-tutorial.html"));
//		items.add(new ResourceItem("Java 编程入门","https://www.ibm.com/developerworks/cn/java/intro-to-java-course/index.html"));
//		items.add(new ResourceItem("W3C School 的 Eclipse 教程","http://www.runoob.com/eclipse/eclipse-tutorial.html"));
//				
		
		String sql = "select * from ResourceItem where status = 1";
		List<ResourceItem> list = SQLHelper.query(sql, null, ResourceItem.class);
		
		model.addAttribute("items", list);	
		
		return "home/index";
	}
	
}