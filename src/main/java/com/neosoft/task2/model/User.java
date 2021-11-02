package com.neosoft.task2.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;


@Entity
@SQLDelete(sql = "UPDATE User SET deleted=true WHERE id=?")
@Where(clause = "deleted = false")
@Data
 public class User {
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	@Size(min = 3, max = 50)
	private String name;
	
	@NotEmpty
	private String surname;
	
	private String city;
	
	@NotNull
	private long pincode;
	
	@NotNull
	@Email
	private String email;
	private Date dob;
	private Date joiningDate;
	 
	 @Min(value = 20000)
	 @Max(value = 200000)
	 private long income;

	 private Boolean deleted;

	

	
	 
}
