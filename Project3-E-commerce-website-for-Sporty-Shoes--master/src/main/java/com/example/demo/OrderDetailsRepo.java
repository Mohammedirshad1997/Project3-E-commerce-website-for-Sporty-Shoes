package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Integer> {

	//@Query("select orders.userId from OrderDetails orders where orders.orderId=?1")
	//List<OrderDetails> findOrdersByUser(int userid);

	
	@Query(nativeQuery = true)
	List<UserOrderSummary> getUserOrderSummary(Integer userId) ;
	
}
