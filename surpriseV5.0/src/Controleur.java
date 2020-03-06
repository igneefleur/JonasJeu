
public class Controleur {
	
	public static void premierTour(Jonas jonas, Anais anais) {
		anais.anaisBas.changemenTour();
		anais.anaisHaut.changementTour();
	}
	
	public static void changementTour(Jonas jonas, Anais anais, Confirmation confirmation, Theo.Humeur humeur) {
		
		confirmation.affichage(humeur == jonas.obtenirTableauTheo()[jonas.obtenirTour() - 1].obtenirHumeur());
		
		if(jonas.obtenirTour() > jonas.obtenirNombreTour())
			Controleur.finPartie(anais);
		
		jonas.changerTour();
		
		anais.anaisBas.changemenTour();
		anais.anaisHaut.changementTour();
	}
	
	public static void finPartie(Anais anais) {
		anais.finPartie();
		System.out.println("bouh.");
		System.exit(0);
	}
	
}
