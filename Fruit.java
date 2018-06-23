public class Fruit extends ProduitFrais {
	
	private int date;

	public Fruit(String nom, int date) {
		super(nom);
		this.date = date;
	}

	public void delivrer() throws Exception {
		if (this.date > Main.date) {
			super.delivrer();
		}
		else {
			throw new Exception("Date de péremption atteinte.");
		}
	}

}