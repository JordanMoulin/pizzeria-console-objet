package fr.Pizzeria.Model;

import java.util.Scanner;

import fr.Pizzeria.Exception.StockageException;

public abstract class MenuService {
	abstract void executeUC(Scanner scanner, PizzaMemDao pizzas) throws StockageException;
}
