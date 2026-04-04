package com.Aadi.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.Aadi.service.CustomUserdeatils;
import com.Aadi.service.JWTFilter;

@Configuration
@EnableWebSecurity
public class Config {

	
	@Autowired
	JWTFilter filter;
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	CustomUserdeatils customUserdeatils;
	
	
	@Bean
	public DaoAuthenticationProvider authenticateuser() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(customUserdeatils);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	

	@Bean
	public AuthenticationManager authManager(AuthenticationConfiguration auth)
	{
		return auth.getAuthenticationManager();
	}
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf(csrf->csrf.disable());
		
	http.authorizeHttpRequests(auth->{
		auth.requestMatchers("/user/createuser","/authenticate").permitAll().
		anyRequest().authenticated();
	}).addFilterBefore(filter,
            UsernamePasswordAuthenticationFilter.class).httpBasic(Customizer.withDefaults());
		return http.build();
	}
	
	
}
