package com.praba.myproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UserData", schema = "dbo")
public class UserData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", length = 8)
	private Long id;
	
	@Column(name="FirstName", nullable=false, length=32)
	private String firstName;
	
	@Column(name="LastName", length=32)
	private String lastName;
	
	@Column(name="MiddleName", length=32)
	private String middleName;
	
	@Column(name="UserID", nullable=false, length=32)
	private String userId;
	
	@Column(name="Password", nullable=false, length=32)
	private String password;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Address address;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Role role;

	
	public Long getId() {
		return id;
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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	

}
