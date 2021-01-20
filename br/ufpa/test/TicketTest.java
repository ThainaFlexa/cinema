package br.ufpa.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.ufpa.product.Ticket;

class TicketTest {
	
	private static Ticket ticket;

	@BeforeAll
	static void setup() {
		ticket = new Ticket(1, 20.0);
		ticket.setPromotionalCode("BLACKFRIDAY");
	}

	@Test
	void checkValidPromotionalCode() {
		boolean valid = ticket.validatePromotionalCode("BLACKFRIDAY");
		
		Assertions.assertTrue(valid);
	}

	@Test
	void checkInvalidPromotionalCode() {
		boolean valid = ticket.validatePromotionalCode("INCORRECTCODE");
		
		Assertions.assertFalse(valid);
	}
}
