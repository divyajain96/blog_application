package com.blogapplication.service;

import java.util.List;

import com.blogapplication.dto.UserDTO;

public interface UserService {

	UserDTO createUser(UserDTO userDTO);
	
	UserDTO updateUser(Integer userId,UserDTO userDTO);
	
	UserDTO getUserById(Integer userId);
	
	List<UserDTO> getAllUsers();
	
	void deleteUser(Integer userId);
}
