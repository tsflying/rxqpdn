package com.rxqp.common.exception;

public class BusinnessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8069980869641924100L;

	private Integer code;
	private String message;

	public BusinnessException(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
