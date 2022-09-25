package com.backend.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private int id;
	@NotBlank(message = "Name cannot be blank!")
	@Column(name = "emp_name")
	private String name;
	@NotBlank
	@Column(name = "job_title")
	private String jobTitle;
	@NotBlank
	@Pattern(regexp = "^[6-9]*\\d{9}", message = "Invalid phone number!")
	@Length(max = 10, min = 10, message = "Invalid phone number!")
	@Column(name = "emp_phone_no")
	private String phoneNo;
	@Email
	@NotBlank
	private String email;
	@NotBlank
	private String fullAddress;
	private String emergencyContactName;
	@Pattern(regexp = "^[6-9]*\\d{9}", message = "Invalid phone number!")
	@Length(max = 10, min = 10, message = "Invalid phone number!")
	private String emergencyContactPhone;
	private String relationship;

}