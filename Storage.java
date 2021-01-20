import java.util.ArrayList;

import br.ufpa.transaction.Sale;
import br.ufpa.user.User;

// Esta classe simula o banco de dados da aplicação.

public class Storage {
	public static ArrayList<User> users = new ArrayList<>();
	public static ArrayList<Sale> sales = new ArrayList<>();
	public static User authenticatedUser;
	
	@SuppressWarnings("serial")
	public static ArrayList<String> profiles = new ArrayList<>(){{
	    add("gestor");
	    add("cliente");
	}};
	
}
