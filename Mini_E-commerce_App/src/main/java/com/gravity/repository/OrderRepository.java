package com.gravity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gravity.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>
{

}
