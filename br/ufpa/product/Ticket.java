package br.ufpa.product;

import java.util.*;

public class Ticket extends Product {
	private String promotionalCode;
	private String movie;
	private ArrayList<String> validPromotionalCodes = new ArrayList<>();

	public Ticket(int code, double price, String movie) {
		super(code, price, "ticket");
		this.movie = movie;
		
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
	
	public String getMovie() {
		return movie;
	}
	
	public boolean validatePromotionalCode(String promotionalCode) {
		// Fake validation of promotional code:
		return validPromotionalCodes.contains(promotionalCode);
	}
}
