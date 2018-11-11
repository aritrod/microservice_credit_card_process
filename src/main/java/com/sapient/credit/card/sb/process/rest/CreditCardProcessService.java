package com.sapient.credit.card.sb.process.rest;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sapient.credit.card.sb.process.constants.CreditCardConstants;
import com.sapient.credit.card.sb.process.dao.CreditCardProcessDAO;
import com.sapient.credit.card.sb.process.dto.CreditCardResponseDTO;
import com.sapient.credit.card.sb.process.model.CreditCard;

@Controller
public class CreditCardProcessService {
	
	@Autowired
	CreditCardProcessDAO creditCardProcessDAO;
	
	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(method = RequestMethod.GET, value="/sapient/creditCard/list")
	@ResponseBody
	public CreditCardResponseDTO getCreditCards() {
		List<CreditCard> cards = null;
		CreditCardResponseDTO creditCardResponseDTO = new CreditCardResponseDTO();
		try {
			cards = creditCardProcessDAO.listCreditCards();
			creditCardResponseDTO.setStatus(CreditCardConstants.SUCCESS_MESSAGE);
			creditCardResponseDTO.setStatusCode(CreditCardConstants.HTTP_200);
			creditCardResponseDTO.setData(cards);
			logger.info("Fetched all credit cards, count = "+ cards.size());
		} catch (Exception e) {
			e.printStackTrace();
		}	
	return creditCardResponseDTO;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(method = RequestMethod.POST, value="/sapient/creditCard/add")
	@ResponseBody
	public CreditCardResponseDTO addCreditCard(@RequestBody CreditCard creditCard) {
		int addedCardCount = 0;
		CreditCardResponseDTO creditCardResponseDTO = new CreditCardResponseDTO();
		try {
			addedCardCount = creditCardProcessDAO.addCreditCard(creditCard);
			logger.info(addedCardCount + " card added");
		} catch (Exception e) {
			creditCardResponseDTO.setStatusCode(CreditCardConstants.HTTP_500);
			e.printStackTrace();
		}
		if (addedCardCount > 0){
			creditCardResponseDTO.setStatus(CreditCardConstants.SUCCESS_MESSAGE);
			creditCardResponseDTO.setStatusCode(CreditCardConstants.HTTP_201);
			creditCardResponseDTO.setData(addedCardCount);
		} else {
			creditCardResponseDTO.setStatus(CreditCardConstants.FAILURE_MESSAGE);
			creditCardResponseDTO.setStatusCode(CreditCardConstants.HTTP_400);
			creditCardResponseDTO.setData(0);
		}
		return creditCardResponseDTO;		
	}

}
