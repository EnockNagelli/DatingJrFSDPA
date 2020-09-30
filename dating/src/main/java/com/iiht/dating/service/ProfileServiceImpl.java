package com.iiht.dating.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iiht.dating.dao.ProfileDao;
import com.iiht.dating.model.Profile;

@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileDao profileDao;
	
	public Boolean saveProfile(Profile profile) throws IOException {
		return profileDao.saveProfile(profile);
	};
	//--------------------------------------------------------------
//	public Boolean deleteProfile(Long userId) {
//		return profileDao.deleteProfile(userId);
//	};
	//--------------------------------------------------------------
//	public Boolean updateProfile(Profile profile) {
//		return profileDao.updateProfile(profile);
//	};
	//--------------------------------------------------------------
//	public List<Profile> getAllProfiles() {
//		return profileDao.getAllProfiles();
//	};
	//--------------------------------------------------------------
//	public Profile getProfileById(Long userId) {
//		return profileDao.getProfileById(userId);
//	};
}