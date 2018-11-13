import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.util.function.BooleanSupplier;


public class Monstres extends Entite{

    public Monstres(int posx, int posy, int nbDegats, int vieActuelle, int vieMax) {
        super(posx, posy, nbDegats, vieActuelle, vieMax);
        
    }
    public Monstres(int posx, int posy) {
    	super(posx, posy);
    }
    public void draw(Graphics2D g2d){
        g2d.drawImage(getMonstresImg(),posx, posy, null);
    }
    public Image getMonstresImg(){
        ImageIcon i=new ImageIcon("/ghost.png");
        return i.getImage();
    } 
    
    public void update(){
            posx+=Math.random();
            posy+=Math.random();    
    }
    
    int coordX2, coordY2;
	public boolean checkCollisions(int posxMonstre,int posyMonstre) {
		if ((posxMonstre == coordX2 && posyMonstre == coordY2)) {
			return true;
		}
		return false;
	}
    
    public BooleanSupplier augmentationVie(int i) {
    	// TODO Auto-generated method stub
    	return null;
    	}
}
