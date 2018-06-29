package com.sqber.blog.security;

import java.util.List;
import java.util.Collection;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class MyAccessDecisionManager implements AccessDecisionManager {

	/*
	 * @param authentication 当前用户
	 * 
	 * @param object 要访问的资源
	 * 
	 * @param configAttributes 安全对象关联的配置属性
	 */
	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {

		if (configAttributes == null)
			return;

		for (ConfigAttribute configAttribute : configAttributes) {
			String attribute = configAttribute.getAttribute();

			for (GrantedAuthority authority : authentication.getAuthorities()) {
				if(authority.getAuthority().equals(attribute))
					return;
			}
		}
		
		throw new AccessDeniedException("");
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return false;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

}
