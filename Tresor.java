import java.awt.Image;

import javax.swing.ImageIcon;

public class Tresor extends Case{

	public int idCase;
	public int coordX;
	public int coordY;
	
	public Tresor(int x,int y) {
		super(x, y);
		this.idCase = 3;
	}
	
	public Image getTresorImg(){
    	ImageIcon i=new ImageIcon(new ImageIcon(getClass().getResource("/Tresor.png")).getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
        return i.getImage();
 }
	
	public boolean activation(int posXHero,int posYHero) {
		if (posXHero == coordX && posYHero == coordY) {
			return true;
		}
		return false;
	}
}
