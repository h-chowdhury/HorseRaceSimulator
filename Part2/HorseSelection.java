package Part2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 * This class defines the horse selection window of the program.
 * 
 * @author Humayra Chowdhury
 * @version Version 2.9
 */
public class HorseSelection extends JFrame {

  private RaceData raceData;
  private int numberOfLanes;
  private int numberOfHorses;

  /**
   * Constructor of HorseSelection
   */
  public HorseSelection(RaceData RD) {

    // Storing the selection values from previous page
    raceData = RD;
    numberOfLanes = raceData.getNumberOfLanes();
    numberOfHorses = raceData.getNumberOfHorses();

    // Creating main frame
    this.setTitle("Horse Racing Simulator - Horse Selection"); 
    this.setVisible(true); 
    this.setSize(1500, 800);
    this.setResizable(false); // prevents resizing window
    this.getContentPane().setBackground(Color.white);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout(10, 10));


    // Title panel
    JPanel titlePanel = new JPanel();
    titlePanel.setPreferredSize(new Dimension(100, 100));

    JLabel title = new JLabel("Horse Customisation");
    title.setFont(new Font("Dialog", Font.BOLD, 50));

    this.add(titlePanel, BorderLayout.NORTH);
    titlePanel.add(title);


    // Left column
    JPanel leftColumnPanel = new JPanel(); 
    leftColumnPanel.setPreferredSize(new Dimension(400, 100));
    leftColumnPanel.setLayout(new GridLayout(2, 1));

      JPanel leftInputBox = new JPanel(); 
      leftInputBox.setLayout(new GridLayout(1, 2));

        // Name input
        JPanel nameBox = new JPanel();
        nameBox.setLayout(new GridLayout(2, 1));
          JLabel nameLabel = new JLabel("Horse Name");
          nameLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
          JTextArea nameInput = new JTextArea();
          nameInput.setSize(20, 5);
        nameBox.add(nameLabel);
        nameBox.add(nameInput);


        // Confidence input
        JPanel confidenceBox = new JPanel();
        confidenceBox.setLayout(new GridLayout(2, 1));
          JLabel confidenceLabel = new JLabel("Horse Confidence");
          confidenceLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
          JSpinner confidenceInput = new JSpinner(new SpinnerNumberModel(0.1, 0.1, 0.9, 0.1));
          
          // Prevent user from directly typing in confidence level
          JComponent editor = confidenceInput.getEditor();
          JFormattedTextField tf = ((JSpinner.DefaultEditor) editor).getTextField();
          tf.setEditable(false);

        confidenceBox.add(confidenceLabel);
        confidenceBox.add(confidenceInput);

        
        // Lane input
        JPanel laneBox = new JPanel();
        laneBox.setLayout(new GridLayout(2, 1));
          JLabel laneLabel = new JLabel("Horse Lane");
          laneLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
          JSpinner laneInput = new JSpinner(new SpinnerNumberModel(1, 1, numberOfLanes, 1));
          
          // Prevent user from directly typing in the lane
          JComponent editor2 = laneInput.getEditor();
          JFormattedTextField tf2 = ((JSpinner.DefaultEditor) editor2).getTextField();
          tf2.setEditable(false);

        laneBox.add(laneLabel);
        laneBox.add(laneInput);

      leftInputBox.add(confidenceBox);
      leftInputBox.add(laneBox);

    leftColumnPanel.add(leftInputBox);
    leftColumnPanel.add(nameBox);
    this.add(leftColumnPanel, BorderLayout.WEST);
    



    // Right column
    JPanel rightColumnPanel = new JPanel();
    rightColumnPanel.setPreferredSize(new Dimension(400, 100));
    rightColumnPanel.setLayout(new GridLayout(3, 1));


      // Saddle input
      JPanel saddleBox = new JPanel();
      saddleBox.setLayout(new GridLayout(5, 1));

        JLabel saddleLabel = new JLabel("Saddle");
        saddleLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

        ButtonGroup saddleButtons = new ButtonGroup();
          JRadioButton s1 = new JRadioButton("Option 1");
          JRadioButton s2 = new JRadioButton("Option 2");
          JRadioButton s3 = new JRadioButton("Option 3");
          saddleButtons.add(s1);
          saddleButtons.add(s2);
          saddleButtons.add(s3);
      
      saddleBox.add(saddleLabel);
      saddleBox.add(s1);
      saddleBox.add(s2);
      saddleBox.add(s3);


      // Horseshoe input
      JPanel horseshoeBox = new JPanel();
      horseshoeBox.setLayout(new GridLayout(5, 1));

        JLabel horseshoeLabel = new JLabel("Horseshoe");
        horseshoeLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

        ButtonGroup horseshoeButtons = new ButtonGroup();
          JRadioButton hs1 = new JRadioButton("Option 1");
          JRadioButton hs2 = new JRadioButton("Option 2");
          JRadioButton hs3 = new JRadioButton("Option 3");
          horseshoeButtons.add(hs1);
          horseshoeButtons.add(hs2);
          horseshoeButtons.add(hs3);
      
        horseshoeBox.add(horseshoeLabel);
        horseshoeBox.add(hs1);
        horseshoeBox.add(hs2);
        horseshoeBox.add(hs3);

    
      // Accessory input
      JPanel accessoryBox = new JPanel();
      accessoryBox.setLayout(new GridLayout(5, 1));

        JLabel accessoryLabel = new JLabel("Accessory");
        accessoryLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

        ButtonGroup accessoryButtons = new ButtonGroup();
          JRadioButton a1 = new JRadioButton("Option 1");
          JRadioButton a2 = new JRadioButton("Option 2");
          JRadioButton a3 = new JRadioButton("Option 3");
          accessoryButtons.add(a1);
          accessoryButtons.add(a2);
          accessoryButtons.add(a3);
      
        accessoryBox.add(accessoryLabel);
        accessoryBox.add(a1);
        accessoryBox.add(a2);
        accessoryBox.add(a3);


    rightColumnPanel.add(saddleBox);
    rightColumnPanel.add(horseshoeBox);
    rightColumnPanel.add(accessoryBox);

    this.add(rightColumnPanel, BorderLayout.EAST);





    // Bottom panel
    JPanel bottomPanel = new JPanel();
    bottomPanel.setPreferredSize(new Dimension(100, 200));
    bottomPanel.setLayout(new GridLayout(1, 3));

      // Coat colour input
      JPanel coatBox = new JPanel();
      coatBox.setLayout(new GridLayout(5, 1));

        JLabel coatLabel = new JLabel("Coat colour");
        laneLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

        ButtonGroup coatButtons = new ButtonGroup();
          JRadioButton c1 = new JRadioButton("Black");
          JRadioButton c2 = new JRadioButton("Brown");
          JRadioButton c3 = new JRadioButton("Grey");
          JRadioButton c4 = new JRadioButton("White");
          coatButtons.add(c1);
          coatButtons.add(c2);
          coatButtons.add(c3);
          coatButtons.add(c4);
      
        coatBox.add(coatLabel);
        coatBox.add(c1);
        coatBox.add(c2);
        coatBox.add(c3);
        coatBox.add(c4);


      // Submit button
      JButton submitButton = new JButton("Submit");
      submitButton.setSize(200, 100);
      submitButton.setFont(new Font("Dialog", Font.BOLD, 30));


      // Hair colour input
      JPanel hairBox = new JPanel();
      hairBox.setLayout(new GridLayout(5, 1));

        JLabel hairLabel = new JLabel("Hair colour");
        hairLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

        ButtonGroup hairButtons = new ButtonGroup();
          JRadioButton h1 = new JRadioButton("Black");
          JRadioButton h2 = new JRadioButton("Brown");
          JRadioButton h3 = new JRadioButton("Grey");
          JRadioButton h4 = new JRadioButton("White");
          hairButtons.add(h1);
          hairButtons.add(h2);
          hairButtons.add(h3);
          hairButtons.add(h4);
      
        hairBox.add(hairLabel);
        hairBox.add(h1);
        hairBox.add(h2);
        hairBox.add(h3);
        hairBox.add(h4);

    bottomPanel.add(coatBox);
    bottomPanel.add(submitButton);
    bottomPanel.add(hairBox);

    this.add(bottomPanel, BorderLayout.SOUTH);



    // Center panel
    JPanel centerPanel = new JPanel();
    centerPanel.setPreferredSize(new Dimension(100, 100));

    this.add(centerPanel, BorderLayout.CENTER);






    /* 
     * Function for submit button.
     * Allows for storage of horse data in a RaceData object.
     * Passes this object and data to RaceDisplay.
     */
    submitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed (ActionEvent e) {
        // Check if chosen lane is taken OR name is empty
        if ((raceData.getLanes(((int) laneInput.getValue()) - 1)) != null || nameInput.getText().trim().isEmpty()) {

          // If chosen lane is taken, display error
          if ((raceData.getLanes(((int) laneInput.getValue()) - 1)) != null) {
            javax.swing.JOptionPane.showMessageDialog(null, 
            "The chosen lane has already been filled. Please enter a different lane.",
            "Invalid Input", javax.swing.JOptionPane.WARNING_MESSAGE);
        
            // Re-enable the button since submission was stopped
            submitButton.setEnabled(true);
            return;
          }
          // If name is empty, display error
          else if (nameInput.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, 
            "Please enter a name.",
            "Invalid Input", javax.swing.JOptionPane.WARNING_MESSAGE);
        
            // Re-enable the button since submission was stopped
            submitButton.setEnabled(true);
            return;
          }
          // If all inputs are valid
        } else {
          // Store horse data in variables
          String horseName = nameInput.getText();
          double horseConfidence = (double) confidenceInput.getValue();
          horseConfidence = Math.round(horseConfidence * 100.0) / 100.0;
          int horseLane = (int) laneInput.getValue();

          // Placeholder image
          ImageIcon symbol = new ImageIcon("C:\\Users\\hummu\\Documents\\Uni\\Year 1\\Semester B\\Object Oriented Programming\\Project\\HorseRaceSimulator\\Part2\\images\\placeholder.png");
          
          // Create horse object
          Horse horse = new Horse(symbol, horseName, horseConfidence, horseLane);
          
          // Store customisation data
          HorseCustomisation horseCustomisation = new HorseCustomisation();
          horse.setHorseCustomisation(horseCustomisation);
          // ** TO BE ADDED ** //

          // Assign horse to lane
          raceData.setLanes(horse, horseLane-1);
          raceData.increaseHorsesProcessed();
  
          // Display new HorseSelection window for each horse
          if (raceData.getHorsesProcessed() < numberOfHorses) {
            HorseSelection horseSelectionPage = new HorseSelection(raceData);
            horseSelectionPage.setVisible(true);
            dispose();
          } else {
            // Redirect to RaceDisplay window when all horses are processed
            submitButton.setEnabled(false);
            RaceDisplay raceDisplayPage = new RaceDisplay(raceData);
            raceDisplayPage.setVisible(true);
            dispose();
          }

        }
      }
    });

  }

}
