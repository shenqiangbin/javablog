package com.sqber.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import com.sqber.blog.base.*;
import com.sqber.blog.model.Task;
import com.sqber.blog.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@GetMapping("/task/add")
	public String add() {	
		return "task/add";
	}
	
	@ResponseBody
	@GetMapping("/task/getById")
	public Response<Task> getById(String id){
		
		Response<Task> response = new Response<Task>();
		
		try {
			
			Task task = taskService.getById(id);
			response.setCode(200);
			response.setData(task);
			
		} catch (Exception e) {			
			e.printStackTrace();
			response.setCode(500);
			response.setMsg("出现错误");
		}
		
		return response;
	}

	@PostMapping("/task/add")
	public String add(@ModelAttribute Task saveModel, Model model) {

		boolean success = false;
		boolean isEdit = saveModel.getId() != 0;
		
		StringBuilder msg = new StringBuilder();
		String checkMsg = checkMethod(saveModel);
		
		if(StringUtils.isEmpty(checkMsg)) {
			if (isEdit) {
				success = editMethod(msg, saveModel);
			} else {
				success = addMethod(msg, saveModel);
			}
		}else {
			msg.append(checkMsg);
		}
		
		model.addAttribute("isEdit", isEdit);
		model.addAttribute("task", saveModel);
		model.addAttribute("msg", msg.toString());
		model.addAttribute("success",success);

		return "task/add";
	}

	private String checkMethod(Task saveModel) {
		StringBuilder msg = new StringBuilder();
		
//		if(StringUtils.isEmpty(saveModel.getName()))
//			msg.append("名称不能为空；");
//		if(saveModel.getName().length() > 400)
//			msg.append("名称请小于400字；");
//		
//		if(StringUtils.isEmpty(saveModel.getUrl()))
//			msg.append("url不能为空；");
//		if(saveModel.getUrl().length() > 400)
//			msg.append("url请小于400字；");
		
		return msg.toString();
	}

	private boolean addMethod(StringBuilder msg, Task saveModel) {
		boolean success = false;
		try {

//			String sql = SqlString.toInsertSql(task.class);
//			List<Object> params = SqlString.toInsertParams(saveModel);
//			int id = SQLHelper.add(sql, params);
//			if (id == -1) {
//				msg.append("新增失败");
//			} else {
//				msg.append("新增成功");
//				success = true;
//			}

		} catch (Exception e) {
			e.printStackTrace();
			msg.append("新增失败，服务器异常");
		}
		return success;
	}

	private boolean editMethod(StringBuilder msg, Task saveModel) {
		boolean success = false;
		try {
//			int id = saveModel.getId();
//
//			task dbModel = null;
//			String sql = "select * from task where status = 1 and id = ?";
//			List<Object> params = new ArrayList<Object>();
//			params.add(id);
//			List<task> items = SQLHelper.query(sql, params, task.class);
//			if (items != null && items.size() > 0)
//				dbModel = items.get(0);
//
//			if (dbModel == null)
//				throw new Exception("数据未找到,id:" + id);
//
//			dbModel.setName(saveModel.getName());
//			dbModel.setUrl(saveModel.getUrl());
//
//			sql = SqlString.toUpdateSql(task.class);
//			params = SqlString.toUpdateParams(saveModel);
//			int effectRows = SQLHelper.update(sql, params);
//			if (effectRows == 0) {
//				msg.append("更新失败");
//			} else {
//				msg.append("更新成功");
//				success = true;
//			}

		} catch (Exception e) {
			e.printStackTrace();
			msg.append("更新失败，服务器异常");
		}
		return success;
	}
}