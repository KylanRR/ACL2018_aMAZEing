import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Phantome extends Monstre{
	private int random=0;
	private int intelligent=1;
	private int etat=random;
	private int right=0;
	private int left=1;
	private int up=2;
	private int down=3;
	private int direction=-1;
	private int derniereDirection=-1;
	int speed=5;
	public Random randomGenerator;

	public Phantome(int posx, int posy) {
		super(posx, posy);
	}
	
	 public Image getPhantomeImg(){
	    	ImageIcon i=new ImageIcon(new ImageIcon(getClass().getResource("/Ghost.png")).getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
	        return i.getImage();
	 }
	 
	 public void draw(Graphics2D g2d){
	    	g2d.drawImage(getPhantomeImg(),posx, posy, null);
		}
	    
	    public void tick() {
			if(etat==random) {
				direction=randomGenerator.nextInt(4);
			}else if(etat==intelligent) {
				boolean move=false;
				if(posx<MoteurDeJeu.heros.posx) {
					if(randomGenerator.nextInt(100)<50) {
						posx+=speed;
						move=true;
						derniereDirection=right;
					}
				}
				if(posx>MoteurDeJeu.heros.posx) {
					if(randomGenerator.nextInt(100)<50) {
						posx-=speed;
						move=true;
						derniereDirection=left;
					}
				}
				if(posy>MoteurDeJeu.heros.posy) {
					if(randomGenerator.nextInt(100)<50) {
						posy-=speed;
						move=true;
						derniereDirection=up;
					}
				}
				if(posy<MoteurDeJeu.heros.posy) {
					if(randomGenerator.nextInt(100)<50) {
						posy+=speed;
						move=true;
						derniereDirection=down;
					}
				}
				
			}
	    }

}
