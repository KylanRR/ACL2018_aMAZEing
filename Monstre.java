import java.util.Random;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Monstre extends Entite{
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

    public Monstre(int posx, int posy, int nbDegats, int vieActuelle, int vieMax) {
        super(posx, posy, nbDegats, vieActuelle, vieMax);
        
    }
    public Monstre(int posx, int posy) {
    	super(posx, posy);
    	direction=randomGenerator.nextInt(4);
    }

    public Monstre(int posx, int posy, int vieActuelle) {
    	super(posx, posy);
    	this.vieActuelle=vieActuelle;
    }
    
    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }
    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }
    public int getNbDegats() {
        return nbDegats;
    }

    public void setNbDegats(int nbDegats) {
        this.nbDegats = nbDegats;
    }
    public int getVieActuelle() {
        return vieActuelle;
    }

    public void setVieActuelle(int vieActuelle) {
        this.vieActuelle = vieActuelle;
    }
    public int getVieMax() {
        return vieMax;
    }

    public void setVieMax(int vieMax) {
        this.vieMax = vieMax;
    }
    
    public Image getMonstreImg(){
    	ImageIcon i=new ImageIcon(new ImageIcon(getClass().getResource("/Monstre.png")).getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
        return i.getImage();
    }
	
    public void draw(Graphics2D g2d){
    	g2d.drawImage(getMonstreImg(),posx, posy, null);
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
   // public void update() {
	//	posy+=velY;
		//posx+=velX;
		
		//checkCollisions();
		
	//}      
      //  public boolean checkupdate(int posXMonstre,int posYMonstre) {
    	//	if (posXMonstre==posx && posYMonstre==posy) {
    		//	return true;
    		//}
    	//	return false;
    	//}
        
       // public boolean checkRandom(int posXMonstre,int posYMonstre) {
    	//	if (posXMonstre==velX && posYMonstre==velY) {
    		//	return true;
    		//}
    		//return false;
    	//}
    

