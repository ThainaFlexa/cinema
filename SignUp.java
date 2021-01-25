import java.util.Scanner;
import java.util.stream.Collectors;

import br.ufpa.user.Customer;
import br.ufpa.user.Manager;
import br.ufpa.user.User;

class SignUp {
	private static Scanner input = new Scanner(System.in);
	
	public static void signup() throws Exception {
		System.out.print("\nPerfil (gestor ou cliente): ");
		String profile = input.nextLine();
		
		while(!Storage.profiles.contains(profile)) {
			System.out.print("\nEste perfil não existe. Digite 'gestor' ou 'cliente': ");
			profile = input.nextLine();
		}
		
		System.out.print("\nNome: ");
		String name = input.nextLine();
		
		System.out.print("\nLogin: ");
		String login = input.nextLine();
		
		while(
			Storage.users.stream().map(user -> user.getLogin())
				.collect(Collectors.toList())
				.contains(login)
		) {
			System.out.print("\nEste login não está disponível. Escolha outro.\nLogin: ");
			login = input.nextLine();
		}
		
		System.out.print("\nSenha: ");
		String password = input.nextLine();
		
		while(password == "") {
			password = input.nextLine();
		}
		
		User user = null;
		
		switch(profile) {
			case "gestor":
				user = new	Manager(name, login, password);
				break;
			case "cliente":
				user = new Customer(name, login, password);
				break;
		}
		
		if(user != null && user.validate()) {
			Storage.users.add(user);
			
			System.out.println("\nUsuário " + user.getName() + " criado com sucesso!");
		} else {
			throw new Exception("\nOcorreu um erro ao criar o usuário. Tente novamente.");
		}
	}
}
