



import java.awt.*;

public class PersonnageVie extends Entite {
// author : Gregoire Clouvel
    /**
     *On va gérer la vie du Héros dans cette classe
     * On prend en paramètre les coordonnées du héros et le plateau de jeu
     */
    public Hero(Point coord, Plateau plateau) {
        super(coord, maze);
        coord = new Point(1,1);
        int  vie = 4;
        maze = new maze;
    }

   

    /**
     * Calcule les dégats recu et recalcule la vie du héros
     * prend en paramètre nbdegats.
     */
    public void subirDegat(int nbDegats) {
        this.vie = vie - nbDegats;
        System.out.println("PAF");
        if (vie <= 0 ){
            Jeu.getInstance().estMort();
            System.out.println("GAME OVER");
        }
    }

    /**
     * Verifie que le héro est encore vivant
     *return true si le héros est en vie.
     */
    public boolean estVivant() {
        return this.vie <= 0;
    }

}

