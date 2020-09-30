package com.iiht.dating.service;

import java.io.IOException;

import com.iiht.dating.model.Profile;

public interface ProfileService {
	
	public Boolean saveProfile(Profile profile) throws IOException;
//	public Boolean deleteProfile(Long userId);
//	public Boolean updateProfile(Profile profile);
//	public List<Profile> getAllProfiles();
	//--------------------------------------------------------------
//	public Profile getProfileById(Long userId);
}