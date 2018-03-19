package com.izba.exception;


public class MyErrorRespone {
	
	private String error;
	
	public MyErrorRespone() {
		
	}

	public MyErrorRespone(String error) {
		super();
		this.error = error;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
}
