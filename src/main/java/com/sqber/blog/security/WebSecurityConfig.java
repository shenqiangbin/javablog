package com.sqber.blog.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

//参照：https://blog.csdn.net/u010324465/article/details/77196380
//https://blog.csdn.net/hj7jay/article/details/51730284
//https://blog.csdn.net/canon_in_d_major/article/details/79675033 密码加密形式
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
    private MySecurityFilter mySecurityFilter;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
				
		http	
		.addFilterBefore(mySecurityFilter, FilterSecurityInterceptor.class)//在正确的位置添加我们自定义的过滤器
		.authorizeRequests()
			.antMatchers("/backmgr/**").authenticated() //只有后台管理的需要登录，其他的访问不需要
			.and()
		.formLogin().loginPage("/account/login") //登录跳转的url
		.and()
		.httpBasic();
	}
	
//	@Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/resources/**");        
//    }
	
	@Bean
	public BCryptPasswordEncoder  passwordEncoder() {
		 return new BCryptPasswordEncoder();
	}
	
//	@Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            .inMemoryAuthentication()
//                .withUser("admin").password(new BCryptPasswordEncoder().encode("123")).roles("USER");
//    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		//builder.authenticationProvider(authenticationProvider);
		builder.userDetailsService(customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
}
