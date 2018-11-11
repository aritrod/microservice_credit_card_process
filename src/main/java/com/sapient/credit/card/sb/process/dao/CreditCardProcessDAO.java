package com.sapient.credit.card.sb.process.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.sapient.credit.card.sb.process.model.CreditCard;

@Repository
public class CreditCardProcessDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<CreditCard> listCreditCards() {
		return jdbcTemplate.query("select * from CREDIT_CARD ORDER BY CARD_NAME",
				new BeanPropertyRowMapper<CreditCard>(CreditCard.class));
	}
	
	public int addCreditCard(CreditCard creditCard) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		return jdbcTemplate.update("insert into CREDIT_CARD (id, card_name, card_number, card_balance, card_limit) " + "values(?, ?, ?, ?, ?)",
				new Object[] {keyHolder.getKey(), creditCard.getCardName(), creditCard.getCardNumber(), creditCard.getCardBalance(), creditCard.getCardLimit() });
	}

}
