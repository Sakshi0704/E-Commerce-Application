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

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
