package com.sqber.blog.controller;

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
							
		String sql = "select * from ResourceItem where status = 1";
		List<ResourceItem> list = SQLHelper.query(sql, null, ResourceItem.class);
		
		model.addAttribute("items", list);	
		
		return "home/index";
	}
	
}