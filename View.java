package mazesolver;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class View extends JFrame{
    /**
 *I will use 2 dimensional array to represent the maze (graph)
 * Other conventions:
 * 
 * maze[raw][col
 * 
 * Values: 1=not-visited node
 *         0=wall (blocked)
 *         9=target node
 
 */
private int [][] maze=
    { {0,0,0,0,0,0,0,0,0,0,0,0,0},
      {0,9,1,1,1,1,1,1,1,1,1,1,0},
      {0,1,1,1,1,1,1,1,1,1,1,1,0},
      {0,1,1,1,1,1,1,1,1,1,1,1,0},
      {0,1,1,1,1,1,1,1,1,1,1,1,0},
      {0,1,1,1,1,1,1,1,1,1,1,1,0},
      {0,1,1,1,1,1,1,1,1,1,1,1,0},
      {0,1,1,1,1,1,1,1,1,1,1,1,0},
      {0,1,1,1,1,1,1,1,1,1,1,1,0},
      {0,0,0,0,0,0,0,0,0,0,0,0,0}

    };

    
    

  public View () {
      setTitle("Super Maze");
      setSize(640,480);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
  }
  
      
@Override
     public void paint (Graphics g) {
        super.paint(g);
        
        g.translate(50, 50);
        
        for(int row=0; row<maze.length; row++)
            for(int col=0; col<maze[0].length; col++) {
                Color color;
                switch (maze[row][col]){
                    case 0:color=Color.GRAY;break;
                    case 9:color=Color.BLUE;break;
                    default:color=Color.WHITE; break;
                
                    
            }
                g.setColor(color);
                g.fillRect(30*col, 30*row, 30, 30);
                g.setColor(Color.WHITE);
                g.drawRect(30*col, 30*row, 30, 30);
                
    }
  
    
     }
     
  


	public static void main (String [] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run () {
				View view=new View();
				view.setVisible(true );
			}
		});
	}
	}