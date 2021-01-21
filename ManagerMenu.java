import java.text.NumberFormat;

import br.ufpa.transaction.Sale;

public class ManagerMenu extends Menu {

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
						System.out.println("\nNenhuma venda realizada até o momento.");
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
					System.out.println(e.getMessage());
					processChoice(choice);
				}
				break;
			
			case 2: 
				try {
					System.out.println("\nUsuários cadastrados ===================");
					Storage.users.forEach(user -> System.out.print(user + "\n"));
				} catch(Exception e) {
					System.out.println(e.getMessage());
					processChoice(choice);
				}
				break;
				
			case 3: 
				Login.logout();
				break;
		}
	}
}

