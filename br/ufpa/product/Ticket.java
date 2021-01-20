package br.ufpa.product;

import java.util.*;

public class Ticket extends Product {
	private String promotionalCode;
	private ArrayList<String> validPromotionalCodes = new ArrayList<>();

	public Ticket(int code, double price) {
		super(code, price);
		
		this.validPromotionalCodes.addAll(new ArrayList<>(
				Arrays.asList("BLACKFRIDAY", "TOTAL10CINE")
		));
	}

	public String getPromotionalCode() {
		return promotionalCode;
	}

	public void setPromotionalCode(String promotionalCode) {
		this.promotionalCode = promotionalCode;
	}
	
	public boolean validatePromotionalCode(String promotionalCode) {
		// Fake validation of promotional code:
		return validPromotionalCodes.contains(promotionalCode);
	}
}
