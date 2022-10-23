package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private AuthenticationSuccessHandler authenticationSuccessHandler;

	@Autowired
	public SecurityConfig(AuthenticationSuccessHandler authenticationSuccessHandler) {
		this.authenticationSuccessHandler = authenticationSuccessHandler;
	}

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * 
	 * System.out.println("Inside configure Authentication");
	 * auth.inMemoryAuthentication() .withUser("admin") .password("admin")
	 * .roles("ADMIN") .and() .withUser("user") .password("user") .roles("USER");
	 * 
	 * 
	 * 
	 * }
	 */

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("user")
		.password("user")
		.roles("USER")
		.and()
		.withUser("admin")
		.password("admin")
		.roles("ADMIN");
	}

	@Bean
	public PasswordEncoder getpassword() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		System.out.println("Inside configure Authorization!!!!!!!");

		/*
		 * http.authorizeRequests() .antMatchers("/admin").hasRole("ADMIN")
		 * .antMatchers("/user").hasAnyRole("ADMIN","USER").and().formLogin();
		 * //.antMatchers("/").permitAll().and().formLogin();
		 */
		http.authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user").hasAnyRole("USER")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.successHandler(authenticationSuccessHandler)
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.deleteCookies("JSESSIONID")
		.permitAll();

	}

}
