package com.capgemini.node.repository;

import com.capgemini.node.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findUserByUserName(String userName);
    Optional<User> findUserByEmail(String email);
}