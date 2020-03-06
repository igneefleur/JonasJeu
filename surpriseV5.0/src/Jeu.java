
public class Jeu {
	
	public Jeu() {
		Jonas jonas = new Jonas();
		Confirmation confirmation = new Confirmation("EVIDENT, EN FAIT.", "C'EST UN ECHEC.");
		Anais anais = new Anais(jonas, confirmation, 400, 200);
		
		Controleur.premierTour(jonas, anais);
	}
	
	public static void main(String[] args) {
		
		new Jeu();
	}

}
