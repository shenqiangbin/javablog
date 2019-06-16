package com.sqber.blog.controller;

import java.util.ArrayList;
import java.util.List;

import com.sqber.blog.model.Pic;
import com.sqber.blog.service.CartoonService;
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
import com.sqber.blog.model.PagedResponse;


@Controller
public class HomeController {
	
	@Autowired
	private SQLHelper SQLHelper;
	@Autowired
	private CartoonService cartoonService;
	
	@GetMapping("/")
	public String index(Model model) {
							
		String sql = "SELECT url,name FROM javablog.pic where status = 1 ORDER BY  RAND() LIMIT 10";
		List<Pic> list = SQLHelper.query(sql, null, Pic.class);

//		for (Pic item:list) {
//			String url = item.getUrl();
//			String subStr = url.substring(0,url.lastIndexOf("."));
//			String ext = url.substring(url.lastIndexOf("."));
//			String newUrl = subStr+"229"+ext;
//			item.setUrl(newUrl);
//		}

//		List<List<Pic>> listArr = new ArrayList<>();
//
//		int lineNum = 5;
//
//		for(int i=0; i<list.size(); i+=lineNum){
//
//			List<Pic> pics = new ArrayList<>();
//
//			for(int j=0; j<5; j++)
//				pics.add(list.get(i+j));
//
//			listArr.add(pics);
//		}

		model.addAttribute("items", list);
		
		return "home/index";
	}
	
	@GetMapping("/test")
	public String test(Model model) {

		cartoonService.getByName("看斗罗大陆".replace("看", ""));
		String val = cartoonService.getOverview();

		ResourceItem resourceItem = new ResourceItem();
		resourceItem.setName("小明");
		model.addAttribute("resourceItem",resourceItem);
		
		PagedResponse<Sites> pagedResponse = new PagedResponse<Sites>();
		pagedResponse.setCurrentPage(1);
		pagedResponse.setPageSize(10);
		pagedResponse.setTotalCount(100);
		pagedResponse.calTotalPage();
		
		model.addAttribute("pageResponse",pagedResponse);
		
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
		model.addAttribute("totalPage", result.getTotalPage());		
		model.addAttribute("currentPage",currentPage);
		
		return "home/sites";
	}
}