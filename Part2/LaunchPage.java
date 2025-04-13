package Part2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
 * @version Version 1.3
 */
public class LaunchPage {
  
  public static void main(String[] args) {

    JLabel title = new JLabel("Welcome to the Horse Racing Simulator!");
    title.setHorizontalAlignment(JLabel.CENTER);
    title.setVerticalAlignment(JLabel.CENTER);
    title.setFont(new Font("Dialog", Font.BOLD, 50));

    JLabel description = new JLabel("<html><body>This simulation runs <br>a race on a set of horses.</body></html>");
    description.setHorizontalAlignment(JLabel.CENTER);
    description.setVerticalAlignment(JLabel.CENTER);
    description.setFont(new Font("Dialog", Font.BOLD, 25));

    JButton startButton = new JButton("Start Simulation");
    startButton.setSize(200, 100);
    startButton.setFont(new Font("Dialog", Font.BOLD, 30));
    
    JFrame frame = new JFrame();
    frame.setTitle("Horse Racing Simulator"); 
    frame.setVisible(true); 
    frame.setSize(1000, 800);
    frame.setResizable(false); // prevents resizing window
    frame.setLayout(new java.awt.GridLayout(2, 1, 5, 5));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setBackground(Color.black);

    JPanel titlePanel = new JPanel();
    JPanel contentPanel = new JPanel();

    titlePanel.setBackground(Color.white);

    titlePanel.setPreferredSize(new Dimension(100, 100));
    contentPanel.setPreferredSize(new Dimension(100, 100));

    startButton.addActionListener (new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        TrackSelection trackSelectionPage = new TrackSelection();
        trackSelectionPage.setVisible(true);
        frame.dispose();
      }
    });

    // --------------------- sub panels ---------------------

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel(); 

    panel1.setBackground(Color.gray);
    panel2.setBackground(Color.darkGray);

    contentPanel.setLayout(new GridLayout(1, 2, 5, 5));

    panel1.setPreferredSize(new Dimension(50, 50));
    panel2.setPreferredSize(new Dimension(50, 50));

    contentPanel.add(panel1);
    contentPanel.add(panel2);

    // -------------------------------------------------------

    frame.add(titlePanel);
    frame.add(contentPanel);

    titlePanel.add(title);

    panel1.add(description);
    panel2.add(startButton);
  }

}

