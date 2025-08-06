package com.gravity.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gravity.model.Product;

@Repository
public class ProductRepository 
{
	private List<Product> productList = new ArrayList<>();
	
	public String addProduct(Product p)
	{
		productList.add(p);
		
		return "Product is added with id: " + p.getId();
	}
	
	public List<Product> getAllProducts()
	{
		return this.productList;
	}
	
	public Product getProductById(int id)
	{
		for(Product p : this.productList)
		{
			if(p.getId() == id)return p;
		}
		
		return null;
	}
	
	public String updateProduct(int id, Product pr)
	{
		for(Product p : this.productList)
		{
			if(p.getId() == id)
			{
				p.setName(pr.getName());
				p.setPrice(pr.getPrice());
			}
		}
		return id + " id product is updated successfully!";
	}
	
	public String deleteProduct(int id)
	{
		for(Product p : this.productList)
		{
			if(p.getId() == id)this.productList.remove(p);
			return id + " id product is deleted successfully!";
		}
		return "Sorry! product not found!";
	}
}
