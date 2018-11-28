import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controle implements KeyListener{
	Heros heros=new Heros(5, 5);

	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			heros.right=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			heros.left=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			heros.up=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			heros.down=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			heros.attack=true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			heros.right=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			heros.left=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			heros.up=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			heros.down=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			heros.attack=false;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}




