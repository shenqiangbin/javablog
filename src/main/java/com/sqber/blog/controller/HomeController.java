package com.sqber.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mysql.jdbc.StringUtils;
import com.sqber.blog.base.PageResult;
import com.sqber.blog.base.SQLHelper;
import com.sqber.blog.dto.ResourceItem;
import com.sqber.blog.dto.Sites;


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
	
	@GetMapping(value={"/sites/{page}","/sites{page}"})
	public String sites(Model model,@PathVariable String page) {
							
		int pageSize = 50;
		int currentPage = 1;
		
		if(!StringUtils.isNullOrEmpty(page))
			currentPage = Integer.parseInt(page);
		
		System.out.println(currentPage);
		
		String sql = "select * from sites order by addtime desc";
		PageResult<Sites> result = SQLHelper.queryPage(sql, null, currentPage, pageSize, Sites.class);
		
		List<Sites> list = result.getData();
		int count = result.getTotalCount();
		
		System.out.println("count:"+count);
		
		model.addAttribute("items", list);
		model.addAttribute("count", count);
		model.addAttribute("currentPage",currentPage);
		
		return "home/sites";
	}
}