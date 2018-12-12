import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Teleportation extends Case{

	public int idCase;
	public static int coordX;
	public static int coordY;

	public Teleportation(int x, int y) {
		super(x, y);
		this.idCase = 5;
	}

	public static void posInit() {
		Random rand = new Random();
		boolean possible =false;
		while(!possible) {
			int randLigne = 1 + rand.nextInt(MoteurDeJeu.labyrinthe.grille.length - 1);
			int randColonne = 1 + rand.nextInt(MoteurDeJeu.labyrinthe.grille[0].length - 1);
			if (MoteurDeJeu.labyrinthe.grille[randLigne][randColonne]==0) {
				MoteurDeJeu.labyrinthe.grille[randLigne][randColonne]=5;	
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

	public static int[] teleporter() {
		Random rand = new Random();
		int ligne = MoteurDeJeu.labyrinthe.grille.length;
		int colonne = MoteurDeJeu.labyrinthe.grille[0].length;
		boolean possible = false;
		int[] pos_apres_tp = new int[] {MoteurDeJeu.heros.posx,MoteurDeJeu.heros.posy};
		while(!possible) {	
			pos_apres_tp[0] = 1 + rand.nextInt(ligne-1);
			pos_apres_tp[1] = 1 + rand.nextInt(colonne-1);
		}
		return pos_apres_tp;
	}

}
