package com.iiht.dating.service;

import java.util.List;

import com.iiht.dating.model.User;

public interface UserService {

	public boolean saveUser(User user);
	public boolean deleteUser(Long userId);
	public Boolean updateUser(User user);
	public List<User> getAllUsers();
	//--------------------------------------------------------------
	public User getUserById(Long userId);
	public boolean validateUser(String loginName, String password);
}