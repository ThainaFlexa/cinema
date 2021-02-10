package br.ufpa.transaction;

import java.text.NumberFormat;
import java.util.ArrayList;

import br.ufpa.product.Product;
import br.ufpa.user.Customer;

public class Sale extends Transaction {
	private Customer customer;
	private ArrayList<Product> products = new ArrayList<>();

	public Sale(Customer customer) {
		super();
		this.customer= customer;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String getFormattedTotal() {
		double total = 0;
		for(Product p: products ) {
			total += p.getPrice();
		}
		
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String formattedTotal = formatter.format(total);
		return formattedTotal;
	}
	
	public double getTotal() {
		double total = 0;
		for(Product p: products ) {
			total += p.getPrice();
		}
		
		return total;
	}

	public void addProduct(Product product) {
		this.products.add(product);
	}
	
	public boolean removeProduct(int code) {
		
		ArrayList<Product> rest = new ArrayList<>();
		for(Product p: products) {
			if(p.getCode()!= code) {
				rest.add(p);
			}
		}
		
		products = rest;
		return true;
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}
	
	

	@Override
	public boolean finish() {
		// Fake successful sale process finish.
		return !products.isEmpty();
	}

	@Override
	public String toString() {
		String output = "Cliente: "
				+ customer.getName();
		
		for(Product product : products) {
			output += "\n\t" + product;
		}
		
		return output;
	}
}
