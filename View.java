/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazesolver;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/**
* @author User
 */
public class View extends JFrame{
    /**
 *I will use 2 dimensional array to represent the maze (graph)
 * Other conventions:
 * 
 * maze[raw][col
 * 
 * Values: 0=not-visited node
 *         1=wall (blocked)
 *         2=visited node
 *         9=target node
 
 */
private int [][] maze=
    { {1,1,1,1,1,1,1,1,1,1,1,1,1},
      {1,0,1,0,1,0,1,0,0,0,0,0,1},
      {1,0,1,0,0,0,1,0,1,1,1,0,1},
      {1,0,0,0,1,1,1,0,0,0,0,0,1},
      {1,0,1,0,0,0,0,0,1,1,1,0,1},
      {1,0,1,0,1,1,1,0,1,0,0,0,1},
      {1,0,1,0,1,0,0,0,1,1,1,0,1},
      {1,0,1,0,1,1,1,0,1,0,1,0,1},
      {1,0,0,0,0,0,0,0,0,0,1,9,1},
      {1,1,1,1,1,1,1,1,1,1,1,1,1}

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
                    case 1:color=Color.BLACK; break;
                    case 9:color=Color.RED; break;
                    default:color=Color.WHITE; break;
                
                    
            }
                g.setColor(color);
                g.fillRect(30*col, 30*row, 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(30*col, 30*row, 30, 30);
    }
  
    
     }

}