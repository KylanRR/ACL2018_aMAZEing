
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;


public class Heros extends Entite {
	public boolean right, left, up, down, attack;
	int speed=5;

    public Heros(int posx, int posy, int nbDegats, int vieActuelle, int vieMax) {
        super(posx, posy, nbDegats, vieActuelle, vieMax);
    }

    public Heros(int posx, int posy) {
        super(posx, posy);
    }
	
    public Image getHerosImg() {
		ImageIcon ic=new ImageIcon(new ImageIcon(getClass().getResource("/Heros.png")).getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		return ic.getImage();
	}
    
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getHerosImg(), posx, posy, null);
		
	}
	
	public void tick() {
		if(right) {
			posx+=speed;
		}
		if(left) {
			posx-=speed;
		}
		if(up) {
			posy-=speed;
		}
		if(down) {
			posy+=speed;
		}
		if(attack) {
			MoteurDeJeu.monstre.nbDegats+=1;
			MoteurDeJeu.heros.nbDegats+=1;
			MoteurDeJeu.monstre.vieActuelle-=1;
			MoteurDeJeu.heros.vieActuelle-=1;
		}
		
	}
	      

		
}
	
    

