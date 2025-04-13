package Part2;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * This class defines the launch window of the program
 * It currently acts as the main entry point.
 * 
 * @author Humayra Chowdhury
 * @version Version 1.0
 */
public class LaunchPage {
  
  public static void main(String[] args) {

    JFrame frame = new JFrame();

    frame.setTitle("Welcome to the Horse Racing Simulator!"); 
    frame.setVisible(true); 
    frame.setSize(420, 420);
    frame.setResizable(false); // prevents resizing window
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.getContentPane().setBackground(new Color(220, 10, 10));
  }

}

