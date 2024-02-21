package com.blogapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapplication.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
