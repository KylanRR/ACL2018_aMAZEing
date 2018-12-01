import javax.swing.*;
import utilensemjava.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Labyrinthe extends JPanel{

	/************************************** VARIABLES **************************************/

	private int niveau;
	private ImageIcon caseVide = new ImageIcon(new ImageIcon(getClass().getResource("/Grass.png")).getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
	private ImageIcon caseMur = new ImageIcon(new ImageIcon(getClass().getResource("/Mur.png")).getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
	private Dimension dim = new Dimension(caseVide.getIconWidth(), caseVide.getIconHeight());
	private String nomFichier;

	public int[][] grille;
	public JButton[][] button;
	public JPanel panel;

	public Labyrinthe(int niveau) throws IOException{
		this.niveau = niveau;
		creerLab(niveau);
	}

	public void creerLab(int niveau) throws IOException {
		//Creation du labyrinthe a partir d'un fichier
		String fichier = choixNiveau(niveau);
		String[] labyrinthe = lectureFichier(fichier).split("\n");
		char[][] grille = new char[labyrinthe.length][labyrinthe[0].split("").length];
		for (int i = 0; i < labyrinthe.length; i++){
			String[] ligne = labyrinthe[i].split("");
			for (int j = 0; j < ligne.length; j++){
				if ( ligne[j] == "1") {
					grille[i][j] = 1;
				}
				else {
					grille[i][j] = 0;
				}
			}

			//Creation d'une matrice de boutons
			button = new JButton[grille.length][grille[0].length];
			panel = new JPanel();
			panel.setLayout(new GridLayout(grille.length, grille[0].length));
			this.setBorder(BorderFactory.createEmptyBorder(13, 13, 13, 13));

			//Debut de parcours de la matrice
			for (int k = 0; k < grille.length; ++k) {
				for (int j = 0; j < grille[0].length; ++j) {

					if (grille[k][j] == 0) {
						//Image de fond herbe
						button[k][j] = new JButton(caseVide);
					}
					else {
						//Image de fond mur
						button[k][j] = new JButton(caseMur);

						button[k][j].setPreferredSize(dim);
						button[k][j].setBorder(null);
						panel.add(button[k][j]);
					}
				}
			} //Fin de parcours de la matrice

			this.add(panel);
		}
	} 

	private static String choixNiveau(int niveau) {
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

	private static String lectureFichier(String nomFichier) throws IOException{
		File f = new File(nomFichier);
		BufferedReader fR = new BufferedReader(new FileReader(f));
		String chaine = "";
		while (chaine != null){
			chaine = fR.readLine();
		}
		fR.close();
		return (chaine);
	}

}







//package mazesolver;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.Random;
//import javax.swing.JPanel;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;

//import javax.swing.Timer;

//public class GameFrame extends JPanel implements ActionListener {
//	Timer mainTimer;
//	Heros heros; 
	
//	int MonstreCount=5;
	
//	static ArrayList<Monstre> monstres=new ArrayList<Monstre>();
//	Random rand=new Random();
	
//	public GameFrame() {  
//		setFocusable(true);
		
//		heros=new Heros(100,00);
//		addKeyListener(new KeyAdapt(heros));
		
//		mainTimer=new Timer(10, this);
//		mainTimer.start();
		
//		for(int i=0; i<MonstreCount; i++) {
//			addMonstre(new Monstre(rand.nextInt(800), rand.nextInt(600)));
//		}
		
//		int i=5;
//	}
	
//	public void paint(Graphics g) {
//		super.paint(g);
//		Graphics2D g2d=(Graphics2D) g;
		
//		heros.draw(g2d);
		
//		Monstre m=new Monstre(200,400);  
//		m.draw(g2d);
//		for(int i=0; i<monstres.size(); i++) {
//			Monstre tempMonstre=monstres.get(i);
//			tempMonstre.draw(g2d);
//		}
//	}
	
//	public void deplacementheros(){
//		heros.update();
//		repaint();
//	}
	
//	public void addMonstre(Monstre m ) {
//		monstres.add(m);
//	}
	
//	public static void removeMonstre(Monstre m) {
//		monstres.remove(m);
//	}
	
//	public static ArrayList<Monstre> getMonstreList(){
//		 return monstres;
//	}
//}
