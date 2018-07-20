package fr.Pizzeria.Model;

import java.util.Scanner;

public class ListerPizzasService extends MenuService {

	@Override
	public void executeUC(Scanner scanner,PizzaMemDao pizzas) {
		System.out.println("Liste des pizzas :");
		pizzas.findAllPizzas();
	}

}
