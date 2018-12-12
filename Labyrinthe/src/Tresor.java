import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Tresor extends Case{

	public int idCase;
	public static int coordX;
	public static int coordY;

	public Tresor(int x,int y) {
		super(x, y);
		this.idCase = 3;
	}

	public static void posInit() {
		Random rand = new Random();
		boolean possible =false;
		while(!possible) {
			int randLigne = 1 + rand.nextInt(MoteurDeJeu.labyrinthe.grille.length - 1);
			int randColonne = 1 + rand.nextInt(MoteurDeJeu.labyrinthe.grille[0].length - 1);
			if (MoteurDeJeu.labyrinthe.grille[randLigne][randColonne]==0) {
				MoteurDeJeu.labyrinthe.grille[randLigne][randColonne]=3;	
				possible = true;
			}
		}
	}

	public static void activation(int posXHero,int posYHero) {
		if (posXHero == coordX && posYHero == coordY) {
			MoteurDeJeu.victoire=true;
		}
	}

}
