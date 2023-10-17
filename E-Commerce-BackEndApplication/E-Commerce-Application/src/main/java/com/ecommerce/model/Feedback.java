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
@Data
@AllArgsConstructor
@NoArgsConstructor
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
	
}
