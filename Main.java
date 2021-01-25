import java.util.Scanner;

import br.ufpa.user.Customer;
import br.ufpa.user.Manager;

class Main {
	private static Scanner input = new Scanner(System.in);
	private static GuestMenu guestMenu = new GuestMenu();
	private static CustomerMenu customerMenu = new CustomerMenu();
	private static ManagerMenu managerMenu = new ManagerMenu();
	
	private static int printMenu(Menu menu) {
		menu.print();
		
		int choice = input.nextInt();
		
		while(!menu.validateOption(choice)) {
			System.out.println("\nOpção inválida! Tente novamente.\n");
			choice = input.nextInt();
		}

        return choice;
	}
	
	public static void main(String[] args) {
		int userChoice;
		
		do {
			if(Storage.authenticatedUser != null && Storage.authenticatedUser.getClass() == Customer.class) {
				userChoice = printMenu(customerMenu);
				customerMenu.processChoice(userChoice);
			} else if(Storage.authenticatedUser != null && Storage.authenticatedUser.getClass() == Manager.class) {
				userChoice = printMenu(managerMenu);
				managerMenu.processChoice(userChoice);
			} else {
				userChoice = printMenu(guestMenu);
				guestMenu.processChoice(userChoice);
			}
			
			System.out.print("\n");
		} while(userChoice != 0);
		
		System.out.println("=======================");
		System.out.println("Programa finalizado!");
		System.out.println("=======================");
		System.exit(0);
	}
}
