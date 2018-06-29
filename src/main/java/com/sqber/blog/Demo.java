package com.sqber.blog;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;


public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("ok");
		
		Object principal = "admin";
		Object credentials = "123";
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(principal,credentials);
			
		AuthenticationManager manager = new SampleAuthenticationMgr();
		Authentication auth = manager.authenticate(token);
		print(auth);
		
		SecurityContextHolder.getContext().setAuthentication(auth);
	}
	

	
	static void print(Object obj) {
		System.out.println(obj);
	}
}


