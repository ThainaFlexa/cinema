import java.util.Scanner;

import br.ufpa.user.User;

public class Login {
	private static Scanner input = new Scanner(System.in);
	
	public static User authenticate() throws Exception {
		System.out.print("Usuário: ");
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
		
		if(finded.getPassword() != password) {
			throw new Exception("Senha incorreta!"); 
		}
		
		return finded;
	}
}
