package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoMem implements IPizzaDao {
	private ArrayList<Pizza> pizzas;

	public ArrayList<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(ArrayList<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public PizzaDaoMem() {
		pizzas = new ArrayList<Pizza>();
		pizzas.add(new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.POISSON));
		pizzas.add(new Pizza("REIN", "La Reine", 11.50, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("IND", "L'indienne", 14.00, CategoriePizza.VIANDE));
	}

	/** Trouve et affiche toutes les pizzas */
	@Override
	public List<Pizza> findAllPizzas() {
		return pizzas;
	}

	/** Permet de sauvegarder une nouvelle pizza */
	@Override
	public void saveNewPizza(Pizza newPizza) {
		pizzas.add(newPizza);
	}

	/** Permet de modifier une pizza */
	@Override
	public void updatePizza(String codePizza, Pizza newPizza) {
		Pizza pizza = findPizzaByCode(codePizza);
		if (pizza != null) {
			pizza.setCode(newPizza.getCode());
			pizza.setLibelle(newPizza.getLibelle());
			pizza.setPrix(newPizza.getPrix());
		}
	}

	/** Permet de rechercher une pizza grâce à son code */
	@Override
	public Pizza findPizzaByCode(String codePizza) {
		for (int i = 0; i < pizzas.size(); i++) {
			if (pizzas.get(i).getCode().equals(codePizza)) {
				return pizzas.get(i);
			}
		}
		return null;
	}

	/** Permet de supprimer une pizza */
	@Override
	public void deletePizza(String codePizza) {
		for (int i = 0; i < pizzas.size(); i++) {
			if (pizzas.get(i).getCode().equals(codePizza)) {
				pizzas.remove(i);
			}
		}
	}

	/** Permet de rechercher si une pizza existe */
	@Override
	public boolean pizzaExists(String codePizza) {
		boolean existe = false;
		for (int i = 0; i < pizzas.size(); i++) {
			if (pizzas.get(i).getCode().equals(codePizza)) {
				existe = true;
			}
		}
		return existe;
	}

}
