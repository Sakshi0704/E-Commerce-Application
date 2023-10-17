package com.ecommerce.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "feedbacks")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer feedback;
	
	@Lob
	private String customerFeedback;

	@Column(columnDefinition = "boolean default false",nullable = false)
	private Boolean deliverOrderFeedback;
	
	@Column(columnDefinition = "boolean default false",nullable = false)
	private Boolean cancelOrderFeedback;
	
	@Column(columnDefinition = "boolean default false",nullable = false)
	private Boolean replacementOrderFeedback;
	
	@Embedded
	private Image image;
	
	@Max(5)
	private Double rating;
	
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime feedbackTimeStamp;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "orderId")
	private Order order;

	public Integer getFeedback() {
		return feedback;
	}

	public void setFeedback(Integer feedback) {
		this.feedback = feedback;
	}

	public String getCustomerFeedback() {
		return customerFeedback;
	}

	public void setCustomerFeedback(String customerFeedback) {
		this.customerFeedback = customerFeedback;
	}

	public Boolean getDeliverOrderFeedback() {
		return deliverOrderFeedback;
	}

	public void setDeliverOrderFeedback(Boolean deliverOrderFeedback) {
		this.deliverOrderFeedback = deliverOrderFeedback;
	}

	public Boolean getCancelOrderFeedback() {
		return cancelOrderFeedback;
	}

	public void setCancelOrderFeedback(Boolean cancelOrderFeedback) {
		this.cancelOrderFeedback = cancelOrderFeedback;
	}

	public Boolean getReplacementOrderFeedback() {
		return replacementOrderFeedback;
	}

	public void setReplacementOrderFeedback(Boolean replacementOrderFeedback) {
		this.replacementOrderFeedback = replacementOrderFeedback;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public LocalDateTime getFeedbackTimeStamp() {
		return feedbackTimeStamp;
	}

	public void setFeedbackTimeStamp(LocalDateTime feedbackTimeStamp) {
		this.feedbackTimeStamp = feedbackTimeStamp;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
