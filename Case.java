import java.awt.Graphics2D;

public abstract class Case {
	
	protected int x,y;
	
	protected boolean traversable;
	
	public Case(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean isSolid() {
		return !traversable;
	}
}