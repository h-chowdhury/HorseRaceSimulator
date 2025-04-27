package Part2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class defines the track selection window of the program.
 * 
 * @author Humayra Chowdhury
 * @version Version 2.9
 */
public class TrackSelection extends JFrame implements ChangeListener {

  // Labels and sliders for input
  JLabel numberOfHorsesLabel;
  JSlider numberOfHorsesSlider;
  JLabel lengthOfTrackLabel;
  JSlider lengthOfTrackSlider;
  JLabel numberOfLanesLabel;
  JSlider numberOfLanesSlider;


  // Constructor for the TrackSelection window
  public TrackSelection() {

    // Page title
    JLabel title = new JLabel("Track Selection");
    title.setFont(new Font("Dialog", Font.BOLD, 50));

    // Slider to select number of horses
    numberOfHorsesLabel = new JLabel();
    numberOfHorsesSlider = new JSlider(1, 8, 1);
    numberOfHorsesSlider.setPreferredSize(new Dimension(300, 100));
    numberOfHorsesSlider.setPaintTicks(true);
    numberOfHorsesSlider.setMinorTickSpacing(1);
    numberOfHorsesSlider.setPaintTrack(true);
    numberOfHorsesSlider.setMajorTickSpacing(1);
    numberOfHorsesSlider.setPaintLabels(true);
    numberOfHorsesSlider.addChangeListener(this);
    numberOfHorsesLabel.setText("Number of horses: " + numberOfHorsesSlider.getValue());
    numberOfHorsesLabel.setFont(new Font("Dialog", Font.PLAIN, 25));

    // Slider to select length of track
    lengthOfTrackLabel = new JLabel();
    lengthOfTrackSlider = new JSlider(0, 250, 1);
    lengthOfTrackSlider.setPreferredSize(new Dimension(300, 100));
    lengthOfTrackSlider.setPaintTicks(true);
    lengthOfTrackSlider.setMinorTickSpacing(10);
    lengthOfTrackSlider.setPaintTrack(true);
    lengthOfTrackSlider.setMajorTickSpacing(50);
    lengthOfTrackSlider.setPaintLabels(true);
    lengthOfTrackSlider.addChangeListener(this);
    lengthOfTrackLabel.setText("Length of track: " + numberOfHorsesSlider.getValue() + "m");
    lengthOfTrackLabel.setFont(new Font("Dialog", Font.PLAIN, 25));

    // Slider to select number of lanes
    numberOfLanesLabel = new JLabel();
    numberOfLanesSlider = new JSlider(1, 8, 1);
    numberOfLanesSlider.setPreferredSize(new Dimension(300, 100));
    numberOfLanesSlider.setPaintTicks(true);
    numberOfLanesSlider.setMinorTickSpacing(1);
    numberOfLanesSlider.setPaintTrack(true);
    numberOfLanesSlider.setMajorTickSpacing(1);
    numberOfLanesSlider.setPaintLabels(true);
    numberOfLanesSlider.addChangeListener(this);
    numberOfLanesLabel.setText("Number of lanes: " + numberOfHorsesSlider.getValue());
    numberOfLanesLabel.setFont(new Font("Dialog", Font.PLAIN, 25));


    // Select track shape
    JPanel trackShapeBox = new JPanel();
    trackShapeBox.setLayout(new GridLayout(4, 1));

      JLabel trackShapeTitle = new JLabel("Select track shape");
      trackShapeTitle.setFont(new Font("Dialog", Font.PLAIN, 25));
      
      ButtonGroup trackShapeButtons = new ButtonGroup();
        JRadioButton ts1 = new JRadioButton("Straight");
        JRadioButton ts2 = new JRadioButton("Zig-Zag");
        JRadioButton ts3 = new JRadioButton("Rectangle");
        ts1.setToolTipText("A set of straight lanes from left to right.");
        ts2.setToolTipText("A set of angular lanes, alternating in a zig-zag pattern.");
        ts3.setToolTipText("A set of lanes going round, forming a rectangular shape.");
        ts1.setSelected(true);
        trackShapeButtons.add(ts1);
        trackShapeButtons.add(ts2);
        trackShapeButtons.add(ts3);
    
      trackShapeBox.add(trackShapeTitle);
      trackShapeBox.add(ts1);
      trackShapeBox.add(ts2);
      trackShapeBox.add(ts3);



    // Select weather conditions
    JPanel weatherBox = new JPanel();
    weatherBox.setLayout(new GridLayout(5, 1));

      JLabel weatherConditionTitle = new JLabel("Select weather");
      weatherConditionTitle.setFont(new Font("Dialog", Font.PLAIN, 25));
  
      ButtonGroup weatherConditionButtons = new ButtonGroup();
        JRadioButton w1 = new JRadioButton("Clear");
        JRadioButton w2 = new JRadioButton("Rain");
        JRadioButton w3 = new JRadioButton("Wind");
        JRadioButton w4 = new JRadioButton("Fog");
        w1.setToolTipText("No weather effects.");
        w2.setToolTipText("Horses will be 10% more prone to falling due to muddy surfaces.");
        w3.setToolTipText("Horses will be 5% more prone to falling and slowness.");
        w4.setToolTipText("Horses will be 10% more prone to slowness due to reduced visibility.");
        w1.setSelected(true);
        weatherConditionButtons.add(w1);
        weatherConditionButtons.add(w2);
        weatherConditionButtons.add(w3);
        weatherConditionButtons.add(w4);
    
      weatherBox.add(weatherConditionTitle);
      weatherBox.add(w1);
      weatherBox.add(w2);
      weatherBox.add(w3);
      weatherBox.add(w4);


    // Submit button - submit all data
    JButton submitButton = new JButton("Submit");
    submitButton.setSize(200, 100);
    submitButton.setFont(new Font("Dialog", Font.BOLD, 30));

    // This allows for the submit button to process the input data, store it in an
    // object of type RaceData, pass this object to a HorseSelection object, and
    // display the HorseSelection window
    submitButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed (ActionEvent e) {

        submitButton.setEnabled(false);

        // Store selected track type
        String trackShapeInput = null;
        if (ts1.isSelected()) {
          trackShapeInput = "Straight";

        } else if (ts2.isSelected()) {
          trackShapeInput = "Zig-Zag";
          
        } else if (ts3.isSelected()) {
          trackShapeInput = "Rectangle";
        }

        // Store selected weather condition
        String weatherConditionInput = null;
        if (w1.isSelected()) {
          weatherConditionInput = "Clear";

        } else if (w2.isSelected()) {
          weatherConditionInput = "Rain";
          
        } else if (w3.isSelected()) {
          weatherConditionInput = "Wind";

        } else if (w4.isSelected()) {
          weatherConditionInput = "Fog";
        }

        int numberOfHorses = numberOfHorsesSlider.getValue();
        int lengthOfTrack = lengthOfTrackSlider.getValue();
        int numberOfLanes = numberOfLanesSlider.getValue();

        // Check if lanes are less than horses
        if (numberOfLanes < numberOfHorses) {
          javax.swing.JOptionPane.showMessageDialog(null, 
          "Number of lanes must be >= the number of horses.",
          "Invalid Input", javax.swing.JOptionPane.WARNING_MESSAGE);
      
          // Re-enable the button since submission was stopped
          submitButton.setEnabled(true);
          return;
        } else {
          // Store track data in a RaceData object
          RaceData raceData = new RaceData();
          raceData.setNumberOfHorses(numberOfHorses);
          raceData.setLengthOfTrack(lengthOfTrack);
          raceData.setNumberOfLanes(numberOfLanes);
  
          // Display HorseSelection window
          HorseSelection horseSelectionPage = new HorseSelection(raceData);
          horseSelectionPage.setVisible(true);
          dispose();
        }
      }
    });

    // Creating main frame
    this.setTitle("Horse Racing Simulator - Track Selection"); 
    this.setVisible(true); 
    this.setSize(1500, 800);
    this.setResizable(false); // prevents resizing window
    this.getContentPane().setBackground(Color.white);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout(5, 5));

    // Set window icon
    this.setIconImage(new ImageIcon("Part2\\images\\windowIcon.png").getImage());
    

        

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

    contentColumn1.add(selectHorseNumPanel);
    contentColumn1.add(trackShapeBox);
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
    selectConditionPanel.add(weatherBox);

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

    // Validation and dynamic code for numberOfHorses slider
    if (source == numberOfHorsesSlider) {
      if (numberOfHorsesSlider.getValue() == 0) {
        numberOfHorsesSlider.setValue(1);
      }
      numberOfHorsesLabel.setText("Number of horses: " + numberOfHorsesSlider.getValue());
    }
    // Validation and dynamiccode for lengthOfTrack slider
    else if (source == lengthOfTrackSlider) {
      if (lengthOfTrackSlider.getValue() == 0) {
        lengthOfTrackSlider.setValue(1);
      }
      lengthOfTrackLabel.setText("Length of track: " + lengthOfTrackSlider.getValue() + "m");
    }
    // Validation and dynamic code for numberOfLanes slider
    else if (source == numberOfLanesSlider) {
      if (numberOfLanesSlider.getValue() == 0) {
        numberOfLanesSlider.setValue(1);
      }
      numberOfLanesLabel.setText("Number of lanes: " + numberOfLanesSlider.getValue());
    }
  }
  
}
