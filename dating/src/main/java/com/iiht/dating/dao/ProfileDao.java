package com.iiht.dating.dao;

import java.util.List;

import com.iiht.dating.model.Profile;

public interface ProfileDao {

	public Boolean saveProfile(Profile profile);
	public Boolean deleteProfile(Long userId);
	public Boolean updateProfile(Profile profile);
	public List<Profile> getAllProfiles();
	//--------------------------------------------------------------
	public Profile getProfileById(Long userId);
}