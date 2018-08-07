package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Pizza;

public class PizzaDaoJPA implements IPizzaDao {

	private ArrayList<Pizza> pizzas;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzeria-console-objet");
	private EntityManager em = emf.createEntityManager();

	@Override
	public List<Pizza> findAllPizzas() {
		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p", Pizza.class);
		pizzas = (ArrayList<Pizza>) query.getResultList();
		return pizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePizza(String codePizza) {
		// TODO Auto-generated method stub

	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}

}
