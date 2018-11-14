package com.infogain.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.app.entity.Role;

import com.infogain.app.service.RoleService;



@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	
	private RoleService roleService;
	
	/*@GetMapping("/display")
	public List<Role> displayRole() {

		return roleService.display();
	}
	
	@PostMapping("/create")
	public Role insertRole(@RequestBody Role role) {
		
		return roleService.insertRole(role);
	}*/
	
	@GetMapping("/display")
	public List<Role> displayRole() {

		return roleService.display();
	}
	
	@PostMapping("/create")
	public Role insertRole(@RequestBody Role role) {
		
		return roleService.insertRole(role);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteRole(@PathVariable (value="id") Integer rid)
	{
		roleService.deleteRole(rid);
	}
	
	@PutMapping("/update/{id}")
	public Role updateRole(@PathVariable (value="id")Integer rid)
	{
		return roleService.updateRole(rid);
		
	}
	
	
	
	
	}
