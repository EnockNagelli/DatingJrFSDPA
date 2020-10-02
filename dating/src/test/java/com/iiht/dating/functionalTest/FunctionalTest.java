package com.iiht.dating.functionalTest;

import static com.iiht.dating.utilTestClass.TestUtils.businessTestFile;
import static com.iiht.dating.utilTestClass.TestUtils.currentTest;
import static com.iiht.dating.utilTestClass.TestUtils.yakshaAssert;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.iiht.dating.utilTestClass.MasterData;

import com.iiht.dating.controller.DatingController;
import com.iiht.dating.controller.ProfileController;
import com.iiht.dating.controller.UserController;
import com.iiht.dating.model.DatingInfo;
import com.iiht.dating.model.Profile;
import com.iiht.dating.model.User;
import com.iiht.dating.service.DatingService;
import com.iiht.dating.service.ProfileService;
import com.iiht.dating.service.UserService;

public class FunctionalTest 
{
	@Mock
	private UserService userService;

	@Mock
	private ProfileService profileService;

	@Mock
	private DatingService datingService;
	
	@InjectMocks
	private UserController userController;

	@InjectMocks
	private ProfileController profileController;
	
	@InjectMocks
	private DatingController datingController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() throws Exception 
	{
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(userController, profileController, datingController).build();
	}

	//------------------------------------------------------------------------------------------------------------------------------------
	/*
	 * Description	: This test is to perform Loading the landing page URL
	 */
	@Test
	public void testLoadingPageUrl() throws Exception 
	{
		MvcResult result = this.mockMvc.perform(get("/")).andReturn();
		System.out.println(result.getResponse().getForwardedUrl());
	    yakshaAssert(currentTest(), 
	    		result.getResponse().getForwardedUrl()!=null && result.getResponse().getForwardedUrl().contentEquals("home") ? true : false, 
	    			businessTestFile);
	}
	//------------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testNewLoginUrl() throws Exception 
	{
		MvcResult result = this.mockMvc.perform(get("/initUser")).andReturn();
		System.out.println(result.getResponse().getForwardedUrl());
	    yakshaAssert(currentTest(), 
	    			result.getResponse().getForwardedUrl()!=null && result.getResponse().getForwardedUrl().contentEquals("loginInfo") ? true : false, 
	    			businessTestFile);
	}
	//------------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testNewLoginValidation() throws Exception 
	{
		User user = MasterData.getUserDetails();

		Mockito.when(this.userService.validateUser("", "")).thenReturn(true);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/loginInfo")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("loginName", user.getLoginName())
				.param("password", user.getPassword());
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse().getForwardedUrl());
		
		yakshaAssert(currentTest(),
				result.getResponse().getForwardedUrl()!=null && result.getResponse().getForwardedUrl().contentEquals("home") ? true : false,
				businessTestFile);	
	}	
	//------------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testRegisterUserUrl() throws Exception 
	{
		MvcResult result = this.mockMvc.perform(get("/registerUser")).andReturn();
		System.out.println(result.getResponse().getForwardedUrl());
	    yakshaAssert(currentTest(), 
	    		result.getResponse().getForwardedUrl()!=null && result.getResponse().getForwardedUrl().contentEquals("saveUser") ? true : false, 
	    			businessTestFile);
	}
	//------------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testSaveNewPost() throws Exception 
	{
		User user = MasterData.getUserDetails();

		user.setUserId((long)1);
		
		Mockito.when(this.userService.saveUser(user)).thenReturn(true);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/saveUser")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("firstName", user.getFirstName())
				.param("lastName", user.getLastName())
				.param("dateOfBirth", user.getDateOfBirth().toString())
				.param("gender", user.getGender())
				.param("address", user.getAddress())
				.param("loginName", user.getLoginName())
				.param("password", user.getPassword());

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse().getRedirectedUrl());
		System.out.println(result.getResponse().getForwardedUrl());

		yakshaAssert(currentTest(), 
				result.getResponse().getRedirectedUrl()!=null && result.getResponse().getRedirectedUrl().contentEquals("home") ? true : false, 
    			businessTestFile);
	}
	//------------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testListAllUsers() throws Exception 
	{
		List<User> users = MasterData.getAllUsers();

		Mockito.when(this.userService.getAllUsers()).thenReturn(users);

		MvcResult result = this.mockMvc.perform(get("/listAllUsers")).andReturn();
		
		yakshaAssert(currentTest(), 
				result.getResponse().getForwardedUrl()!=null && result.getResponse().getForwardedUrl().contentEquals("displayAllUsers") ? true : false, 
    			businessTestFile);		
	}
	//------------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testNewProfileUrl() throws Exception 
	{
		MvcResult result = this.mockMvc.perform(get("/initProfile")).andReturn();
		System.out.println(result.getResponse().getForwardedUrl());
	    yakshaAssert(currentTest(), 
	    			result.getResponse().getForwardedUrl()!=null && result.getResponse().getForwardedUrl().contentEquals("saveProfile") ? true : false, 
	    			businessTestFile);
	}
	//------------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testSaveProfile() throws Exception 
	{
		Profile profile = MasterData.getProfileDetails();
		Profile newProfile = MasterData.getProfileDetails();
		
		newProfile.setUserId((long)1);

		Mockito.when(this.profileService.saveProfile(profile)).thenReturn(true);
				
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/saveProfile")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("userId", profile.getUserId().toString())
				.param("profileImage", profile.getProfileImage().toString())
				.param("contactNo", profile.getContactNo().toString())
				.param("email", profile.getEmail())
				.param("qualification", profile.getQualification())
				.param("hobbies", profile.getHobbies())
				.param("foodHabits", profile.getFoodHabits())
				.param("aboutMe", profile.getAboutMe());
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse().getRedirectedUrl());
		System.out.println(result.getResponse().getForwardedUrl());

		yakshaAssert(currentTest(), 
				result.getResponse().getRedirectedUrl()!=null && result.getResponse().getRedirectedUrl().contentEquals("home") ? true : false, 
    			businessTestFile);
	}
	//------------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testInitDatingById() throws Exception
	{
		DatingInfo dating = MasterData.getDatingInfoDetails();

		dating.setUserId((long)1);

		Mockito.when(this.datingController.initDating((long)1, null, null)).thenReturn("datingDetails");
		
		Mockito.when(this.datingService.getAllDatingProposals()).thenReturn(MasterData.getAllDatingInfo());

		MvcResult result = this.mockMvc.perform(get("/initDating/"+1)).andReturn();
		
		yakshaAssert(currentTest(), 
				result.getResponse().getForwardedUrl()!=null && result.getResponse().getForwardedUrl().contentEquals("datingDetails") ? true : false, 
    			businessTestFile);
	}
	//------------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testSaveDatingProposal() throws Exception 
	{
		DatingInfo datingInfo = MasterData.getDatingInfoDetails();
		DatingInfo newDatingInfo = MasterData.getDatingInfoDetails();
		
		newDatingInfo.setUserId((long)1);

		Mockito.when(this.datingService.saveDatingInfo(datingInfo)).thenReturn(true);
				
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/saveDatingProposal")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("userId", datingInfo.getUserId().toString())
				.param("receiverId", datingInfo.getReceiverId().toString())
				.param("datingDate", datingInfo.getDatingDate().toString())
				.param("datingTime", datingInfo.getDatingTime().toString())
				.param("location", datingInfo.getLocation())
				.param("requestStatus", datingInfo.getRequestStatus())
				.param("datingRequest", datingInfo.getDatingRequest());
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse().getRedirectedUrl());
		System.out.println(result.getResponse().getForwardedUrl());

		yakshaAssert(currentTest(), 
				result.getResponse().getRedirectedUrl()!=null && result.getResponse().getRedirectedUrl().contentEquals("home") ? true : false, 
    			businessTestFile);
	}
	//------------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testViewAllDatingProposals() throws Exception
	{
		List<DatingInfo> listDatingInfo = MasterData.getAllDatingInfo();
		
		Mockito.when(this.datingService.getAllDatingProposals()).thenReturn(listDatingInfo);
		
		MvcResult result = this.mockMvc.perform(get("/listDatingProposals")).andReturn();
		
		yakshaAssert(currentTest(), 
    			result.getResponse().getForwardedUrl()!=null && result.getResponse().getForwardedUrl().contentEquals("home") ? true : false, 
    			businessTestFile);
	}
}