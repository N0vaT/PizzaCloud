package com.nova.pizzaCloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http.
                authorizeRequests()
                .antMatchers("/design", "/orders").hasRole("USER")
                .antMatchers("/","/**").permitAll()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/design", true)
                .and()
                .cors().and().csrf().disable()
                .build();
    }
}
