package fr.Pizzeria.Console;

import java.util.Scanner;

import fr.Pizzeria.Exception.SavePizzaException;
import fr.Pizzeria.Exception.StockageException;
import fr.Pizzeria.Exception.UpdatePizzaException;
import fr.Pizzeria.Model.AjouterPizzaService;
import fr.Pizzeria.Model.ExportPizza;
import fr.Pizzeria.Model.ListerPizzasService;
import fr.Pizzeria.Model.ModifierPizzaService;
import fr.Pizzeria.Model.PizzaMemDao;
import fr.Pizzeria.Model.SupprimerPizzaService;

public class PizzeriaAdminConsoleApp {
	public static void main(String[] args) {

		/* Variables */
		PizzaMemDao dao = new PizzaMemDao();
		int choixM = 0;
		Scanner scanner = new Scanner(System.in);

		/* Boucle pour rester dans le menu */
		while(choixM != 99){

			System.out.println("***** Pizzeria Administration *****  ");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("5. Exporter la liste des pizzas");
			System.out.println("99. Sortir");
			choixM = scanner.nextInt();

			switch(choixM){
			case 1:
				ListerPizzasService listPizza = new ListerPizzasService();
				listPizza.executeUC(scanner, dao);
				break;
			case 2:
				AjouterPizzaService addPizza = new AjouterPizzaService();
				try {
					addPizza.executeUC(scanner,dao);
				} catch (SavePizzaException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				ModifierPizzaService modifPizza = new ModifierPizzaService();
				try {
					modifPizza.executeUC(scanner, dao);
				} catch (UpdatePizzaException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				SupprimerPizzaService supprPizza = new SupprimerPizzaService();
				supprPizza.executeUC(scanner, dao);
				break;
			case 5:
				ExportPizza pdfPizza = new ExportPizza();
				pdfPizza.executeUC(scanner, dao);
				break;
			case 99:
				System.out.println("Aurevoir :'(");
				break;
			default :
				System.out.println("Rentrez un chiffre valable !");
				break;
			}
		}
		scanner.close();
	}
}
