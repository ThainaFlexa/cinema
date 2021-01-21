public class GuestMenu extends Menu {

	public GuestMenu() {
		super(new String[]{
				"1 - Criar usuário",
				"2 - Fazer login",
				"0 - Finalizar"
			}, "Menu do VISITANTE");
	}
	
	@Override
	public void processChoice(int choice) {
		switch(choice) {
			case 1: 
				try {
					SignUp.signup();
				} catch(Exception e) {
					System.out.println(e.getMessage());
					processChoice(choice);
				}
				break;
			
			case 2: 
				try {
					Storage.authenticatedUser = Login.authenticate(); 
				} catch(Exception e) {
					System.out.println(e.getMessage());
					processChoice(choice);
				}
				break;
		}
	}
}
