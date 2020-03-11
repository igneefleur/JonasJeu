import java.awt.Frame;

public class AffichageScore extends Frame {
	
	private static final long serialVersionUID = 1L;
	

	private Jonas jonas;
	
	private AffichageScorePanneau panneau;
	
	public AffichageScore(Jonas j) {
		this.jonas = j;
		
		panneau = new AffichageScorePanneau(this.jonas);
		
		this.add(this.panneau);
		
		this.setTitle("C'est fini.");
		
		this.setSize(614, 153);
		
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.setVisible(true);
	}
	

}
