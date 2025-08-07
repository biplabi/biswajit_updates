package com.gravity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gravity.model.Order;
import com.gravity.model.OrderItems;
import com.gravity.projection.OrderInfo;
import com.gravity.repository.OrderItemsRepository;
import com.gravity.repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService 
{
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired OrderItemsRepository oiRepo;
	
	public String saveOrder(Order o)
	{
		Order ord = this.orderRepo.save(o);
		
		return "Order is saved with id: " + ord.getId();
	}
	
	public List<Order> getAllOrders()
	{
		return this.orderRepo.findAll();
	}
	
	public String updateOrder(int id, Order o)
	{
		Order ord = this.orderRepo.getById(id);
		
		ord.setCustomerId(o.getCustomerId());
		ord.setOrderDate(o.getOrderDate());
		
		this.orderRepo.save(ord);
		
		return id + " order is updated.";
	}
	
	public String deleteOrder(int id)
	{
		this.orderRepo.deleteById(id);
		return id + " order is deleted.";
	}
	
	public List<OrderInfo> getOrderInfo()
	{
		return this.orderRepo.findAllOrderInfo();
	}
	
	public List<String> getCustomerByOrder()
	{
		return this.orderRepo.getCustomersByOrder();
	}
	
	@Transactional
	public void placeOrderWithItems(Order order, List<OrderItems> items)
	{
		Order savedOrder = this.orderRepo.save(order);
		
		
		for(OrderItems item : items)
		{
			item.setOrderId(savedOrder.getId());
		}
		
		oiRepo.saveAll(items);
		throw new ArithmeticException();
	}
}
