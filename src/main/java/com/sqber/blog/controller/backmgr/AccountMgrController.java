package com.sqber.blog.controller.backmgr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountMgrController {

	@GetMapping("/backmgr/account/index")
	public String Index() {
		return "accountmgr/index";
	}
}
