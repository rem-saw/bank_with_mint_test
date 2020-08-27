package com.verify_card.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.verify_card.domain.CardDetail;
import com.verify_card.payload.VerificationPayload;
import com.verify_card.payload.VerificationResponse;
import com.verify_card.proxy.CardDataProxy;


public class BinList implements  CardDataProxy {

	@Override
	public ResponseEntity<?> cardData(String cardNumber){

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("cardNumber", cardNumber);

		ResponseEntity<?> response = new RestTemplate().getForEntity(
				"https://lookup.binlist.net/{cardNumber}", CardDetail.class,
				uriVariables);

		return response ;
	}



}
