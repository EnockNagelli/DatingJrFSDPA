package com.iiht.dating.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iiht.dating.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	//-----------------------------------------------------------------------------------------------------------
	public boolean saveUser(User user) {
		sessionFactory.getCurrentSession().save(user);
		return true;
	};
	//-----------------------------------------------------------------------------------------------------------
	public boolean deleteUser(Long userId) {
		return true;
	};
	//-----------------------------------------------------------------------------------------------------------
	public void updateUser(Long userId) {
		
	};
	//-----------------------------------------------------------------------------------------------------------
	@SuppressWarnings("unchecked")
	public List<User> showAllUser() {
		String hql = "FROM User";		  		
		return (List<User>) sessionFactory.getCurrentSession().createQuery(hql).list();		
	};
	//-----------------------------------------------------------------------------------------------------------
	@SuppressWarnings("deprecation")
	public boolean validateUser(String loginName, String password) {
		User user = (User) sessionFactory.getCurrentSession().createCriteria(User.class)
	             .add(Restrictions.and(Restrictions.eq("loginName",loginName),Restrictions.eq("password",password)))
	             .uniqueResult();

		if(user != null)
			return true;
		else 
			return false;
	};	
}