package com.iiht.dating.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.iiht.dating.model.DatingInfo;

@Repository
@Transactional
public class DatingDaoImpl implements DatingDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Boolean saveDatingInfo(DatingInfo datingInfo) {
		
//		Long userId = Long.parseLong(request.getParameter("userId"));
//		Long receiverId = Long.parseLong(request.getParameter("receiverId"));
		
//		Date datingDate = Date.valueOf(request.getParameter("datingDate"));
//		Time datingTime = Time.valueOf(request.getParameter("datingTime"));

//		String location = request.getParameter("location");
//		String requestStatus = request.getParameter("requestStatus");
//		String datingRequest = request.getParameter("datingRequest");

//		DatingInfo datingInfo = new DatingInfo();

//		datingInfo.setUserId(userId);
//		datingInfo.setReceiverId(receiverId);
//		datingInfo.setDatingDate(datingDate);
//		datingInfo.setDatingTime(datingTime);
//		datingInfo.setLocation(location);
//		datingInfo.setRequestStatus("Pending");
//		datingInfo.setDatingRequest(datingRequest);

		sessionFactory.getCurrentSession().save(datingInfo);
		return Boolean.TRUE;
	};

	//-----------------------------------------------------------------------------------------------------------
	@SuppressWarnings("unchecked")
	public List<DatingInfo> getAllDatingProposals() {
		
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpSession session = requestAttributes.getRequest().getSession();
		
		Long loginUserId = (Long) session.getAttribute("loginUserId");

		String hql = "SELECT us FROM DatingInfo us WHERE us.receiverId="+loginUserId;
						
		return (List<DatingInfo>) sessionFactory.getCurrentSession().createQuery(hql).list();		
	};

	//-----------------------------------------------------------------------------------------------------------
	public DatingInfo getDatingInfoById(Long userId) {
		String hql = "SELECT di FROM DatingInfo di where di.userId="+userId;
		return (DatingInfo) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();		
	};	
}