package com.iiht.dating.service;

import java.util.List;

import com.iiht.dating.model.Profile;

public interface ProfileService {
	
	public Boolean saveProfile(Profile profile);
	public Boolean deleteProfile(Long userId);
	public Boolean updateProfile(Profile profile);
	public List<Profile> getAllProfiles();
	//--------------------------------------------------------------
	public Profile getProfileById(Long userId);
}