package com.gravity.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "orderitems")
@Data
public class OrderItems 
{
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private int orderId;
	
	@Column
	private int productId;
	
	@Column
	private int quantity;
}
