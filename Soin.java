
public class Soin extends Tresor{
	
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
}