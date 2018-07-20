package fr.Pizzeria.Model;

import java.util.Scanner;

public class ModifierPizzaService extends MenuService {
	private String choixP;
	private String code;
	private String nom;
	private Double prix;
	private Pizza newPizza;

	@Override
	public void executeUC(Scanner scanner,PizzaMemDao pizzas) {
		System.out.println("Mise à jour d’une pizza :");
		pizzas.findAllPizzas();
		System.out.println("Choisir le code de la pizza à modifier :");
		choixP = scanner.next();
		System.out.println("Veuillez saisir le nouveau code :");
		code = scanner.next();
		System.out.println("Veuillez saisir le nouveau nom :");
		nom = scanner.next();
		System.out.println("Veuillez saisir le nouveau prix :");
		prix = scanner.nextDouble();
		newPizza = new Pizza(code,nom,prix);
		pizzas.updatePizza(choixP, newPizza);

	}
}