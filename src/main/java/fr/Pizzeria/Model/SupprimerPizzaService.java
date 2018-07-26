package fr.Pizzeria.Model;

import java.util.Scanner;

public class SupprimerPizzaService extends MenuService {
	private String choixP;

	@Override
	public void executeUC(Scanner scanner,PizzaMemDao pizzas) {
		System.out.println("Suppression d’une pizza :");
		pizzas.findAllPizzas();
		System.out.println("Veuillez choisir le code de la pizza à supprimer :");
		choixP = scanner.next();
		pizzas.deletePizza(choixP);
	}
}