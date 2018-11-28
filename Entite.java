import java.awt.Rectangle;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.Timer;
import java.awt.event.ActionEvent;
public class  Entite {
	public int posx;
	public int posy;
	public int nbDegats;
	public int vieActuelle;
	public int vieMax;
	
	
	Monstres monstre=new Monstres(posx, posy);
	Heros hero=new Heros(posx, posy); 
	Timer time;
	boolean collisions=false;
	
	public Entite() {
		monstre=new Monstres(5,10);
		hero=new Heros(4,9);
		time=new Timer();
		time.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		monstre.move();
		hero.move();
		checkCollisions();
		repaint();
	}
	
public Entite(int posx, int posy, int nbDegats, int vieActuelle, int vieMax) {
	this.posx=posx;
	this.posy=posy;
	this.nbDegats=nbDegats;
	this.vieActuelle=vieActuelle;
	this.vieMax=vieMax;
}

    public Entite(int posx, int posy) {
    	this.posx=posx;
    	this.posy=posy;
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
    
    public Rectangle getBounds() {
        return new Rectangle(posx, posy, 200, 400);
    }
	
	public void collisions() {
		 ArrayList<Monstres> monstres=GameFrame.getMonstreList();
		 
		 for(int i=0; i<monstres.size();i++) {
			 Monstres tempMonstre=monstres.get(i);
			 if(getBounds().intersects(monstres.get(i).getBounds())) {
				 GameFrame.removeMonstre(tempMonstre);
			 }
		 }
	}

	
	public boolean checkCollisions() {
		Rectangle monstre=Monstres.getBounds();
		Rectangle hero=Heros.getBounds();
		if(hero.intersects(monstre)) {
			collisions=true;
		else 
			collisions=false;
			
		}
	}
	private void repaint() {
		// TODO Auto-generated method stub

		}
	public static void main(String[] args) {
		JFrame frame = new JFrame("Collision Detection");
		frame.setVisible(true);
		frame.setSize(800, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}

