package com.verify_card.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.verify_card.domain.Card;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {

	Card findByCardNumber(String cardNumber) ; 

	@Query(value = "SELECT * FROM card LIMIT :end OFFSET :start", nativeQuery = true)
	List<Card> findAllCard(int start, int end);

	@Query(value = "SELECT COUNT(*) FROM card", nativeQuery = true)
	long getSize();

}
