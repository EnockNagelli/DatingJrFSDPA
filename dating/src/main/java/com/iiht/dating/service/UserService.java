package com.iiht.dating.service;

import java.util.List;

import com.iiht.dating.model.User;

public interface UserService {

	public boolean saveUser(User user);
	public boolean deleteUser(Long userId);
	public void updateUser(Long userId);
	public List<User> showAllUser();
	//--------------------------------------------------------------
	public boolean validateUser(String loginName, String password);
}