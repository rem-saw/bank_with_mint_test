package com.verify_card.proxy;

import org.springframework.http.ResponseEntity;

public interface CardDataProxy {
  
	ResponseEntity<?> cardData(String cardNumber) ;
}
