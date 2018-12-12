import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Affichage extends JPanel{
	
	/************************************** FONCTIONS **************************************/
	
	int tailleImage=30;
	
	/************************************** FONCTIONS **************************************/

	public void paintComponent(Graphics g) {
		try {
			Image caseVide = ImageIO.read(new File("Images/Grass.png"));
			Image caseMur = ImageIO.read(new File("Images/Mur.png"));
			Image caseHero = ImageIO.read(new File("Images/Hero.png"));
			Image caseTresor = ImageIO.read(new File("Images/Tresor.png"));
			Image casePiege = ImageIO.read(new File("Images/Piege.png"));
			Image caseTP = ImageIO.read(new File("Images/Portail.png"));
			Image caseHeal= ImageIO.read(new File("Images/Heal.png"));
			Image caseMonstre = ImageIO.read(new File("Images/Monstre.png"));
			Image caseGhost = ImageIO.read(new File("Images/Ghost.png"));
			Image victoire = ImageIO.read(new File("Images/Victoire.png"));
			Image perdu = ImageIO.read(new File("Images/Loss.png"));

			for (int i = 0; i < MoteurDeJeu.labyrinthe.grille.length; ++i)
				for (int j = 0; j < MoteurDeJeu.labyrinthe.grille[0].length; ++j) {			

					if (MoteurDeJeu.labyrinthe.grille[i][j] == 1)
						//Image de mur
						g.drawImage(caseMur, j*tailleImage, i*tailleImage+65,tailleImage,tailleImage, this);

					else if (MoteurDeJeu.labyrinthe.grille[i][j] == 2)
						//Image de heros
						g.drawImage(caseHero, j*tailleImage, i*tailleImage+65,tailleImage,tailleImage, this);

					else if (MoteurDeJeu.labyrinthe.grille[i][j] == 3)
						//Image de trésor
						g.drawImage(caseTresor, j*tailleImage, i*tailleImage+65,tailleImage,tailleImage, this);

					else if (MoteurDeJeu.labyrinthe.grille[i][j] == 4)
						//Image de piège
						g.drawImage(casePiege, j*tailleImage, i*tailleImage+65,tailleImage,tailleImage, this);

					else if (MoteurDeJeu.labyrinthe.grille[i][j] == 5)
						//Image de portail
						g.drawImage(caseTP, j*tailleImage, i*tailleImage+65,tailleImage,tailleImage, this);

					else if (MoteurDeJeu.labyrinthe.grille[i][j] == 6)
						//Image de soin
						g.drawImage(caseHeal, j*tailleImage, i*tailleImage+65,tailleImage,tailleImage, this);

					else if (MoteurDeJeu.labyrinthe.grille[i][j] == 7)
						//Image de monstre
						g.drawImage(caseMonstre, j*tailleImage, i*tailleImage+65,tailleImage,tailleImage, this);

					else if (MoteurDeJeu.labyrinthe.grille[i][j] == 8)
						//Image de fantome
						g.drawImage(caseGhost, j*tailleImage, i*tailleImage+65,tailleImage,tailleImage, this);

					else
						//Image d'herbe
						g.drawImage(caseVide, j*tailleImage, i*tailleImage+65,tailleImage,tailleImage, this);

				} 
			if (MoteurDeJeu.victoire)
			{
				g.drawImage(victoire,0,30,super.getWidth(),super.getHeight(), this);
			}
			if (MoteurDeJeu.herosEstMort)
			{
				g.drawImage(perdu,0,30,super.getWidth(),super.getHeight(), this);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}      


	} 
}
