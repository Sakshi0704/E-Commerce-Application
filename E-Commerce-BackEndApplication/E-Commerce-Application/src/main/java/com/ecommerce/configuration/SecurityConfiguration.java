package com.ecommerce.configuration;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class SecurityConfiguration {

	public static final String[] PUBLIC_URLS = {"/buymart/auth/customers/signup", 
											"/buymart/auth/customers/signin",
												"/buymart/auth/admins/signup"
			
						};
	
	public static final String USER_ADMIN_URLS[] = {};
	
	public static final String ADMIN_URLS[] = {};
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.cors(cors -> cors.configurationSource(new CorsConfigurationSource() {
			
			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				CorsConfiguration cfg = new CorsConfiguration();
				cfg.setAllowedOriginPatterns(Collections.singletonList("*"));
				cfg.setAllowedMethods(Collections.singletonList("*"));
				cfg.setAllowCredentials(true);
				cfg.setAllowedHeaders(Collections.singletonList("*"));
				cfg.setExposedHeaders(Arrays.asList("Authorization")); // this need to be configure in cors origin if 
														//any ui domain try to use resource of web service
				return cfg;
			}
		}))
		.authorizeHttpRequests(auth -> {
			auth
			  .requestMatchers("/swagger-ui*/**","/v3/api-docs/**").permitAll()
			  .requestMatchers(PUBLIC_URLS).permitAll()
			  .requestMatchers(ADMIN_URLS).hasRole("ADMIN")
			  .requestMatchers(USER_ADMIN_URLS).hasAnyRole("ADMIN","USER")  // what is ** is showing PathVeriable -----
			  .anyRequest().authenticated();
		})
		.csrf(csrf -> csrf.disable())
		.addFilterAfter(new JwtTokenGeneratorFilter(), BasicAuthenticationFilter.class)
		.addFilterBefore(new JwtTokenValidatorFilter(), BasicAuthenticationFilter.class)
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults());
		
		return http.build();	
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); 
		// this is one of the hashing technique and recommendated one
	}
	
}
