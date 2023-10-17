
package com.ecommerce.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	private String firstName;
	
	private String lastName;
	
	private String contact;
	
	@Email
	private String email;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	@Embedded
	private Image image;
	
	@Past
	private LocalDate dateOfBirth;
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private LocalDateTime accountCreateDate;
	
	@UpdateTimestamp
	@Column(nullable = false)
	private LocalDateTime accountUpdatedDate;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "addressId")
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "cartId")
	private Cart cart;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "customer")
	private List<Review> listOfReviews = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "customer")
	private List<Order> listOfOrders = new ArrayList<>();
	
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<CancelOrderRequest> listOfCancelOrders = new ArrayList<>();
//	
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<ReplaceOrderRequest> listOfReplaceOrders = new ArrayList<>();
//	
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<RefundOrderRequest> listOfRefunds = new ArrayList<>();
//	
	
	@ManyToMany(cascade = CascadeType.MERGE , fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userId" , referencedColumnName = "userId"),inverseJoinColumns = @JoinColumn(name = "roleId", referencedColumnName = "roleId"))
	private Set<Role> roles = new HashSet<>();
	
}
