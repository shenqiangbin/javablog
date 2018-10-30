package com.sqber.blog.controller.backmgr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MgrHomeController {
	
	@GetMapping("/backmgr/mgrHome/index")
	public String Index() {
		return "mgrHome/index";
	}
}
