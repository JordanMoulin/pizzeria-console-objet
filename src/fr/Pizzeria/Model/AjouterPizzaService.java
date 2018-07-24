package fr.Pizzeria.Model;

import java.util.Scanner;

import fr.Pizzeria.Exception.SavePizzaException;

public class AjouterPizzaService extends MenuService {
	private String code;
	private String nom;
	private double prix;
	private Pizza newPizza;
	private String cat;

	@Override
	public void executeUC(Scanner scanner, PizzaMemDao pizzas) throws SavePizzaException {
		System.out.println("Ajout d’une nouvelle pizza :\n Veuillez saisir le code :");
		code = scanner.next();
		System.out.println("Veuillez saisir le nom (sans espace) :");
		nom = scanner.next();
		System.out.println("Veuillez saisir le prix");
		prix = scanner.nextInt();
		System.out.println("Veuillez saisir la categorie de pizza (Viande/Poisson/Sans Viande)");
		cat = scanner.next();
		if(cat.compareTo("Viande")==0){
			newPizza = new Pizza(code,nom,prix,CategoriePizza.VIANDE);
		}else if(cat.compareTo("Poisson")==0){
			newPizza = new Pizza(code,nom,prix,CategoriePizza.POISSON);
		}else if(cat.compareTo("Sans Viande")==0){
			newPizza = new Pizza(code,nom,prix,CategoriePizza.SANS_VIANDE);
		}else{
			throw new SavePizzaException(cat+" n'est pas une catégorie valable");
		}
		//newPizza = new Pizza(code,nom,prix,CategoriePizza.valueOf(cat));
		pizzas.saveNewPizza(newPizza);
	}
}
