import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Theo {
	
	/*
	 * enumeration des differentes
	 * humeurs pouvant etre prises par
	 * un Theo.
	 * le static modifie la position
	 * d'Humeur pour que s'il est
	 * modifie, il est modifie dans
	 * tous les Theo.
	 */
	public static enum Humeur {HEUREUX, COLERE, NEUTRE, ARRET, TRISTE, POUET};
	

	public static Color couleur(Humeur h) {
		switch(h) {
		case HEUREUX :
			return new Color(0, 200, 0);
		case COLERE :
			return new Color(200, 0, 0);
		case NEUTRE :
			return new Color(238, 238, 238);
		case TRISTE :
			return new Color(100, 100, 255);
		case POUET :
			return new Color(200, 0, 200);
		default :
			return new Color(255, 255, 255);
		}
	}
	
	/*
 	* tableau des humeurs sans l'humeur Arret.
 	* n'est utilise que pour les boutons.
 	*/
	private static Humeur[] creationTableauHumeurSansArret() {
		Humeur[] tableau01 = Humeur.values();
		Humeur[] tableau02 = new Humeur[tableau01.length - 1];
		for(int i = 0, j = 0; i < tableau02.length; i++, j++)
			if(tableau01[j] != Humeur.ARRET)
				tableau02[i] = tableau01[j];
			else i--;
		return tableau02;
	}
	
	private Random nombre;
	
	private Humeur humeur;
	private String phrase;
	
	private Humeur[] tableauHumeurAleatoireSansArretAvecHumeurTheo; // commentaire
	private Humeur[] creationTableauHumeurAleatoireSansArretAvecHumeurTheo(int longueur) {
		ArrayList<Humeur> liste01 = new ArrayList<Humeur>();
		ArrayList<Humeur> liste02 = new ArrayList<Humeur>();
		Humeur[] tableau01 = new Humeur[longueur];
		
		for(Humeur h : Theo.creationTableauHumeurSansArret())
			liste01.add(h);
		
		
		
		int nombre = liste01.indexOf(this.humeur);
		try{
			liste02.add(liste01.get(nombre));
			liste01.remove(nombre);
		} catch(ArrayIndexOutOfBoundsException e) {
			nombre = this.nombre.nextInt(liste01.size());
			liste02.add(liste01.get(nombre));
			liste01.remove(nombre);
		}
		
	
		
		for(int i = 1; i < longueur; i++) {
			nombre = this.nombre.nextInt(liste01.size());
			liste02.add(liste01.get(nombre));
			liste01.remove(nombre);
		}
		
		for(int i = 0; i < longueur; i++) {
			nombre = this.nombre.nextInt(liste02.size());
			tableau01[i] = liste02.get(nombre);
			liste02.remove(nombre);
		}
		
		return tableau01;
	}
	
	public Humeur obtenirHumeur() {
		return this.humeur;
	}
	
	public Humeur[] obtenirTableauHumeur() {
		return this.tableauHumeurAleatoireSansArretAvecHumeurTheo;
	}
	
	public boolean memeHumeur(Humeur h) {
		return this.humeur == h;
	}
	
	public Theo(Humeur h, String p, Random r) {
		this.humeur = h;
		this.phrase = p;
		this.nombre = r;
		
		this.tableauHumeurAleatoireSansArretAvecHumeurTheo = this.creationTableauHumeurAleatoireSansArretAvecHumeurTheo(4);
	}
	
	/*
	 * renvoie la phrase du Theo.
	 */
	@Override
	public String toString() {
		return this.phrase;
	}
	
	// ..non.
	
}
