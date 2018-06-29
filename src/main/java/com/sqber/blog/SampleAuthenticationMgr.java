package com.sqber.blog;

import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.servlet.RequestToViewNameTranslator;

import javafx.beans.binding.When.BooleanConditionBuilder;

public class SampleAuthenticationMgr implements AuthenticationManager{

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		String name = auth.getName();
		Object principal = auth.getPrincipal();
		Object credentials = auth.getCredentials();
		
		print("name:" + name);
		print("principal:" + principal);
		print("credentials:" + credentials);
		
		if(checkUser(name, (String) credentials)) {
			List<GrantedAuthority> authorities = getAuthorities(name);
			return new UsernamePasswordAuthenticationToken(name, credentials, authorities); 
		}
		throw new BadCredentialsException("用户名或密码错误");
				
	}
	
	private boolean checkUser(String userName,String password) {
		//查询数据库
		if(userName == "admin" && password == "123")
			return true;
		else
			return false;
	}
	
	private List<GrantedAuthority> getAuthorities(String userName){
		
		//查询数据库
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		
		list.add(new SimpleGrantedAuthority("user"));
		list.add(new SimpleGrantedAuthority("admin"));
		list.add(new SimpleGrantedAuthority("video-editer"));
		list.add(new SimpleGrantedAuthority("article-editer"));
		
		return list;
	}
	
	static void print(Object obj) {
		System.out.println(obj);
	}
	
	
}
