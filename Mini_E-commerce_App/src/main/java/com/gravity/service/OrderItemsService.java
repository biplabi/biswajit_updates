package com.gravity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gravity.model.OrderItems;
import com.gravity.projection.CustomerSpend;
import com.gravity.repository.OrderItemsRepository;

@Service
public class OrderItemsService 
{
	@Autowired
	private OrderItemsRepository orderItemsRepo;
	
	public String addItems(OrderItems oi)
	{
		OrderItems oitem = this.orderItemsRepo.save(oi);
		
		return "Order item is added with id: " + oitem.getId();
	}
	
	public List<OrderItems> getAllOrderItems()
	{
		return this.orderItemsRepo.findAll();				
	}
	
	public String updateOrderItem(int id, OrderItems oi)
	{
		OrderItems oitem = this.orderItemsRepo.getById(id);
		
		oitem.setOrderId(oi.getOrderId());
		oitem.setProductId(oi.getProductId());
		oitem.setQuantity(oi.getQuantity());
		
		this.orderItemsRepo.save(oitem);
		
		return id + " item is updated!";
	}
	
	public String deleteOrderItems(int id)
	{
		this.orderItemsRepo.deleteById(id);
		
		return id + " orderItems is deleted.";
	}
	
	public List<CustomerSpend> getCustomerSpend()
	{
		return this.orderItemsRepo.getCustomerSpend();
	}
}
