package com.iiht.dating.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iiht.dating.model.DatingInfo;

@Repository
@Transactional
public class DatingDaoImpl implements DatingDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Boolean saveDatingInfo(DatingInfo datingInfo) {
		sessionFactory.getCurrentSession().save(datingInfo);
		return Boolean.TRUE;
	};
}