import java.util.ArrayList;

public class  Entite {
	public int posx;
	public int posy;
	public int nbDegats;
	public int vieActuelle;
	public int vieMax;
	
public Entite(int posx, int posy, int nbDegats, int vieActuelle, int vieMax) {
	this.posx=posx;
	this.posy=posy;
	this.nbDegats=nbDegats;
	this.vieActuelle=vieActuelle;
	this.vieMax=vieMax;
}

public Entite(int posx2, int posy2) {
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
    

	
    public void checkCollisions() {
		 ArrayList<Monstre> monstres=GameFrame.getMonstreList();
		 
		 for(int i=0; i<monstres.size();i++) {
			 Monstre tempMonstre=monstres.get(i);
			 if(getBounds().intersects(monstres.get(i).getBounds())) {
				 GameFrame.removeMonstre(tempMonstre);
			 }
		 }
	}

}

