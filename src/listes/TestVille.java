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
		int resultL = 0;

		/** recherche de la ville avec le plus d'habitants */
		for(int i=0;i<villes.size()-1;i++){
			if(villes.get(i).getNbHabitants()>longueur){
				longueur = villes.get(i).getNbHabitants();
			}
		}
		System.out.println(longueur);
	}
}
