package com.sqber.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sqber.blog.base.SQLHelper;
import com.sqber.blog.dto.ResourceItem;


@Controller
public class HomeController {
	
	@Autowired
	private SQLHelper SQLHelper;
	
	@GetMapping("/")
	public String index(Model model) {
							
		String sql = "select * from ResourceItem where status = 1";
		List<ResourceItem> list = SQLHelper.query(sql, null, ResourceItem.class);
		
		model.addAttribute("items", list);	
		
		return "home/index";
	}
	
	@GetMapping("/test")
	public String test(Model model) {
		
		ResourceItem resourceItem = new ResourceItem();
		resourceItem.setName("小明");
		model.addAttribute("resourceItem",resourceItem);
		
		return "home/test";
	}	
}