import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;

public class AnaisBas extends Panel {

	private static final long serialVersionUID = 1L;
	
	private int largeur, hauteur;
	
	private Jonas jonas;
	private Anais anais;
	private Confirmation confirmation;
	
	private AnaisBouton[] tableauBouton = new AnaisBouton[4];
	
	public void changemenTour() {
		for(int i = 0; i < this.tableauBouton.length; i++)
			this.tableauBouton[i].modifierHumeur(this.jonas.obtenirTableauTheo()[this.jonas.obtenirTour() - 1].obtenirTableauHumeur()[i]);
		
	}
	
	public AnaisBas(Jonas j, Anais a, Confirmation c, int l, int h) {
		this.largeur = l;
		this.hauteur = h;
		
		this.jonas = j;
		this.anais = a;
		this.confirmation = c;
		
		this.setLayout(new GridLayout(1, 4));
		
		this.setPreferredSize(new Dimension(this.largeur, this.hauteur));
		
		for(int i = 0; i < this.tableauBouton.length; i++) {
			this.tableauBouton[i] = new AnaisBouton(this.jonas, this.anais, this.confirmation);
			this.add(tableauBouton[i]);
		}
	}

}
