package com.sqber.blog.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationProvider作废 implements AuthenticationProvider {

	private CustomUserDetailsService customUserDetailsService; 
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName_input = authentication.getName();
		String password_input = (String)authentication.getCredentials();
		
		UserDetails dbUserDetails = customUserDetailsService.loadUserByUsername(userName_input);
//		if(dbUserDetails==null || dbUserDetails.getPassword().equals(password_input))
//			throw new BadCredentialsException("用户名或密码错误");
		
		//只要返回这个 Token 就代表用户登录了
		return new UsernamePasswordAuthenticationToken(userName_input, password_input, dbUserDetails.getAuthorities());		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return false;
	}

}
