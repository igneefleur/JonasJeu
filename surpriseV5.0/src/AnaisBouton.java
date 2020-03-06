import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnaisBouton extends Button implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private Jonas jonas;
	private Anais anais;
	private Confirmation confirmation;
	
	private Theo.Humeur humeur;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Controleur.changementTour(this.jonas, this.anais, this.confirmation, this.humeur);
	}
	
	public void modifierHumeur(Theo.Humeur h) {
		this.humeur = h;
		
		this.setLabel(this.humeur.toString());
		this.setBackground(Theo.couleur(this.humeur));
	}
	
	public AnaisBouton(Jonas j, Anais a, Confirmation c) {
		super();
		
		this.anais = a;
		this.jonas = j;
		this.confirmation = c;
		
		this.addActionListener(this);
				
	}
	
}
