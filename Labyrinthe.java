import javax.swing.*;
import java.awt.*;

public class Labyrinthe extends JPanel{

	/************************************** VARIABLES **************************************/
	
	private int taille;
	private ImageIcon caseVide = new ImageIcon(new ImageIcon(getClass().getResource("/Grass.png")).getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
	private ImageIcon caseMur = new ImageIcon(new ImageIcon(getClass().getResource("/Mur.png")).getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
	private Dimension dim = new Dimension(caseVide.getIconWidth(), caseVide.getIconHeight());
	
	public int[][] grille;
	public JButton[][] button;
	public JPanel panel;
	
	/************************************** CONSTRUCTEUR **********************************/
	
	public Labyrinthe(int taille){
		this.taille = taille;
		creerLab();
	}
	
	/************************************** FONCTIONS *************************************/
	 
	public void creerLab() {
		
			if (taille == 1) {
				
				//Création du labyrinthe de taille 1, les "1" seront des murs et les "0" des espaces vides
				grille = new int[][]{
					{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
					{ 0, 0, 0, 0, 0, 1, 0, 0, 0, 1 },
					{ 1, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
					{ 1, 0, 0, 1, 0, 1, 1, 1, 0, 1 },
					{ 1, 0, 1, 1, 0, 0, 0, 0, 0, 1 },
					{ 1, 0, 1, 1, 0, 1, 1, 1, 0, 1 },
					{ 1, 0, 1, 1, 0, 1, 0, 0, 0, 1 },
					{ 1, 0, 0, 1, 0, 1, 1, 1, 1, 1 },
					{ 1, 0, 1, 1, 0, 0, 0, 0, 0, 1 },
					{ 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 }
				};
				
			}
			
			else if (taille == 2) {
				
				//Création du labyrinthe de taille 2, les "1" seront des murs et les "0" des espaces vides
				grille = new int[][]{
					    	{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1 },
					    	{ 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0 },
					    	{ 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0 },
					    	{ 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0 },
					    	{ 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0 },
					    	{ 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0 },
					    	{ 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0 },
					    	{ 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0 },
					    	{ 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1 },
					    	{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 }
				 };
				
			}
			
			else if (taille == 3) {
				
				//Création du labyrinthe de taille 3, les "1" seront des murs et les "0" des espaces vides
				grille = new int[][]{
					    	{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1 },
					    	{ 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
					    	{ 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1 },
					    	{ 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1 },
					    	{ 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1 },
					    	{ 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1 },
					    	{ 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
					    	{ 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1 },
					    	{ 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1 },
					    	{ 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0 },
					    	{ 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0 },
					    	{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0 }
				};
	
			}
			
			else {
				
				//Création du labyrinthe sans issue de taille autre, les "1" seront des murs et les "0" des espaces vides
				grille = new int[][]{
					    { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
					    { 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
					    { 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1 },
					    { 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1 },
					    { 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1 },
					    { 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1 },
					    { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
					    { 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1 },
					    { 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1 },
					    { 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1 },
					    { 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1 },
					    { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
				};
			}
			
			//Création d'une matrice de boutons
			button = new JButton[grille.length][grille[0].length];
			panel = new JPanel();
			panel.setLayout(new GridLayout(grille.length, grille[0].length));
			this.setBorder(BorderFactory.createEmptyBorder(13, 13, 13, 13));
		
			//Début de parcours de la matrice
			for (int i = 0; i < grille.length; ++i)
				for (int j = 0; j < grille[0].length; ++j) {
						
					if (grille[i][j] == 0)  
						//Image de fond blanc
						button[i][j] = new JButton(caseVide);
					
					else 
						//Image de fond noir
						button[i][j] = new JButton(caseMur);
				
					button[i][j].setPreferredSize(dim);
					button[i][j].setBorder(null);
					panel.add(button[i][j]);

				} //Fin de parcours de la matrice
		      
			this.add(panel);
			
		} //Fin creerLab()
		
	/************************************** ALGORITHME DE RESOLUTION *************************************/
	
		public boolean resolutionLab(int pos_x, int pos_y) {
			 
				boolean done = false;
			
				//Si la fonction estValide() renvoie true
				if (estValide(pos_x, pos_y)) {
					
					grille[pos_x][pos_y] = 3;
					
					//Si la case passée en paramètre est la dernière case du labyrinthe
					if (pos_x == grille.length-1 && pos_y == grille[0].length-1)
						return true;
					
					else {
						//Appels récursifs
						done = resolutionLab(pos_x + 1, pos_y);
						if (!done)
							done = resolutionLab(pos_x, pos_y + 1);
						if (!done)
							done = resolutionLab(pos_x - 1, pos_y);
						if (!done)
							done = resolutionLab(pos_x, pos_y - 1);
					}
					if (done) 
			            		grille[pos_x][pos_y] = 7;
			     
				}
				
			return done;

		} //Fin resolutionLab()
		
		private boolean estValide(int pos_x, int pos_y) {
			
			boolean result = false;
			 
		      //Si la case passée en paramètre est dans les dimensions du labyrinthe
		      if (pos_x >= 0 && pos_x < grille.length && pos_y >= 0 && pos_y < grille[0].length)
		    	 //Et si la case est un espace vide
		         if (grille[pos_x][pos_y] == 0)
		            result = true;

		      return result;

		} //Fin estValide()
	
} //Fin class



