package com.josephadogeridev.spring.security_6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(
                        request-> request
                                .requestMatchers("register","login").permitAll()
                                .anyRequest().authenticated()

                )
                //.formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();

    }

    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails josephdetails = User.withUsername("joseph")
                .password("{noop}password")
                .roles("USER")
                .build();

        UserDetails mikedetails = User.withUsername("mike")
                .password("{noop}password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(josephdetails, mikedetails);



    }

}
