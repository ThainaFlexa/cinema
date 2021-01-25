import java.util.Scanner;

import br.ufpa.product.Snack;
import br.ufpa.product.Ticket;
import br.ufpa.transaction.Sale;
import br.ufpa.user.Customer;

class Selling {
	private static Scanner input = new Scanner(System.in);
	
	public static void addToCart(String product) throws Exception {
		switch(product) {
			case "ticket":
				addTicketToCart();
				break;
				
			case "snack":
				addSnackToCart();
				break;
		}
	}
	
	public static void removeFromCart(String product) throws Exception {
		int code;
		
		System.out.print("\nInforme o código do item para remover: ");
		code = input.nextInt();
	
		boolean removed = Storage.sale.removeProduct(code);
		
		if(!removed) {
			throw new Exception("Este item não consta em seu carrinho!");
		} else {
			System.out.print("\nItem removido do carrinho!\n");
		}		
	}

	private static void addSnackToCart() throws Exception {
		int code;
		System.out.print("\nQual lanche deseja comprar?\n");
		
		String snackFormat = "| %-6d | %-24s | %-10s |%n";

		System.out.println("\nLanches disponiveis:\n");
		System.out.format("+--------+--------------------------+------------+%n");
		System.out.format("| Código | Item                     | Valor      |%n");
		System.out.format("+--------+--------------------------+------------+%n");
		
		for(Snack snack: Storage.snacks) {	
			if(snack.isAvailable()) {
				System.out.format(snackFormat, snack.getCode(), snack.getDescription(), snack.getFormattedPrice());
			}
		}
		
		System.out.format("+--------+--------------------------+------------+%n");
		
		System.out.print("\n\nInforme o código do lanche: ");
		code = input.nextInt();
		
		Snack snack = Storage.snacks.stream().
			    filter(p -> p.getCode() == code).
			    findFirst().
			    orElse(null);
		
		if(snack == null) {
			throw new Exception("\nLanche indisponível!");
		}
		
		snack.setAvailable(false);
		
		Storage.sale.addProduct(snack);
		
		System.out.print("\nLanche adicionado ao carrinho!\n");
	}

	private static void addTicketToCart() throws Exception {
		int code;
		String itemFormat = "| %-6d | %-24s | %-10s |%n";

		System.out.println("\nIngressos disponiveis:\n");
		System.out.format("+--------+--------------------------+------------+%n");
		System.out.format("| Código | Filme                    | Valor      |%n");
		System.out.format("+--------+--------------------------+------------+%n");
		
		for(Ticket ticket: Storage.tickets) {	
			if(ticket.isAvailable()) {
				System.out.format(itemFormat, ticket.getCode(), ticket.getMovie(), ticket.getFormattedPrice());
			}
		}
		
		System.out.format("+--------+--------------------------+------------+%n");
		
		System.out.print("\nInforme o código do ingresso: ");
		code = input.nextInt();
		
		Ticket ticket = Storage.tickets.stream().
			    filter(i -> i.getCode() == code && i.isAvailable()).
			    findFirst()
			    .orElse(null);
		
		if(ticket == null) {
			throw new Exception("\nIngresso indisponível!");
		}
		
		ticket.setAvailable(false);
		
		Storage.sale.addProduct(ticket);
		
		System.out.print("\nIngresso adicionado ao carrinho!\n");
	}
	
	public static void sell() throws Exception {
		if(Storage.sale.getProducts().size() > 0) {
			boolean finished = Storage.sale.finish();
			
			if(finished) {
				Storage.sales.add(Storage.sale);

				System.out.print("\nVenda finalizada! Obrigado!\n");	
				
				Storage.sale = new Sale((Customer) Storage.authenticatedUser);
			} else {
				throw new Exception("Houve um erro ao finalizar a venda!");
			}
		} else {
			throw new Exception("Não há nenhum produto em seu carrinho!");
		}
	}
}
