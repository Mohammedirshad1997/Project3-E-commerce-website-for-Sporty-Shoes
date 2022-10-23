package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDAO {
	
	Logger log = Logger.getAnonymousLogger();
	
	
	@Autowired
	ProductRepo repo;
	
    @Autowired
    OrderDetailsRepo orderRepo;
	
	public Product insert(Product p) {
		return repo.save(p);
	}
	
	public Product update(Product p) {

		Product pp = repo.findById(p.getSid()).orElse(null);
		pp.setSname(p.getSname());
		pp.setScost(p.getScost());
		return repo.save(pp);

	}
	
	public List<Product> getAll() {
		return repo.findAll();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}

	public OrderDetails placeOrder(OrderDetails o) {
		
		
		return orderRepo.save(o);
	}
	
	public List<UserOrderSummary> viewOrderReport(int userId) {
		
		List<UserOrderSummary> orderSummary =  orderRepo.getUserOrderSummary(userId);
		Optional.ofNullable(orderSummary).orElse(new ArrayList<>())
		    .stream()
		    .forEach(odr -> {
		    	log.info("\n Order Details "+ odr.toString());
		    });
		//List<OrderDetails> userList = orderRepo.findOrdersByUser(userid);
		
		//Product productList = repo.findAllById(ordersList);
		
		return orderSummary ;
	}
}
