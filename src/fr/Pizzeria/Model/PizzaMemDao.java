package fr.Pizzeria.Model;

import java.util.ArrayList;

public class PizzaMemDao implements IPizzaDao {
	private ArrayList<Pizza> pizzas;

	public PizzaMemDao(){
		pizzas = new ArrayList<Pizza>();
		pizzas.add(new Pizza("PEP","Pépéroni",12.50,CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("MAR","Margherita",14.00,CategoriePizza.POISSON));
		pizzas.add(new Pizza("REIN","La Reine",11.50,CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("FRO","La 4 fromages",12.00,CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("CAN","La cannibale",12.50,CategoriePizza.VIANDE));
		pizzas.add(new Pizza("SAV","La savoyarde",13.00,CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("ORI","L'orientale",13.50,CategoriePizza.VIANDE));
		pizzas.add(new Pizza("IND","L'indienne",14.00,CategoriePizza.VIANDE));
	}

	@Override
	public Pizza[] findAllPizzas() {
		for(int i=0;i<pizzas.size();i++){
			System.out.println(pizzas.get(i).getCode()+" -> "+pizzas.get(i).getLibelle()+" ("+pizzas.get(i).getPrix()+
					") : "+pizzas.get(i).getCat().getNom());
		}
		return null;
	}

	@Override
	public void saveNewPizza(Pizza newPizza) {
		pizzas.add(newPizza);
	}

	@Override
	public void updatePizza(String codePizza, Pizza newPizza) {
		int i = pizzas.indexOf(findPizzaByCode(codePizza));
		if(pizzas.get(i).getCode().equals(codePizza)){
			pizzas.get(i).setCode(newPizza.getCode());
			pizzas.get(i).setLibelle(newPizza.getLibelle());
			pizzas.get(i).setPrix(newPizza.getPrix());
		}
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		int result = 0;
		for(int i=0;i<pizzas.size();i++){
			if(pizzas.get(i).getCode().equals(codePizza)){
				result=i;
			}
		}
		return pizzas.get(result);
	}
	@Override
	public void deletePizza(String codePizza) {
		for(int i=0;i<pizzas.size();i++){
			if(pizzas.get(i).getCode().equals(codePizza)){
				pizzas.remove(i);
			}
		}
	}


	@Override
	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}

}
