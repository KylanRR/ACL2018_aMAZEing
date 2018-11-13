

import java.awt.Color;
import java.awt.Graphics2D;

public class Mur extends Case {

	public Mur(int x, int y) {
		super(x, y);
		this.traversable = false;
	}

// remplacer dans fillrect par le nom de l'afficheur
	@Override
	public void dessiner(Graphics2D g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x*maze.WIDTH, y*maze.HEIGHT, maze.WIDTH, maze.HEIGHT);
	}

}