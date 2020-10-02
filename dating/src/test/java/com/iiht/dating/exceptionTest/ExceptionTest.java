package com.iiht.dating.exceptionTest;

import static com.iiht.dating.utilTestClass.TestUtils.exceptionTestFile;
import static com.iiht.dating.utilTestClass.TestUtils.currentTest;
import static com.iiht.dating.utilTestClass.TestUtils.yakshaAssert;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.iiht.dating.controller.DatingController;
import com.iiht.dating.controller.UserController;
import com.iiht.dating.service.DatingService;
import com.iiht.dating.service.UserService;

public class ExceptionTest {
	
	@Mock
	private UserService userService;

	@Mock
	private DatingService datingService;
	
	@InjectMocks
	private UserController userController;

	@InjectMocks
	private DatingController datingController;
	
	private MockMvc mockMvc;

	//-----------------------------------------------------------------------------------------------------------------------------
	@Before
	public void setup() throws Exception 
	{
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(userController, datingController).build();	
	}
	//-----------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testListAllUserForException() throws Exception 
	{
		Mockito.when(this.userService.getAllUsers()).thenReturn(null);
		
		MvcResult result = this.mockMvc.perform(get("/listAllUsers")).andReturn();
		yakshaAssert(currentTest(), 
				result.getResponse().getForwardedUrl()!=null && result.getResponse().getForwardedUrl().contentEquals("error") ? true : false, 
    			exceptionTestFile);	
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testListAllDatingProposalsForException() throws Exception 
	{
		Mockito.when(this.datingService.getAllDatingProposals()).thenReturn(null);
		
		MvcResult result = this.mockMvc.perform(get("/listDatingProposals")).andReturn();
		yakshaAssert(currentTest(), 
				result.getResponse().getForwardedUrl()!=null && result.getResponse().getForwardedUrl().contentEquals("error") ? true : false, 
    			exceptionTestFile);	
	}	
}