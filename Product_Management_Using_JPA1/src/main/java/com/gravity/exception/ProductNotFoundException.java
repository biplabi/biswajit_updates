package com.gravity.exception;

@SuppressWarnings("serial")
public class ProductNotFoundException extends RuntimeException
{
	public ProductNotFoundException()
	{
		
	}
	
	public ProductNotFoundException(String errMsg)
	{
		super(errMsg);
	}
}
