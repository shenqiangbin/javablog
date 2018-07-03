package com.sqber.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//参照：https://blog.csdn.net/u010324465/article/details/77196380
//https://blog.csdn.net/hj7jay/article/details/51730284
//https://blog.csdn.net/canon_in_d_major/article/details/79675033 密码加密形式
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


	@Override
	protected void configure(HttpSecurity http) throws Exception {
				
		http	
		.authorizeRequests()
			.antMatchers("/resources/**", "/signup", "/about","/task/**").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin().and()
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
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("admin").password(new BCryptPasswordEncoder().encode("123")).roles("USER");
    }
	
}
