import java.util.ArrayList;
import java.util.Random;

public class Jonas {

	private Random nombre;
	
	private int tourCourant = 1;
	private int nombreTourSansArret;
	
	/*
	 * liste contenant tous les Theo
	 * possibles de tableauTheo.
	 * est prive car n'est utilise
	 * que pour creer le tableau
	 * juste apres.
	 */
	private ArrayList<Theo> listeTheo = new ArrayList<Theo>();
	
	/*
	 * tableau contenant tous les Theo
	 * utilises pour le jeu. la taille
	 * du tableau depend de nombreTour
	 */
	private Theo[] tableauTheo;
	
	/*
	 * ajoute un ou plusieurs Theo en
	 * fonction d'une humeur dans listeTheo.
	 */
	private void ajoutTheo(Theo.Humeur h, String... args) {
		for(String p : args)
			this.listeTheo.add(new Theo(h, p, this.nombre));
	}
	
	/*
	 * ajoute tous les Theo � listeTheo en fonction
	 * des humeurs (pour ajouter un Theo, il suffit
	 * d'ajouter un String � la fonction ajoutTheo
	 * correspondante avec une Humeur).
	 */
	private void creationListeTheo() {
		this.ajoutTheo(Theo.Humeur.HEUREUX,
				"Ca marche, je vais pouvoir t'admirer sur java", 
				"j'ai un trou, dans mon plafond.",
				"Un massage ?",
				"N'importe, tant que je suis avec vous. <3",
				"Elle me dégoûte trop.",
				"Mais je suis à poil dans mon lit et j'ai même pas p'tit dej!",
				"Anis.");
		
		this.ajoutTheo(Theo.Humeur.COLERE,
				"Je ne te réponds plus.",
				"J'ai des champis sur le feu :'(",
				"Je m'habille et j'arrive", 
				"Juis poussiereux, dsl",
				"mon appart c'est un peu un pokemon",
				"Juis pas d'accord",
				"Ce soir <3");
		
		this.ajoutTheo(Theo.Humeur.NEUTRE,
				"Parfait est une insulte pour Nolan, il est bien plus", 
				"ctrl+espace",
				"Viens jouer à lol.",
				"t'es fou",
				"J'aime le fun.",
				"Pousses.",
				"J'aime le pâté ?");
		
		this.ajoutTheo(Theo.Humeur.TRISTE,
				"c'était ton anniv ?",
				"Enplus je serai sur le départ, on pourra pas aller se balader.",
				"xWx",
				"Jme suis rendormie"
				);
		
		this.ajoutTheo(Theo.Humeur.POUET,
				"j'étais poussiérieux ?",
				"Les dieux m'ont parlés et ils m'ont ordonné d'avoir la flemme",
				"mais faut que je dorme moi"
				);
		
		this.ajoutTheo(Theo.Humeur.ARRET,
				"Je vote contre Théo.",
				"Je vous quitte.",
				"Vive Théo il est trop fort et trop beau");
	}
	
	/*
	 * cree le tableauTheo contenant autant de Theo que
	 * de nombreTour + 1 en fonction des Theo de listeTheo
	 * (necessite la creation de la listeTheo).
	 * le dernier theo etant toujours d'humeur Arret.
	 * tous les autres Theo sont selectionnes aleatoirement
	 * une fois les Theo d'humeur Arret retires.
	 * aucun Theo ne peut etre en double dans le tableau,
	 * sauf si la liste contient des doublons.
	 */
	private void creationTableauTheo() {
		ArrayList<Theo> liste01 = new ArrayList<Theo>();
		ArrayList<Theo> liste02 = new ArrayList<Theo>();
		
		Random nombre = new Random(0);
		
		for(int i = 0; i < this.listeTheo.size(); i++)
			if(this.listeTheo.get(i).memeHumeur(Theo.Humeur.ARRET))
				liste02.add(this.listeTheo.get(i));
			else
				liste01.add(this.listeTheo.get(i));
		
		for(int i = 0; i < this.nombreTourSansArret; i++) {
			int n = nombre.nextInt(liste01.size());
			this.tableauTheo[i] = liste01.get(n);
			liste01.remove(n);
		}
		
		this.tableauTheo[this.nombreTourSansArret] = liste02.get(nombre.nextInt(liste02.size()));
	}
	
	public int obtenirTour() {
		return this.tourCourant;
	}
	
	public void changerTour() {
		this.tourCourant++;
	}
	
	public int obtenirNombreTour() {
		return this.nombreTourSansArret;
	}
	
	public Theo[] obtenirTableauTheo() {
		return this.tableauTheo;
	}
	
	/*
	 * initialise un Jonas.
	 * necessite pour bien fonctionner
	 * l'utilisation des methodes
	 * creationListeTheo et creationTableauTheo
	 */
	public Jonas() {
		this.nombre = new Random(0);
		
		this.nombreTourSansArret = nombre.nextInt(3) + 3;
		this.tableauTheo = new Theo[this.nombreTourSansArret + 1];		
		
		this.creationListeTheo();
		this.creationTableauTheo();
	}
	
	
	// a supprimer ulterieurement
	public Jonas(int n) {
		this.nombre = new Random(0);
		
		if(n > 0)
			this.nombreTourSansArret = n;
		else
			this.nombreTourSansArret = nombre.nextInt(3) + 3;
		this.tableauTheo = new Theo[this.nombreTourSansArret + 1];
		
		this.creationListeTheo();
		this.creationTableauTheo();
		
	}
	
}
