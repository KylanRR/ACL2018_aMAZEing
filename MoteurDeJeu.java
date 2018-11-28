import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;

import utilensemjava.Lecture;

public class MoteurDeJeu extends JFrame {
	
	/************************************** VARIABLES **************************************/
	
	private int size;
	private Labyrinthe labyrinthe;
	public static Heros heros;
	public static Monstre monstre;
	public ArrayList<Monstre> monstres;
	Random rand=new Random();
	
	public MoteurDeJeu(int niveau_Labyrinthe) throws IOException {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.size = niveau_Labyrinthe;
	
		
		labyrinthe = new Labyrinthe(size);
		heros=new Heros(100,100,0,5,5);
		monstres=new ArrayList<>();
		addKeyListener((KeyListener) this);
		
		this.add(labyrinthe, BorderLayout.CENTER);
	
		pack();
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d=(Graphics2D) g;
		
		heros.draw(g2d);
	
		for(int i=0; i<monstres.size(); i++) {
			monstres.get(i).paint(g);
			
		}
	}
	
	public void tick() {
		heros.tick();
		monstres.get(i).tick();
	}
	
	
	
	public static void main(String[] args) throws IOException {
		
		boolean b = false;
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (b==false || !sc.hasNextInt()){
			try{
				System.out.println("Veuillez saisir le niveau du labyrinthe (1 à 3) :");
				int choixniveau = sc.nextInt();
				if (choixniveau == 1 || choixniveau == 2 || choixniveau == 3 ) {
					System.out.println("Vous avez saisi le niveau : " + choixniveau);
					b=true; 
				}
				else {					
					System.out.println("Choix Impossible.");
					sc = new Scanner(System.in);
				}
			}
			catch(java.util.InputMismatchException e){
				System.out.println("Chiffre demandé");
				sc = new Scanner(System.in);
				continue;				
			}
		}
	
		MoteurDeJeu fenetre = new MoteurDeJeu(niveau);
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);
	}

	
	
} 

