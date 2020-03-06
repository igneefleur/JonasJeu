import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;

public class AnaisHaut extends Panel {

	private static final long serialVersionUID = 1L;

	private int largeur, hauteur;
	
	private Jonas jonas;

	public void changementTour() {
		this.repaint();
	}
	
	public void paint(Graphics g) {
		g.setFont(new Font("Garamond", Font.BOLD, 20));
		g.drawString(this.jonas.obtenirTableauTheo()[this.jonas.obtenirTour() - 1].toString(), 10, 30);
	}
	
	public AnaisHaut(Jonas j, Anais a, int l, int h) {
		this.largeur = l;
		this.hauteur = h;
		
		this.jonas = j;
		
		this.setPreferredSize(new Dimension(this.largeur, this.hauteur));
		
	}
	
}
