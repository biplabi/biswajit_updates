package com.gravity.dto;

import java.util.List;

import com.gravity.model.Order;
import com.gravity.model.OrderItems;

import lombok.Data;

@Data
public class OrderRequest 
{
	private Order order;
	private List<OrderItems> orderItems;
}
