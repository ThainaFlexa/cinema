package br.ufpa.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.ufpa.user.Customer;
import br.ufpa.product.Snack;
import br.ufpa.product.Ticket;
import br.ufpa.transaction.Sale;

class SaleTest {
	
	private static Customer customer;
	private static Sale sale;
	
	@BeforeAll
	static void setup() {
		customer = new Customer("Thaina Flexa", "thainaflexa", "123456");
	}
	
	@BeforeEach
	void setupEach() {
		sale = new Sale(customer);
	}
	
	@Test
	void addProductsToSale() {
		Ticket ticket = new Ticket(1, 23.0, "Os Vingadores");
		Snack snack = new Snack(2, 18.99, "Batata Frita");
		
		sale.addProduct(ticket);
		sale.addProduct(snack);
		
		Assertions.assertEquals(sale.getProducts().size(), 2);
	}
	
	@Test
	void removeProductsFromSale() {
		Ticket ticket = new Ticket(1, 23.0, "Os Vingadores");
		Snack snack = new Snack(2, 18.99, "Batata Frita");
		
		sale.addProduct(ticket);
		sale.addProduct(snack);
		sale.removeProduct(ticket);
		
		Assertions.assertEquals(sale.getProducts().size(), 1);
	}

	@Test
	void finishSale() {
		Ticket ticket = new Ticket(1, 23.9, "Os Vingadores");
		
		sale.addProduct(ticket);
		
		boolean finished = sale.finish();
		
		Assertions.assertTrue(finished);;
	}
	
	@Test
	void cantFinishEmptySale() {
		boolean finished = sale.finish();
		
		Assertions.assertFalse(finished);
	}
	
	@Test
	void calculateTotalPrice() {
		Ticket ticket = new Ticket(1, 23.0, "Os Vingadores");
		Snack snack = new Snack(2, 27.0, "Batata Frita");
		
		sale.addProduct(ticket);
		sale.addProduct(snack);
		
		Assertions.assertEquals(sale.calculateTotal(), 50.0);
	}

}
