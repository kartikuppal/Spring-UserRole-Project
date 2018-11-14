package com.infogain.app.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.infogain.app.dto.RoleDto;
import com.infogain.app.entity.Role;
import com.infogain.app.entity.User;
import com.infogain.app.repository.IRoleRepo;
import com.infogain.app.repository.UserRepo;
@Service
public class RoleService {

	@Autowired
	IRoleRepo roleRepo;
	@Autowired
	UserRepo userRepo;
	




	public List<Role> display() {
		
		return roleRepo.findAll();
	}

	
	public Role insertRole(Role role) {
		
		return roleRepo.save(role);
	}

	
	public List<Role> getRole(List<Integer> id) {
		
		return  roleRepo.findAllById(id);
	}

	
	public void deleteRole(Integer id) {
		
		roleRepo.deleteById(id);

		
	}

	
	public Role updateRole(Integer id) {
		Role role = new Role();
		role = roleRepo.findById(id).get();
		role.setRoleName(role.getRoleName());
		return roleRepo.save(role);

	}

/*	
	public Role roleEntityAssembler(RoleDto roleDto) {
		role.setRoleName(roleDto.getName());
		Set<User> users = new HashSet<>();
		for(int i=0; i<roleDto.getUserIds().size();i++)
		{
			Integer userId = roleDto.getUserIds().get(i);
			User user = userRepo.findById(userId).get();
			users.add(user);
		}
		role.setUser(users);
		return role;
	}*/

}
