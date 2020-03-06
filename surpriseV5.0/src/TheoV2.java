import java.util.ArrayList;
import java.util.Random;

public class TheoV2 {
	
	public static enum Humeur {HEUREUX, COLERE, NEUTRE, ARRET, TRISTE};
	
	public static Humeur[] tableauHumeurSansArret = TheoV2.creationTableauHumeurSansArret();
	private static Humeur[] creationTableauHumeurSansArret() {
		Humeur[] tableau01 = Humeur.values();
		Humeur[] tableau02 = new Humeur[tableau01.length - 1];
		for(int i = 0, j = 0; i < tableau02.length; i++, j++)
			if(tableau01[j] != Humeur.ARRET)
				tableau02[i] = tableau01[j];
			else i--;
		return tableau02;
	}
	
	private Random nombre = new Random(0);
	
	public Humeur humeur;
	public String phrase;
	
	public Humeur[] tableauHumeurAleatoireSansArretAvecHumeurTheo; // commentaire
	private Humeur[] creationTableauHumeurAleatoireSansArretAvecHumeurTheo(int longueur) {
		ArrayList<Humeur> liste01 = new ArrayList<Humeur>();
		ArrayList<Humeur> liste02 = new ArrayList<Humeur>();
		Humeur[] tableau01 = new Humeur[longueur];
		
		for(Humeur h : TheoV2.creationTableauHumeurSansArret())
			liste01.add(h);
		
		int nombre = liste01.indexOf(this.humeur);
		liste02.add(liste01.get(nombre));
		liste01.remove(nombre);
		
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
	
	public TheoV2() {
		this.humeur = Humeur.TRISTE;
		this.phrase = "Tu as envie de voir Anais n'est ce pas?";
		
		this.tableauHumeurAleatoireSansArretAvecHumeurTheo = this.creationTableauHumeurAleatoireSansArretAvecHumeurTheo(1);
	}
	
	public TheoV2(Humeur h, String p) {
		this.humeur = h;
		this.phrase = p;
		
		this.tableauHumeurAleatoireSansArretAvecHumeurTheo = this.creationTableauHumeurAleatoireSansArretAvecHumeurTheo(4);
	}
	
	public static void main(String[] args) {
		new TheoV2();
	}
	
}
