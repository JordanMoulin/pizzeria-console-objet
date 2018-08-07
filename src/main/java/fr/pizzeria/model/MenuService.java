package fr.pizzeria.model;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.StockageException;

public abstract class MenuService {
	abstract void executeUC(Scanner scanner, IPizzaDao pizzas) throws StockageException;
}
