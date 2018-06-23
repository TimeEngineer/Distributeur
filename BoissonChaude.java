public class BoissonChaude extends Produit {

	private int stockCafe;
	private int stockChocolat;
	private int stockThe;

	public BoissonChaude() {
		super("Boisson Chaude",0.60);
		this.stockCafe = 30;
		this.stockChocolat = 30;
		this.stockThe = 30;
	}

	public String get_stock_str() {
		return '\n' + "Café : " + Integer.toString(this.stockCafe) + '\n' + "Chocolat : " + Integer.toString(this.stockChocolat) + '\n' + "Thé : " + Integer.toString(this.stockThe);
	}

	public void delivrer(int selection, int sucre, boolean forte) throws Exception {
		int bool = forte ? 1 : 0;
		int stock = 1 + bool;
		if (sucre > Main.sucre) {
			throw new Exception("Pas assez de sucre en stock.");
		}
		switch (selection) {
            case 0:
            	if (this.stockCafe >= stock) 
            		this.stockCafe -= stock;
            	else
            		throw new Exception("Pas assez de café en stock.");
                break;
            case 1:
            	if (this.stockChocolat >= stock) 
            		this.stockChocolat -= stock;
            	else
            		throw new Exception("Pas assez de chocolat en stock.");
                break;
            case 2:
            	if (this.stockThe >= stock) 
            		this.stockThe -= stock;
            	else
            		throw new Exception("Pas assez de thé en stock.");
                break;
        }
        Main.sucre -= sucre;
	}

	public void remplir() {
		this.stockCafe = 30;
		this.stockChocolat = 30;
		this.stockThe = 30;
	}
	
}