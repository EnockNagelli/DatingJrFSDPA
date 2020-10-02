package com.iiht.dating.utilTestClass;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import org.hibernate.engine.jdbc.BlobProxy;

import com.iiht.dating.model.DatingInfo;
import com.iiht.dating.model.Profile;
import com.iiht.dating.model.User;


public class MasterData 
{
	public static User getUserDetails() 
	{
		User user = new User();
		
		//user.setUserId(1);
		user.setFirstName("Praveen");
		user.setLastName("Kumar");
		user.setDateOfBirth(Date.valueOf("2020-11-10"));
		user.setGender("Male");
		user.setAddress("Hyderabad");
		user.setLoginName("praveen");
		user.setPassword("kumar");
		
		return user;
	}

	public static Profile getProfileDetails() 
	{
		Profile profile = new Profile();
		
		profile.setUserId((long)1);
		
		InputStream inputStream = null;														// input stream of the upload file
        Part filePart = (Part) new File("E:\\Enock's Profiles\\Nexwave Photo.jpg");			// obtains the upload file part in this multipart request
		if (filePart != null) {
			try {
				inputStream = filePart.getInputStream();									// obtains input stream of the upload file
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}																				
		}
        //Blob photo = Hibernate.getLobCreator(sessionFactory.getCurrentSession()).createBlob(inputStream, 16177215);
        //org.springframework.web.util.NestedServletException: Request processing failed; nested exception is org.hibernate.HibernateException: Could not obtain transaction-synchronized Session for current thread

        Blob profileImage = BlobProxy.generateProxy(inputStream, 16177215);
	
		profile.setProfileImage(profileImage);
		profile.setContactNo((long)12345);
		profile.setEmail("abc@gmail.com");
		profile.setQualification("B.Tech");
		profile.setHobbies("aaaa");
		profile.setFoodHabits("bbbb");
		profile.setAboutMe("cccc");
		
		return profile;
	}
	
	public static DatingInfo getDatingInfoDetails() 
	{
		DatingInfo dating = new DatingInfo();
		
		dating.setUserId((long)1);
		dating.setReceiverId((long)2);
		dating.setDatingDate(Date.valueOf("2020-12-20"));
		dating.setDatingTime(Time.valueOf("09:0:00"));
		dating.setLocation("aaaa");
		dating.setDatingRequest("bbbb");
		dating.setDatingRequest("Accepted");

		return dating;
	}
	
	public static List<User> getAllUsers() 
	{
		List<User> users = new ArrayList<User>();
		
		users.add(new User((long)1, "Praveen", "Kumar", Date.valueOf("2020-11-10"), "Male", "Hyderabad", "praveen", "kumar"));
		users.add(new User((long)2, "Shekar", "Gupta", Date.valueOf("2020-12-10"), "Male", "Mumbai", "shekar", "gupta"));
		users.add(new User((long)3, "Sneha", "Latha", Date.valueOf("2020-12-10"), "Female", "Chennai", "sneha", "latha"));
		users.add(new User((long)4, "Rinkki", "Ford", Date.valueOf("2020-12-10"), "Female", "New York", "rinkki", "ford"));

		return users;
	}
	
	public static List<DatingInfo> getAllDatingInfo(){
		
		List<DatingInfo> dating = new ArrayList<DatingInfo>();
		
		dating.add(new DatingInfo((long)1, (long)3, Date.valueOf("2020-12-20"), Time.valueOf("09:0:00"), "aaaa","bbbb","cccc"));
		dating.add(new DatingInfo((long)2, (long)4, Date.valueOf("2020-12-20"), Time.valueOf("09:0:00"), "aaaa","bbbb","cccc"));
		dating.add(new DatingInfo((long)5, (long)7, Date.valueOf("2020-12-20"), Time.valueOf("09:0:00"), "aaaa","bbbb","cccc"));
		dating.add(new DatingInfo((long)6, (long)8, Date.valueOf("2020-12-20"), Time.valueOf("09:0:00"), "aaaa","bbbb","cccc"));
		
		return dating;
	}
}