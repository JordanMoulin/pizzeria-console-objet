package fr.Pizzeria.Model;

import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.Pizzeria.Exception.SavePizzaException;

public class AjouterPizzaService extends MenuService {
	private String code;
	private String nom;
	private String prix;
	private Pizza newPizza;
	private String cat;

	@Override
	public void executeUC(Scanner scanner, PizzaMemDao pizzas) throws SavePizzaException {
		System.out.println("Ajout d’une nouvelle pizza :\n Veuillez saisir le code (3 lettres) :");
		code = scanner.next();
		System.out.println("Veuillez saisir le nom (sans espace) :");
		nom = scanner.next();
		System.out.println("Veuillez saisir le prix :");
		prix = scanner.next();
		if(!NumberUtils.isCreatable(prix)){
			throw new SavePizzaException("Ce n'est pas un prix !");
		}else{
			System.out.println("Veuillez saisir la categorie de pizza (Viande/Poisson/Sans Viande) :");
			cat = scanner.next();
			cat = cat.toUpperCase();
			if(cat.compareTo("VIANDE")==0 || cat.compareTo("POISSON")==0 || cat.compareTo("SANS VIANDE")==0){
				newPizza = new Pizza(code,nom,Double.parseDouble(prix),CategoriePizza.valueOf(cat));
			}else{
				throw new SavePizzaException(cat+" n'est pas une catégorie valable");
			}
			pizzas.saveNewPizza(newPizza);
		}
	}
}
