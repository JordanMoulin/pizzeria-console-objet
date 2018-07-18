package fr.Pizzeria.Console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		int choix = 0;

		while(choix != 99){

			System.out.println("***** Pizzeria Administration *****  ");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");

			Scanner scanner = new Scanner(System.in); 
			choix = scanner.nextInt();

			switch(choix){
			case 1:
				System.out.println("Liste des pizzas :");
				break;
			case 2:
				System.out.println("Ajout d’une nouvelle pizza :");
				break;
			case 3:
				System.out.println("Mise à jour d’une pizza :");
				break;
			case 4:
				System.out.println("Suppression d’une pizz :");
				break;
			default:
				System.out.println("Aurevoir :'(");
				break;
			}
			scanner.close();
		}
	}
}
