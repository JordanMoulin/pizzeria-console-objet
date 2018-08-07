package fr.pizzeria.model;

import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;

public class AjouterPizzaService extends MenuService {
	private String code;
	private String nom;
	private String prix;
	private Pizza newPizza;
	private int cat;

	@Override
	public void executeUC(Scanner scanner, IPizzaDao dao) throws SavePizzaException {
		System.out.println("Ajout d’une nouvelle pizza :\n Veuillez saisir le code (3 lettres) :");
		code = scanner.next();
		System.out.println("Veuillez saisir le nom (sans espace) :");
		nom = scanner.next();
		System.out.println("Veuillez saisir le prix :");
		prix = scanner.next();
		if (!NumberUtils.isCreatable(prix)) {
			throw new SavePizzaException("Ce n'est pas un prix !");
		} else {
			System.out.println("Veuillez saisir la categorie de pizza \n 1: Viande \n 2: Sans Viande \n 3: Poisson");
			cat = scanner.nextInt();
			if (cat == 1) {
				newPizza = new Pizza(code, nom, Double.parseDouble(prix), CategoriePizza.valueOf("VIANDE"));
			} else if (cat == 2) {
				newPizza = new Pizza(code, nom, Double.parseDouble(prix), CategoriePizza.valueOf("SANS_VIANDE"));
			} else if (cat == 3) {
				newPizza = new Pizza(code, nom, Double.parseDouble(prix), CategoriePizza.valueOf("POISSON"));
			} else {
				throw new SavePizzaException("Ce n'est pas une catégorie valable");
			}
			dao.saveNewPizza(newPizza);
		}
	}
}
