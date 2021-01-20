import java.util.Scanner;

import br.ufpa.user.Customer;
import br.ufpa.user.Manager;
import br.ufpa.user.User;

public class SignUp {
	private static Scanner input = new Scanner(System.in);
	
	public static User signup() throws Exception {
		System.out.print("Perfil (gestor ou cliente): ");
		String profile = input.next();
		
		while(!Storage.profiles.contains(profile)) {
			System.out.print("Este perfil não existe. Digite gestor ou cliente: ");
			profile = input.next();
		}
		
		System.out.print("Nome: ");
		String name = input.next();
		
		System.out.print("Login: ");
		String login = input.next();
		
		System.out.print("\nSenha: ");
		String password = input.next();
		
		User user;
		
		switch(profile) {
			case "gestor":
				user = new	Manager(name, login, password);
				break;
			case "cliente":
				user = new Customer(name, login, password);
				break;
			default:
				return null;
		}
		
		if(user.validate()) {
			Storage.users.add(user);
		} else {
			throw new Exception("Ocorreu um erro ao criar o usuário. Tente novamente.");
		}
		
		return user;
	}
}
