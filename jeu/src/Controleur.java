
public class Controleur {
	
	public static void premierTour(Jonas jonas, Anais anais) {
		anais.anaisBas.changemenTour();
		anais.anaisHaut.changementTour();
	}
	
	public static void changementTour(Jonas jonas, Anais anais, Confirmation confirmation, Theo.Humeur humeur) {
		
		boolean verification = humeur == jonas.obtenirTableauTheo()[jonas.obtenirTour() - 1].obtenirHumeur();
		
		if(verification)
			jonas.changerScore();
		
		confirmation.affichage(verification);
		
		if(jonas.obtenirTour() > jonas.obtenirNombreTour())
			Controleur.finPartie(jonas, anais);
		else {
			jonas.changerTour();
			
			anais.anaisBas.changemenTour();
			anais.anaisHaut.changementTour();
		}
		
	}
	
	public static void finPartie(Jonas jonas, Anais anais) {
		anais.finPartie();
		
		new AffichageScore(jonas);
		
		new java.util.Timer().schedule(new java.util.TimerTask(){
	        @Override
	        public void run() {
	        	System.exit(0);
	        }
	    }, 5000, 5000);
	}
	
}
