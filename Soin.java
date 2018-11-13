
public class Soin extends Case{

	public int idCase;
	public int coordX;
	public int coordY;

	public Soin(int x, int y) {
		super(x, y);
		this.idCase = 6;
	}

	public boolean activation(int posXHero,int posYHero) {
		if (posXHero == coordX && posYHero == coordY) {
			return true;
		}
		return false;
	}

	public int gainVie(int pvHero,int posXHero,int posYHero) {
		if (activation(posXHero, posYHero)) {
			pvHero += 30; 
		}
		return 	pvHero;
	}

}