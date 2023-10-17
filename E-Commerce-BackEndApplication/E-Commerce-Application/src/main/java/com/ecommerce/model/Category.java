package com.ecommerce.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;
	
	private String categoryName;
	
	private String categoryDescription;
	
	@Column(insertable = false, nullable = false)
	private Boolean active;
	
	@CreationTimestamp
	@Column(nullable = false , updatable = false)
	private LocalDateTime categoryAddedDateTime;
	
	@CreationTimestamp
	@Column(nullable = false)
	private LocalDateTime categoryUpdatedDateTime;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "category")
	private List<Product> listOfProducts = new ArrayList<>();
	
}
