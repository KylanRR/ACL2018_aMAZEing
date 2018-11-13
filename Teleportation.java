
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

}
