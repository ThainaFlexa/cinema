import java.util.Scanner;

import br.ufpa.transaction.Sale;
import br.ufpa.user.Customer;
import br.ufpa.user.User;

public class Login {
	private static Scanner input = new Scanner(System.in);
	
	public static User authenticate() throws Exception {
		System.out.print("\nLogin: ");
		String login = input.next();

		User finded = Storage.users.stream()
				  .filter(user -> login.equals(user.getLogin()))
				  .findAny()
				  .orElse(null);
		
		if(finded == null) {
			throw new Exception("Este login não existe!"); 
		}
		
		System.out.print("\nSenha: ");
		String password = input.next();
		
		if(!finded.getPassword().equals(password)) {
			throw new Exception("Senha incorreta!"); 
		}
		
		if(finded.getClass() == Customer.class) {
			Storage.sale = new Sale((Customer) finded);
		}
		
		System.out.println("\nBem-vindo(a) " + finded.getName() + "!");
		
		return finded;
	}
	
	public static void logout() {
		Storage.authenticatedUser = null;
		Storage.sale = null;
		
		System.out.println("\nFazendo logout...");
	}
}
