
public class Tresor {

	public int idCase;
	public int coordX;
	public int coordY;
	
	public Tresor(int x,int y) {
		this.idCase = 3;
		this.coordX = x;
		this.coordY = y;
	}
	
	public boolean activation(int posXHero,int posYHero) {
		if (posXHero == coordX && posYHero == coordY) {
			return true;
		}
		return false;
	}
}
