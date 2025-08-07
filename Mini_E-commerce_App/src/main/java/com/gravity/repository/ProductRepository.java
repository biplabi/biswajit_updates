package com.gravity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gravity.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
{
	@Query(value = "SELECT p.name, SUM(oi.quantity) AS totalSales " +
			"FROM product p JOIN orderitems oi ON p.id = oi.product_id " +
			"GROUP BY p.name", nativeQuery = true
			)
	public List<Object[]> getProductSales();
}
