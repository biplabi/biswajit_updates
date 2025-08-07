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

import com.gravity.model.Product;
import com.gravity.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController 
{
	@Autowired
	private ProductService service;
	
	@PostMapping("/add")
	public String addProduct(@RequestBody Product p)
	{
		return this.service.addProduct(p);
	}
	
	@GetMapping("/show")
	public List<Product> getAllProducts()
	{
		return this.service.getAllProducts();
	}
	
	@PutMapping("/{id}")
	public String updateProduct(@PathVariable("id")int id, @RequestBody Product p)
	{
		return this.service.updateProduct(id, p);
	}
	
	@DeleteMapping("{id}")
	public String deleteProduct(@PathVariable("id")int id)
	{
		return this.service.deleteProduct(id);
	}
	
	@GetMapping("/productSales")
	public List<Object[]> getProductSales()
	{
		return this.service.getProductSales();
	}
}
