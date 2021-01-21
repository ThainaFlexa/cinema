package br.ufpa.transaction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Transaction {
	private LocalDateTime dateTime;
	
	public Transaction() {
		super();
		this.dateTime = LocalDateTime.now();
	}
	
	public abstract boolean finish();
	
	public String getFormattedDateTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		return dateTime.format(formatter);
	}
}
