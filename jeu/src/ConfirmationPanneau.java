import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;

public class ConfirmationPanneau extends Panel {

	private static final long serialVersionUID = 1L;

	private String phrase = "bouh";
	private Color couleur = new Color(0, 0, 0);
	
	@Override
	public void paint(Graphics g) {
		g.setColor(this.couleur);
		g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		g.drawString(this.phrase, 0 + 10, this.getHeight() - 20);
	}
	
	public void changerCouleur(Color c) {
		this.couleur = c;
	}
	
	public void changerPhrase(String s) {
		this.phrase = s;
	}
	
	public ConfirmationPanneau() {
		super();
	}
	
}
