package com.verify_card.payload;

public class VerificationResponse {

	boolean success ;
	VerificationPayload payload;



	public VerificationResponse(boolean success, VerificationPayload payload) {
		this.success = success;
		this.payload = payload;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public VerificationPayload getPayload() {
		return payload;
	}

	public void setPayload(VerificationPayload payload) {
		this.payload = payload;
	}



}
