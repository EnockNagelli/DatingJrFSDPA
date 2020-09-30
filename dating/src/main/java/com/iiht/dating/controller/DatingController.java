package com.iiht.dating.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iiht.dating.exception.InvalidDatingException;
import com.iiht.dating.exception.UserNotFoundException;
import com.iiht.dating.model.DatingExceptionResponse;
import com.iiht.dating.model.DatingInfo;
import com.iiht.dating.model.User;
import com.iiht.dating.service.DatingService;

@Controller
public class DatingController {

	@Autowired
	private DatingService datingService;
	
	//----------------------------------------------------------------------------------------------------------------
	// 			1. ADD DATING INFORMATION FOR DATING APPLICATION
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/initDating/{userId}", method = RequestMethod.GET)
	public String initView(@PathVariable(name = "userId") Long userId, HttpSession session, Model model) {
		
		Long loginUserId = (Long) session.getAttribute("loginUserId");
		
		model.addAttribute("loginUserId", loginUserId);					// Sender
		model.addAttribute("userId", userId);							// Receiver

		model.addAttribute("datingDetails", new DatingInfo());
		return "datingDetails";
	}
	
	//----------------------------------------------------------------------------------------------------------------
	//@RequestMapping(value = "/saveDatingProposal", method = {RequestMethod.GET, RequestMethod.POST})
	@PostMapping(value = "/saveDatingProposal")
	public ModelAndView saveDatingProposal(HttpServletRequest request) throws InvalidDatingException {
	//public ModelAndView saveDatingProposal(HttpServletRequest request, @Valid @ModelAttribute("datingDetails") DatingInfo datingInfo, BindingResult bindingResult) throws InvalidDatingException {
	//public ModelAndView saveDatingProposal(@Valid @ModelAttribute("datingDetails") DatingInfo datingInfo, BindingResult bindingResult) throws InvalidDatingException {

		System.out.println("Inside Save Dating Proposal....");

		Long userId = Long.parseLong(request.getParameter("userId"));
		Long receiverId = Long.parseLong(request.getParameter("receiverId"));
		Date datingDay = Date.valueOf(request.getParameter("datingDate"));
		Time datingTime = Time.valueOf(request.getParameter("datingTime"));

//		Long userId = datingInfo.getUserId();
//		Long receiverId = datingInfo.getReceiverId();
//		Date datingDay = datingInfo.getDatingDate();
//		Time datingTime = datingInfo.getDatingTime();
				
		System.out.println("User Id : "+userId);
		System.out.println("Receiver Id : "+receiverId);
		System.out.println("Dating Day  : "+datingDay);
		System.out.println("Dating Time : "+datingTime);
		
		ModelAndView mav = null;
//		try {
//			Boolean validUser = datingService.saveDatingInfo(datingInfo);
//			if (bindingResult.hasErrors() || validUser == false) {
//				mav = new ModelAndView("initDating");
//			} else {
//				mav = new ModelAndView("home");
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}		
		return mav;		
	}

	//----------------------------------------------------------------------------------------------------------------
	// 			2. LIST ALL DATING PROPOSALS AVAILABLE AT DATING APPLICATION
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/listDatingProposals", method = RequestMethod.GET)
	public ModelAndView findAllProposals() {
		
		ModelAndView mav = null;
		try 
		{
			List<DatingInfo> datingList = datingService.getAllDatingProposals();

			if (!CollectionUtils.isEmpty(datingList)) {
				mav = new ModelAndView("displayAllDatingProposals", "datingList", datingList);
			} else {
				//mav = new ModelAndView("home");
				throw new UserNotFoundException("No Records Found");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return mav;		
	}	
	
	//----------------------------------------------------------------------------------------------------------------
	// 			1. Exception Handling
	//----------------------------------------------------------------------------------------------------------------
	@ExceptionHandler(InvalidDatingException.class)
	public ResponseEntity<DatingExceptionResponse> UserHandler(InvalidDatingException exception) {
		DatingExceptionResponse resp = new DatingExceptionResponse(exception.getMessage(),System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value());
		ResponseEntity<DatingExceptionResponse> response = new ResponseEntity<DatingExceptionResponse>(resp, HttpStatus.BAD_REQUEST);		
		return response;
	}	
}
