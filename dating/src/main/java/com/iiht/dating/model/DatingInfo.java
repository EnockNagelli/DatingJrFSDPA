package com.iiht.dating.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DatingInfo")
public class DatingInfo implements Serializable {
	
	private static final long serialVersionUID = -4832839635515608633L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "userId")
	private Long userId;
	
	@NotNull
	@Column(name = "datingDate")
	private LocalDate datingDate;

	@NotNull
	@Column(name = "datingTime")
	private LocalTime datingTime;

	@NotNull
	@Size(min=1, max=255)
	@Column(name = "location")
	private String location;
	
	@NotNull
	@Size(min=1, max=255)
	@Column(name = "status")
	private String status;								//Accepted / Rejected

	@NotNull
	@Size(min=1, max=255)
	@Column(name = "datingRequest")
	private String datingRequest;						//description about the dating	
}