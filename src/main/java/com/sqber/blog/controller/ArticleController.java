package com.sqber.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {
	
	@GetMapping("/article/add")
	public String add(Model model) {	
		
		model.addAttribute("content","##title");
		return "article/add";
	}
	
	@GetMapping("/article/view")
	public String view(Model model) {	
		
		model.addAttribute("content","##title");
		return "article/view";
	}
}
