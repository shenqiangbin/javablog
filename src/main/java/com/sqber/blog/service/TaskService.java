package com.sqber.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqber.blog.base.SQLHelper;
import com.sqber.blog.base.SqlString;
import com.sqber.blog.model.Task;

@Service
public class TaskService {

	@Autowired
	private SQLHelper sqlHelper;

	public Task getById(String id) {

		String sql = "select * from task where id = ? and status = 1";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
		List<Task> files = sqlHelper.query(sql, params, Task.class);
		if (files != null && files.size() > 0)
			return files.get(0);

		return null;
	}
	
	public int add(Task model) throws IllegalArgumentException, IllegalAccessException {
		
		String sql = SqlString.toInsertSql(model.getClass());
		List<Object> params = SqlString.toInsertParams(model);
		
		int id = sqlHelper.add(sql, params);
		return id;
	}
}
