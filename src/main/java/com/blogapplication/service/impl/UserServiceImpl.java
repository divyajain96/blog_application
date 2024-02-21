package com.blogapplication.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blogapplication.dto.UserDTO;
import com.blogapplication.exceptions.ResourceNotFoundException;
import com.blogapplication.model.User;
import com.blogapplication.repository.UserRepository;
import com.blogapplication.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;
//	public UserServiceImpl(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		User user = this.dtoToUser(userDTO);
		User savedUser = this.userRepository.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDTO updateUser(Integer userId, UserDTO userDTO) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id ", userId));
//		User user1=this.dtoToUser(userDTO);
//		User updateUser = this.userRepository.save(user);
//		return this.userToDto(updateUser);
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getName());
		user.setPassword(userDTO.getPassword());
		user.setAbout(userDTO.getAbout());
		User updateUser = this.userRepository.save(user);
		UserDTO userDto1 = this.userToDto(updateUser);
		return userDto1;
	}

	@Override
	public UserDTO getUserById(Integer userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id ", userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = this.userRepository.findAll();
		List<UserDTO> userDTo = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		return userDTo;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id: ", userId));
		this.userRepository.delete(user);
	}

	public User dtoToUser(UserDTO userDTO) {
		/*
		 * User user = new User(); user.setId(userDTO.getId());
		 * user.setName(userDTO.getName()); user.setEmail(userDTO.getEmail());
		 * user.setPassword(userDTO.getPassword()); user.setAbout(userDTO.getAbout());
		 * return user;
		 */
		User user = this.modelMapper.map(userDTO, User.class);
		return user;
	}

	public UserDTO userToDto(User user) {

		/*
		 * UserDTO dto = new UserDTO();
		 * dto.setId(user.getId());
		 * dto.setName(user.getName()); 
		 * dto.setEmail(user.getEmail());
		 * dto.setPassword(user.getPassword()); 
		 * dto.setAbout(user.getAbout()); 
		 * return dto;
		 */
		UserDTO userDTO=this.modelMapper.map(user,UserDTO.class );
		return userDTO;
	}
}
