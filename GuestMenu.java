import br.ufpa.user.User;

public class GuestMenu extends Menu {

	public GuestMenu() {
		super(new String[]{
				"1 - Criar usuário",
				"2 - Fazer login",
				"0 - Sair"
			}, "Menu do visitante");
	}
	
	@Override
	public void processChoice(int choice) {
		switch(choice) {
			case 1: 
				try {
					User createdUser = SignUp.signup();
					Storage.users.add(createdUser);
					System.out.println("Usuário " + createdUser.getName() + " criado com sucesso!");
				} catch(Exception e) {
					System.out.println(e.getMessage());
					processChoice(choice);
				}
				break;
			
			case 2: 
				try {
					Storage.authenticatedUser = Login.authenticate(); 
				} catch(Exception e) {
					System.out.println("Ocorreu um erro ao fazer login. Tente novamente.");
					processChoice(choice);
				}
				break;
				
			case 0: 
				System.exit(0);
				break;
		}
	}
}
