package com.capgemini.node.service;

import com.capgemini.node.pojo.UserRequest;
import com.capgemini.node.pojo.UserResponse;

public interface UserService {

    String registerUser(UserRequest user);
    String loginUser(String value,String password);

    UserResponse getUserByUserName(String username);

    UserResponse getUserById(int id);
}
