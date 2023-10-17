package com.ecommerce.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "pickUpOrderRequests")
public class PickUpOrderRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pickUpOrderRequestId;
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime pickUpOrderTimeStamp;
	
	@UpdateTimestamp
	@Column(nullable = false)
	private LocalDateTime pickUpOrderUpdatedTimeStamp;
	
	private LocalDateTime expectedPickUpDate;
	
	private String pickedUpBy;
	
	private Boolean isReturnOrderPickedUp;
	
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "orderId")
	private Order order;
}
