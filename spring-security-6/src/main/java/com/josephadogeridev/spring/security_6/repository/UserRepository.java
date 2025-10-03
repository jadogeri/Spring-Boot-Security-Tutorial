package com.josephadogeridev.spring.security_6.repository;

import com.josephadogeridev.spring.security_6.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


    User findByUsername(String username);
}
