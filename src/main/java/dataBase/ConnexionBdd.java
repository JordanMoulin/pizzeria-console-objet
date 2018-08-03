package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBdd {
	// Informations de connexion à une base de données
	private static String url = "jdbc:mysql://localhost:3306/pizzeria";
	private static String user = "root";
	private static String passwd = "";
	private static Connection connexion = null;

	public static Connection getInstance() {
		if (connexion == null) {
			try {
				connexion = DriverManager.getConnection(url, user, passwd);
			} catch (SQLException e) {
			}
		}
		return connexion;
	}
}
