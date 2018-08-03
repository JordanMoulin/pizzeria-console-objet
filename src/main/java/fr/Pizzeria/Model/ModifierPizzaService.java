package fr.pizzeria.model;

import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.pizzeria.dao.PizzaBddDao;
import fr.pizzeria.exception.UpdatePizzaException;

public class ModifierPizzaService extends MenuService {
	private String choixP;
	private String code;
	private String nom;
	private String prix;
	private Pizza newPizza;
	private String cat;

	@Override
	public void executeUC(Scanner scanner, PizzaBddDao pizzas) throws UpdatePizzaException {
		System.out.println("Mise à jour d’une pizza :");
		pizzas.findAllPizzas();
		System.out.println("Choisir le code de la pizza à modifier :");
		choixP = scanner.next();
		if (pizzas.pizzaExists(choixP)) {
			System.out.println("Veuillez saisir le nouveau code (3 lettres) :");
			code = scanner.next();
			System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
			nom = scanner.next();
			System.out.println("Veuillez saisir le nouveau prix :");
			prix = scanner.next();
			if (!NumberUtils.isCreatable(prix)) {
				throw new UpdatePizzaException("Ce n'est pas un prix !");
			} else {
				System.out.println("Veuillez saisir la categorie de pizza (Viande/Poisson/Sans_Viande) :");
				cat = scanner.next();
				cat = cat.toUpperCase();
				if (cat.compareTo("VIANDE") == 0 || cat.compareTo("POISSON") == 0
						|| cat.compareTo("SANS_VIANDE") == 0) {
					newPizza = new Pizza(code, nom, Double.parseDouble(prix), CategoriePizza.valueOf(cat));
				} else {
					throw new UpdatePizzaException(cat + " n'est pas une catégorie valable");
				}
				pizzas.updatePizza(choixP, newPizza);
			}
		} else {
			throw new UpdatePizzaException("Aucune pizza ne correspond !");
		}
	}
}