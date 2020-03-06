import java.awt.Color;

public class Confirmation extends java.awt.Frame {

	private static final long serialVersionUID = 1L;
	
	private ConfirmationPanneau panneau = new ConfirmationPanneau();
	
	private String phraseReussite;
	private String phraseEchec;
	
	private Color couleurReussite = new Color(0, 0, 255);
	private Color couleurEchec = new Color(255, 0, 0);
	
	public void affichage(boolean b) {
		if(b) {
			this.panneau.changerPhrase(this.phraseReussite);
			this.panneau.changerCouleur(this.couleurReussite);
		} else {
			this.panneau.changerPhrase(this.phraseEchec);
			this.panneau.changerCouleur(this.couleurEchec);
		}
			
		
		this.setVisible(true);
		
		new java.util.Timer().schedule(new java.util.TimerTask(){
	        @Override
	        public void run() {
	    		Confirmation.this.setVisible(false);
	    		this.cancel();
	        }
	    }, 1000, 1000);
	}
	
	public Confirmation(String pr, String pe) {
		this.phraseReussite = pr;
		this.phraseEchec = pe;
		
		this.add(this.panneau);
		
		this.setTitle("Oh.");
		
		this.setSize(250, 100);
		
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}
	
}
