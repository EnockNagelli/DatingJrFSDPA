package com.iiht.dating.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.iiht.dating.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	//-----------------------------------------------------------------------------------------------------------
	public Boolean saveUser(User user) {
		
		User newUser = new User();

		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		
		newUser.setFirstName(firstName.substring(0, 1).toUpperCase() + firstName.substring(1));
		newUser.setLastName(lastName.substring(0, 1).toUpperCase() + lastName.substring(1));
		newUser.setDateOfBirth(user.getDateOfBirth());
		newUser.setGender(user.getGender());
		newUser.setAddress(user.getAddress());
		newUser.setLoginName(user.getLoginName());
		newUser.setPassword(user.getPassword());
		
		sessionFactory.getCurrentSession().save(newUser);

		return Boolean.TRUE;
	};
	//-----------------------------------------------------------------------------------------------------------
	public Boolean deleteUser(Long userId) {
		//String deleteQuery = "DELETE FROM USER us WHERE us.userId="+userId;
		User user = sessionFactory.getCurrentSession().load(User.class, userId);
		sessionFactory.getCurrentSession().delete(user);
		return Boolean.TRUE;
	};
	//-----------------------------------------------------------------------------------------------------------
	public Boolean updateUser(User user) {
		
		String updateHql = "UPDATE User us SET "
				+ "us.firstName='"+user.getFirstName()+"', "
				+ "us.lastName='"+user.getLastName()+"', "
				+ "us.dateOfBirth='"+user.getDateOfBirth()+"', "
				+ "us.gender='"+user.getGender()+"', "
				+ "us.address='"+user.getAddress()+"', "
				+ "us.loginName='"+user.getLoginName()+"', "
				+ "us.password='"+user.getPassword()+"' "
				+ "WHERE us.userId="+user.getUserId();
		
		int a = sessionFactory.getCurrentSession().createQuery(updateHql).executeUpdate();
		if(a != 0 | a != -1)
			return Boolean.TRUE;
		else
			return Boolean.FALSE;
	};
	//-----------------------------------------------------------------------------------------------------------
	public User getUserById(Long userId) {
		String hql = "SELECT us FROM User us where us.userId="+userId;
		return (User) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();		
	};
	//-----------------------------------------------------------------------------------------------------------
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {

		ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpSession session = requestAttributes.getRequest().getSession();
		
		String loginName = (String) session.getAttribute("loginName");
		
		String hql = "SELECT us.gender FROM User us WHERE us.loginName='"+loginName+"'";
		
		String gender = (String) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
		
		if(gender.equalsIgnoreCase("male"))
			hql = "SELECT us FROM User us WHERE us.loginName != '"+loginName+"' AND GENDER='female'" ;
		else
			hql = "SELECT us FROM User us WHERE us.loginName != '"+loginName+"' AND GENDER='male'" ;
		
		return (List<User>) sessionFactory.getCurrentSession().createQuery(hql).list();		
	};
	//-----------------------------------------------------------------------------------------------------------
	@SuppressWarnings("deprecation")
	public boolean validateUser(String loginName, String password) {
		User user = (User) sessionFactory.getCurrentSession().createCriteria(User.class)
	             .add(Restrictions.and(Restrictions.eq("loginName", loginName),Restrictions.eq("password", password)))
	             .uniqueResult();

		ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpSession session = requestAttributes.getRequest().getSession();

		session.setAttribute("loginUserId", user.getUserId());
		
		return true;
	};	
}