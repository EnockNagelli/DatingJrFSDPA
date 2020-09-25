package com.iiht.dating.dao;

import java.util.List;

import com.iiht.dating.model.User;

public interface UserDao {

	public boolean saveUser(User user);
	public boolean deleteUser(Long userId);
	public void updateUser(Long userId);
	public List<User> showAllUser();
	//--------------------------------------------------------------
	public boolean validateUser(String loginName, String password);
}