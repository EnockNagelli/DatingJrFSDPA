package com.iiht.dating.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iiht.dating.exception.InvalidProfileException;
import com.iiht.dating.model.Profile;
import com.iiht.dating.model.ProfileExceptionResponse;
import com.iiht.dating.service.ProfileService;

@Controller
public class ProfileController {

	@Autowired
	private ProfileService profileService;
	
	//----------------------------------------------------------------------------------------------------------------
	// 			1. ADD PROFILE INFORMATION FOR DATING APPLICATION
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/initProfile", method = RequestMethod.GET)
	public String initView(Model model) {
		model.addAttribute("profileData", new Profile());
		return "profileInfo";
	}	
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/saveProfile", method = RequestMethod.POST)
	public ModelAndView saveProfileInfo(@Valid @ModelAttribute("profileData") Profile profile, BindingResult bindingResult) throws InvalidProfileException {

		System.out.println("Inside Save Profile Information....");
		ModelAndView mav = null;
		try {
			Boolean validUser = profileService.saveProfile(profile);
			if (bindingResult.hasErrors() || validUser == false) {
				mav = new ModelAndView("initProfile");
			} else {
				mav = new ModelAndView("home");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		return mav;		
	}
	
	//----------------------------------------------------------------------------------------------------------------
	// 			1. Exception Handling
	//----------------------------------------------------------------------------------------------------------------
	@ExceptionHandler(InvalidProfileException.class)
	public ResponseEntity<ProfileExceptionResponse> UserHandler(InvalidProfileException exception) {
		ProfileExceptionResponse resp = new ProfileExceptionResponse(exception.getMessage(),System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value());
		ResponseEntity<ProfileExceptionResponse> response = new ResponseEntity<ProfileExceptionResponse>(resp, HttpStatus.BAD_REQUEST);		
		return response;
	}

//	@ExceptionHandler(ProfileNotFoundException.class)
//	public ResponseEntity<ProfileExceptionResponse> UserNotFoundHandler(ProfileNotFoundException exception) {
//		ProfileExceptionResponse resp = new ProfileExceptionResponse(exception.getMessage(),System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
//		ResponseEntity<ProfileExceptionResponse> response = new ResponseEntity<ProfileExceptionResponse>(resp, HttpStatus.NOT_FOUND);
//		return response;
//	}	
}