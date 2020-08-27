package com.verify_card.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.verify_card.services.CardService;

@CrossOrigin
@RestController
@RequestMapping("/card-scheme")
public class CardController {
	
	@Autowired 
	private CardService cardService ; 
	
	@GetMapping("/verify/{cardNumber}")
	public ResponseEntity<?> verifyCard(@PathVariable String cardNumber) {
		return cardService.verifyCard(cardNumber);
	}
	
	@GetMapping("/stats")
	public ResponseEntity<?> getScheme(@RequestParam(value="start") int start , @RequestParam(value="limit") int limit) {
		return  cardService.getCards(start,limit);
	}

}
