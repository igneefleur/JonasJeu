import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;

public class AffichageScorePanneau extends Panel {

	
	private static final long serialVersionUID = 1L;

	private Jonas jonas;
	private Color couleur = new Color(0, 0, 0);
	private String resultat = "Je suis très déçu. Recommence. Fallait être meilleur.";
	
	
	public void paint(Graphics g) {
		g.setColor(this.couleur);
		g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		g.drawString(this.resultat, 10, 30);
		g.drawString(this.jonas.obtenirScore() + "/" + (this.jonas.obtenirNombreTour() + 1), 300, 100);
	}
	
	public AffichageScorePanneau(Jonas j) {
		this.jonas = j;
	}
	
}
