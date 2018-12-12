import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Labyrinthe extends JPanel{

	/************************************** VARIABLES **************************************/

	public int[][] grille;
	public int niveau;
	int ligne;
	int colonne;
	
	/************************************** CONSTRUCTEUR **********************************/

	public Labyrinthe(int niveau) throws IOException{
		this. niveau = niveau;
		creerLab();
	}

	/************************************** FONCTIONS *************************************/

	public void creerLab() {
		if (niveau == 1) {
			ligne = 10;
			colonne = 10;
		}
		else if (niveau == 2) {
			ligne = 15;
			colonne = 20;
		}
		else {
			ligne = 15;
			colonne = 30;
		}
		grille = new int[ligne][colonne];
		for(int i = 0;i<ligne;i++) {
			grille[i][0]= 1;
			grille[i][colonne-1]= 1;
		}
		for(int j = 0;j<colonne;j++) {
			grille[0][j]= 1;
			grille[ligne-1][j]= 1;
		}
		MoteurDeJeu.nbMur = (ligne-2)*(colonne-2)*20/100;
		MoteurDeJeu.nbMonstre = colonne/ligne +1;
		MoteurDeJeu.nbFantome = (colonne+ligne)/10;
		MoteurDeJeu.nbPiege = (ligne-2)*(colonne-2)*5/100;
		MoteurDeJeu.nbSoin = (ligne-2)*(colonne-2)*3/100;
		MoteurDeJeu.nbTp = (ligne-2)*(colonne-2)*1/100;
		Random rand = new Random();
		int i=0;
		while (i<=MoteurDeJeu.nbMur){
			int randomLigne = 1 + rand.nextInt(grille.length - 1);
			int randomColonne = 1 + rand.nextInt(grille[0].length - 1);
			if(grille[randomLigne][randomColonne] != 1) {
				grille[randomLigne][randomColonne] = 1;
				i++;
			}
		}
		
	} //Fin creerLab()

	private static String generationNiveau(int niveau) {
		String fichier;
		if (niveau == 1) {
			fichier = "Labyrinthe_niveau_1.txt";
		}
		else if (niveau == 2) {
			fichier = "Labyrinthe_niveau_2.txt";
		}
		else {
			fichier = "Labyrinthe_niveau_3.txt";
		}
		return fichier;
	}
}