package fr.Pizzeria.Exception;

public class StockageException extends Exception{
	private String msg;
	
	public StockageException(String msg) {
		super(msg);
	}
}
