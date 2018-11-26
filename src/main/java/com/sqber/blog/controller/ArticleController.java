package com.sqber.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {
	
	@GetMapping("/article/add")
	public String add() {	
		return "article/add";
	}
}
