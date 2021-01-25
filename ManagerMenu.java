import java.text.NumberFormat;
import java.util.Scanner;

import br.ufpa.transaction.Sale;
import br.ufpa.user.User;

class ManagerMenu extends Menu {
	private Scanner input = new Scanner(System.in);

	public ManagerMenu() {
		super(new String[]{
				"1 - Relatório de vendas",
				"2 - Listar usuários",
				"3 - Logout",
				"0 - Finalizar"
			}, "Menu do GESTOR");
	}

	@Override
	public void processChoice(int choice) {
		switch(choice) {
			case 1: 
				try {
					if(Storage.sales.size() == 0) {
						throw new Exception("\nNenhuma venda realizada até o momento.");
					} else {
						String itemFormat = "| %-20s | %-20s | %-11s |%n";
						String totalFormat = "| %-43s | %-11s |%n";

						System.out.println("\nVendas realizadas:\n");
						System.out.format("+----------------------+----------------------+-------------+%n");
						System.out.format("| Cliente              | Data                 | Faturamento |%n");
						System.out.format("+----------------------+----------------------+-------------+%n");
						
						for(Sale sale: Storage.sales) {
					    	System.out.format(itemFormat, sale.getCustomer(), sale.getFormattedDateTime(), sale.getFormattedTotal());
					    }
						
						System.out.format("+----------------------+----------------------+-------------+%n");
			
						double total = Storage.sales.stream()
								.map(i -> i.getTotal())
								.mapToDouble(Double::valueOf)
								.sum();
						
						NumberFormat formatter = NumberFormat.getCurrencyInstance();
						String formattedTotal = formatter.format(total); 
						
						System.out.format(totalFormat, "TOTAL", formattedTotal);
						
						System.out.format("+---------------------------------------------+-------------+%n");	
					}
				} catch(Exception e) {
					System.out.println("\n" + e.getMessage() + "\n");
					processChoice(choice);
				}
				break;
			
			case 2: 
				try {		
					if(Storage.users.size() == 0) {
						throw new Exception("\nNenhum usuário cadastrado.");
					} else {
						String itemFormat = "| %-26s | %-20s |%n";
	
						System.out.println("\nUsuários cadastrados:\n");
						System.out.format("+----------------------------+----------------------+%n");
						System.out.format("| Usuário                    | Login                |%n");
						System.out.format("+----------------------------+----------------------+%n");
						
						for(User user: Storage.users) {
					    	System.out.format(itemFormat, user.getName(), user.getLogin());
					    }
						
						System.out.format("+----------------------------+----------------------+%n");
					}
				} catch(Exception e) {
					System.out.println("\n" + e.getMessage() + "\n");
					processChoice(choice);
				}
				break;
				
			case 3: 
				Login.logout();
				break;
		}
		
		System.out.print("\nPressione Enter para continuar...");
		input.nextLine();
	}
}

