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
		double total = products.stream()
				.map(i -> i.getPrice())
				.mapToDouble(Double::valueOf)
				.sum();
		
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String formattedTotal = formatter.format(total);
		return formattedTotal;
	}
	
	public double getTotal() {
		double total = products.stream()
				.map(i -> i.getPrice())
				.mapToDouble(Double::valueOf)
				.sum();
		
		return total;
	}

	public void addProduct(Product product) {
		this.products.add(product);
	}
	
	public boolean removeProduct(int code) {
		Product toRemove = products.stream().
		    filter(p -> p.getCode() == code).
		    findFirst().
		    orElse(null);
		
		return this.products.remove(toRemove);
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
		return true;
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
