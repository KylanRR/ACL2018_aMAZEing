import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

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
		
		int niveau = Lecture.lireEntier("Quel niveau ? : ");
		MoteurDeJeu fenetre = new MoteurDeJeu(niveau);
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);
	}

	
	
} 

