import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.util.function.BooleanSupplier;
import java.util.Random;


public class Monstres extends Entite{
	int velX=0, velY=0;
	int speed=5;
	Random rand = new Random(); 
	int position = rand.nextInt(4);

    public Monstres(int posx, int posy, int nbDegats, int vieActuelle, int vieMax) {
        super(posx, posy, nbDegats, vieActuelle, vieMax);
        
    }
    public Monstres(int posx, int posy) {
    	super(posx, posy);
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
    public void draw(Graphics2D g2d){
        g2d.drawImage(getMonstresImg(),posx, posy, null);
    }
    public Image getMonstresImg(){
        ImageIcon i=new ImageIcon("/ghost.png");
        return i.getImage();
    } 
    
    public static int getRandom(int[] array) {
	    int rnd = new Random().nextInt(array.length);
	    return array[rnd];
	}
    
    public void randommovement(){
    	int[] randomArr= {-1,1}; 

           velX+= speed*getRandom(randomArr); 
           velY+= speed*getRandom(randomArr); 
    }
    
    public boolean checkrandom(int posXMonstre,int posYMonstre) {
		if (posXMonstre==velX && posYMonstre==velY) {
			return true;
		}
		return false;
	}
    
    public void update() { 
		posy+=velY;
		posx+=velX;
		
		checkCollisions();
	}
    
    
    public boolean checkupdate(int posXMonstre,int posYMonstre) {
		if (posXMonstre==posx && posYMonstre==posy) {
			return true;
		}
		return false;
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
