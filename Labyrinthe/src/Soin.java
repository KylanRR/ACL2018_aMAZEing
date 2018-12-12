import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Soin extends Case{

	public int idCase;
	public static int coordX;
	public static int coordY;

	public Soin(int x, int y) {
		super(x, y);
		this.idCase = 6;
	}

	public static void posInit() {
		Random rand = new Random();
		boolean possible =false;
		while(!possible) {
			int randLigne = 1 + rand.nextInt(MoteurDeJeu.labyrinthe.grille.length - 1);
			int randColonne = 1 + rand.nextInt(MoteurDeJeu.labyrinthe.grille[0].length - 1);
			if (MoteurDeJeu.labyrinthe.grille[randLigne][randColonne]==0) {
				MoteurDeJeu.labyrinthe.grille[randLigne][randColonne]=6;	
				possible = true;
			}
		}
	}

	public static boolean activation(int posXHero,int posYHero) {
		if (posXHero == coordX && posYHero == coordY) {
			return true;
		}
		return false;
	}

	public static void gainVie() {
		MoteurDeJeu.heros.vieActuelle += 30; 
	}
	
}