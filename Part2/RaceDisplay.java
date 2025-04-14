package Part2;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

/**
 * This class defines the race display window of the program.
 * 
 * @author Humayra Chowdhury
 * @version Version 1.0
 */
public class RaceDisplay extends JFrame {

  public RaceDisplay () {
          // Creating main frame
          this.setTitle("Horse Racing Simulator"); 
          this.setVisible(true); 
          this.setSize(1000, 800);
          this.setResizable(false); // prevents resizing window
          this.getContentPane().setBackground(Color.white);
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          this.setLayout(new BorderLayout(5, 5));
  }
}
