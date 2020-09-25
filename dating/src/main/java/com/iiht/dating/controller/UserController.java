package com.iiht.dating.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import com.iiht.dating.exception.UserException;
import com.iiht.dating.exception.UserNotFoundException;
import com.iiht.dating.model.User;
import com.iiht.dating.model.UserExceptionResponse;
import com.iiht.dating.service.UserService;

@Controller
//@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	//----------------------------------------------------------------------------------------------------------------
	// 			1. BASIC FUNCTIONALITY
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView startController(HttpServletResponse response) throws IOException{
		System.out.println("Server Started. Inside the controller. Serving upon landing page...");
		return new ModelAndView("home");
	}

	//----------------------------------------------------------------------------------------------------------------
	// 			2. ADD NEW USER INFORMATION FOR DATING APPLICATION
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/registerUser", method = RequestMethod.GET)
	public ModelAndView addNewUser() {
		return new ModelAndView("registerUser");
	}
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/initUser", method = RequestMethod.GET)
	public String initView(Model model) {
		model.addAttribute("userform", new User());
		return "loginForm";
	}	
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUserInfo(HttpServletRequest request) {

		System.out.println("Inside Save User Information....");
		
		//Long userId = Long.parseLong(request.getParameter("userId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"));
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");

		User user = new User();

		//user.setUserId(userId);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setDateOfBirth(dateOfBirth);
		user.setGender(gender);
		user.setAddress(address);
		user.setLoginName(loginName);
		user.setPassword(password);

		/*
		 * System.out.println("Company Details : ");
		 * System.out.println("----------------------------------");
		 * System.out.println("1. Company Code : " + companyDetails.getCompanyCode());
		 * System.out.println("2. Registered Stock Exchange : " + companyDetails.getStockExchange()); 
		 * System.out.println("3. Company Name : " + companyDetails.getCompanyName()); 
		 * System.out.println("4. Company CEO : " + companyDetails.getCompanyCEO()); 
		 * System.out.println("5. Company Turnover : " + companyDetails.getTurnover());
		 * System.out.println("6. Board Of Directors : " + companyDetails.getBoardOfDirectors());
		 * System.out.println("7. Company Profile : " + companyDetails.getCompanyProfile());
		 * System.out.println("----------------------------------");
		 */
		 
		userService.saveUser(user);

		return "home";
	}
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value="/loginInfo", method= RequestMethod.POST)
	public ModelAndView doLogin(@Valid @ModelAttribute("userform") User user, BindingResult result) {

		System.out.println("Inside Login authentication....");
		
		String loginName = user.getLoginName();
		String password = user.getPassword();
		
		boolean validUser = userService.validateUser(loginName, password);
			
		if (validUser == false || result.hasErrors()) {
            return new ModelAndView("loginForm");
        }
        return new ModelAndView("home");
	}

	//----------------------------------------------------------------------------------------------------------------	
	@RequestMapping("/listAllUsers")
	public ModelAndView findAllUsers(){
		return new ModelAndView();
	}

	
	//----------------------------------------------------------------------------------------------------------------
	// 			1. Exception Handling
	//----------------------------------------------------------------------------------------------------------------
	@ExceptionHandler(UserException.class)
	public ResponseEntity<UserExceptionResponse> UserHandler(UserException exception) {
		UserExceptionResponse resp = new UserExceptionResponse(exception.getMessage(),System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value());
		ResponseEntity<UserExceptionResponse> response = new ResponseEntity<UserExceptionResponse>(resp, HttpStatus.BAD_REQUEST);		
		return response;
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<UserExceptionResponse> UserNotFoundHandler(UserNotFoundException exception) {
		UserExceptionResponse resp = new UserExceptionResponse(exception.getMessage(),System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		ResponseEntity<UserExceptionResponse> response = new ResponseEntity<UserExceptionResponse>(resp, HttpStatus.NOT_FOUND);
		return response;
	}	
}