public class ProduitFrais extends Produit {
	
	private int stock;

	public ProduitFrais(String nom) {
		super(nom,1.0);
		this.stock = 10;
	}

	public String get_stock_str() {
		return '\n' + super.nom + " : " + Integer.toString(this.stock);
	}

	public void delivrer() throws Exception {
		if (this.stock > 0) {
			this.stock -= 1;
		}
		else {
			throw new Exception("Pas assez de " + super.nom + " en stock.");
		}
	}

	public void remplir() {
		this.stock = 10;
	}

}