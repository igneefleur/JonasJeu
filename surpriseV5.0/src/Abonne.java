import java.util.ArrayList;
import java.util.Collections;

public class Abonne implements Comparable<Abonne> {

	private String prenom, nom;
	private int numero;
	
	private static int compteur = 1;
	
	private static void add(ArrayList<Abonne> liste, Abonne... args) {
		for(Abonne a : args)
			liste.add(a);
	}
	
	@Override
	public String toString() {
		return "(" + this.numero + ")" + "_" + this.prenom + "_" + this.nom;
	}
		
	private Abonne(String p, String n) {
		this.prenom = p;
		this.nom = n;
		
		this.numero = Abonne.compteur; Abonne.compteur++;
	}
	
	@Override
	public int compareTo(Abonne arg0) {
		int comparaison0 = this.nom.compareTo(arg0.nom);
		
		if(comparaison0 == 0)
			return this.prenom.compareTo(arg0.prenom);
		
		return comparaison0;
	}
	
	public static void main(String[] args) {
		Abonne fd = new Abonne("Florian", "Duzes");
		Abonne ks = new Abonne("Kevin", "Spataro");
		
		System.out.println(fd.compareTo(ks));
		
		ArrayList<Abonne> listeAbonne = new ArrayList<Abonne>();
		
		Abonne.add(listeAbonne,
				new Abonne("Florian", "Guibert"),
				new Abonne("Idriss", "Berkane"),
				new Abonne("Elsa", "Verinski"),
				new Abonne("Anne", "Guibert")
				);
		
		Collections.sort(listeAbonne);
		System.out.println(listeAbonne);
		System.out.println("∅♥");
		
		
		
	}
}
