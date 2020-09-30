package com.iiht.dating.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iiht.dating.exception.InvalidUserException;
import com.iiht.dating.exception.UserNotFoundException;
import com.iiht.dating.model.User;
import com.iiht.dating.model.UserExceptionResponse;
import com.iiht.dating.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	//----------------------------------------------------------------------------------------------------------------
	// 			1. BASIC FUNCTIONALITY
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView startController(HttpServletResponse response) throws IOException{
		System.out.println("Server Started. Inside the User controller. Serving upon landing page...");
		return new ModelAndView("home");
	}

	//----------------------------------------------------------------------------------------------------------------
	// 			2. LOGIN AUTHENTICATION FOR DATING APPLICATION
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/initUser", method = RequestMethod.GET)
	public ModelAndView initView(Model model) {
		model.addAttribute("userform", new User());
		return new ModelAndView("loginForm");
	}
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value="/loginInfo", method= RequestMethod.POST)
	public ModelAndView doLogin(HttpServletRequest request, @Valid @ModelAttribute("userform") User user, BindingResult bindingResult) {

		System.out.println("Inside Login authentication....");
		
		String loginName = user.getLoginName();
		String password = user.getPassword();
		
		HttpSession session = request.getSession();
		ModelAndView mav = null;

		try 
		{
			boolean validUser = userService.validateUser(loginName, password);
			
			if (bindingResult.hasErrors() || validUser == false) {
				mav = new ModelAndView("initUser");
			} else {
				session.setAttribute("loginName", loginName);
				mav = new ModelAndView("home");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		return mav;
	}

	//----------------------------------------------------------------------------------------------------------------
	// 			3. ADD NEW USER INFORMATION FOR DATING APPLICATION
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/registerUser", method = RequestMethod.GET)
	public ModelAndView addNewUser(Model model) {
		model.addAttribute("userform", new User());
		return new ModelAndView("registerUser");
	}
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView saveUserInfo(@Valid @ModelAttribute("userform") User user, BindingResult bindingResult) throws InvalidUserException {

		System.out.println("Inside Save User Information....");
		
		ModelAndView mav = null;
		try 
		{
			Boolean validUser = userService.saveUser(user);
			if (bindingResult.hasErrors() || validUser == false) {
				mav = new ModelAndView("registerUser");
			} else {
				mav = new ModelAndView("home");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		return mav;
	}

	//----------------------------------------------------------------------------------------------------------------
	// 			4. LIST ALL REGISTERED USERS IN DATING APPLICATION
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/listAllUsers", method = RequestMethod.GET)
	public ModelAndView findAllUsers() {
			
		//String loginName= (String) session.getAttribute("loginName");
		
		ModelAndView mav = null;
		try 
		{
			List<User> userList = userService.getAllUsers();

			if (!CollectionUtils.isEmpty(userList)) {
				mav = new ModelAndView("displayAllUsers", "userList", userList);
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
	@ExceptionHandler(InvalidUserException.class)
	public ResponseEntity<UserExceptionResponse> UserHandler(InvalidUserException exception) {
		UserExceptionResponse resp = new UserExceptionResponse(exception.getMessage(),System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value());
		ResponseEntity<UserExceptionResponse> response = new ResponseEntity<UserExceptionResponse>(resp, HttpStatus.BAD_REQUEST);		
		return response;
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ModelAndView UserNotFoundHandler(UserNotFoundException exception) {
	//public ResponseEntity<UserExceptionResponse> UserNotFoundHandler(UserNotFoundException exception) {
		UserExceptionResponse resp = new UserExceptionResponse(exception.getMessage(),System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		ModelAndView mav = new ModelAndView();
		mav.addObject(resp.getMessage());
		//ResponseEntity<UserExceptionResponse> response = new ResponseEntity<UserExceptionResponse>(resp, HttpStatus.NOT_FOUND);
		//return response;
		return mav;
	}	
}