package com.ecommerce.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Embeddable
public class OrderProductDetails {

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "productId")
	private Product product;
	
	private Integer productQuantity;
	
	private Double productTotalAmount;
	
	@Column(columnDefinition = "boolean default false", nullable = false)
	private Boolean isProductCancelled;
	
	@Column(columnDefinition = "boolean default false", nullable = false)
	private Boolean isProductReturned;
	
	@Column(columnDefinition = "boolean default false", nullable = false)
	private Boolean isProductReplaced;
	
	@Column(columnDefinition = "boolean default false", nullable = false)
	private Boolean isProductRefunded;
	
	@Column(columnDefinition = "boolean default false", nullable = false)
	private Boolean isProductDelievered;
	
	@Column(columnDefinition = "boolean default false", nullable = false)
	private Boolean isReplacementProduct;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	public Boolean getIsProductCancelled() {
		return isProductCancelled;
	}

	public void setIsProductCancelled(Boolean isProductCancelled) {
		this.isProductCancelled = isProductCancelled;
	}

	public Boolean getIsProductReturned() {
		return isProductReturned;
	}

	public void setIsProductReturned(Boolean isProductReturned) {
		this.isProductReturned = isProductReturned;
	}

	public Boolean getIsProductReplaced() {
		return isProductReplaced;
	}

	public void setIsProductReplaced(Boolean isProductReplaced) {
		this.isProductReplaced = isProductReplaced;
	}

	public Boolean getIsProductRefunded() {
		return isProductRefunded;
	}

	public void setIsProductRefunded(Boolean isProductRefunded) {
		this.isProductRefunded = isProductRefunded;
	}

	public Boolean getIsProductDelievered() {
		return isProductDelievered;
	}

	public void setIsProductDelievered(Boolean isProductDelievered) {
		this.isProductDelievered = isProductDelievered;
	}

	public Boolean getIsReplacementProduct() {
		return isReplacementProduct;
	}

	public void setIsReplacementProduct(Boolean isReplacementProduct) {
		this.isReplacementProduct = isReplacementProduct;
	}

}
