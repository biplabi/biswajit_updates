package com.gravity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gravity.model.OrderItems;
import com.gravity.projection.CustomerSpend;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer>
{
	@Query(value = "SELECT c.name as customerName, SUM(p.price * oi.quantity) AS totalSpend " +
            "FROM customer c " +
            "JOIN orders o ON c.id = o.customer_id " +
            "JOIN orderitems oi ON o.id = oi.order_id " +
            "JOIN product p ON oi.product_id = p.id " +
            "GROUP BY c.name", nativeQuery = true)
	List<CustomerSpend> getCustomerSpend();
}
