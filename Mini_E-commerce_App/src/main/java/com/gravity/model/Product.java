package com.gravity.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product 
{
	@Id
	@GeneratedValue
	private int id;
	
	@Column(length = 15)
	private String name;
	
	@Column
	private double price;
}
