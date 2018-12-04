import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MoteurDeJeu extends JFrame implements ActionListener{

	/************************************** VARIABLES **************************************/

	private int size;
	private Labyrinthe labyrinthe;
	private Labyrinthe labyrintheFacile;
	private Labyrinthe labyrintheMoyen;
	private Labyrinthe labyrintheDur;
	public static Heros heros;
	public static Monstre monstre;
	public static Phantome phantome;
	public ArrayList<Monstre> monstres;
	public ArrayList<Phantome> phantomes;
	Random rand=new Random();
	private JLabel enTete;

	/************************************** CONSTRUCTEUR **************************************/

	public MoteurDeJeu(int niveau_Labyrinthe) throws IOException {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.size = niveau_Labyrinthe;

		labyrinthe = new Labyrinthe(size);
		heros=new Heros(100,100,0,5,5);
		monstres=new ArrayList<>();
		addKeyListener((KeyListener) this);

		enTete = new JLabel("Jeu du labyrinthe");
		enTete.setHorizontalAlignment(JLabel.CENTER);
		enTete.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		this.add(enTete, BorderLayout.NORTH);
		this.add(labyrinthe, BorderLayout.CENTER);

		pack();

	}

	/************************************** MENU **********************************/

	private JMenuBar BarreMenu() {

		JMenuBar BarreMenu = new JMenuBar();

		JMenu Jeu = new JMenu("Labyrinthe");	
		BarreMenu.add(Jeu);
		JMenuItem item = new JMenuItem("Niveau Facile");			
		Jeu.add(item);												
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LabFacile();

			}
		});

		item = new JMenuItem("Niveau Moyen");			
		Jeu.add(item);												
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LabMoyen();

			}
		});

		item = new JMenuItem("Niveau Difficile");			
		Jeu.add(item);												
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LabDifficile();

			}
		});

		return BarreMenu;
	}

	/************************************** FONCTIONS **********************************/

	public static int choixNiveau() {
		boolean b = false;
		Scanner sc = new Scanner(System.in);
		int choixniveau = sc.nextInt();
		while (b==false || !sc.hasNextInt()){
			try{
				System.out.println("Veuillez saisir le niveau du labyrinthe (1 a 3) :");
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
				System.out.println("Chiffre demande");
				sc = new Scanner(System.in);
				continue;				
			}
		}
		sc.close();
		return choixniveau;
	}
	
	private void LabFacile() {
		labyrintheFacile = new Labyrinthe(1);
		labyrintheFacile.setLocationRelativeTo(null);
		labyrintheFacile.setVisible(true);
		this.dispose();
		
	}
	
	private void LabMoyen() {
		labyrintheMoyen = new Labyrinthe(2);
		labyrintheMoyen.setLocationRelativeTo(null);
		labyrintheMoyen.setVisible(true);
		this.dispose();
		
	}
	
	private void LabDifficile() {
		labyrintheDur = new Labyrinthe(3);
		labyrintheDur.setLocationRelativeTo(null);
		labyrintheDur.setVisible(true);
		this.dispose();
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d=(Graphics2D) g;

		heros.draw(g2d);

		for(int i=0; i<monstres.size(); i++) {
			monstres.get(i).draw(g2d);	
		}
		for(int i=0; i<phantomes.size(); i++) {
			phantomes.get(i).draw(g2d);	
		}

	}

	public void tick() {
		heros.tick();
		for(int i=0; i<monstres.size(); i++) {
			monstres.get(i).tick();
		}
		for(int i=0; i<phantomes.size(); i++) {
			phantomes.get(i).tick();
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int choixniveau = choixNiveau();
		MoteurDeJeu fenetre = new MoteurDeJeu(choixniveau);
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);
	}

} 
