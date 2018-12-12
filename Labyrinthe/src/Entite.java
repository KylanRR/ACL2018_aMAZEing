import java.util.Random;

public class  Entite {
	public int posx;
	public int posy;
	public int nbDegats;
	public int vieActuelle;
	public int vieMax;
	public int idCase;
	public static int idCasePrecedent;

	public Entite(int posx, int posy, int nbDegats, int vieActuelle, int vieMax) {
		this.posx=posx;
		this.posy=posy;
		this.nbDegats=nbDegats;
		this.vieActuelle=vieActuelle;
		this.vieMax=vieMax;
	}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx, Labyrinthe lab) {
		boolean collision = checkCollisions(posx, this.posy);
		if (collision==false) this.posx = posx;
	}

	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy, Labyrinthe lab) {
		boolean collision = checkCollisions(this.posx, posy);
		if (collision==false) this.posy = posy;
	}

	public int getNbDegats() {
		return nbDegats;
	}

	public void setNbDegats(int nbDegats) {
		this.nbDegats = nbDegats;
	}

	public int getVieActuelle() {
		return vieActuelle;
	}

	public void setVieActuelle(int vieActuelle) {
		this.vieActuelle = vieActuelle;
	}

	public int getVieMax() {
		return vieMax;
	}

	public void setVieMax(int vieMax) {
		this.vieMax = vieMax;
	}

	public boolean checkCollisions(int x, int y) {
		if(MoteurDeJeu.labyrinthe.grille[x][y] == 1 || MoteurDeJeu.labyrinthe.grille[x][y] == 2 || MoteurDeJeu.labyrinthe.grille[x][y] == 7 ||MoteurDeJeu.labyrinthe.grille[x][y] == 8) {
			return true;
		}
		return false;
	}

	public boolean estMort() {
		if(this.vieActuelle<=0) {
			return true;
		}
		return false;
	}
	
}

