package com.josephadogeridev.spring.security_6.controller;

import com.josephadogeridev.spring.security_6.entity.User;
import com.josephadogeridev.spring.security_6.repository.UserRepository;
import com.josephadogeridev.spring.security_6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserService userService;

    public UserController(UserService userService,UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        //return userRepository.save(user);
        return userService.register(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody User user){

        return userService.verify(user);
   }
}
