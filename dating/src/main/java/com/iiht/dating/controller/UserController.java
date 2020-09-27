package com.iiht.dating.controller;

import java.io.IOException;
import java.sql.Date;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iiht.dating.exception.UserException;
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
	public String saveUserInfo(HttpServletRequest request) throws Exception {

		System.out.println("Inside Save User Information....");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Date dateOfBirth = Date.valueOf(request.getParameter("dateOfBirth"));
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");

		User user = new User();

		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setDateOfBirth(dateOfBirth);
		user.setGender(gender);
		user.setAddress(address);
		user.setLoginName(loginName);
		user.setPassword(password);
		 
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
	@RequestMapping(value = "/listAllUsers", method = RequestMethod.GET)
	public ModelAndView findAllUsers() {
		
		ModelAndView md = null;
		try {
			List<User> userList = userService.getAllUsers();

			if (!CollectionUtils.isEmpty(userList)) {
				md = new ModelAndView("displayAllUsers", "userList", userList);
			} else {
				md = new ModelAndView("home");
				throw new RuntimeException("No Records Found");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return md;		
	}
	//----------------------------------------------------------------------------------------------------------------	
	@RequestMapping(value = "/deleteUser/{userId}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable(name = "userId") Long userId) {
		
		Boolean value = userService.deleteUser(userId);
		
		if(value == true)
		{
			List<User> userList = userService.getAllUsers();
			return new ModelAndView("displayAllUsers", "userList", userList );
		}
		else
			return new ModelAndView("home");
	}	
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/editUser/{userId}", method = RequestMethod.GET)
	public ModelAndView showEditUserPage(HttpServletRequest request, @PathVariable(name = "userId") Long userId) {
		
		User user = userService.getUserById(userId);
		
	    HttpSession editUserSession = request.getSession();
	    editUserSession.setAttribute("loginName", user.getLoginName());
	    editUserSession.setAttribute("password", user.getPassword());
			    
		/*
		 * System.out.println("User Id : "+userId);
		 * System.out.println("First Name : "+user.getFirstName());
		 * System.out.println("Lasst Name : "+user.getLastName());
		 * System.out.println("Date Of Birth : "+user.getDateOfBirth());
		 * System.out.println("User Gender : "+user.getGender());
		 * System.out.println("Address : "+user.getAddress());
		 * System.out.println("Login Name : "+user.getLoginName());
		 * System.out.println("Password : "+user.getPassword());
		 */
		
	    return new ModelAndView("editUser", "userData", user);
	}
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/saveEditUser/{userId}")
	public ModelAndView updateUserInfo(HttpServletRequest request, @PathVariable(name="userId") Long userId) {

		System.out.println("Inside Saving Edited User Information....");
		
	    HttpSession editUserSession = request.getSession();

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Date dateOfBirth = Date.valueOf(request.getParameter("dateOfBirth"));
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String loginName = (String) editUserSession.getAttribute("loginName");
		String password = (String) editUserSession.getAttribute("password");

		/*
		 * System.out.println("\n"); System.out.println("After Editing");
		 * System.out.println("------------------------------------------------------");
		 * System.out.println("User Id : "+userId);
		 * System.out.println("First Name : "+firstName);
		 * System.out.println("Lasst Name : "+lastName);
		 * System.out.println("Date Of Birth : "+dateOfBirth);
		 * System.out.println("User Gender : "+gender);
		 * System.out.println("Address : "+address);
		 * System.out.println("Login Name : "+loginName);
		 * System.out.println("Password : "+password); System.out.println("\n");
		 */

	    User user = new User();
	    
		user.setUserId(userId);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setDateOfBirth(dateOfBirth);
		user.setGender(gender);
		user.setAddress(address);
		user.setLoginName(loginName);
		user.setPassword(password);
		 
		Boolean updated = userService.updateUser(user);

		if(updated == true)
		{
			List<User> userList = userService.getAllUsers();
			return new ModelAndView("displayAllUsers", "userList", userList);
		}
		else
			return new ModelAndView("editUser");
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