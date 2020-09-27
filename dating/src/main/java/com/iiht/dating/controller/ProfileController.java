package com.iiht.dating.controller;

import java.io.InputStream;
import java.sql.Blob;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iiht.dating.exception.ProfileException;
import com.iiht.dating.model.Profile;
import com.iiht.dating.model.ProfileExceptionResponse;
import com.iiht.dating.service.ProfileService;

@Controller
public class ProfileController {

	@Autowired
	private ProfileService profileService;
	
//	@Autowired
//	private SessionFactory sessionFactory;
	
	//----------------------------------------------------------------------------------------------------------------
	// 			1. ADD PROFILE INFORMATION FOR DATING APPLICATION
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/initProfile", method = RequestMethod.GET)
	public String initView(Model model) {
		model.addAttribute("profileForm", new Profile());
		return "profileInfo";
	}	
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/saveProfile", method = RequestMethod.POST)
	public String saveProfileInfo(HttpServletRequest request) throws Exception {

		System.out.println("Inside Save Profile Information....");
		
		Long userId = Long.parseLong(request.getParameter("userId"));
		
		InputStream inputStream = null;																	// input stream of the upload file
        Part filePart = (Part) request.getPart("userPhoto");											// obtains the upload file part in this multipart request
        if (filePart != null) {
            inputStream = filePart.getInputStream();													// obtains input stream of the upload file
        }
        //Blob photo = Hibernate.getLobCreator(sessionFactory.getCurrentSession()).createBlob(inputStream, 16177215);
        //org.springframework.web.util.NestedServletException: Request processing failed; nested exception is org.hibernate.HibernateException: Could not obtain transaction-synchronized Session for current thread

        Blob profileImage = BlobProxy.generateProxy(inputStream, 16177215);
        Long contactNo = Long.parseLong(request.getParameter("contactNo"));
		String email = request.getParameter("email");
		String qualification = request.getParameter("qualification");
		String foodHabits = request.getParameter("foodHabits");
		String hobbies = request.getParameter("hobbies");
		String aboutMe = request.getParameter("aboutMe");

		Profile profile = new Profile();

		profile.setUserId(userId);
		profile.setProfileImage(profileImage);
		//profile.setProfileImage(photo);
		profile.setContactNo(contactNo);
		profile.setEmail(email);
		profile.setQualification(qualification);
		profile.setHobbies(hobbies);
		profile.setFoodHabits(foodHabits);
		profile.setAboutMe(aboutMe);

		profileService.saveProfile(profile);

		return "home";
	}
	
	//----------------------------------------------------------------------------------------------------------------
	// 			1. Exception Handling
	//----------------------------------------------------------------------------------------------------------------
	@ExceptionHandler(ProfileException.class)
	public ResponseEntity<ProfileExceptionResponse> UserHandler(ProfileException exception) {
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