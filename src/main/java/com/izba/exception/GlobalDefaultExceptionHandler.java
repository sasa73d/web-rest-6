package com.izba.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	 @ExceptionHandler(Throwable.class)
	 @ResponseBody
	 @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	 public MyErrorRespone handleException(Throwable ex) {
		 MyErrorRespone response = new MyErrorRespone( ex.getMessage());
		 return response;
	 }

}
