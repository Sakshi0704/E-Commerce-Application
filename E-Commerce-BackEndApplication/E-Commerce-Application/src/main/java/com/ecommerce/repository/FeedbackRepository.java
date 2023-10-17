package com.ecommerce.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.Customer;
import com.ecommerce.model.Feedback;
import com.ecommerce.model.Order;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

	Page<Feedback> findByCustomer(Customer customer, Pageable pageable);

	Page<Feedback> findByOrder(Order order, Pageable pageable);
	
}
