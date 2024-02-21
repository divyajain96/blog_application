package com.blogapplication.exceptions;

//public class ResourceNotFoundException extends RuntimeException {
//
//	public ResourceNotFoundException() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public ResourceNotFoundException(String message) {
//		super(message);
//		// TODO Auto-generated constructor stub
//	}
//
//}

public class ResourceNotFoundException extends RuntimeException {

	String resourceName;
	String fieldName;
	long fieldValue;
	public ResourceNotFoundException() {
		super();
	}
	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s : %s",resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

}
