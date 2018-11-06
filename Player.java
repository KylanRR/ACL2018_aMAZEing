package mazesolver;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;
public class Player extends Entite {
	int velX=0, velY=0;
	int speed=5;
	
	public Player(int posx, int posy) {
		super (posx, posy);
	}
	
	
	
	public void update() { 
		posy+=velY;
		posx+=velX;
		
		checkCollisions();
	}
	
	public void draw(Graphics2D g2d) {
		g2d.drawImage(getPlayerImg(), posx, posy, null);
		
	}
	
	public Image getPlayerImg() {
		ImageIcon ic=new ImageIcon("C:\\Users\\User\\eclipse-workspace\\mazesolver\\src\\mazesolver\\heros.png");
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
	
	public void checkCollisions() {
		 ArrayList<Monstre> monstres=GameFrame.getMonstreList();
		 
		 for(int i=0; i<monstres.size();i++) {
			 Monstre tempMonstre=monstres.get(i);
			 if(getBounds().intersects(monstres.get(i).getBounds())) {
				 GameFrame.removeMonstre(tempMonstre);
			 }
		 }
	}
	public Rectangle getBounds() {
		return new Rectangle(posx,posy,getPlayerImg().getWidth(null), getPlayerImg().getHeight(null));	
		}


public static void main(String[] args) {
}
}