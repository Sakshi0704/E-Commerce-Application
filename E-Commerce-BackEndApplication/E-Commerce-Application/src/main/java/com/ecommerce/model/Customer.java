
package com.ecommerce.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	private String firstName;
	
	private String lastName;
	
	private String contact;
	
	@Email
	@Column(unique = true,nullable = false)
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
	
	@ManyToOne(cascade = CascadeType.MERGE , fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userId" , referencedColumnName = "userId"),inverseJoinColumns = @JoinColumn(name = "roleId", referencedColumnName = "roleId"))
	private Role role;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDateTime getAccountCreateDate() {
		return accountCreateDate;
	}

	public void setAccountCreateDate(LocalDateTime accountCreateDate) {
		this.accountCreateDate = accountCreateDate;
	}

	public LocalDateTime getAccountUpdatedDate() {
		return accountUpdatedDate;
	}

	public void setAccountUpdatedDate(LocalDateTime accountUpdatedDate) {
		this.accountUpdatedDate = accountUpdatedDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Review> getListOfReviews() {
		return listOfReviews;
	}

	public void setListOfReviews(List<Review> listOfReviews) {
		this.listOfReviews = listOfReviews;
	}

	public List<Order> getListOfOrders() {
		return listOfOrders;
	}

	public void setListOfOrders(List<Order> listOfOrders) {
		this.listOfOrders = listOfOrders;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
