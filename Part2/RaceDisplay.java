package Part2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.Timer;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;

/**
 * This class defines the race display window of the program.
 * 
 * @author Humayra Chowdhury
 * @version Version 1.5
 */
public class RaceDisplay extends JFrame {

  RacePanel racePanel;

  /**
   * Constructor of RaceDisplay
   */
  public RaceDisplay (RaceData RD) {

    RaceData raceData = RD;

    // Creating main frame
    this.setTitle("Horse Racing Simulator - Race Display"); 
    this.setVisible(true); 
    this.setSize(1500, 800);
    this.setResizable(false); // prevents resizing window
    this.getContentPane().setBackground(Color.white);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout(5, 5));

    // Title panel
    JPanel titlePanel = new JPanel();
    titlePanel.setPreferredSize(new Dimension(100, 100));

    JLabel title = new JLabel("Horse Race");
    title.setFont(new Font("Dialog", Font.BOLD, 50));

    this.add(titlePanel, BorderLayout.NORTH);
    titlePanel.add(title);

    
    // Left column
    JPanel leftColumnPanel = new JPanel(); 
    leftColumnPanel.setPreferredSize(new Dimension(200, 100));
    this.add(leftColumnPanel, BorderLayout.WEST);


    // Right column
    JPanel rightColumnPanel = new JPanel();
    rightColumnPanel.setPreferredSize(new Dimension(200, 100));
    this.add(rightColumnPanel, BorderLayout.EAST);


    // Race panel (center panel)
    racePanel = new RacePanel(raceData);
    this.add(racePanel, BorderLayout.CENTER);
  }
}
