package fr.Pizzeria.Console;

import java.util.Scanner;

import fr.Pizzeria.Model.AjouterPizzaService;
import fr.Pizzeria.Model.Pizza;
import fr.Pizzeria.Model.PizzaMemDao;

public class PizzeriaAdminConsoleApp {
	public static void main(String[] args) {

		PizzaMemDao pizzas = new PizzaMemDao();

		/* Variables */
		int choixM = 0;
		String choixP;
		String code;
		String nom;
		double prix;
		Pizza newPizza;
		Scanner scanner = new Scanner(System.in);

		/* Boucle pour rester dans le menu */
		while(choixM != 99){

			System.out.println("***** Pizzeria Administration *****  ");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");
			choixM = scanner.nextInt();

			switch(choixM){
			case 1:
				System.out.println("Liste des pizzas :");
				pizzas.findAllPizzas();
				break;
			case 2:
				AjouterPizzaService addPizza= new AjouterPizzaService();
				
				break;
			case 3:
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
				break;
			case 4:
				System.out.println("Suppression d’une pizza :");
				pizzas.findAllPizzas();
				System.out.println("Veuillez choisir le code de la pizza à supprimer :");
				choixP = scanner.next();
				pizzas.deletePizza(choixP);
				break;
			default:
				System.out.println("Aurevoir :'(");
				break;
			}
		}
		scanner.close();
	}
}
