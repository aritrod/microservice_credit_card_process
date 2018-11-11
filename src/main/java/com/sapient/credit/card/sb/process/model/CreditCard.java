package com.sapient.credit.card.sb.process.model;

public class CreditCard {
	
	private Long id;
	private String cardName;
	private String cardNumber;
	private String cardBalance;
	private String cardLimit;
	
	public CreditCard() {
		super();
	}
	
	public CreditCard(Long id, String cardName, String cardNumber, String cardBalance, String cardLimit) {
		this.id = id;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.cardBalance = cardBalance;
		this.cardLimit = cardLimit;		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardBalance() {
		return cardBalance;
	}

	public void setCardBalance(String cardBalance) {
		this.cardBalance = cardBalance;
	}

	public String getCardLimit() {
		return cardLimit;
	}

	public void setCardLimit(String cardLimit) {
		this.cardLimit = cardLimit;
	}
	

}
