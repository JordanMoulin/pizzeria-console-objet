package fr.pizzeria.model;

public enum CategoriePizza {
	VIANDE ("Viande"), POISSON ("Poisson"), SANS_VIANDE ("Sans Viande"); 
	
	private String nom;
	
	private CategoriePizza(String nom){
		this.nom=nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
