package com.praba.myproject.model;

public class Login {

	private String userId;
	private String role;
	private boolean success;
	private String errMessage;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setErrMessage(String message) {
		this.errMessage = message;
	}
	
	public String getErrMessage() {
		return errMessage;
	}

}
