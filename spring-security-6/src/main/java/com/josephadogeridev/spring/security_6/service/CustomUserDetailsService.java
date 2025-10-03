package com.josephadogeridev.spring.security_6.service;

import com.josephadogeridev.spring.security_6.CustomUserDetails;
import com.josephadogeridev.spring.security_6.entity.User;
import com.josephadogeridev.spring.security_6.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class CustomUserDetailsService implements UserDetailsService {


    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            System.out.println("user " + username + " not found");
            throw new UsernameNotFoundException("username " + username + " not found");
        }else{
            return new CustomUserDetails(user);
        }
    }
}
