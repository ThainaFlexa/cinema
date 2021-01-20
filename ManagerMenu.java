public class ManagerMenu extends Menu {

	public ManagerMenu() {
		super(new String[]{
				"1 - Relatório de vendas",
				"2 - Listar usuários",
				"0 - Sair"
			}, "Menu do gestor");
	}

	@Override
	public void processChoice(int choice) {
		switch(choice) {
			case 1: 
				try {
					Storage.sales.forEach(sale -> System.out.print(sale));
				} catch(Exception e) {
					System.out.println(e.getMessage());
					processChoice(choice);
				}
				break;
			
			case 2: 
				try {
					Storage.users.forEach(user -> System.out.print(user));
				} catch(Exception e) {
					System.out.println(e.getMessage());
					processChoice(choice);
				}
				break;
				
			case 0: 
				System.exit(0);
				break;
		}
	}
}
