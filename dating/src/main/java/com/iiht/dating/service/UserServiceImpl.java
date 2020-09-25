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
	public void updateUser(Long userId) {
		userDao.updateUser(userId);
	};
	//------------------------------------------------------------------------------
	public List<User> showAllUser() {
		return userDao.showAllUser();
	};
	//------------------------------------------------------------------------------
	public boolean validateUser(String loginName, String password) {
		return userDao.validateUser(loginName, password);
	};
}