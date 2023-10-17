package com.ecommerce.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	
	private String productName;
	
	private String productDescription;
	
	private String brand;
	
	private String type;
	
	private Double salePrice;
	
	private Double marketPrice;
	
	private Integer discountPercentage;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private Integer stockQuantity;
	
	private Double rating;
	
	private Integer manufacturingYear;
	
	private Integer manufacturingMonth;
	
	@Column(columnDefinition = "boolean default true", nullable = false)
	private Boolean avaiable;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime productAddedDateTime;
	
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@UpdateTimestamp
	@Column(nullable = false)
	private LocalDateTime productUpdatedDateTime;
	
	
	@ManyToOne
	private Category category;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "product")
	private List<Review> listOfReviews = new ArrayList<>();
	
	@ElementCollection
	private List<Image> images;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long totalSales;
}
