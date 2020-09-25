package com.iiht.dating.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name="Profile")
public class Profile {

	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "userId")
	private Long userId;

	@NotNull
	@Column(name = "image", unique=true)
	private Blob image;

	@NotNull
	@Size(min=3, max=50)
	@Column(name = "contactNo")
	private Long contactNo;
	
	@NotNull
	@Size(min=1, max=255)
	@Column(name = "email")
	private String email;

	@NotNull
	@Size(min=1, max=255)
	@Column(name = "qualification")
	private String qualification;

	@NotNull
	@Size(min=1, max=255)
	@Column(name = "hobbies")
	private String hobbies;

	@NotNull
	@Size(min=1, max=255)
	@Column(name = "foodHabits")
	private String foodHabits;

	@NotNull
	@Size(min=1, max=255)
	@Column(name = "aboutMe")
	private String aboutMe;

	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profile(Long userId, @NotNull Blob image, @NotNull @Size(min = 3, max = 50) Long contactNo,
			@NotNull @Size(min = 1, max = 255) String email, @NotNull @Size(min = 1, max = 255) String qualification,
			@NotNull @Size(min = 1, max = 255) String hobbies, @NotNull @Size(min = 1, max = 255) String foodHabits,
			@NotNull @Size(min = 1, max = 255) String aboutMe) {
		super();
		this.userId = userId;
		this.image = image;
		this.contactNo = contactNo;
		this.email = email;
		this.qualification = qualification;
		this.hobbies = hobbies;
		this.foodHabits = foodHabits;
		this.aboutMe = aboutMe;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}

	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getFoodHabits() {
		return foodHabits;
	}
	public void setFoodHabits(String foodHabits) {
		this.foodHabits = foodHabits;
	}

	public String getAboutMe() {
		return aboutMe;
	}
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
}