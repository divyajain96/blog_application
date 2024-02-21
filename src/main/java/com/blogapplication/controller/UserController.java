package com.blogapplication.controller;

import java.util.List;
/*import java.util.Map;
import org.springframework.http.HttpStatusCode;
import com.blogapplication.dto.ResponseDTO;
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapplication.dto.ApiResponse;
import com.blogapplication.dto.UserDTO;
import com.blogapplication.service.UserService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/users")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	// POST - create user
	@PostMapping("/")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO)
	{
		UserDTO createUserDto = this.userService.createUser(userDTO);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	}
	

	// GET - users get
	@GetMapping("/")
	public ResponseEntity<List<UserDTO>> allUsers()
	{
		List<UserDTO> allUsers = this.userService.getAllUsers();
		return new ResponseEntity<>(allUsers,HttpStatus.OK);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> usersById(@PathVariable("userId") int userId)
	{
		UserDTO userById = this.userService.getUserById(userId);
		return new ResponseEntity<>(userById,HttpStatus.OK);
	}
	// PUT - update user
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
		UserDTO updateUser = this.userService.updateUser(id,userDTO);
		return new ResponseEntity<>(updateUser,HttpStatus.OK);
	}

	// DELETE - delete User
	@DeleteMapping("/{id}")
	/*public ResponseEntity<?> deleteUser(@PathVariable int id)
	{
		this.userService.deleteUser(id);
//		return new ResponseEntity<>("User is Deleted",HttpStatus.OK)
		return new ResponseEntity(Map.of("message","User is Deleted Sucessfully"),HttpStatus.OK);
	}*/
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable int id)
	{
		this.userService.deleteUser(id);
		return new ResponseEntity<>(new ApiResponse("User Deleted SucessFully",true),HttpStatus.OK);
	}
	
}
