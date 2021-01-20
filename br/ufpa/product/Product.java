package br.ufpa.product;

import java.text.NumberFormat;

public abstract class Product {
	private int code;
	private double price;
	private String description;
	
	public Product(int code, double price, String description) {
		super();
		this.code = code;
		this.price = price;
		this.description = description;
	}
	
	public double getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (code != other.code)
			return false;
		return true;
	}

	@Override
	public String toString() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String formattedPrice = formatter.format(price);
		
		return code + " - " + description + " -> " + formattedPrice;
	}
}
