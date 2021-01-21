import java.util.ArrayList;

import br.ufpa.product.Snack;
import br.ufpa.product.Ticket;
import br.ufpa.transaction.Sale;
import br.ufpa.user.Customer;
import br.ufpa.user.Manager;
import br.ufpa.user.User;

// Esta classe simula o banco de dados da aplicação.

public class Storage {
	public static ArrayList<User> users = new ArrayList<>();
	public static ArrayList<Sale> sales = new ArrayList<>();
	public static ArrayList<Ticket> tickets = new ArrayList<>();
	public static ArrayList<Snack> snacks = new ArrayList<>();
	public static Sale sale;
	public static User authenticatedUser;
	
	static {
		users.add(new Manager("Felipe", "gestor", "123456"));
		users.add(new Customer("Thaina", "cliente", "123456"));
		
		Ticket[] availableTickets = new Ticket[]{
				new Ticket(1, 27, "Os Vingadores"),
				new Ticket(2, 24.9, "Star Wars"),
				new Ticket(3, 22, "Homem Aranha"),
				new Ticket(4, 18, "Missão impossível"),
				new Ticket(5, 26.75, "O Quarteto Fantástico")
		};
		Snack[] availableSnacks = new Snack[]{
				new Snack(10, 7.5, "Pipoca pequena"),
				new Snack(11, 12.0, "Pipoca média"),
				new Snack(12, 18.0, "Pipoca grande"),
				new Snack(13, 6.5, "Refrigerante 300ml"),
				new Snack(14, 8.9, "Refrigerante 500ml"),
				new Snack(15, 6.5, "Chocolate Garoto 350g"),
				new Snack(16, 6.0, "Chocolate Laka 300g")
		};
		
		for(int i = 0; i < availableTickets.length; i++) {
			tickets.add(availableTickets[i]);
		}
		
		for(int i = 0; i < availableSnacks.length; i++) {
			snacks.add(availableSnacks[i]);
		}
    }
	
	@SuppressWarnings("serial")
	public static ArrayList<String> profiles = new ArrayList<>(){{
	    add("gestor");
	    add("cliente");
	}};
	
}
