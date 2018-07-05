package com.sqber.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sqber.blog.base.Response;
import com.sqber.blog.model.Project;
import com.sqber.blog.service.ProjectService;

@Controller
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@ResponseBody
	@GetMapping("/project/getAll")
	public Response<List<Project>> getAll(){
		
		Response<List<Project>> response = new Response<List<Project>>();
		
		try {
			
			List<Project> list = projectService.getAll();
			response.setCode(200);
			response.setData(list);
			
		} catch (Exception e) {			
			e.printStackTrace();
			response.setCode(500);
			response.setMsg("出现错误");
		}
		
		return response;
	}
}
