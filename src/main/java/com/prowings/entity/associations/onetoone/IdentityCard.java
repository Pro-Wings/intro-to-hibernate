package com.prowings.entity.associations.onetoone;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class IdentityCard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@Column
    private int cardNumber;

	@Column
	private String cardType;

    public IdentityCard() {
	}

	public IdentityCard(Long id, int cardNumber, String cardType) {
		super();
		this.id = id;
		this.cardNumber = cardNumber;
		this.cardType = cardType;
	}

	public IdentityCard(int cardNumber, String cardType) {
		super();
		this.cardNumber = cardNumber;
		this.cardType = cardType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	@Override
	public String toString() {
		return "IdentityCard [id=" + id + ", cardNumber=" + cardNumber + ", cardType=" + cardType + "]";
	}
}
