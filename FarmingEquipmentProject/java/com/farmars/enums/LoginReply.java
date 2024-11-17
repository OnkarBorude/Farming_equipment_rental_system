package com.farmars.enums;

public enum LoginReply {
	
	SUCCESSFUL("0000","Success", "User Login Successfully"),
    LOGIN_UNSUCCESSFUL("NOTI0004","Fail", "Please check email and password is correct or not");
	
	
	private final String code;
	private final String status;
	private final String messege;
	
	LoginReply(String code, String status, String messege ) {
		this.code=code;
		this.status=status;
		this.messege=messege;
	}

	public String getCode() {
		return code;
	}

	public String getStatus() {
		return status;
	}

	public String getMessege() {
		return messege;
	}
	
	
	
	
}
