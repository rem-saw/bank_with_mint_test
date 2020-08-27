package com.verify_card.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.verify_card.domain.Card;
import com.verify_card.domain.CardDetail;
import com.verify_card.payload.StatPayload;
import com.verify_card.payload.VerificationPayload;
import com.verify_card.payload.VerificationResponse;
import com.verify_card.repositories.CardRepository;

@Service
public class CardService {

	@Autowired
	private CardRepository cardRepository ; 

	public ResponseEntity<?> verifyCard(String cardNumber){
		Card card ;
		try {
			CardHandler cardHandler = new CardHandler(new BinList());
			CardDetail cardDetail = (CardDetail) cardHandler.getCardData(cardNumber).getBody();

			if (cardRepository.findByCardNumber(cardNumber) == null) {
				card = new Card() ; 
				card.setBank(cardDetail.getBank().getName());
				card.setCardNumber(cardNumber);
				card.setScheme(cardDetail.getScheme());
				card.setType(cardDetail.getType());
				card.setCount(card.getCount()+1);
				saveCard(card) ;
			}  else {
				card = cardRepository.findByCardNumber(cardNumber) ;
				card.setCount(card.getCount()+1);
				saveCard(card) ;
			}


			VerificationPayload verificationPayload =
					new VerificationPayload(cardDetail.getBank().getName(),cardDetail.getScheme(),cardDetail.getType());

			return new ResponseEntity<VerificationResponse>(new VerificationResponse(true,verificationPayload),HttpStatus.OK) ; 
		} catch(Exception ex) {
			if (cardRepository.findByCardNumber(cardNumber) == null) {
				card = new Card() ; 
				card.setCardNumber(cardNumber);
				card.setCount(card.getCount()+1);
				saveCard(card) ;		
			} else {
				card = cardRepository.findByCardNumber(cardNumber) ;
				card.setCount(card.getCount()+1);
				saveCard(card) ;
			}
			VerificationPayload verificationPayload =
					new VerificationPayload(null,null,null);
			return new ResponseEntity<VerificationResponse>(new VerificationResponse(false,verificationPayload),HttpStatus.BAD_REQUEST) ; 
		}


	}

	public void saveCard(Card card) {
		cardRepository.save(card) ; 
	}

	public ResponseEntity<?> getCards(int start, int limit) {
		Map<String, Integer> payload = new HashMap<>();
		try {

			List<Card> cards = cardRepository.findAllCard(start, limit) ;

			long size  = cardRepository.getSize(); 

			for (int i = 0 ; i < cards.size(); i++) {
				payload.put(cards.get(i).getCardNumber(), cards.get(i).getCount());
			}


			return new ResponseEntity<StatPayload>(new StatPayload(true, start, limit,size, payload) , HttpStatus.OK) ; 
		} catch(Exception ex) {
			return new ResponseEntity<StatPayload>(new StatPayload(false, start, limit,0, payload) , HttpStatus.OK) ; 
		}
	}



}
