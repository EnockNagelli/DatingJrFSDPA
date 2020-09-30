package com.iiht.dating.dao;

import java.util.List;

import com.iiht.dating.model.DatingInfo;

public interface DatingDao {
	
	public Boolean saveDatingInfo(DatingInfo  datingInfo);
	public List<DatingInfo> getAllDatingProposals();
	public DatingInfo getDatingInfoById(Long userId);	
}
