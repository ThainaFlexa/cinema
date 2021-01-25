import java.text.NumberFormat;
import java.util.Scanner;

import br.ufpa.product.Product;
import br.ufpa.product.Ticket;

class CustomerMenu extends Menu {
	private Scanner input = new Scanner(System.in);

	public CustomerMenu() {
		super(new String[]{
				"1 - Comprar ingresso",
				"2 - Comprar lanche",
				"3 - Ver carrinho",
				"4 - Remover do carrinho",
				"5 - Finalizar venda",
				"6 - Logout",
				"0 - Finalizar"
			}, "Menu do CLIENTE");
	}

	@Override
	public void processChoice(int choice) {
		switch(choice) {
			case 1: 
				try {
					if(Storage.tickets.size() == 0) {
						throw new Exception("\nNão há ingressos disponíveis.");
					} else {
						Selling.addToCart("ticket");
					}
				} catch(Exception e) {
					String message = e.getMessage() != null ? e.getMessage() : "Código não encontrado!"; 
					System.out.println("\n" + message + "\n");
				}
				break;
			
			case 2: 
				try {
					if(Storage.snacks.size() == 0) {
						throw new Exception("\nNão há lanches disponíveis.");
					} else {
						Selling.addToCart("snack");
					}
				} catch(Exception e) {
					String message = e.getMessage() != null ? e.getMessage() : "Código não encontrado!"; 
					System.out.println("\n" + message + "\n");
				}
				break;
				
			case 3: 
				try {
					if(Storage.sale.getProducts().size() == 0) {
						throw new Exception("\nNenhum item adicionado ao seu carrinho!");
					}
					
					String itemFormat = "| %-6d | %-32s | %-10s |%n";
					String totalFormat = "| %-41s | %-10s |%n";

					System.out.println("\nSeu carrinho de compras:\n");
					System.out.format("+--------+----------------------------------+------------+%n");
					System.out.format("| Código | Item                             | Valor      |%n");
					System.out.format("+--------+----------------------------------+------------+%n");
					
					for(Product product : Storage.sale.getProducts()) {
						String description = (product.getClass() == Ticket.class) ? 
								"Ingresso: " + ((Ticket) product).getMovie() : 
								product.getDescription();
														
				    	System.out.format(itemFormat, product.getCode(), description, product.getFormattedPrice());
				    }
					
					System.out.format("+--------+----------------------------------+------------+%n");
		
					double total = Storage.sale.getProducts().stream()
							.map(i -> i.getPrice())
							.mapToDouble(Double::valueOf)
							.sum();
					
					NumberFormat formatter = NumberFormat.getCurrencyInstance();
					String formattedTotal = formatter.format(total); 
					
					System.out.format(totalFormat, "TOTAL A PAGAR", formattedTotal);
					
					System.out.format("+-------------------------------------------+------------+%n");
				} catch(Exception e) {
					System.out.println("\n" + e.getMessage() + "\n");
				}
				break;
				
			case 4:
				try {
					if(Storage.sale.getProducts().size() == 0) {
						throw new Exception("\nNenhum item adicionado ao seu carrinho!");
					} else {
						Selling.removeFromCart("ticket");
					}
				} catch(Exception e) {
					System.out.println("\n" + e.getMessage() + "\n");
				}
				break;
			
			case 5: 
				try {
					Selling.sell();
				} catch(Exception e) {
					System.out.println("\n" + e.getMessage() + "\n");
				}
				break;
				
			case 6: 
				Login.logout();
				break;
		}
		
		System.out.print("\nPressione Enter para continuar...");
		input.nextLine();
	}
}
