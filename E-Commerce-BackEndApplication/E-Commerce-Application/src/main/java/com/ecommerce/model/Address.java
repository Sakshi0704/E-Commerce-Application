package com.ecommerce.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;
	
	private String addressLine1;
	
	private String addressLine2;
	
	private String buildingName;
	
	private String landMark;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String pincode;
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime addressCreateDate;
	
	@UpdateTimestamp
	@Column(nullable = false)
	private LocalDateTime addressUpdateDate;

	
	
	
	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public LocalDateTime getAddressCreateDate() {
		return addressCreateDate;
	}

	public void setAddressCreateDate(LocalDateTime addressCreateDate) {
		this.addressCreateDate = addressCreateDate;
	}

	public LocalDateTime getAddressUpdateDate() {
		return addressUpdateDate;
	}

	public void setAddressUpdateDate(LocalDateTime addressUpdateDate) {
		this.addressUpdateDate = addressUpdateDate;
	}
}
