import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Anais extends Frame implements WindowListener {

	private static final long serialVersionUID = 1L;
	
	private int largeur, hauteur;
	
	private Jonas jonas;
	private Confirmation confirmation;
	
	public AnaisHaut anaisHaut;
	public AnaisBas anaisBas;
	
	public void finPartie() {
		System.out.println(this.jonas.obtenirScore());
		this.setVisible(false);
	}
	
	public Anais(Jonas j, Confirmation c, int l, int h) {
		super();
		
		this.largeur = l;
		this.hauteur = h;
		
		this.jonas = j;
		this.confirmation = c;
		
		this.addWindowListener(this);
		
		this.setSize(new Dimension(this.largeur, this.hauteur));
		
		this.anaisHaut = new AnaisHaut(this.jonas, this, this.largeur, this.hauteur / 3);
		this.anaisBas = new AnaisBas(this.jonas, this, this.confirmation, this.largeur, this.hauteur / 3);
		
		this.setLayout(new BorderLayout());
		
		this.add(anaisHaut, BorderLayout.NORTH);		
		this.add(anaisBas, BorderLayout.SOUTH);
		
		
		this.setTitle("Surprise.");
		this.setBackground(new Color(243, 237, 249)); // 0, 187, 187
		
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		
	}

}
