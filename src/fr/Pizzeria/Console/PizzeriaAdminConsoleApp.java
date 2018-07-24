package fr.Pizzeria.Console;

import java.util.Scanner;

import fr.Pizzeria.Exception.SavePizzaException;
import fr.Pizzeria.Model.AjouterPizzaService;
import fr.Pizzeria.Model.ListerPizzasService;
import fr.Pizzeria.Model.ModifierPizzaService;
import fr.Pizzeria.Model.PizzaMemDao;
import fr.Pizzeria.Model.SupprimerPizzaService;

public class PizzeriaAdminConsoleApp {
	public static void main(String[] args) {

		/* Variables */
		PizzaMemDao pizzas = new PizzaMemDao();
		int choixM = 0;
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
				ListerPizzasService listPizza = new ListerPizzasService();
				listPizza.executeUC(scanner, pizzas);
				break;
			case 2:
				AjouterPizzaService addPizza = new AjouterPizzaService();
				try {
					addPizza.executeUC(scanner,pizzas);
				} catch (SavePizzaException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				ModifierPizzaService modifPizza = new ModifierPizzaService();
				modifPizza.executeUC(scanner, pizzas);
				break;
			case 4:
				SupprimerPizzaService supprPizza = new SupprimerPizzaService();
				supprPizza.executeUC(scanner, pizzas);
				break;
			default:
				System.out.println("Aurevoir :'(");
				break;
			}
		}
		scanner.close();
	}
}
