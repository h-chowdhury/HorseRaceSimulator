package Part2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class defines the launch window of the program
 * It currently acts as the main entry point.
 * 
 * @author Humayra Chowdhury
 * @version Version 1.1
 */
public class LaunchPage {
  
  public static void main(String[] args) {



    JFrame frame = new JFrame();
    frame.setTitle("Horse Racing Simulator"); 
    frame.setVisible(true); 
    frame.setSize(1000, 800);
    frame.setResizable(false); // prevents resizing window
    frame.setLayout(new java.awt.GridLayout(2, 1, 5, 5));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setBackground(new Color(220, 10, 10));

    JPanel titlePanel = new JPanel();
    JPanel contentPanel = new JPanel();

    titlePanel.setBackground(Color.orange);
    contentPanel.setBackground(Color.black);

    titlePanel.setPreferredSize(new Dimension(100, 100));
    contentPanel.setPreferredSize(new Dimension(100, 100));

    // --------------------- sub panels ---------------------

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel(); 

    panel1.setBackground(Color.yellow);
    panel2.setBackground(Color.pink);

    contentPanel.setLayout(new GridLayout(1, 2, 5, 5));

    panel1.setPreferredSize(new Dimension(50, 50));
    panel2.setPreferredSize(new Dimension(50, 50));

    contentPanel.add(panel1);
    contentPanel.add(panel2);

    // -------------------------------------------------------

    frame.add(titlePanel);
    frame.add(contentPanel);


}

}

