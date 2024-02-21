package com.blogapplication.advice;

import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blogapplication.dto.ResponseDTO;
import com.blogapplication.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class AllExceptionsHandlers {

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler
	public ResponseDTO resourceNotFoundException(ResourceNotFoundException e)
	{
		return new ResponseDTO(404,"error",e.getMessage());
	}
	
	/*public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException e)
	{
		String message=e.getMessage();
		ApiResponse apiResponse=new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}*/
	
}
