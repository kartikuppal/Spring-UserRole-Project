package com.infogain.app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.app.dto.UserDto;
import com.infogain.app.entity.User;
import com.infogain.app.repository.UserRepo;
import com.infogain.app.service.UserException;
import com.infogain.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	UserRepo userRepo;
	

	
	
		// Display all users
		@GetMapping("/display")
		public List<User> displayUser() {

			return userService.display();
		}
		
		
		// Insert into table user
		@PostMapping("/create")
		public User insertUser(@RequestBody UserDto userDto) throws UserException  {
			
			User user =  userService.entityAssembler(userDto);
			return userRepo.save(user);
		}
	
		/*// Insert into table user
		@PostMapping("/create")
		public User insertUser(@RequestBody UserDto userDto) throws UserException  {
			
			User user =  userService.entityAssembler(userDto);
			return userRepo.save(user);
		}*/
		
	/*	@PostMapping("/create")
		public User insertUser(@RequestBody User user) throws UserException
		{
			return userService.insertUser(user);
		}*/
		
		// Fetch User using id
		@GetMapping("/byId/{id}")
		public User getUser(@PathVariable(value="id") Integer userId)
		{
			User user =userService.getUserById(userId);
			return user;
		}
		
		// Update user
		@PutMapping("/update/{id}")
		public User updateUser(@PathVariable(value="id") Integer userId,@RequestBody UserDto userDto)
		{
			return userService.updateUser(userId, userDto);
		}
		
		//Deleting User
		@DeleteMapping("/delete/{id}")
		public void deleteUser(@PathVariable(value="id") Integer userId)
		{
			userService.deleteUser(userId);
		}
		
	}
