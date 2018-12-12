import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

public class Fantome extends Monstre{
	private int random=0;
	private int intelligent=1;
	private int etat=random;
	private int right=0;
	private int left=1;
	private int up=2;
	private int down=3;
	private int derniereDirection=-1;
	int speed=5;
	public Random randomGenerator;

	public Fantome(int posx, int posy, int nbDegats, int vieActuelle, int vieMax) {
		super(posx, posy, nbDegats, vieActuelle, vieMax);   
		this.idCase = 8;
	}

	public void posInit() {
		Random rand = new Random();
		boolean possible =false;
		while(!possible) {
			int randLigne = 1 + rand.nextInt(MoteurDeJeu.labyrinthe.grille.length - 1);
			int randColonne = 1 + rand.nextInt(MoteurDeJeu.labyrinthe.grille[0].length - 1);
			if (MoteurDeJeu.labyrinthe.grille[randLigne][randColonne]==0) {
				MoteurDeJeu.labyrinthe.grille[randLigne][randColonne]=8;
				this.posx = randLigne;
				this.posy = randColonne;	
				possible = true;
			}
		}
	}

	public void deplacement() {
		if(etat==random) {
			int directionRand = randomGenerator.nextInt(4);
			if(directionRand == 1) {
				MoteurDeJeu.labyrinthe.grille[this.posx][this.posy]=idCasePrecedent;
				this.posx-=1;
				idCasePrecedent = MoteurDeJeu.labyrinthe.grille[this.posx][this.posy];
				MoteurDeJeu.labyrinthe.grille[this.posx][this.posy]=this.idCase;
			}
			if(directionRand == 2) {
				MoteurDeJeu.labyrinthe.grille[this.posx][this.posy]=idCasePrecedent;
				this.posy-=1;
				idCasePrecedent = MoteurDeJeu.labyrinthe.grille[this.posx][this.posy];
				MoteurDeJeu.labyrinthe.grille[this.posx][this.posy]=this.idCase;
			}
			if(directionRand == 3) {
				MoteurDeJeu.labyrinthe.grille[this.posx][this.posy]=idCasePrecedent;
				this.posy+=1;
				idCasePrecedent = MoteurDeJeu.labyrinthe.grille[this.posx][this.posy];
				MoteurDeJeu.labyrinthe.grille[this.posx][this.posy]=this.idCase;
			}
			else {
				MoteurDeJeu.labyrinthe.grille[this.posx][this.posy]=idCasePrecedent;
				this.posx+=1;
				idCasePrecedent = MoteurDeJeu.labyrinthe.grille[this.posx][this.posy];
				MoteurDeJeu.labyrinthe.grille[this.posx][this.posy]=this.idCase;
			}
		}else if(etat==intelligent) {
			boolean move=false;
			if(posx<MoteurDeJeu.heros.posx) {
				if(randomGenerator.nextInt(100)<50) {
					posx+=speed;
					move=true;
					derniereDirection=right;
				}
			}
			if(posx>MoteurDeJeu.heros.posx) {
				if(randomGenerator.nextInt(100)<50) {
					posx-=speed;
					move=true;
					derniereDirection=left;
				}
			}
			if(posy>MoteurDeJeu.heros.posy) {
				if(randomGenerator.nextInt(100)<50) {
					posy-=speed;
					move=true;
					derniereDirection=up;
				}
			}
			if(posy<MoteurDeJeu.heros.posy) {
				if(randomGenerator.nextInt(100)<50) {
					posy+=speed;
					move=true;
					derniereDirection=down;
				}
			}

		}
	}

}