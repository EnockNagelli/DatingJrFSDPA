package com.iiht.dating.controller;

import java.sql.Date;
import java.sql.Time;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iiht.dating.exception.DatingException;
import com.iiht.dating.model.DatingExceptionResponse;
import com.iiht.dating.model.DatingInfo;
import com.iiht.dating.service.DatingService;

@Controller
public class DatingController {
	
	@Autowired
	private DatingService datingService;
	
	//----------------------------------------------------------------------------------------------------------------
	// 			1. ADD DATING INFORMATION FOR DATING APPLICATION
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/initDating", method = RequestMethod.GET)
	public String initView(Model model) {
		model.addAttribute("datingForm", new DatingInfo());
		return "datingDetails";
	}	
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/saveDatingProposal", method = RequestMethod.POST)
	public String saveDatingProposal(HttpServletRequest request) throws Exception {

		System.out.println("Inside Save Dating Proposal....");
		
		Long userId = Long.parseLong(request.getParameter("userId"));
		Long receiverId = Long.parseLong(request.getParameter("receiverId"));
		
		Date datingDate = Date.valueOf(request.getParameter("datingDate"));
		Time datingTime = Time.valueOf(request.getParameter("datingTime"));

		String location = request.getParameter("location");
		String requestStatus = request.getParameter("requestStatus");
		String datingRequest = request.getParameter("datingRequest");

		DatingInfo datingInfo = new DatingInfo();

		datingInfo.setUserId(userId);
		datingInfo.setReceiverId(receiverId);
		datingInfo.setDatingDate(datingDate);
		datingInfo.setDatingTime(datingTime);
		datingInfo.setLocation(location);
		datingInfo.setRequestStatus(requestStatus);
		datingInfo.setDatingRequest(datingRequest);

		datingService.saveDatingInfo(datingInfo);

		return "home";
	}
	
	//----------------------------------------------------------------------------------------------------------------
	// 			1. Exception Handling
	//----------------------------------------------------------------------------------------------------------------
	@ExceptionHandler(DatingException.class)
	public ResponseEntity<DatingExceptionResponse> UserHandler(DatingException exception) {
		DatingExceptionResponse resp = new DatingExceptionResponse(exception.getMessage(),System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value());
		ResponseEntity<DatingExceptionResponse> response = new ResponseEntity<DatingExceptionResponse>(resp, HttpStatus.BAD_REQUEST);		
		return response;
	}	
}
