package com.sqber.blog.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sqber.blog.model.Role;
import com.sqber.blog.service.RoleService;
import com.sqber.blog.service.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		userName = "admin";
		String password = "123";
		
		try {
			
			//com.sqber.blog.model.User userDb = userService.getUserByUserCode(userName);
			
//			if(userDb == null)
//				throw new UsernameNotFoundException("用户名或密码不正确");
			
			//password from database
			//password = userDb.getPassword();
			
			String encodePassword = new BCryptPasswordEncoder().encode(password);
			List<GrantedAuthority> authorities = getAuthorities(userName);
			User user = new User(userName, encodePassword, authorities);
			
			return user;
			
		} catch (Exception e) {
			throw new UsernameNotFoundException("用户名或密码不正确");
		}
			
	}

	private List<GrantedAuthority> getAuthorities(String userName) throws Exception {

		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		authorities.add(new SimpleGrantedAuthority("role_user"));

		//data from database
//		List<Role> roles = roleService.getRolesByUserCode(userName);
//		if(roles != null) {
//			roles.forEach( r -> authorities.add(new SimpleGrantedAuthority(r.getRoleName())));
//		}
		
		return authorities;
	}

}
