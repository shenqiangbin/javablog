package com.sqber.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sqber.blog.base.Response;
import com.sqber.blog.model.Task;

@Controller
public class ArticleController {
	
	@GetMapping("/article/add")
	public String add(Model model) {	
		
		model.addAttribute("content","##title");
		return "article/add";
	}	
	
	@ResponseBody
	@PostMapping("/article/add")
	public String add(Task saveModel, Model model) {

		Response<String> response = new Response<String>();
		response.setCode(200);
		response.setMsg("this is msg");
		response.setData("this is data");
		
		return "";
//		boolean success = false;
//		boolean isEdit = saveModel.getId() != 0;
//		
//		StringBuilder msg = new StringBuilder();
//		String checkMsg = checkMethod(saveModel);
//		
//		if(StringUtils.isEmpty(checkMsg)) {
//			if (isEdit) {
//				success = editMethod(msg, saveModel);
//			} else {
//				success = addMethod(msg, saveModel);
//			}
//		}else {
//			msg.append(checkMsg);
//		}
//		
//		model.addAttribute("isEdit", isEdit);
//		model.addAttribute("task", saveModel);
//		model.addAttribute("msg", msg.toString());
//		model.addAttribute("success",success);
//
//		return "task/add";
		
	}
	
	
	@GetMapping("/article/view")
	public String view(Model model) {	
		
		model.addAttribute("content","##title");
		return "article/view";
	}
}
