package fr.pizzeria.model;

import java.lang.reflect.Field;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.pizzeria.utils.ToString;

@Entity
@Table(name = "pizzas")
public class Pizza {

	@Id // Déclare à JPA quel champ représente la clé primaire
	@Column(name = "id")
	private int id;

	@Column(name = "code")
	@ToString(uppercase = true, apres = " -> ")
	private String code;

	@Column(name = "libelle")
	@ToString(avant = "", uppercase = true)
	private String libelle;

	@Column(name = "prix")
	@ToString(avant = " (", apres = "€)")
	private double prix;

	@Enumerated(EnumType.STRING)
	private CategoriePizza cat;

	public CategoriePizza getCat() {
		return cat;
	}

	public void setCat(CategoriePizza cat) {
		this.cat = cat;
	}

	static int compteur;

	public Pizza() {

	}

	public Pizza(String code, String libelle, double prix, CategoriePizza cat) {
		compteur++;
		this.id = compteur;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.cat = cat;
	}

	public Pizza(int id, String code, String libelle, double prix) {
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String chaine = "";
		String upperChaine = "";
		Class structure = this.getClass();
		Field[] fields = structure.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(ToString.class)) {
				ToString annotation = field.getAnnotation(ToString.class);
				String apres = annotation.apres();
				String avant = annotation.avant();
				boolean a = annotation.uppercase();
				try {
					if (a) {
						upperChaine = (String) field.get(this);
						upperChaine = upperChaine.toUpperCase();
						chaine += avant + upperChaine + apres;
					} else {
						chaine += avant + field.get(this) + apres;
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return chaine;
	}

	public int getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getLibelle() {
		return libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setId(int sId) {
		id = sId;
	}

	public void setCode(String sCode) {
		code = sCode;
	}

	public void setLibelle(String sLibelle) {
		libelle = sLibelle;
	}

	public void setPrix(double sPrix) {
		prix = sPrix;
	}
}
