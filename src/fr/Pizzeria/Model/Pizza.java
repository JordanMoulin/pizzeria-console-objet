package fr.Pizzeria.Model;

public class Pizza {
	int id; 
	String code;
	String libelle;
	double prix;
	
	static int compteur;

	public Pizza(String code,String libelle,double prix){
		compteur++;
		this.id=compteur;
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
