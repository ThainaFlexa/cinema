package br.ufpa.transaction;

import java.time.LocalDateTime;

import br.ufpa.user.Authenticable;

public abstract class Transaction implements Authenticable {
	private LocalDateTime dateTime;
	
	public Transaction() {
		super();
		this.dateTime = LocalDateTime.now();
	}
	
	public abstract boolean finish();
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	
}
