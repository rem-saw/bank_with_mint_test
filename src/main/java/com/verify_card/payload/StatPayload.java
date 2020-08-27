package com.verify_card.payload;

import java.util.Map;

public class StatPayload {

	boolean success ; 

	int start ; 

	int limit; 

	long  size  ;

	Map<String, Integer> payload ;



	public StatPayload(boolean success, int start, int limit, long size, Map<String, Integer> payload) {

		this.success = success;
		this.start = start;
		this.limit = limit;
		this.size = size;
		this.payload = payload;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public Map<String, Integer> getPayload() {
		return payload;
	}

	public void setPayload(Map<String, Integer> payload) {
		this.payload = payload;
	}





}
