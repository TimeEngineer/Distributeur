public class Produit {
	
	protected String nom;
	private double prix;

	public Produit(String nom, double prix) {
		this.nom = nom;
		this.prix = prix;
	}

	public String toString() {
		return this.nom + " : " + Double.toString(prix) + " €";
	}

	public double get_prix() {
		return this.prix;
	}

	public String get_stock_str() {
		return "";
	}
	public void delivrer() throws Exception {}
	public void remplir() {}

}