package com.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "carts")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "cardId")
	private Integer cartId;
	
	private Integer cartQuantity;
	
	private Double cartTotalAmount;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<CartProductDetails> listOfProducts = new ArrayList<>();

	
	
	
	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getCartQuantity() {
		return cartQuantity;
	}

	public void setCartQuantity(Integer cartQuantity) {
		this.cartQuantity = cartQuantity;
	}

	public Double getCartTotalAmount() {
		return cartTotalAmount;
	}

	public void setCartTotalAmount(Double cartTotalAmount) {
		this.cartTotalAmount = cartTotalAmount;
	}

	public List<CartProductDetails> getListOfProducts() {
		return listOfProducts;
	}

	public void setListOfProducts(List<CartProductDetails> listOfProducts) {
		this.listOfProducts = listOfProducts;
	}

	
}
