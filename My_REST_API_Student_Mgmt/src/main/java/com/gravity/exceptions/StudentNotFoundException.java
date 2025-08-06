package com.gravity.exceptions;

@SuppressWarnings("serial")
public class StudentNotFoundException extends Exception
{
	public StudentNotFoundException()
	{
		
	}
	public StudentNotFoundException(String errMsg)
	{
		super(errMsg);
	}
}
