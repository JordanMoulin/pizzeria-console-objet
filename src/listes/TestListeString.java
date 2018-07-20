package listes;

import java.util.ArrayList;
import java.util.Arrays;

public class TestListeString {

	public static void main(String[] args) {
		ArrayList<String> villes = new ArrayList<String>();
		villes.add("Nice");
		villes.add("Carcassonne");
		villes.add("Narbonne");
		villes.add("Lyon");
		villes.add("Foix");
		villes.add("Pau");
		villes.add("Marseille");
		villes.add("Tarbes");
		int longueur = villes.get(0).length();
		String resultL = "";

		/** recherche de la ville avec le plus grand nombre */
		for(int i=0;i<villes.size()-1;i++){
			if(villes.get(i).length()>longueur){
				resultL = villes.get(i);
				longueur = villes.get(i).length();
			}
		}
		//System.out.println(resultL);

		/** Mets les noms de villes en majuscules */
		for(int i=0; i<villes.size();i++){
			villes.set(i,villes.get(i).toUpperCase());
		}
		
		/** affiche tous les éléments de la liste */
		System.out.println(Arrays.deepToString(villes.toArray()));
	}
}
