package com.infogain.app.dto;

import java.util.List;

import javax.persistence.Column;

import org.hibernate.validator.constraints.UniqueElements;

public class UserDto
{
	int id;
	String userName;
	@Column(unique = true)
	String email;
	List<Integer> roleIds;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Integer> getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(List<Integer> roleIds) {
		this.roleIds = roleIds;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", userName=" + userName + ", email=" + email + ", roleIds=" + roleIds + "]";
	}
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDto(int id, String userName, String email, List<Integer> roleIds) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.roleIds = roleIds;
	}
	

}
