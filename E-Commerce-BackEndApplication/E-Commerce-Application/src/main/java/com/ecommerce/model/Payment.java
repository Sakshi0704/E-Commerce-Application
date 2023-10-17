package com.ecommerce.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "payments")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentId;
	
	private String paymentType;
	
	private Boolean allowed;
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime paymentAddedTimeStamp;
	
	@UpdateTimestamp
	@Column(nullable = false)
	private LocalDateTime paymentUpdatedTimeStamp;
	
	@JsonIgnore
	@OneToOne(mappedBy = "payment")
	private Order order;

	
	
	
	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Boolean getAllowed() {
		return allowed;
	}

	public void setAllowed(Boolean allowed) {
		this.allowed = allowed;
	}

	public LocalDateTime getPaymentAddedTimeStamp() {
		return paymentAddedTimeStamp;
	}

	public void setPaymentAddedTimeStamp(LocalDateTime paymentAddedTimeStamp) {
		this.paymentAddedTimeStamp = paymentAddedTimeStamp;
	}

	public LocalDateTime getPaymentUpdatedTimeStamp() {
		return paymentUpdatedTimeStamp;
	}

	public void setPaymentUpdatedTimeStamp(LocalDateTime paymentUpdatedTimeStamp) {
		this.paymentUpdatedTimeStamp = paymentUpdatedTimeStamp;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	} 

}
