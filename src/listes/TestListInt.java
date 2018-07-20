package listes;

import java.util.ArrayList;
import java.util.Arrays;

public class TestListInt {

	public static void main(String[] args) {
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		int nega=0;

		ArrayList<Integer> entiers = new ArrayList<Integer>();
		entiers.add(-1);
		entiers.add(5);
		entiers.add(7);
		entiers.add(3);
		entiers.add(-2);
		entiers.add(4);
		entiers.add(8);
		entiers.add(5);

		

		/** recherche le plus petit élément de la liste */
		for(int i=0;i<entiers.size()-1;i++){
			if(min>entiers.get(i))
				min=entiers.get(i);
		}
		//System.out.println(min);

		/** recherche le plus grand élément de la liste */
		for(int i=0;i>entiers.size()-1;i++){
			if(max>entiers.get(i))
				max=entiers.get(i);
		}
		//System.out.println(min);

		/** recherche les éléments négatifs et les modifis */
		for(int i=0;i<entiers.size()-1;i++){
			if(entiers.get(i)<0){
				entiers.set(i,-entiers.get(i));
			}
		}
		/** affiche tous les éléments de la liste */
		System.out.println(Arrays.deepToString(entiers.toArray()));
	}
}
