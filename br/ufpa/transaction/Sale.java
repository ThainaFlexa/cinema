package br.ufpa.transaction;

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

	@Override
	public boolean authenticate() {
		// Fake authentication for sales checkout
		return true;
	}
	
	public void addProduct(Product product) {
		this.products.add(product);
	}
	
	public void removeProduct(Product product) {
		this.products.remove(product);
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}
	
	public double calculateTotal() {
		double sum = 0;
		
		for(Product product : products) {
			sum += product.getPrice();
		}
		
		return sum;
	}

	@Override
	public boolean finish() {
		// Fake successful sale process finish.
		return !products.isEmpty();
	}
}
