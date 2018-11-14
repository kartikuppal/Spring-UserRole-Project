package com.infogain.app.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import javax.security.auth.message.callback.PrivateKeyCallback.IssuerSerialNumRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.infogain.app.dto.UserDto;
import com.infogain.app.entity.Role;
import com.infogain.app.entity.User;
import com.infogain.app.repository.IRoleRepo;
import com.infogain.app.repository.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private RoleService roleService;
	@Autowired
	private IRoleRepo roleRepo;

	public List<User> display() {
		return userRepo.findAll();
	}

	public User getUserById(Integer userId) {
		User users = userRepo.findById(userId).get();
		return users;
	}

	public void deleteUser(Integer userId) {
		userRepo.deleteById(userId);

	}

	public User updateUser(Integer userId, UserDto userDto) {

		User user= userRepo.findById(userId).get();
		user.setUserName(userDto.getUserName());
		user.setEmail(userDto.getEmail());
		HashSet< Role>roles = new HashSet<>();
		for (int i = 0; i < userDto.getRoleIds().size(); i++) {
			Integer roleID = userDto.getRoleIds().get(i);
			Role role = roleRepo.findById(roleID).get();
			roles.add(role);
		}
		user.setRole(roles);
		userRepo.save(user);
		return user;
	}

	public User entityAssembler(UserDto userDto) throws UserException {

		User existingUser = userRepo.findByEmail(userDto.getEmail());
		if (existingUser != null) {
			throw new UserException("user already exist with given email");
		}
		
		else {
			User user = new User();
			user.setPassword(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8));
			Set<Role> roles = new HashSet<>();
			user.setUserName(userDto.getUserName());
			user.setEmail(userDto.getEmail());

			for (int i = 0; i < userDto.getRoleIds().size(); i++) {
				Integer roleID = userDto.getRoleIds().get(i);
				Role role = roleRepo.findById(roleID).get();
				roles.add(role);
			}
			user.setRole(roles);
			return user;
		}
	}


	/*public User insertUser(User user) throws UserException {
		User existingUser = userRepo.findByEmail(user.getEmail());
		if (existingUser != null) {
			throw new UserException("User already exist with given email");
		} else {
			user.setPassword(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8));// generates
																								// random
																								// password
			List<Integer> id = new ArrayList<Integer>();

			id.add(1);
			id.add(2);

			List<Role> role = roleService.getRole(id);
			Set<Role> roles = new HashSet<>();
			roles.addAll(role);
			user.setRole(roles);
			return userRepo.save(user);
		}
	}
*/

}
