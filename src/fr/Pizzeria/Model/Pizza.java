package fr.Pizzeria.Model;

public class Pizza {
	int id; 
	String code;
	String libelle;
	double prix;

	public Pizza(String code,String libelle,double prix){
		this.id=id++;
		this.code=code;
		this.libelle=libelle;
		this.prix=prix;
	}
	
	public Pizza(int id,String code,String libelle,double prix){
		this.id=id;
		this.code=code;
		this.libelle=libelle;
		this.prix=prix;
	}
	
	@Override
	public String toString() {
		return "Pizza [id=" + id + ", code=" + code + ", libelle=" + libelle + ", prix=" + prix + "]";
	}
	
	public int getId(){
		return id;
	}
	public String getCode(){
		return code;
	}
	public String getLibelle(){
		return libelle;
	}
	public double getPrix(){
		return prix;
	}
	
	public void setId(int sId){
		id = sId;
	}
	public void setCode(String sCode){
		code = sCode;
	}
	public void setLibelle(String sLibelle){
		libelle = sLibelle;
	}
	public void setPrix(double sPrix){
		prix = sPrix;
	}
}
