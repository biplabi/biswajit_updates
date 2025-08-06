package com.gravity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gravity.model.OrderItems;
import com.gravity.service.OrderItemsService;

@RestController
@RequestMapping("/orderItems")
public class OrderItemsController 
{
	@Autowired
	private OrderItemsService service;
	
	@PostMapping("/add")
	public String addOrderItems(@RequestBody OrderItems oi)
	{
		return this.service.addItems(oi);
	}
	
	@GetMapping("/show")
	public List<OrderItems> getAllOrderItems()
	{
		return this.service.getAllOrderItems();
	}
	
	@PutMapping("/{id}")
	public String updateOrderItem(@PathVariable("id")int id, @RequestBody OrderItems oi)
	{
		return this.service.updateOrderItem(id, oi);
	}
	
	@DeleteMapping("/{id}")
	public String deleteOrderItems(@PathVariable("id")int id)
	{
		return this.service.deleteOrderItems(id);
	}
}
