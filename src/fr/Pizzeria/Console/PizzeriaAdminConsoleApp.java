package fr.Pizzeria.Console;

import java.util.Scanner;

import fr.Pizzeria.Model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		/* initialisation du tableau de pizzas */
		Pizza[] tempP;
		Pizza[] p = new Pizza[8];
		p[0]= new Pizza("PEP","Pépéroni",12.50);
		p[1]= new Pizza("MAR","Margherita",14.00);
		p[2]= new Pizza("REIN","La Reine",11.50);
		p[3]= new Pizza("FRO","La 4 fromages",12.00);
		p[4]= new Pizza("CAN","La cannibale",12.50);
		p[5]= new Pizza("SAV","La savoyarde",13.00);
		p[6]= new Pizza("ORI","L'orientale",13.50);
		p[7]= new Pizza("IND","L'indienne",14.00);
		
		/* Variables */
		int i;
		int choixM = 0;
		String choixP;
		String code;
		String nom;
		double prix;
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
				for(i=0;i<p.length;i++){
					System.out.println(p[i].getId()+" "+p[i].getCode()+" -> "+p[i].getLibelle()+" ("+p[i].getPrix()+")");
				}
				break;
			case 2:
				System.out.println("Ajout d’une nouvelle pizza :\n Veuillez saisir le code :");
				code = scanner.next();
				System.out.println("Veuillez saisir le nom (sans espace) :");
				nom = scanner.next();
				System.out.println("Veuillez saisir le prix");
				prix = scanner.nextInt();
				tempP = new Pizza[p.length+1];
				for(i=0;i<p.length;i++){
					tempP[i] = p[i];
				}
				tempP[p.length]= new Pizza(code,nom,prix);
				p = new Pizza[tempP.length];
				for(i=0;i<tempP.length;i++){
					p[i]= tempP[i];
				}
				break;
			case 3:
				System.out.println("Mise à jour d’une pizza :");
				for(i=0;i<p.length;i++){
					System.out.println(p[i].getCode()+" -> "+p[i].getLibelle()+" ("+p[i].getPrix()+")");
				}
				System.out.println("Choisir le code de la pizza à modifier :");
				choixP = scanner.next();
				System.out.println("Veuillez saisir le nouveau code :");
				code = scanner.next();
				System.out.println("Veuillez saisir le nouveau nom :");
				nom = scanner.next();
				System.out.println("Veuillez saisir le nouveau prix :");
				prix = scanner.nextDouble();
				for(i=0;i<p.length-1;i++){
					if(p[i].getCode().equals(choixP)){
						p[i].setCode(code);
						p[i].setLibelle(nom);
						p[i].setPrix(prix);
					}
				}
				break;
			case 4:
				System.out.println("Suppression d’une pizza :");
				for(i=0;i<p.length;i++){
					System.out.println(p[i].getCode()+" -> "+p[i].getLibelle()+" ("+p[i].getPrix()+")");
				}
				System.out.println("Veuillez choisir le code de la pizza à supprimer :");
				choixP = scanner.next();
				for(i=0;i<p.length;i++){
					if(p[i].getCode().equals(choixP)){
						for(int y=i;y<p.length-1;y++){
							p[y] = p[y+1];
						}
					}
				}
				tempP = new Pizza[p.length-1];
				for(i=0;i<tempP.length;i++){
					tempP[i] = p[i];
				}
				p = new Pizza[tempP.length];
				for(i=0;i<tempP.length;i++){
					p[i]= tempP[i];
				}
				break;
			default:
				System.out.println("Aurevoir :'(");
				break;
			}
			
		}
		scanner.close();
	}
}
