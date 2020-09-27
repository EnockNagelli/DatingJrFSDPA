package com.iiht.dating.dao;

import java.util.List;

import com.iiht.dating.model.User;

public interface UserDao {

	public Boolean saveUser(User user);
	public Boolean deleteUser(Long userId);
	public Boolean updateUser(User user);
	public List<User> getAllUsers();
	//--------------------------------------------------------------
	public User getUserById(Long userId);
	public boolean validateUser(String loginName, String password);
}