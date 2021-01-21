import java.text.NumberFormat;

import br.ufpa.product.Product;
import br.ufpa.product.Ticket;

public class CustomerMenu extends Menu {

	public CustomerMenu() {
		super(new String[]{
				"1 - Comprar ingresso",
				"2 - Comprar lanche",
				"3 - Ver carrinho",
				"4 - Finalizar venda",
				"5 - Logout",
				"0 - Finalizar"
			}, "Menu do CLIENTE");
	}

	@Override
	public void processChoice(int choice) {
		switch(choice) {
			case 1: 
				try {
					if(Storage.tickets.size() == 0) {
						System.out.println("\nNão há ingressos disponíveis.");
					} else {
						Selling.addToCart("ticket");
					}
				} catch(Exception e) {
					System.out.println(e.getMessage());
					processChoice(choice);
				}
				break;
			
			case 2: 
				try {
					if(Storage.snacks.size() == 0) {
						System.out.println("\nNão há lanches disponíveis.");
					} else {
						Selling.addToCart("snack");
					}
				} catch(Exception e) {
					System.out.println(e.getMessage());
					processChoice(choice);
				}
				break;
				
			case 3: 
				try {
					if(Storage.sale.getProducts().size() == 0) {
						System.out.println("\nNenhum item adicionado ao seu carrinho!");
						break;
					}
					
					String itemFormat = "| %-6d | %-32s | %-10s |%n";
					String totalFormat = "| %-41s | %-10s |%n";

					System.out.println("\nSeu carrinho de compras:\n");
					System.out.format("+--------+----------------------------------+------------+%n");
					System.out.format("| Código | Item                             | Valor      |%n");
					System.out.format("+--------+----------------------------------+------------+%n");
					
					for(Product product : Storage.sale.getProducts()) {
						String description;
						
						if(product.getClass() == Ticket.class) {
							description = "Ingresso: " + ((Ticket) product).getMovie();
						} else {
							description = product.getDescription();
						}
								
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
					System.out.println(e.getMessage());
				}
				break;
			
			case 4: 
				try {
					Selling.sell();
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 5: 
				Login.logout();
				break;
		}
	}
}
