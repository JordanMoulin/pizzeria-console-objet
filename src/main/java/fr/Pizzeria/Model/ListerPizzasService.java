package fr.pizzeria.model;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaBddDao;

public class ListerPizzasService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, PizzaBddDao dao) {
		System.out.println("Liste des pizzas :");
		List<Pizza> pizzas = dao.findAllPizzas();
		for (int i = 0; i < pizzas.size(); i++) {
			System.out.println(pizzas.get(i).toString());
		}
	}
}
