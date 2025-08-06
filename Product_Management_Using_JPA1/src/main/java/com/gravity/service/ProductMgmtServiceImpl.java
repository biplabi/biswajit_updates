package com.gravity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gravity.exception.ProductNotFoundException;
import com.gravity.model.Product;
import com.gravity.repository.ProductRepository;

@Service
public class ProductMgmtServiceImpl implements IProductMgmtService
{
	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public String registerProduct(Product p)
	{
		Product pr = this.productRepo.save(p);
		
		return "Product is registered with product id: " + pr.getId();
	}
	
	@Override
	public List<Product> getAllProducts()
	{
		return this.productRepo.findAll();
	}
	
	@Override
	public String updateProduct(int id, Product p)
	{
		Product pr = this.productRepo.getById(id);
		
		pr.setName(p.getName());
		pr.setPrice(p.getPrice());
		
		this.productRepo.save(pr);
		
		return id + " product is updated.";
	}

	@Override
	public String deleteProduct(int id) 
	{
		this.productRepo.deleteById(id);
		
		return id + " product is deleted successfully!";
	}
	
	@Override
	public Page<Product> getAllProductsByPage(int page, int pageSize, String pageField, String direction)
	{
		Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(pageField).ascending() : Sort.by(pageField).descending();
		
		Pageable pageable = PageRequest.of(page, pageSize, sort);
		
		return this.productRepo.findAll(pageable);
	}
	
	@Override
	public Product getProductById(int id)
	{
		Optional<Product> op = this.productRepo.findById(id);
		
		if(op.isPresent())
		{
			return op.get();
		}
		else
		{
			throw new ProductNotFoundException("Enter a valid id!");
		}
	}
}
