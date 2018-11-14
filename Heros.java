import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.util.function.BooleanSupplier;


public class Heros extends Entite {
	int velX=0, velY=0;
	int speed=5;

    public Heros(int posx, int posy, int nbDegats, int vieActuelle, int vieMax) {
        super(posx, posy, nbDegats, vieActuelle, vieMax);
    }
    public Heros(int posx, int posy) {
    	super(posx, posy);
    }
    
    int coordX1, coordY1;
	public boolean checkCollisions(int posxHero, int posyHero) {
		if (posxHero == coordX1 && posyHero == coordY1) {
			return true;
		}
		return false;
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getHerosImg(), posx, posy, null);	
	}
	
	public Image getHerosImg() {
		ImageIcon ic=new ImageIcon("heros.png");
		return ic.getImage();
	}
        
        public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();
		
		if(key==KeyEvent.VK_W) {
			velY=-speed;
		} else if (key==KeyEvent.VK_S) {
			velY=speed;
		}else if (key==KeyEvent.VK_A) {
			velX=-speed;
		} else if (key==KeyEvent.VK_D) {
			velX=speed;
		}
        }
        
        public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		
		if(key==KeyEvent.VK_W) {
			velY=0;
		} else if (key==KeyEvent.VK_S) {
			velY=0;
		}else if (key==KeyEvent.VK_A) {
			velX=0;
		} else if (key==KeyEvent.VK_D) {
			velX=0;
		}
		
	}
	
	public void update() { 
		posy+=velY;
		posx+=velX;
		
		checkCollisions();
	}
	
	public boolean checkupdate(int posXHero,int posYHero) {
    		if (posXHero==posx && posYHero==posy) {
    			return true;
    		}
    		return false;
    	}
	
        public Rectangle getBounds() {
            return new Rectangle(posx,posy,getHerosImg().getWidth(null), getHerosImg().getHeight(null));	
	}
	
        public boolean statusVie(int coordX1, int coordY1) {
        	// TODO Auto-generated method stub
      
        	if((coordX1 != monstre.getPositionX())&& (coordY1 != monstre.getPositionY())) {
        		return true ;
        	}
        	else {
        		return false;
        	}
        	}
        
        public void diminutionVie(int coordX1, int coordY1) {
        	// TODO Auto-generated method stub
        	
        	if((coordX1 == monstre.getPositionX())&& (coordY1 == monstre.getPositionY())) {
        		return vieActuelle-- ;
        	}
        	
        	}
    
}