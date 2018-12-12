import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Controle extends JFrame implements KeyListener, ActionListener{
	
	static Affichage affichageLab = new Affichage();
	public JButton debutPartie = new JButton("Commencer la partie");
	public JLabel label;
	
	public Controle() throws IOException {
		this.setTitle("Labyrinthe");
		this.setSize(315, 425);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		addKeyListener(this);
		this.setJMenuBar(BarreMenu());
		this.setContentPane(affichageLab);
		debutPartie.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		debutPartie.setHorizontalAlignment(JButton.CENTER);
		debutPartie.addActionListener(this);
		
		this.add(debutPartie, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	/************************************** MENU **********************************/

	private JMenuBar BarreMenu() {

		JMenuBar BarreMenu = new JMenuBar();

		JMenu Jeu = new JMenu("Choix du niveau");	
		BarreMenu.add(Jeu);

		JMenuItem item = new JMenuItem("Niveau Facile");			
		Jeu.add(item);												
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					LabFacile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		item = new JMenuItem("Niveau Moyen");			
		Jeu.add(item);												
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					LabMoyen();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		item = new JMenuItem("Niveau Difficile");			
		Jeu.add(item);												
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					LabDifficile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		return BarreMenu;
	}
	
	/************************************** FONCTIONS **********************************/
	
		private void LabFacile() throws IOException {
			MoteurDeJeu.labyrinthe = new Labyrinthe(1);
			this.setContentPane(affichageLab);
			this.setSize(365, 465);
			this.setVisible(true);
			this.repaint();
	
		}
	
		private void LabMoyen() throws IOException {
			MoteurDeJeu.labyrinthe = new Labyrinthe(2);
			this.setContentPane(affichageLab);
			this.setSize(615, 575);
			this.setVisible(true);
			this.repaint();
	
		}
	
		private void LabDifficile() throws IOException {
			MoteurDeJeu.labyrinthe = new Labyrinthe(3);
			this.setSize(915, 575);
			this.setContentPane(affichageLab);
			this.setVisible(true);
			this.repaint();
	
		}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == debutPartie) {
			affichageLab = new Affichage();
			MoteurDeJeu.partieInit();
			String vieHero = Integer.toString(MoteurDeJeu.heros.vieActuelle);
			String PVMax = Integer.toString(MoteurDeJeu.heros.vieMax);
			label = new JLabel(vieHero+"/"+PVMax+"PV");
			addKeyListener(this);
			this.setContentPane(affichageLab);
			this.add(label);
			this.setVisible(true);
			MoteurDeJeu.jeuEnCours = true;
			this.repaint();
		}
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			MoteurDeJeu.heros.right=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			MoteurDeJeu.heros.left=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			MoteurDeJeu.heros.up=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			MoteurDeJeu.heros.down=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			MoteurDeJeu.heros.attack=true;
		}
		affichageLab.repaint();
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			MoteurDeJeu.heros.deplacement();
			Heros.verifCase();
			for(int i=0;i<MoteurDeJeu.nbMonstre;i++) {
				MoteurDeJeu.monstres.get(i).deplacement();
			}
			for(int i=0;i<MoteurDeJeu.nbFantome;i++) {
				MoteurDeJeu.fantomes.get(i).deplacement();
			}
			if(MoteurDeJeu.heros.estMort()) {
				MoteurDeJeu.herosEstMort = true;
			}
			MoteurDeJeu.heros.right=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			MoteurDeJeu.heros.deplacement();
			Heros.verifCase();
			for(int i=0;i<MoteurDeJeu.nbMonstre;i++) {
				MoteurDeJeu.monstres.get(i).deplacement();
			}
			for(int i=0;i<MoteurDeJeu.nbFantome;i++) {
				MoteurDeJeu.fantomes.get(i).deplacement();
			}
			if(MoteurDeJeu.heros.estMort()) {
				MoteurDeJeu.herosEstMort = true;
			}
			MoteurDeJeu.heros.left=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			MoteurDeJeu.heros.deplacement();
			Heros.verifCase();
			for(int i=0;i<MoteurDeJeu.nbMonstre;i++) {
				MoteurDeJeu.monstres.get(i).deplacement();
			}
			for(int i=0;i<MoteurDeJeu.nbFantome;i++) {
				MoteurDeJeu.fantomes.get(i).deplacement();
			}
			if(MoteurDeJeu.heros.estMort()) {
				MoteurDeJeu.herosEstMort = true;
			}
			MoteurDeJeu.heros.up=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			MoteurDeJeu.heros.deplacement();
			Heros.verifCase();
			for(int i=0;i<MoteurDeJeu.nbMonstre;i++) {
				MoteurDeJeu.monstres.get(i).deplacement();
			}
			for(int i=0;i<MoteurDeJeu.nbFantome;i++) {
				MoteurDeJeu.fantomes.get(i).deplacement();
			}
			if(MoteurDeJeu.heros.estMort()) {
				MoteurDeJeu.herosEstMort = true;
			}
			MoteurDeJeu.heros.down=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			MoteurDeJeu.heros.attackHero();
			if(MoteurDeJeu.heros.estMort()) {
				MoteurDeJeu.herosEstMort = true;
			}
			for(int i=0;i<MoteurDeJeu.nbMonstre;i++) {
				MoteurDeJeu.monstres.get(i).deplacement();
			}
			for(int i=0;i<MoteurDeJeu.nbFantome;i++) {
				MoteurDeJeu.fantomes.get(i).deplacement();
			}
			MoteurDeJeu.heros.attack=false;
		}
		affichageLab.repaint();
	}

	public void keyTyped(KeyEvent e) {
		//System.out.println("keyTyped");
	}
	
}




