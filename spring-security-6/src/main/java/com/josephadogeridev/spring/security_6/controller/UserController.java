package com.josephadogeridev.spring.security_6.controller;

import com.josephadogeridev.spring.security_6.entity.User;
import com.josephadogeridev.spring.security_6.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userRepository.save(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody User user){
        User u =userRepository.findByUserName(user.getUsername());
        if(u==null){
            return "failure";
        }else{
            return "success";
        }
   }
}
