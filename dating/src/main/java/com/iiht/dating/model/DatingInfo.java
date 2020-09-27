package com.iiht.dating.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "datingInfo")
public class DatingInfo implements Serializable {
	
	private static final long serialVersionUID = -4832839635515608633L;

	@Id
	@Column(name = "userId")
	private Long userId;

	@NotNull
	@Column(name = "receiverId")
	private Long receiverId;
	
	@NotNull
	@Column(name = "datingDate")
	private Date datingDate;

	@NotNull
	@Column(name = "datingTime")
	private Time datingTime;

	@NotNull
	@Size(min=1, max=255)
	@Column(name = "location")
	private String location;
	
	@NotNull
	@Size(min=1, max=255)
	@Column(name = "requestStatus")
	private String requestStatus;								//Accepted / Rejected

	@NotNull
	@Size(min=1, max=255)
	@Column(name = "datingRequest")
	private String datingRequest;								//description about the dating

	public DatingInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DatingInfo(Long userId, @NotNull Long receiverId, @NotNull Date datingDate,
			@NotNull Time datingTime, @NotNull @Size(min = 1, max = 255) String location,
			@NotNull @Size(min = 1, max = 255) String requestStatus,
			@NotNull @Size(min = 1, max = 255) String datingRequest) {
		super();
		this.userId = userId;
		this.receiverId = receiverId;
		this.datingDate = datingDate;
		this.datingTime = datingTime;
		this.location = location;
		this.requestStatus = requestStatus;
		this.datingRequest = datingRequest;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}

	public Date getDatingDate() {
		return datingDate;
	}
	public void setDatingDate(Date datingDate) {
		this.datingDate = datingDate;
	}

	public Time getDatingTime() {
		return datingTime;
	}
	public void setDatingTime(Time datingTime) {
		this.datingTime = datingTime;
	}

	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getDatingRequest() {
		return datingRequest;
	}
	public void setDatingRequest(String datingRequest) {
		this.datingRequest = datingRequest;
	}
}