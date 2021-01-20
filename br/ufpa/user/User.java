package br.ufpa.user;

public abstract class User implements Authenticable {
	private String name;
	private String login;
	private String password;
	
	public User(String name, String login, String password) {
		super();
		this.name = name;
		this.login = login;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public boolean authenticate() {
		// Fake authentication for users
		return true;
	}
	
	public boolean validate() {
		return name != "" &&
			login != "" &&
			password != "";
	}

	@Override
	public String toString() {
		return name + " (" + login + ")";
	}
}
