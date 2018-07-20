package fr.Pizzeria.Model;

import java.util.Scanner;

public class AjouterPizzaService extends MenuService {
	private String code;
	private String nom;
	private double prix;
	private Pizza newPizza;

	@Override
	public void executeUC(Scanner scanner, PizzaMemDao pizzas) {
		System.out.println("Ajout d’une nouvelle pizza :\n Veuillez saisir le code :");
		code = scanner.next();
		System.out.println("Veuillez saisir le nom (sans espace) :");
		nom = scanner.next();
		System.out.println("Veuillez saisir le prix");
		prix = scanner.nextInt();
		newPizza = new Pizza(code,nom,prix);
		pizzas.saveNewPizza(newPizza);
		
	}
}
