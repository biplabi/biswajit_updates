package com.gravity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gravity.model.Order;
import com.gravity.projection.OrderInfo;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>
{
	@Query(value = "SELECT o.id AS orderId, c.name as customerName, c.email as customerEmail, p.name as productName, p.price as productPrice, oi.quantity as quantity " + 
			"FROM orders o " +
			"JOIN customer c ON o.customer_Id = c.id " +
			"JOIN orderitems oi ON o.id = oi.order_Id " +
			"JOIN product p ON oi.product_Id = p.id", nativeQuery = true
			)
	List<OrderInfo> findAllOrderInfo();
	
	@Query(value = "SELECT name FROM customer WHERE id IN (SELECT customer_id FROM orders GROUP BY customer_id having COUNT(*) = 1)", nativeQuery = true)
	List<String> getCustomersByOrder();
}
