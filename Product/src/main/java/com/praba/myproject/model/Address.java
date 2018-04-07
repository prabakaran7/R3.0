package com.praba.myproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Address", schema = "product")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", length = 8)
	private Long id;

	@Column(name = "DoorNo", length = 5)
	private String doorNo;

	@Column(name = "BuildingNo", length = 8)
	private String buildingNo;

	@Column(name = "StreetLine1", length = 128)
	private String streetLine1;
	
	@Column(name = "StreetLine2", length = 128)
	private String streetLine2;
	
	@Column(name = "City", length = 32)
	private String city;
	
	@Column(name = "Taluk", length = 32)
	private String taluk;
	
	@Column(name = "District", length = 64)
	private String district;
	
	@Column(name = "PinCode", length = 6)
	private String pinCode;
	
	@Column(name = "State", length = 64)
	private String state;
	
	@Column(name = "Country", length = 64)
	private String country;

	public Long getId() {
		return id;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getBuildingNo() {
		return buildingNo;
	}

	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}

	public String getStreetLine1() {
		return streetLine1;
	}

	public void setStreetLine1(String streetLine1) {
		this.streetLine1 = streetLine1;
	}

	public String getStreetLine2() {
		return streetLine2;
	}

	public void setStreetLine2(String streetLine2) {
		this.streetLine2 = streetLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTaluk() {
		return taluk;
	}

	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	
}
