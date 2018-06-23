import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;
import java.util.Iterator;


class Fenetre extends JFrame{
    public Fenetre(final Vector<Produit> produits){
	super("Distributeur");

	Container pan = getContentPane();
	JPanel p1 = new JPanel(new FlowLayout());
	JPanel p2 = new JPanel(new FlowLayout());
	JPanel p3 = new JPanel(new FlowLayout());
	JPanel p4 = new JPanel(new FlowLayout());
	// Les diiférents éléments
	final JTextField tf_montant = new JTextField(5);
	final JTextField tf_rendu = new JTextField(5);
	JButton bt_delivrer = new JButton("Delivrer");
	JButton bt_remplir = new JButton("Remplir");
	final String [] lbc_str = {"Café","Chocolat","Thé"};
	final JComboBox<Produit> lprod = new JComboBox<Produit>(produits);
	final JComboBox<String> lbc = new JComboBox<String>(lbc_str);
	final JCheckBox cb_lait = new JCheckBox("Lait");
	final JCheckBox cb_fort = new JCheckBox("Plus fort");
	final JCheckBox cb_al = new JCheckBox("Alongé");
	final JSlider sl = new JSlider(0,5);
	
	// Traitement sur les boutons
	bt_delivrer.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	try {
        		String strmontant = tf_montant.getText();
        		double montant = Double.parseDouble(strmontant);
    			Produit p = (Produit) lprod.getSelectedItem();
    			double rendu = montant - p.get_prix();
    			if (rendu >= 0) {
		    		switch (lprod.getSelectedIndex()) {
		    			case Main.BC: // Position de Boisson Chaude
		    				((BoissonChaude) p).delivrer(lbc.getSelectedIndex(), sl.getValue(), cb_fort.isSelected());
		    				break;
		    			default:
		    				p.delivrer();
		    				break;
		    		}
		    		tf_rendu.setText(Double.toString(rendu));
		    		tf_montant.setText("");
		    		System.out.println("Le client vient d'effectuer un achat de : " + p.toString() + " avec un montant de " + strmontant + ", il en reste " + p.get_stock_str());
		    	}
		    	else {
		    		throw new Exception("Le montant est insuffisant");
		    	}
        	}
 			catch (Exception except) {
        		System.out.println(except.getMessage());
        	}
		}
    });
    bt_remplir.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	Iterator it = produits.iterator();
    		while(it.hasNext()) {
    			((Produit) it.next()).remplir();
    		}
    		Main.sucre = 100;
    		System.out.println("Remplissage...");
        }
    });
	// Affichage
	this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	setBounds(50,50,550,170);
	p1.add(new JLabel("Montant : "));
	p1.add(tf_montant);
	p1.add(new JLabel(" rendu : "));
	p1.add(tf_rendu);
	p2.add(lprod);
	p3.add(lbc);
	p3.add(cb_al);
	p3.add(cb_fort);
	p3.add(cb_lait);
	p3.add(new JLabel("Sucre"));
	p3.add(sl);
	p4.add(bt_delivrer);
	p4.add(bt_remplir);
	pan.setLayout(new BorderLayout());
	pan.add(p1,BorderLayout.NORTH);
	pan.add(p2,BorderLayout.WEST);
	pan.add(p3,BorderLayout.CENTER);
	pan.add(p4,BorderLayout.SOUTH);
	setVisible(true);
    }
}

class Main{
    public static int date = 100;
    public static int sucre = 100;
    public final static int BC = 8; // Position de Boisson Chaude
    
    public static void main(String arg[]){
	Vector<Produit> produits = new Vector<Produit>();
	
	produits.add(new ProduitFrais("Coca"));
	produits.add(new ProduitFrais("Coca Zero"));
	produits.add(new ProduitFrais("Evian"));
	produits.add(new ProduitFrais("Orangina"));
	produits.add(new ProduitFrais("Fanta"));
	produits.add(new ProduitFrais("IceTea"));
	produits.add(new Fruit("Pomme",103));
	produits.add(new Fruit("Orange",99));
	produits.add(new BoissonChaude());
	Fenetre fen = new Fenetre(produits);
    }
}