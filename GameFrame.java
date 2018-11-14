package mazesolver;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

public class GameFrame extends JPanel implements ActionListener {
	Timer mainTimer;
	Heros heros; 
	
	int MonstreCount=5;
	
	static ArrayList<Monstre> monstres=new ArrayList<Monstre>();
	Random rand=new Random();
	
	public GameFrame() {  
		setFocusable(true);
		
		heros=new Heros(100,00);
		addKeyListener(new KeyAdapt(heros));
		
		mainTimer=new Timer(10, this);
		mainTimer.start();
		
		for(int i=0; i<MonstreCount; i++) {
			addMonstre(new Monstre(rand.nextInt(800), rand.nextInt(600)));
		}
		
		int i=5;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d=(Graphics2D) g;
		
		heros.draw(g2d);
		
		Monstre m=new Monstre(200,400);  
		m.draw(g2d);
		for(int i=0; i<monstres.size(); i++) {
			Monstre tempMonstre=monstres.get(i);
			tempMonstre.draw(g2d);
		}
	}
	
	public void deplacementheros(){
		heros.update();
		repaint();
	}
	
	public void addMonstre(Monstre m ) {
		monstres.add(m);
	}
	
	public static void removeMonstre(Monstre m) {
		monstres.remove(m);
	}
	
	public static ArrayList<Monstre> getMonstreList(){
		 return monstres;
	}
}
