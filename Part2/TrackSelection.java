package Part2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class defines the track selection window of the program.
 * 
 * @author Humayra Chowdhury
 * @version Version 1.3
 */
public class TrackSelection extends JFrame implements ChangeListener {

  JLabel noOfHorsesLabel;
  JSlider noOfHorsesSlider;
  JLabel lengthOfTrackLabel;
  JSlider lengthOfTrackSlider;

  public TrackSelection() {

    // Page title
    JLabel title = new JLabel("Track Selection");
    title.setFont(new Font("Dialog", Font.BOLD, 50));

    // Slider to select number of horses
    noOfHorsesLabel = new JLabel();
    noOfHorsesSlider = new JSlider(0, 15, 1);
    noOfHorsesSlider.setPreferredSize(new Dimension(300, 100));
    noOfHorsesSlider.setPaintTicks(true);
    noOfHorsesSlider.setMinorTickSpacing(1);
    noOfHorsesSlider.setPaintTrack(true);
    noOfHorsesSlider.setMajorTickSpacing(5);
    noOfHorsesSlider.setPaintLabels(true);
    noOfHorsesSlider.addChangeListener(this);
    noOfHorsesLabel.setText("Number of horses: " + noOfHorsesSlider.getValue());

    // Slider to select length of track
    lengthOfTrackLabel = new JLabel();
    lengthOfTrackSlider = new JSlider(0, 500, 1);
    lengthOfTrackSlider.setPreferredSize(new Dimension(300, 100));
    lengthOfTrackSlider.setPaintTicks(true);
    lengthOfTrackSlider.setMinorTickSpacing(50);
    lengthOfTrackSlider.setPaintTrack(true);
    lengthOfTrackSlider.setMajorTickSpacing(100);
    lengthOfTrackSlider.setPaintLabels(true);
    lengthOfTrackSlider.addChangeListener(this);
    lengthOfTrackLabel.setText("Length of track: " + noOfHorsesSlider.getValue() + "m");

    

    // Creating main frame
    this.setTitle("Horse Racing Simulator"); 
    this.setVisible(true); 
    this.setSize(1000, 800);
    this.setResizable(false); // prevents resizing window
    this.getContentPane().setBackground(Color.white);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout(5, 5));


    // --------------------- sub panels ---------------------

    // Title panel
    JPanel titlePanel = new JPanel();
    titlePanel.add(title);


    // Content panel
    JPanel contentPanel = new JPanel();
    contentPanel.setLayout(new GridLayout(1, 3));


    // Column 1 - (2 stacked panels)
    JPanel contentColumn1 = new JPanel();
    contentColumn1.setLayout(new GridLayout(2, 1));

    JPanel selectHorseNumPanel = new JPanel();
    selectHorseNumPanel.add(noOfHorsesLabel);
    selectHorseNumPanel.add(noOfHorsesSlider);

    JPanel selectTrackPanel = new JPanel();

    contentColumn1.add(selectHorseNumPanel);
    contentColumn1.add(selectTrackPanel);
    contentPanel.add(contentColumn1);


    // Column 2 - (2 stacked panels)
    JPanel contentColumn2 = new JPanel();
    contentColumn2.setLayout(new GridLayout(2, 1));

    JPanel selectLengthPanel = new JPanel();
    selectLengthPanel.add(lengthOfTrackLabel);
    selectLengthPanel.add(lengthOfTrackSlider);

    JPanel selectLaneNumPanel = new JPanel();

    contentColumn2.add(selectLengthPanel);
    contentColumn2.add(selectLaneNumPanel);
    contentPanel.add(contentColumn2);


    // Column 3 - (1 panel)
    JPanel contentColumn3 = new JPanel();
    contentColumn3.setLayout(new BorderLayout());

    JPanel selectConditionPanel = new JPanel();

    contentColumn3.add(selectConditionPanel);
    contentPanel.add(contentColumn3);


    // -------------------------------------------------------

    this.add(titlePanel, BorderLayout.NORTH);
    this.add(contentPanel, BorderLayout.CENTER);
  
  } 

  @Override 
  public void stateChanged(ChangeEvent e) {
    Object source = e.getSource();

    if (source == noOfHorsesSlider) {
      noOfHorsesLabel.setText("Number of horses: " + noOfHorsesSlider.getValue());
    }
    else if (source == lengthOfTrackSlider) {
      lengthOfTrackLabel.setText("Length of track: " + lengthOfTrackSlider.getValue() + "m");
    }
  }
  
}
