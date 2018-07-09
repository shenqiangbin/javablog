package com.sqber.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sqber.blog.base.SQLHelper;
import com.sqber.blog.model.Role;

@Service
public class RoleService {

	@Autowired
	private SQLHelper sqlHelper;
	
	public List<Role> getRolesByUserCode(String userCode) throws Exception {
		
		String sql = "select * from role where status = 1 and rolecode in (select rolecode from userrole where status = 1 and usercode = ?)";
		List<Object> params = new ArrayList<>();
		params.add(userCode);
		
		List<Role> roles = sqlHelper.query(sql, params, Role.class);
		return roles;
	}
}
