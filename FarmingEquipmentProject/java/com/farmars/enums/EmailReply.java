package com.farmars.enums;

public enum EmailReply {
	
	OTP_SENT_SUCCESS("0000","Success","Email sent successfully..!"),
	OTP_SENT_FAILED("USER004","Failed","User Added But Email not send");
	
	
	private final String code;
	private final String status;
	private final String messege;
	
	EmailReply(String code, String status, String messege ) {
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
