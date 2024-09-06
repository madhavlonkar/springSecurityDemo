package com.revshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revshop.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
