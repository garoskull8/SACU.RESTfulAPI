package com.garosoft.app.ws.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.garosoft.app.ws.service.AlumnoService;


@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	private final AlumnoService userDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public WebSecurity(AlumnoService userDeailsService,BCryptPasswordEncoder bCryptPasswordEncoder ) {
		this.userDetailsService=userDeailsService;
		this.bCryptPasswordEncoder=bCryptPasswordEncoder;
	}
	
	@Override 
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().cors().and();
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL)
		.permitAll()
		.anyRequest()
		.authenticated().and()
		.addFilter(getAuthenticationFilter())
		.addFilter(new AuthorizationFilter(authenticationManager()))
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
	
	public AuthenticationFilter getAuthenticationFilter() throws Exception{
			final AuthenticationFilter filter= new AuthenticationFilter(authenticationManager());
			filter.setFilterProcessesUrl("/alumnos/login");
			return filter;
	}
}
