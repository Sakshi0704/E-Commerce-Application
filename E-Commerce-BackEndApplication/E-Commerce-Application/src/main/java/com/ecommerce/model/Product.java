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
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
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
	
	private Integer stockQuantity;
	
	private Double rating;
	
	private Integer manufacturingYear;
	
	private Integer manufacturingMonth;
	
	@Column(columnDefinition = "boolean default true", nullable = false)
	private Boolean avaiable;
	
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime productAddedDateTime;
	
	
	
	@UpdateTimestamp
	@Column(nullable = false)
	private LocalDateTime productUpdatedDateTime;
	
	
	@ManyToOne
	private Category category;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "product")
	private List<Review> listOfReviews = new ArrayList<>();
	
	@ElementCollection
	private List<Image> images;
	
	
	private Long totalSales;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public Double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public Integer getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(Integer discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public Integer getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Integer getManufacturingYear() {
		return manufacturingYear;
	}

	public void setManufacturingYear(Integer manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
	}

	public Integer getManufacturingMonth() {
		return manufacturingMonth;
	}

	public void setManufacturingMonth(Integer manufacturingMonth) {
		this.manufacturingMonth = manufacturingMonth;
	}

	public Boolean getAvaiable() {
		return avaiable;
	}

	public void setAvaiable(Boolean avaiable) {
		this.avaiable = avaiable;
	}

	public LocalDateTime getProductAddedDateTime() {
		return productAddedDateTime;
	}

	public void setProductAddedDateTime(LocalDateTime productAddedDateTime) {
		this.productAddedDateTime = productAddedDateTime;
	}

	public LocalDateTime getProductUpdatedDateTime() {
		return productUpdatedDateTime;
	}

	public void setProductUpdatedDateTime(LocalDateTime productUpdatedDateTime) {
		this.productUpdatedDateTime = productUpdatedDateTime;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Review> getListOfReviews() {
		return listOfReviews;
	}

	public void setListOfReviews(List<Review> listOfReviews) {
		this.listOfReviews = listOfReviews;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Long getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(Long totalSales) {
		this.totalSales = totalSales;
	}

}
