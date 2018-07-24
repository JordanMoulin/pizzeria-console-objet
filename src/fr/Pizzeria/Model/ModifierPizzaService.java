package fr.Pizzeria.Model;

import java.util.Scanner;

public class ModifierPizzaService extends MenuService {
	private String choixP;
	private String code;
	private String nom;
	private Double prix;
	private Pizza newPizza;
	private String cat;

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
		System.out.println("Veuillez saisir la categorie de pizza (Viande/Poisson/Sans Viande)");
		cat = scanner.next();
		if(cat.compareTo("Viande")==0){
			newPizza = new Pizza(code,nom,prix,CategoriePizza.VIANDE);
		}else if(cat.compareTo("Poisson")==0){
			newPizza = new Pizza(code,nom,prix,CategoriePizza.POISSON);
		}else if(cat.compareTo("Sans Viande")==0){
			newPizza = new Pizza(code,nom,prix,CategoriePizza.SANS_VIANDE);
		}else{
			System.out.println(cat+" n'est pas une catégorie de pizza valable, veuillez recommencer !");
		}
		pizzas.updatePizza(choixP, newPizza);

	}
}