package br.ufpa.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.ufpa.user.Authenticable;
import br.ufpa.user.Customer;
import br.ufpa.user.Manager;

class UserTest {

	@Test
	void managerCreate() {
		Manager manager = new Manager("Thaina Flexa", "thaineflexa", "123456");
		Assertions.assertNotNull(manager);
	}
	
	@Test
	void customerCreate() {
		Customer manager = new Customer("Thaina Flexa", "thaineflexa", "123456");
		Assertions.assertNotNull(manager);
	}

	@Test
	void userChangeName() {
		Customer user = new Customer("Thaina Flexa", "thaineflexa", "123456");
		user.setName("Gustavo");
		Assertions.assertEquals(user.getName(), "Gustavo");
	}
	
	@Test
	void userChangePassword() {
		Customer user = new Customer("Thaina Flexa", "thaineflexa", "123456");
		user.setPassword("654321");
		Assertions.assertEquals(user.getPassword(), "654321");
	}
	
	@Test
	void userAuthentication() {
		Authenticable user = new Customer("Thaina Flexa", "thaineflexa", "123456");
		boolean authenticated = user.authenticate();
		Assertions.assertTrue(authenticated);
	}
}
