import java.util.ArrayList;
import java.util.Random;

public class Jonas {

	private Random nombre;
	
	private int tourCourant = 1;
	private int nombreTourSansArret;
	
	private int score = 0;
	
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
	 * ajoute tous les Theo ï¿½ listeTheo en fonction
	 * des humeurs (pour ajouter un Theo, il suffit
	 * d'ajouter un String ï¿½ la fonction ajoutTheo
	 * correspondante avec une Humeur).
	 */
	private void creationListeTheo() {
		this.ajoutTheo(Theo.Humeur.JOIE,
				"Ca marche, je vais pouvoir t'admirer sur java", // j'étais joie. Meme si tu ne l'as jamais fait..
				
				"Un massage ?", // massage == joie
				"Mais je suis a poil dans mon lit et j'ai meme pas p'tit dej!", // t'imaginer nu suffit ;-)
				"N'importe, tant que je suis avec vous. <3", // mignon
				
				"Elle me degoute trop.", // je n'aime pas ma soeur, je suis donc satisfait.
				
				"Anis.");
		
		this.ajoutTheo(Theo.Humeur.COLERE,				
				"c'est l'habitude", // car tu ne fais pas attention a moi. A plusieurs reprises.
				"...", // j'attendais une reponse.
				
				"Je m'habille et j'arrive", // je ne veux pas que tu t'habilles.
				"Ce soir <3", // Pourquoi pas maintenant? En plus on ne s'est meme pas vu au final.
				
				"C'est une rageuse Anis."
				);
		
		this.ajoutTheo(Theo.Humeur.NEUTRE,
				"Parfait est une insulte pour Nolan, il est bien plus", // evident, inutile de formuler cette phrase
				"Juis pas d'accord", // m'en fous.
				"j'ai un trou, dans mon plafond.", // idem
				"ctrl+espace", // pourquoi cette phrase est dans le jeu?
				"Viens jouer a lol.", // non merci.
				"t'es fou", // evident aussi.
				"J'aime le fun.",  // ton avis ne m'interesse pas. Mais ton corps...
				"Occupé" // je m'en fous. Je viens quand meme.
				);
		
		this.ajoutTheo(Theo.Humeur.TRISTE,
				"c'etait ton anniv ?", // car je me suis senti blesse par son manque d'attention.
				
				"Jme suis rendormie", // apres une attente de 45minutes, aucune reaction n'eatait approprie. Une simple larme suffisait. 
				"Enplus je serai sur le depart, on pourra pas aller se balader.", // balade == joie.
				
				"xWx", // Pas compris. l'incomprehension me rend plutot triste.
				
				"rien", // je voulais qu'il se passe quelque chose
				
				"Juis avec mon frere, desole", // parce que je voulais du Brownie
				
				"tkt, elle est pire quand elle loupe un canon."
				);
		
		this.ajoutTheo(Theo.Humeur.POUET, // mélange d'insatisfaction et de desespoir du aux excuses de Jonas.
				// ridicule.
				"Juis poussiereux, dsl",
				"j'etais poussierieux ?",
				
				// fatigue incomprehensible.
				"Les dieux m'ont parles et ils m'ont ordonne d'avoir la flemme",
				"mais faut que je dorme moi",
				
				// ???.
				"mon appart c'est un peu un pokemon",
				"J'ai des champis sur le feu :'(",
				"J'aime le pate ?"
				);
		
		this.ajoutTheo(Theo.Humeur.DEGOUT,
				"Je ne te reponds plus.", // tu ne le merites pas.
				"Vive Theo il est trop fort et trop beau", // qu'ai je fait pour meriter ce mensonge?
				
				"Pousses.", // sale
				
				"c'est pas ta faute." // un peu. ce qui empire la situation (je me degoute).
				);
		
		this.ajoutTheo(Theo.Humeur.ARRET,
				"Je vote contre Theo.", // je veux mourir
				"Je vous quitte." // Une idee inimaginable
				);
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
		
		for(int i = 0; i < this.listeTheo.size(); i++)
			if(this.listeTheo.get(i).memeHumeur(Theo.Humeur.ARRET))
				liste02.add(this.listeTheo.get(i));
			else
				liste01.add(this.listeTheo.get(i));
		
		for(int i = 0; i < this.nombreTourSansArret; i++) {
			int n = this.nombre.nextInt(liste01.size());
			this.tableauTheo[i] = liste01.get(n);
			liste01.remove(n);
		}
		
		this.tableauTheo[this.nombreTourSansArret] = liste02.get(this.nombre.nextInt(liste02.size()));
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
	
	public int obtenirScore () {
		return this.score;
	}
	
	public void changerScore () { 
		this.score++; 
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
		this.nombre = new Random();
		
		this.nombreTourSansArret = nombre.nextInt(9) + 3;
		this.tableauTheo = new Theo[this.nombreTourSansArret + 1];		
		
		this.creationListeTheo();
		this.creationTableauTheo();
	}
	
}
