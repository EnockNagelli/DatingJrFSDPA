package com.iiht.dating.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iiht.dating.dao.DatingDao;
import com.iiht.dating.model.DatingInfo;

@Service
@Transactional
public class DatingServiceImpl implements DatingService {

	@Autowired
	private DatingDao datingDao;
	
	public Boolean saveDatingInfo(DatingInfo datingInfo) {
		return datingDao.saveDatingInfo(datingInfo);
	};
}