package com.blogapplication.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDTO {

	public ResponseDTO(String string, HttpStatus ok, int id) {}

	private int statusCode;
	
	private String error;
	
	private Object message;
}
