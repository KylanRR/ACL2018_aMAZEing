import java.io.IOException;
import javax.swing.*;
import java.util.ArrayList;

public class MoteurDeJeu {

	/************************************** VARIABLES **************************************/

	private int size;
	public static Labyrinthe labyrinthe;
	static Controle fenetre;
	static boolean jeuEnCours = false;
	static boolean herosEstMort = false;
	static boolean victoire = false;
	static int nbMonstre;
	static int nbFantome;
	static int nbPiege;
	static int nbSoin;
	static int nbMur;
	static int nbTp;

	public static Heros heros;

	public static ArrayList<Monstre> monstres = new ArrayList<Monstre>();
	public static ArrayList<Fantome> fantomes = new ArrayList<Fantome>();

	public static void partieInit() {
		Tresor.posInit();
		heros = new Heros(0,0,30,200,200);
		heros.posInit();
		for (int i = 0;i<nbPiege;i++) {
			Piege.posInit();
		}
		for (int i = 0;i<nbSoin;i++) {
			Soin.posInit();
		}
		for (int i = 0;i<nbTp;i++) {
			Teleportation.posInit();
		}
			for (int i = 0;i<nbMonstre;i++) {
				Monstre monstre = new Monstre(0,0,30,100,100);
				monstres.add(i,monstre);
				monstre.posInit();
		}
			for (int i = 0;i<nbFantome;i++) {
				Fantome fantome = new Fantome(0,0,30,100,100);
				fantomes.add(i,fantome);
				fantome.posInit();
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		labyrinthe = new Labyrinthe(1);
		fenetre = new Controle();
		while(jeuEnCours) {
			if (herosEstMort || victoire) {
				jeuEnCours = false;
			}
			fenetre.setVisible(false);
		}
	}

} 
