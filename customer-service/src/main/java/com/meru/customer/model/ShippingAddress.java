package com.meru.customer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "shipping_address")
public class ShippingAddress {

	public ShippingAddress(String houseNo, String streetName, String cityName, String pincCode, String landmark) {
		super();
		this.houseNo = houseNo;
		this.streetName = streetName;
		this.cityName = cityName;
		this.pincCode = pincCode;
		this.landmark = landmark;
	}

	@Column(name = "hno",nullable = false)
	private String houseNo;
	
	@Column(name = "street_name",nullable = false)
	private String streetName;
	
	@Column(name = "city",nullable = false)
	private String cityName;
	
	@Column(name = "pincode",nullable = false)
	private String pincCode;
	
	@Column(name = "nearest_landmark",nullable = false)
	private String landmark;

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getPincCode() {
		return pincCode;
	}

	public void setPincCode(String pincCode) {
		this.pincCode = pincCode;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	
}
