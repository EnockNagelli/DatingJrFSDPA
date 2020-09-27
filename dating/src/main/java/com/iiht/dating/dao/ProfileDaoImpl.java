package com.iiht.dating.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iiht.dating.model.Profile;

@Repository
@Transactional
public class ProfileDaoImpl implements ProfileDao {

	@Autowired
	private SessionFactory sessionFactory;

	//-----------------------------------------------------------------------------------------------------------
	public Boolean saveProfile(Profile profile) {
		sessionFactory.getCurrentSession().save(profile);
		return Boolean.TRUE;
	};
	
	//-----------------------------------------------------------------------------------------------------------
	public Boolean deleteProfile(Long userId) {
		Profile profile = sessionFactory.getCurrentSession().load(Profile.class, userId);
		sessionFactory.getCurrentSession().delete(profile);
		return Boolean.TRUE;
	};
	
	//-----------------------------------------------------------------------------------------------------------
	public Boolean updateProfile(Profile profile) {

		String updateHql = "UPDATE Profile prof SET "
				+ "prof.profileImage='"+profile.getProfileImage()+"', "
				+ "prof.contactNo='"+profile.getContactNo()+"', "
				+ "prof.email='"+profile.getEmail()+"', "
				+ "prof.qualification='"+profile.getQualification()+"', "
				+ "prof.foodHabits='"+profile.getFoodHabits()+"', "
				+ "prof.hobbies='"+profile.getHobbies()+"', "
				+ "prof.aboutMe='"+profile.getAboutMe()+"' "
				+ "WHERE us.userId="+profile.getUserId();
		
		int a = sessionFactory.getCurrentSession().createQuery(updateHql).executeUpdate();
		if(a != 0 | a != -1)
			return Boolean.TRUE;
		else
			return Boolean.FALSE;
	};
	
	//-----------------------------------------------------------------------------------------------------------
	@SuppressWarnings("unchecked")
	public List<Profile> getAllProfiles() {
		String hql = "FROM Profile";
		return (List<Profile>) sessionFactory.getCurrentSession().createQuery(hql).list();		
	};

	//-----------------------------------------------------------------------------------------------------------
	public Profile getProfileById(Long userId) {
		String hql = "SELECT us FROM Profile us where us.userId="+userId;
		return (Profile) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();		
	};
}