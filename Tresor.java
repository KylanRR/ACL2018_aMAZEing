
public class Tresor extends Case{

	public int idCase;
	public int coordX;
	public int coordY;
	
	public Tresor(int x,int y) {
		super(x, y);
		this.idCase = 3;
	}
	
	public boolean activation(int posXHero,int posYHero) {
		if (posXHero == coordX && posYHero == coordY) {
			return true;
		}
		return false;
	}
}
