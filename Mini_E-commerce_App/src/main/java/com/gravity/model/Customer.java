package com.gravity.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "customer")
@Data
public class Customer 
{
	@Id
	@GeneratedValue
	private int id;
	
	@Column(length = 20)
	private String name;
	
	@Column(length = 30)
	private String email;
}
