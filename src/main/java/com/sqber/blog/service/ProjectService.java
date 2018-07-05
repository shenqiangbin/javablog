package com.sqber.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqber.blog.base.SQLHelper;
import com.sqber.blog.model.Project;

@Service
public class ProjectService {

	@Autowired
	private SQLHelper sqlHelper;
	
	public Project getById(String id) {

		String sql = "select * from project where id = ? and status = 1";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		List<Project> files = sqlHelper.query(sql, params, Project.class);
		if (files != null && files.size() > 0)
			return files.get(0);

		return null;
	}
	
	public List<Project> getAll(){
		
		String sql = "select * from project where status = 1";
		List<Project> models = sqlHelper.query(sql, null, Project.class);
		return models;
	}
}
