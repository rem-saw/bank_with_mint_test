package com.verify_card.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.verify_card.proxy.CardDataProxy;



public class CardHandler {

	private CardDataProxy cardDataProxy ;

	CardHandler(CardDataProxy cardDataProxy) {
		this.cardDataProxy = cardDataProxy;
	}

	public ResponseEntity<?> getCardData (String cardNumber){
		return cardDataProxy.cardData(cardNumber) ;
	}




}
