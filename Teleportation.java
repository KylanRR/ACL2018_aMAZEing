import java.util.Random;

public class Teleportation extends Case{
	
	public int idCase;
	public int coordX;
	public int coordY;
	
	public Teleportation(int x, int y) {
		super(x, y);
		this.idCase = 5;
	}
	
	public boolean activation(int posXHero,int posYHero) {
		if (posXHero == coordX && posYHero == coordY) {
			return true;
		}
		return false;
	}

	public int[] teleporter(int posXHero,int posYHero) {
		Random rand = new Random();
		int[] pos_apres_tp = new int[] {posXHero,posYHero};
		if (activation(posXHero,posYHero)) {
			pos_apres_tp[0] = rand.nextInt(10);
			pos_apres_tp[1] = rand.nextInt(10);
		}
		return pos_apres_tp;
	}
}
