package game;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;
import java.awt.event.KeyEvent.*;

public class DeplacerHeros extends JFrame{
	JLabel heros;
	
	public void Move(){
		heros = new JLabel();
		heros.addKeyListener(new KeyAdapter(){
	
    	public void keyPressed (KeyEvent e) { 
    		int bouton = e.getKeyCode (); 

    		if (bouton == KeyEvent.VK_LEFT) { 
    			 heros.setLocation(heros.getX()-1,heros.getY());
                 repaint(); 
    		} 

    		if (bouton == KeyEvent.VK_RIGHT) { 
    			heros.setLocation(heros.getX()+1,heros.getY());
                repaint();
    		} 

    		if (bouton == KeyEvent.VK_UP) { 
    			heros.setLocation(heros.getX(),heros.getY()+1);
                repaint(); 
    		} 

    		if (bouton == KeyEvent.VK_DOWN) { 
    			heros.setLocation(heros.getX(),heros.getY()-1);
                repaint();
    		} 
    	}
	


	    public void keyReleased (KeyEvent e) { 
			int key = e.getKeyCode (); 
		
			if (key == KeyEvent.VK_LEFT) { 
				heros.setLocation(heros.getX(),heros.getY()); 
			} 
		
			if (key == KeyEvent.VK_RIGHT) { 
				heros.setLocation(heros.getX(),heros.getY());
			} 
		
			if (key == KeyEvent.VK_UP) { 
				heros.setLocation(heros.getX(),heros.getY()); 
			} 
		
			if (key == KeyEvent.VK_DOWN) { 
				heros.setLocation(heros.getX(),heros.getY());
			} 
	    }
    }
    
	}
	
}
	


