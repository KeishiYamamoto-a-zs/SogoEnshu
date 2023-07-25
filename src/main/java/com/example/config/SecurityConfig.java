package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailService;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http.formLogin(login -> login
	            .loginProcessingUrl("/login")
	            .loginPage("/login")
	            .defaultSuccessUrl("/vegetable",true)
	            .failureUrl("/login?error")
	            .usernameParameter("userMailaddress")
	            .passwordParameter("password")
	            .permitAll()
	            
	    ).logout(logout -> logout
	            .logoutSuccessUrl("/login")
	            
	    ).authorizeHttpRequests(authz -> authz
	            .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
	            .requestMatchers("/login").permitAll()
	            .requestMatchers("/signup").permitAll()
	            .requestMatchers("/signupUser").permitAll()
	            .requestMatchers("/general").hasRole("GENERAL")
	            .requestMatchers("/admin").hasRole("ADMIN")
	            .anyRequest().authenticated() //他のURLはログイン後のみアクセス可能
	    ) .csrf().disable();
	            
	   
	    return http.build();
	}

	@Bean

	public BCryptPasswordEncoder passwordEncoder() {

	return new BCryptPasswordEncoder();

	}

	/*@Bean
	public UserDetailsService users() {
	  UserDetails admin = User.builder()
	                          .username("admin")
	                          .password(passwordEncoder().encode("password"))
	                          .authorities("ADMIN")
	                          .build();
	  UserDetails user = User.builder()
	                         .username("user")
	                         .password(passwordEncoder().encode("password"))
	                         .authorities("USER")
	                         .build();
	  return new InMemoryUserDetailsManager(admin, user);	  
	  
	} */
    
    
}