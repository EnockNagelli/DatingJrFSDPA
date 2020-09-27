package com.iiht.dating.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iiht.dating.dao.UserDao;
import com.iiht.dating.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	//------------------------------------------------------------------------------
	public boolean saveUser(User user) {
		return userDao.saveUser(user);
	};
	//------------------------------------------------------------------------------
	public boolean deleteUser(Long userId) {
		return userDao.deleteUser(userId);
	};
	//------------------------------------------------------------------------------
	public Boolean updateUser(User user) {
		return userDao.updateUser(user);
	};
	//------------------------------------------------------------------------------
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	};
	//------------------------------------------------------------------------------
	public User getUserById(Long userId) {
		return userDao.getUserById(userId);
	}
	//------------------------------------------------------------------------------
	public boolean validateUser(String loginName, String password) {
		return userDao.validateUser(loginName, password);
	};
}