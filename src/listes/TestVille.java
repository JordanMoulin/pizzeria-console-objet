package listes;

import java.util.ArrayList;

public class TestVille {
	public static void main(String[] args) {
		ArrayList<Ville> villes = new ArrayList<Ville>();
		villes.add(new Ville("Nice",343000));
		villes.add(new Ville("Carcassonne",47800));
		villes.add(new Ville("Narbonne",53400));
		villes.add(new Ville("Lyon",484000 ));
		villes.add(new Ville("Foix",9700 ));
		villes.add(new Ville("Pau",77200));
		villes.add(new Ville("Marseille",850700));
		villes.add(new Ville("Tarbes",40600));
		
		int longueur = villes.get(0).getNbHabitants();
		int plage = 100000;

		/** recherche de la ville avec le plus d'habitants */
		for(int i=0;i<villes.size()-1;i++){
			if(villes.get(i).getNbHabitants()>longueur){
				longueur = villes.get(i).getNbHabitants();
			}
		}
		//System.out.println(longueur);
		
		/** recherche de la ville avec le plus petit nombre d'habitants */
		for(int i=0;i<villes.size()-1;i++){
			if(villes.get(i).getNbHabitants()<longueur){
				longueur = villes.get(i).getNbHabitants();
			}
		}
		//System.out.println(longueur);
		
		/** Mets les noms de villes en majuscules */
		for(int i=0; i<villes.size();i++){
			if(villes.get(i).getNbHabitants()>plage){
				villes.get(i).setNom(villes.get(i).getNom().toUpperCase());;
			}
		}
		/** affiche tous les éléments de la liste */
		for(int i=0;i<villes.size();i++){
			System.out.println("Ville : "+villes.get(i).getNom()+", habitants : "+villes.get(i).getNbHabitants());
		}
	}
}
