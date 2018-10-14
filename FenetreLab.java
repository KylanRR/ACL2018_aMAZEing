import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreLab extends JFrame implements ActionListener{
	
	/************************************** VARIABLES **************************************/
	
	private int size;
	private Labyrinthe labyrinthe;
	
	public FenetreLab(int niveau_Labyrinthe) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.size = niveau_Labyrinthe;
		
		labyrinthe = new Labyrinthe(size);
		
		this.add(labyrinthe, BorderLayout.CENTER);
		
		pack();
		
	}
	
	public static void main(String[] args) {
		
		FenetreLab fenetre = new FenetreLab(1);
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);
	} 
	
} 
