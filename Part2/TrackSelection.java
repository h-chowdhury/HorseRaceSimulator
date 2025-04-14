package Part2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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
 * @version Version 1.9
 */
public class TrackSelection extends JFrame implements ChangeListener {

  // Labels and sliders for input
  JLabel numberOfHorsesLabel;
  JSlider numberOfHorsesSlider;
  JLabel lengthOfTrackLabel;
  JSlider lengthOfTrackSlider;
  JLabel numberOfLanesLabel;
  JSlider numberOfLanesSlider;

  public TrackSelection() {

    // Page title
    JLabel title = new JLabel("Track Selection");
    title.setFont(new Font("Dialog", Font.BOLD, 50));

    // Slider to select number of horses
    numberOfHorsesLabel = new JLabel();
    numberOfHorsesSlider = new JSlider(0, 15, 1);
    numberOfHorsesSlider.setPreferredSize(new Dimension(300, 100));
    numberOfHorsesSlider.setPaintTicks(true);
    numberOfHorsesSlider.setMinorTickSpacing(1);
    numberOfHorsesSlider.setPaintTrack(true);
    numberOfHorsesSlider.setMajorTickSpacing(5);
    numberOfHorsesSlider.setPaintLabels(true);
    numberOfHorsesSlider.addChangeListener(this);
    numberOfHorsesLabel.setText("Number of horses: " + numberOfHorsesSlider.getValue());
    numberOfHorsesLabel.setFont(new Font("Dialog", Font.PLAIN, 25));

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
    lengthOfTrackLabel.setText("Length of track: " + numberOfHorsesSlider.getValue() + "m");
    lengthOfTrackLabel.setFont(new Font("Dialog", Font.PLAIN, 25));

    // Slider to select number of lanes
    numberOfLanesLabel = new JLabel();
    numberOfLanesSlider = new JSlider(0, 20, 1);
    numberOfLanesSlider.setPreferredSize(new Dimension(300, 100));
    numberOfLanesSlider.setPaintTicks(true);
    numberOfLanesSlider.setMinorTickSpacing(1);
    numberOfLanesSlider.setPaintTrack(true);
    numberOfLanesSlider.setMajorTickSpacing(5);
    numberOfLanesSlider.setPaintLabels(true);
    numberOfLanesSlider.addChangeListener(this);
    numberOfLanesLabel.setText("Number of lanes: " + numberOfHorsesSlider.getValue() + "m");
    numberOfLanesLabel.setFont(new Font("Dialog", Font.PLAIN, 25));

    // Select track shape
    JLabel trackShapeTitle = new JLabel("Select track shape");
    trackShapeTitle.setFont(new Font("Dialog", Font.PLAIN, 25));

    // Select weather conditions
    JLabel weatherConditionTitle = new JLabel("Select weather");
    weatherConditionTitle.setFont(new Font("Dialog", Font.PLAIN, 25));

    // Submit button - submit all data
    JButton submitButton = new JButton("Submit");
    submitButton.setSize(200, 100);
    submitButton.setFont(new Font("Dialog", Font.BOLD, 30));

    // This allows for the submit button to process the input data
    // and display the HorseSelection window
    submitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed (ActionEvent e) {
        submitButton.setEnabled(false);

        int numberOfHorses = numberOfHorsesSlider.getValue();
        int lengthOfTrack = lengthOfTrackSlider.getValue();
        int numberOfLanes = numberOfLanesSlider.getValue();

        RaceData raceData = new RaceData();
        raceData.setNumberOfHorses(numberOfHorses);
        raceData.setLengthOfTrack(lengthOfTrack);
        raceData.setNumberOfLanes(numberOfLanes);

        HorseSelection horseSelectionPage = new HorseSelection(raceData);
        horseSelectionPage.setVisible(true);
      }
    });




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
    selectHorseNumPanel.add(numberOfHorsesLabel);
    selectHorseNumPanel.add(numberOfHorsesSlider);

    JPanel selectTrackPanel = new JPanel();
    selectTrackPanel.add(trackShapeTitle);

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
    selectLaneNumPanel.add(numberOfLanesLabel);
    selectLaneNumPanel.add(numberOfLanesSlider);

    contentColumn2.add(selectLengthPanel);
    contentColumn2.add(selectLaneNumPanel);
    contentPanel.add(contentColumn2);


    // Column 3 - (2 panel)
    JPanel contentColumn3 = new JPanel();
    contentColumn3.setLayout(new GridLayout(2, 1));

    JPanel selectConditionPanel = new JPanel();
    selectConditionPanel.add(weatherConditionTitle);

    JPanel submitButtonPanel = new JPanel();
    submitButtonPanel.add(submitButton);

    contentColumn3.add(selectConditionPanel);
    contentColumn3.add(submitButtonPanel);
    contentPanel.add(contentColumn3);



    // -------------------------------------------------------

    this.add(titlePanel, BorderLayout.NORTH);
    this.add(contentPanel, BorderLayout.CENTER);
  
  } 

  // This method allows for the sliders to be processed dynamically
  @Override 
  public void stateChanged(ChangeEvent e) {
    Object source = e.getSource();

    if (source == numberOfHorsesSlider) {
      if (numberOfHorsesSlider.getValue() == 0) {
        numberOfHorsesSlider.setValue(1);
      }
      numberOfHorsesLabel.setText("Number of horses: " + numberOfHorsesSlider.getValue());
    }
    else if (source == lengthOfTrackSlider) {
      if (lengthOfTrackSlider.getValue() == 0) {
        lengthOfTrackSlider.setValue(1);
      }
      lengthOfTrackLabel.setText("Length of track: " + lengthOfTrackSlider.getValue() + "m");
    }
    else if (source == numberOfLanesSlider) {
      if (numberOfLanesSlider.getValue() == 0) {
        numberOfLanesSlider.setValue(1);
      }
      numberOfLanesLabel.setText("Number of lanes: " + numberOfLanesSlider.getValue());
    }
  }
  
}
