package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataBase.ConnexionBdd;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaBddDao implements IPizzaDao {

	private ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
	private Connection connexion = ConnexionBdd.getInstance();

	@Override
	public List<Pizza> findAllPizzas() {
		try (PreparedStatement statement = connexion.prepareStatement("select * from pizzas")) {
			// Récupération du curseur de résultat de l'exécution de la
			// requêteSQL
			try (ResultSet resultSet = statement.executeQuery()) {
				// Déplacement du curseur
				// -> return true si il y a un prochain élement, false sinon
				while (resultSet.next()) {
					// int id = resultSet.getInt("id");
					String code = resultSet.getString("code");
					String libelle = resultSet.getString("libelle");
					double prix = resultSet.getDouble("prix");
					String categorie = resultSet.getString("categorie");

					Pizza pizza = new Pizza(code, libelle, prix, CategoriePizza.valueOf(categorie));
					pizzas.add(pizza);
					assert !pizzas.isEmpty();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return pizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		pizzas.add(pizza);
		try (PreparedStatement statement = connexion
				.prepareStatement("insert into pizzas (code,libelle,prix,categorie) values(?,?,?,?)")) {
			// Récupération du curseur de résultat de l'exécution de la
			// requêteSQL
			// Valorisation du paramètre
			statement.setString(1, pizza.getCode());
			statement.setString(2, pizza.getLibelle());
			statement.setDouble(3, pizza.getPrix());
			statement.setString(4, pizza.getCat().toString());

			try (ResultSet resultSet = statement.executeQuery()) {

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		try (PreparedStatement statement = connexion
				.prepareStatement("update pizzas set code = ?, libelle = ?, prix = ?, categorie = ? where code =?")) {
			// Récupération du curseur de résultat de l'exécution de la
			// requêteSQL
			// Valorisation du paramètre
			statement.setString(1, pizza.getCode());
			statement.setString(2, pizza.getLibelle());
			statement.setDouble(3, pizza.getPrix());
			statement.setString(4, pizza.getCat().toString());
			statement.setString(5, codePizza);

			try (ResultSet resultSet = statement.executeQuery()) {

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
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
