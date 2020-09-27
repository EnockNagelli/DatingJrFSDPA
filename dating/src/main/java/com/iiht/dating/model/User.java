package com.iiht.dating.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="User")
public class User implements Serializable {

	private static final long serialVersionUID = 8744222782294589450L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "userId")
	private Long userId;

	@NotNull
	@Size(min=3, max=50)
	@Column(name = "firstName")
	private String firstName;

	@NotNull
	@Size(min=3, max=50)
	@Column(name = "lastName")
	private String lastName;

	@NotNull
	@Column(name = "dateOfBirth")
	private Date dateOfBirth;

	@NotNull
	@Size(min=4, max=6)
	@Column(name = "gender")
	private String gender;

	@NotNull
	@Size(min=1, max=255)
	@Column(name = "address")
	private String address;

	@NotNull
	@Size(min=1, max=100)
	@Column(name = "loginName")
	private String loginName;

	@NotNull
	@Size(min=6, max=10, message="required")  
	@Column(name = "password")
	private String password;
	
	@OneToOne(cascade= {CascadeType.MERGE})
	@JoinColumn(name="userId")
	private Profile profile;

	//@OneToMany(cascade= {CascadeType.MERGE})
	//@JoinColumn(name="userId")
	//private DatingInfo datingInfo;

	public User() {
		super();
	}	
	
	public User(Long userId, @NotNull @Size(min = 3, max = 50) String firstName,
			@NotNull @Size(min = 3, max = 50) String lastName, @NotNull Date dateOfBirth,
			@NotNull @Size(min = 4, max = 6) String gender, @NotNull @Size(min = 1, max = 255) String address,
			@NotNull @Size(min = 1, max = 100) String loginName,
			@NotNull @Size(min = 6, max = 10, message = "required") String password) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.address = address;
		this.loginName = loginName;
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}