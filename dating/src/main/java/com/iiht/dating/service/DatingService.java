package com.iiht.dating.service;

import java.util.List;

import com.iiht.dating.model.DatingInfo;

public interface DatingService {

	public Boolean saveDatingInfo(DatingInfo  datingInfo);
	public List<DatingInfo> getAllDatingProposals();
	public DatingInfo getDatingInfoById(Long userId);	
}
