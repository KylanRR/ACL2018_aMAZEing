public abstract class Case {
	
	protected int idCase;
	protected int coordX;
	protected int coordY;
	
	protected boolean traversable;
	
	public Case(int x, int y) {
		this.coordX = x;
		this.coordY = y;
	}
	
	public boolean isSolid() {
		return !traversable;
	}
}