import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Heros extends Entite {
	public boolean right, left, up, down, attack;
	int speed=5;

	public Heros(int posx, int posy, int nbDegats, int vieActuelle, int vieMax) {
		super(posx, posy, nbDegats, vieActuelle, vieMax);
		this.idCase = 2;
	}

	public void posInit() {
		Random rand = new Random();
		boolean possible =false;
		while(!possible) {
			int randLigne = 1 + rand.nextInt(MoteurDeJeu.labyrinthe.grille.length - 1);
			int randColonne = 1 + rand.nextInt(MoteurDeJeu.labyrinthe.grille[0].length - 1);
			if (MoteurDeJeu.labyrinthe.grille[randLigne][randColonne]==0) {
				MoteurDeJeu.labyrinthe.grille[randLigne][randColonne]=2;
				this.posx = randLigne;
				this.posy = randColonne;
				possible = true;
			}
		}
	}

	public void subirDegat(int nbDegats) {
		this.vieActuelle -= nbDegats;
	}

	public void attackHero() {
		for(int i=0;i<MoteurDeJeu.monstres.size();i++) {
			Monstre monstre = MoteurDeJeu.monstres.get(i);
			if (MoteurDeJeu.heros.posx-1 == monstre.posx || MoteurDeJeu.heros.posx+1 == monstre.posx || MoteurDeJeu.heros.posy-1 == monstre.posy || MoteurDeJeu.heros.posy+1 == monstre.posy) {
				monstre.vieActuelle-=MoteurDeJeu.heros.nbDegats;
				MoteurDeJeu.heros.vieActuelle-=monstre.nbDegats;
				if (monstre.estMort()) {
					MoteurDeJeu.nbMonstre--;
					MoteurDeJeu.monstres.remove(i);
					MoteurDeJeu.labyrinthe.grille[monstre.posx][monstre.posy] = 0;
				}
			}
		}
		for(int i=0;i<MoteurDeJeu.fantomes.size();i++) {
			Monstre fantome = MoteurDeJeu.fantomes.get(i);
			if (MoteurDeJeu.heros.posx-1 == fantome.posx || MoteurDeJeu.heros.posx+1 == fantome.posx || MoteurDeJeu.heros.posy-1 == fantome.posy || MoteurDeJeu.heros.posy+1 == fantome.posy) {
				fantome.vieActuelle-=MoteurDeJeu.heros.nbDegats;
				MoteurDeJeu.heros.vieActuelle-=fantome.nbDegats;
				if (fantome.estMort()) {
					MoteurDeJeu.nbFantome--;
					MoteurDeJeu.fantomes.remove(i);
					MoteurDeJeu.labyrinthe.grille[fantome.posx][fantome.posy] = 0;
				}
			}
		}
	}

	public static void verifCase() {
		if (Piege.activation(MoteurDeJeu.heros.posx,MoteurDeJeu.heros.posx)) {
			Piege.degatsPiege();
		}
		else if (Soin.activation(MoteurDeJeu.heros.posx,MoteurDeJeu.heros.posx)) {
			Soin.gainVie();
		}
		else if (Teleportation.activation(MoteurDeJeu.heros.posx,MoteurDeJeu.heros.posx)) {
			int[] caseTP = Teleportation.teleporter();
			MoteurDeJeu.labyrinthe.grille[MoteurDeJeu.heros.posx][MoteurDeJeu.heros.posy]=idCasePrecedent;
			MoteurDeJeu.heros.posx = caseTP[0];
			MoteurDeJeu.heros.posy = caseTP[1];
			idCasePrecedent = MoteurDeJeu.labyrinthe.grille[MoteurDeJeu.heros.posx][MoteurDeJeu.heros.posy];
			MoteurDeJeu.labyrinthe.grille[MoteurDeJeu.heros.posx][MoteurDeJeu.heros.posy]=2;
		}
		else {
			Tresor.activation(MoteurDeJeu.heros.posx,MoteurDeJeu.heros.posx);
		}

	}

	public void deplacement() {
		if(right) {
			if(checkCollisions(MoteurDeJeu.heros.posx+1,MoteurDeJeu.heros.posy)) {
				MoteurDeJeu.labyrinthe.grille[MoteurDeJeu.heros.posx][MoteurDeJeu.heros.posy]=idCasePrecedent;
				idCasePrecedent = MoteurDeJeu.labyrinthe.grille[MoteurDeJeu.heros.posx+1][MoteurDeJeu.heros.posy];
				MoteurDeJeu.labyrinthe.grille[MoteurDeJeu.heros.posx+1][MoteurDeJeu.heros.posy]=2;
			}
		}
		if(left) {
			if(checkCollisions(MoteurDeJeu.heros.posx-1,MoteurDeJeu.heros.posy)) {
				MoteurDeJeu.labyrinthe.grille[MoteurDeJeu.heros.posx][MoteurDeJeu.heros.posy]=idCasePrecedent;
				idCasePrecedent = MoteurDeJeu.labyrinthe.grille[MoteurDeJeu.heros.posx+1][MoteurDeJeu.heros.posy];
				MoteurDeJeu.labyrinthe.grille[MoteurDeJeu.heros.posx-1][MoteurDeJeu.heros.posy]=2;
			}
		}
		if(up) {
			if(checkCollisions(MoteurDeJeu.heros.posx,MoteurDeJeu.heros.posy-1)) {
				MoteurDeJeu.labyrinthe.grille[MoteurDeJeu.heros.posx][MoteurDeJeu.heros.posy]=idCasePrecedent;
				idCasePrecedent = MoteurDeJeu.labyrinthe.grille[MoteurDeJeu.heros.posx+1][MoteurDeJeu.heros.posy];
				MoteurDeJeu.labyrinthe.grille[MoteurDeJeu.heros.posx][MoteurDeJeu.heros.posy-1]=2;
			}
		}
		if(down) {
			if(checkCollisions(MoteurDeJeu.heros.posx,MoteurDeJeu.heros.posy+1)) {
				MoteurDeJeu.labyrinthe.grille[MoteurDeJeu.heros.posx][MoteurDeJeu.heros.posy]=idCasePrecedent;
				idCasePrecedent = MoteurDeJeu.labyrinthe.grille[MoteurDeJeu.heros.posx+1][MoteurDeJeu.heros.posy];
				MoteurDeJeu.labyrinthe.grille[MoteurDeJeu.heros.posx][MoteurDeJeu.heros.posy+1]=2;
			}
		}
	}

}