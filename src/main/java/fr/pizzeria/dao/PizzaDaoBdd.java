package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataBase.ConnexionBdd;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoBdd implements IPizzaDao {

	private ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
	private Connection connexion = ConnexionBdd.getInstance();

	@Override
	public List<Pizza> findAllPizzas() {
		pizzas = new ArrayList<Pizza>();
		try (PreparedStatement statement = connexion.prepareStatement("select * from pizzas")) {
			// R�cup�ration du curseur de r�sultat de l'ex�cution de la
			// requ�teSQL
			try (ResultSet resultSet = statement.executeQuery()) {
				// D�placement du curseur
				// -> return true si il y a un prochain �lement, false sinon
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
		if(pizzas.isEmpty()){
			findAllPizzas();
		}
		pizzas.add(pizza);
		try (PreparedStatement statement = connexion
				.prepareStatement("insert into pizzas (code,libelle,prix,categorie) values(?,?,?,?)")) {
			// R�cup�ration du curseur de r�sultat de l'ex�cution de la
			// requ�teSQL
			// Valorisation du param�tre
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
			// R�cup�ration du curseur de r�sultat de l'ex�cution de la
			// requ�teSQL
			// Valorisation du param�tre
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
		if(pizzaExists(codePizza)){
			try (PreparedStatement statement = connexion
					.prepareStatement("delete from pizzas where code=?")) {
				// R�cup�ration du curseur de r�sultat de l'ex�cution de la
				// requ�teSQL
				// Valorisation du param�tre
				statement.setString(1, codePizza);

				try (ResultSet resultSet = statement.executeQuery()) {

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("La pizza que vous voulez supprimez n'existe pas");
		}
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		try (PreparedStatement statement = connexion
				.prepareStatement("select * from pizzas where code=?")) {
			// R�cup�ration du curseur de r�sultat de l'ex�cution de la
			// requ�teSQL
			// Valorisation du param�tre
			statement.setString(1, codePizza);

			try (ResultSet resultSet = statement.executeQuery()) {
				if(resultSet.next()){
					return true;
				}else{
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
}
