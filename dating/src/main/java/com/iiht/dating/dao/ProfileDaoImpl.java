package com.iiht.dating.dao;

import java.io.IOException;
//import java.io.InputStream;
//import java.sql.Blob;

//import javax.servlet.http.Part;

import org.hibernate.SessionFactory;
//import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iiht.dating.model.Profile;

@Repository
@Transactional
public class ProfileDaoImpl implements ProfileDao {

	@Autowired
	private SessionFactory sessionFactory;

	//-----------------------------------------------------------------------------------------------------------
	public Boolean saveProfile(Profile profile) throws IOException {
		
//		Long userId = profile.getUserId();
		
//		InputStream inputStream = null;													// input stream of the upload file
        //Part filePart = (Part) request.getPart("profilePhoto");						// obtains the upload file part in this multipart request
//		Part filePart = (Part) profile.getProfileImage();								// obtains the upload file part in this multipart request
//		if (filePart != null) {
//          inputStream = filePart.getInputStream();									// obtains input stream of the upload file
//      }
        //Blob photo = Hibernate.getLobCreator(sessionFactory.getCurrentSession()).createBlob(inputStream, 16177215);
        //org.springframework.web.util.NestedServletException: Request processing failed; nested exception is org.hibernate.HibernateException: Could not obtain transaction-synchronized Session for current thread

//        Blob profileImage = BlobProxy.generateProxy(inputStream, 16177215);
//        Long contactNo = profile.getContactNo();
//		String email = profile.getEmail();
//		String qualification = profile.getQualification();
//		String foodHabits = profile.getFoodHabits();
//		String hobbies = profile.getHobbies();
//		String aboutMe = profile.getAboutMe();

//		Profile newProfile = new Profile();

//		newProfile.setUserId(userId);
//		newProfile.setProfileImage(profileImage);
		//profile.setProfileImage(photo);
//		newProfile.setContactNo(contactNo);
//		newProfile.setEmail(email);
//		newProfile.setQualification(qualification);
//		newProfile.setHobbies(hobbies);
//		newProfile.setFoodHabits(foodHabits);
//		newProfile.setAboutMe(aboutMe);
		
		sessionFactory.getCurrentSession().save(profile);
		return Boolean.TRUE;
	};

	//-----------------------------------------------------------------------------------------------------------
//	@SuppressWarnings("unchecked")
//	public List<Profile> getAllProfiles() {
//		String hql = "FROM Profile";
//		return (List<Profile>) sessionFactory.getCurrentSession().createQuery(hql).list();		
//	};

	//-----------------------------------------------------------------------------------------------------------
//	public Profile getProfileById(Long userId) {
//		String hql = "SELECT us FROM Profile us where us.userId="+userId;
//		return (Profile) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
//	};
}