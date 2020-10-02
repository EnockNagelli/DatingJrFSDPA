package com.iiht.dating.entityValidationTest;

import static com.iiht.dating.utilTestClass.TestUtils.boundaryTestFile;
import static com.iiht.dating.utilTestClass.TestUtils.currentTest;
import static com.iiht.dating.utilTestClass.TestUtils.yakshaAssert;

import java.io.IOException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import com.iiht.dating.model.DatingInfo;
import com.iiht.dating.model.Profile;
import com.iiht.dating.model.User;
import com.iiht.dating.utilTestClass.MasterData;

public class EntityValidationTest {
    private Validator validator;
    
    //----------------------------------------------------------------------------------------------
    @Before
    public void setUp() {
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    //----------------------------------------------------------------------------------------------
    @Test
    public void testUserSuccess() throws IOException {
    	User user = MasterData.getUserDetails();
        Set<ConstraintViolation<User>> violations = validator.validate(user);
	    yakshaAssert(currentTest(), violations.isEmpty() ? true : false, boundaryTestFile);	    
    }
    @Test
    public void testUserFailed() throws IOException {
    	User user = MasterData.getUserDetails();
    	user.setFirstName(null);
        Set<ConstraintViolation<User>> violations = validator.validate(user);
	    yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    //----------------------------------------------------------------------------------------------
    @Test
    public void testProfileSuccess() throws IOException {
    	Profile profile = MasterData.getProfileDetails();
        Set<ConstraintViolation<Profile>> violations = validator.validate(profile);
	    yakshaAssert(currentTest(), violations.isEmpty() ? true : false, boundaryTestFile);
    }
    @Test
    public void testProfileFailed() throws IOException {
    	Profile profile = MasterData.getProfileDetails();
    	profile.setContactNo(null);
    	Set<ConstraintViolation<Profile>> violations = validator.validate(profile);
	    yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }
    
    
    //----------------------------------------------------------------------------------------------
    @Test
    public void testDatingInfoSuccess() throws IOException {
    	DatingInfo datingInfo = MasterData.getDatingInfoDetails();
        Set<ConstraintViolation<DatingInfo>> violations = validator.validate(datingInfo);
	    yakshaAssert(currentTest(), violations.isEmpty() ? true : false, boundaryTestFile);
    }
    @Test
    public void testDatingInfoFailed() throws IOException {
    	DatingInfo datingInfo = MasterData.getDatingInfoDetails();
    	datingInfo.setDatingDate(null);
    	Set<ConstraintViolation<DatingInfo>> violations = validator.validate(datingInfo);
	    yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }    
}
