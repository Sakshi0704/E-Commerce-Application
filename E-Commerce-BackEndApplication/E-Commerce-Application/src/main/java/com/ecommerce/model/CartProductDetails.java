package com.ecommerce.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Embeddable
public class CartProductDetails {

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "productId")
	private Product Product;
	
	private Integer productQuantity;
	
	private Double productTotalAmount;

	public Product getProduct() {
		return Product;
	}

	public void setProduct(Product product) {
		Product = product;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Double getProductTotalAmount() {
		return productTotalAmount;
	}

	public void setProductTotalAmount(Double productTotalAmount) {
		this.productTotalAmount = productTotalAmount;
	}
	
}
