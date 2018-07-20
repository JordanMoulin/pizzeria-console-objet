package fr.Pizzeria.Model;

import java.util.Scanner;

public abstract class MenuService {
	abstract void executeUC(Scanner scanner, PizzaMemDao pizzas);
}
