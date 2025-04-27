package Part2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Timer;

import javax.swing.Box;
import javax.swing.BoxLayout;
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
 * @version Version 1.9
 */
public class RaceDisplay extends JFrame {

  private RacePanel racePanel;
  private RaceData raceData;

  private int numberOfHorses;
  private Horse[] lanes;

  private String trackShape;
  private String weatherCondition;

  /**
   * Constructor of RaceDisplay
   */
  public RaceDisplay (RaceData RD) {

    raceData = RD;
    numberOfHorses = raceData.getNumberOfHorses();
    lanes = raceData.getLanesArray();
    trackShape = raceData.getTrackShape();
    weatherCondition = raceData.getWeatherCondition();

    // Creating main frame
    this.setTitle("Horse Racing Simulator - Race Display"); 
    this.setVisible(true); 
    this.setSize(1500, 800);
    this.setResizable(false); // prevents resizing window
    this.getContentPane().setBackground(Color.white);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout(5, 5));

    // Set window icon
    this.setIconImage(new ImageIcon("Part2\\images\\windowIcon.png").getImage());


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
    leftColumnPanel.setLayout(new BoxLayout(leftColumnPanel, BoxLayout.Y_AXIS));
    this.add(leftColumnPanel, BorderLayout.WEST);


      JPanel horseInfo;

      // Fill left column with horse info

      JLabel horsesTitle = new JLabel();
      horsesTitle.setText("Horses: ");
      horsesTitle.setFont(new Font("Dialog", Font.PLAIN, 15));
      leftColumnPanel.add(horsesTitle);
  
      for (int i=0; i<lanes.length; i++) {
        if (lanes[i] != null) {
          horseInfo = new JPanel();
          horseInfo.setLayout(new BoxLayout(horseInfo, BoxLayout.X_AXIS));
  
          Horse currentHorse = lanes[i];
          JLabel horseSymbol = new JLabel(currentHorse.getSymbol());
          JLabel horseName = new JLabel(currentHorse.getName());
          JLabel horseLane = new JLabel("L" + currentHorse.getLane());

          horseInfo.add(horseSymbol);
          horseInfo.add(Box.createRigidArea(new Dimension(10, 0))); // Space between symbol and name

          horseInfo.add(horseName);
          horseInfo.add(Box.createRigidArea(new Dimension(30, 0))); // Space between name and confidence

          horseInfo.add(horseLane);

          leftColumnPanel.add(horseInfo);
          leftColumnPanel.add(Box.createVerticalStrut(10));
        }
      }


    // Right column
    JPanel rightColumnPanel = new JPanel();
    rightColumnPanel.setPreferredSize(new Dimension(200, 100));
    this.add(rightColumnPanel, BorderLayout.EAST);

      JLabel trackTitle = new JLabel();
      trackTitle.setText("Selected Track:");
      trackTitle.setFont(new Font("Dialog", Font.PLAIN, 15));
      rightColumnPanel.add(trackTitle);

      JLabel trackSelected = new JLabel();
      trackSelected.setText(trackShape);
      trackSelected.setFont(new Font("Dialog", Font.PLAIN, 10));
      rightColumnPanel.add(trackSelected);

      JLabel weatherTitle = new JLabel();
      weatherTitle.setText("Weather Conditions: ");
      weatherTitle.setFont(new Font("Dialog", Font.PLAIN, 15));
      rightColumnPanel.add(weatherTitle);

      JLabel weatherSelected = new JLabel();
      weatherSelected.setText(weatherCondition);
      weatherSelected.setFont(new Font("Dialog", Font.PLAIN, 10));
      rightColumnPanel.add(weatherSelected);


    // Race panel (center panel)
    racePanel = new RacePanel(raceData);
    this.add(racePanel, BorderLayout.CENTER);
  }
}
