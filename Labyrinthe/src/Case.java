import java.util.Random;

public abstract class Case {
	
	protected int idCase;
	protected static int coordX;
	protected static int coordY;
	
	protected boolean traversable;
	
	public Case(int x, int y) {
		this.coordX = x;
		this.coordY = y;
	}
	
	public void posInit(Labyrinthe lab) {
		Random rand = new Random();
		int randLigne = 1 + rand.nextInt(lab.grille.length - 1);
		int randColonne = 1 + rand.nextInt(lab.grille[0].length - 1);
		if (lab.grille[randLigne][randColonne]==0) {
			lab.grille[randLigne][randColonne]=this.idCase;
			this.coordX = randLigne;
			this.coordY = randColonne;
		}
	}
	
}