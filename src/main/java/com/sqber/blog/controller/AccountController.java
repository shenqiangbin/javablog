package com.sqber.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sqber.blog.base.SQLHelper;


@Controller
public class AccountController {
	
	@Autowired
	private SQLHelper SQLHelper;
	
	@GetMapping("/account/login")
	public String index(HttpServletRequest request,Model model) {						
		
		if(SecurityContextHolder.getContext().getAuthentication() != null &&
			SecurityContextHolder.getContext().getAuthentication().isAuthenticated() && 
			!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) 
		) {
			return "redirect:/";
		}else {
			return "account/login";	
		}		
	}

}