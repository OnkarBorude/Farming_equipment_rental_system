package com.farmars.enums;

public enum OtpReply {
	
	OTP_SENT_SUCCESS("0000","Success","Otp Sent Successfully..!"),
	OTP_SENT_FAILED("USER004","Failed","invalid credential");
	
	private final String code;
	private final String status;
	private final String message;
	
	
	
	OtpReply(String code, String status, String message ) {
		this.code=code;
		this.status=status;
		this.message=message;
	}

	public String getCode() {
		return code;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

}
