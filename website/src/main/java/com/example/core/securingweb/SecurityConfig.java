package com.example.core.securingweb;

import com.example.core.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/").permitAll()
                .defaultSuccessUrl("/home")//
                .failureUrl("/login?message=error")
                .permitAll()
                .and()
                .logout()
                .permitAll();

        http
                .authorizeRequests()
                .antMatchers("/assets/**").permitAll()
                .anyRequest().authenticated();


    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring()
//                .antMatchers("/inline.**") // or better ending with ".{js,html}" or something
//                .antMatchers("/resources/static/**/*");
//    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return new UserService();
    }
}
