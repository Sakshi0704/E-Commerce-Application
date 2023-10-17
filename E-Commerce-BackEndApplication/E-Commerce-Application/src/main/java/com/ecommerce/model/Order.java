package com.ecommerce.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.context.properties.bind.DefaultValue;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	private String orderStatus;
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime orderTimeStamp;
	
	@UpdateTimestamp
	@Column(nullable = false)
	private LocalDateTime orderUpdatedTimeStamp;
	
	private Integer orderQuantity;
	
	private Double orderTotalAmount;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "paymentId")
	private Payment payment;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	@ElementCollection
	@JoinColumn(name = "productId")
	private List<OrderProductDetails> listOfProducts = new ArrayList<>();
	
	// cancelled by customer product should by added to Inventory
	@Column(columnDefinition = "boolean default false", nullable = false)
	private Boolean isOrderCancelled;
	
	@Column(columnDefinition = "boolean default false",nullable = false)
	private Boolean isOrderReturned;
	
	@Column(columnDefinition = "boolean default false",nullable = false)
	private Boolean isOrderReplaced;
	
	@Column(columnDefinition = "boolean default false", nullable = false)
	private Boolean isOrderRefunded;
	
	@Column(columnDefinition = "boolean default false", nullable = false)
	private Boolean isOrderDelivered;
	
	@Column(columnDefinition = "boolean default false", nullable = false)
	private Boolean isReplacementOrder;
	
	private Integer originalOrderId;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public LocalDateTime getOrderTimeStamp() {
		return orderTimeStamp;
	}

	public void setOrderTimeStamp(LocalDateTime orderTimeStamp) {
		this.orderTimeStamp = orderTimeStamp;
	}

	public LocalDateTime getOrderUpdatedTimeStamp() {
		return orderUpdatedTimeStamp;
	}

	public void setOrderUpdatedTimeStamp(LocalDateTime orderUpdatedTimeStamp) {
		this.orderUpdatedTimeStamp = orderUpdatedTimeStamp;
	}

	public Integer getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public Double getOrderTotalAmount() {
		return orderTotalAmount;
	}

	public void setOrderTotalAmount(Double orderTotalAmount) {
		this.orderTotalAmount = orderTotalAmount;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderProductDetails> getListOfProducts() {
		return listOfProducts;
	}

	public void setListOfProducts(List<OrderProductDetails> listOfProducts) {
		this.listOfProducts = listOfProducts;
	}

	public Boolean getIsOrderCancelled() {
		return isOrderCancelled;
	}

	public void setIsOrderCancelled(Boolean isOrderCancelled) {
		this.isOrderCancelled = isOrderCancelled;
	}

	public Boolean getIsOrderReturned() {
		return isOrderReturned;
	}

	public void setIsOrderReturned(Boolean isOrderReturned) {
		this.isOrderReturned = isOrderReturned;
	}

	public Boolean getIsOrderReplaced() {
		return isOrderReplaced;
	}

	public void setIsOrderReplaced(Boolean isOrderReplaced) {
		this.isOrderReplaced = isOrderReplaced;
	}

	public Boolean getIsOrderRefunded() {
		return isOrderRefunded;
	}

	public void setIsOrderRefunded(Boolean isOrderRefunded) {
		this.isOrderRefunded = isOrderRefunded;
	}

	public Boolean getIsOrderDelivered() {
		return isOrderDelivered;
	}

	public void setIsOrderDelivered(Boolean isOrderDelivered) {
		this.isOrderDelivered = isOrderDelivered;
	}

	public Boolean getIsReplacementOrder() {
		return isReplacementOrder;
	}

	public void setIsReplacementOrder(Boolean isReplacementOrder) {
		this.isReplacementOrder = isReplacementOrder;
	}

	public Integer getOriginalOrderId() {
		return originalOrderId;
	}

	public void setOriginalOrderId(Integer originalOrderId) {
		this.originalOrderId = originalOrderId;
	}

}
