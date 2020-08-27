package com.verify_card.payload;

import com.verify_card.domain.Bank;

public class VerificationPayload {

	String scheme ; 
	String type ;
	String bank ; 
	
	
	
	
	public VerificationPayload(  String bank,String scheme,String type) {
	
		this.scheme = scheme;
		this.type = type;
		this.bank = bank;
	}
	public String getScheme() {
		return scheme;
	}
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}

	
}
