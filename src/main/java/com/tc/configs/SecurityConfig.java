package com.tc.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	//写死的账户密码
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> db = auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder());
		db.withUser("admin").password(new BCryptPasswordEncoder().encode("admin")).roles("ADMIN");
		db.withUser("1").password(new BCryptPasswordEncoder().encode("1")).roles("USER");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/css/**","/").permitAll()
			.antMatchers("/js/**","/").permitAll()
			.antMatchers("/user/**").hasRole("USER")
			.and()
			.formLogin().loginPage("/index")
			.and()
			.exceptionHandling().accessDeniedPage("/");
		http.logout().logoutSuccessUrl("/");
		
	}
}