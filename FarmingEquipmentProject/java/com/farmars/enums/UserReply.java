package com.farmars.enums;

public enum UserReply {
	
	SUCCESSFUL("0000","Success", "Registration Successful"),
    UNSUCCESSFUL("USER0004","Fail", "Registration Unsuccessful");
	
	
	private final String code;
	private final String status;
	private final String messege;
	
	UserReply(String code, String status, String messege ) {
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
