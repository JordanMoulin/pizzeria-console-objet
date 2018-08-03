package fr.pizzeria.model;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaBddDao;
import fr.pizzeria.exception.StockageException;

public abstract class MenuService {
	abstract void executeUC(Scanner scanner, PizzaBddDao pizzas) throws StockageException;
}
