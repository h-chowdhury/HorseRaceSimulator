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
import javax.swing.border.Border;

/**
 * This class defines the horse selection window of the program.
 * 
 * @author Humayra Chowdhury
 * @version Version 3.4
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
    this.setSize(1500, 800);
    this.setResizable(false); // prevents resizing window
    this.getContentPane().setBackground(Color.white);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout(5, 5));


    // Title panel
    JPanel titlePanel = new JPanel();
    titlePanel.setLayout(new BorderLayout());
    titlePanel.setPreferredSize(new Dimension(100, 100));

    JLabel title = new JLabel("Horse Customisation");
    title.setFont(new Font("Dialog", Font.BOLD, 50));

      // Submit button
      JButton submitButton = new JButton("Submit");
      submitButton.setSize(200, 100);
      submitButton.setFont(new Font("Dialog", Font.BOLD, 30));

    titlePanel.add(title, BorderLayout.CENTER);
    titlePanel.add(submitButton, BorderLayout.EAST);

    this.add(titlePanel, BorderLayout.NORTH);


    // Left column
    JPanel leftColumnPanel = new JPanel(); 
    leftColumnPanel.setPreferredSize(new Dimension(400, 100));
    leftColumnPanel.setLayout(new GridLayout(4, 2, 10, 10));

      // Name input
      JPanel nameBox = new JPanel();
      nameBox.setLayout(new GridLayout(2, 1));
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        JTextArea nameInput = new JTextArea();
        nameInput.setSize(20, 5);
      nameBox.add(nameLabel);
      nameBox.add(nameInput);


      // Confidence input
      JPanel confidenceBox = new JPanel();
      confidenceBox.setLayout(new GridLayout(2, 1));
        JLabel confidenceLabel = new JLabel("Confidence");
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
        JLabel laneLabel = new JLabel("Lane");
        laneLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        JSpinner laneInput = new JSpinner(new SpinnerNumberModel(1, 1, numberOfLanes, 1));
        
        // Prevent user from directly typing in the lane
        JComponent editor2 = laneInput.getEditor();
        JFormattedTextField tf2 = ((JSpinner.DefaultEditor) editor2).getTextField();
        tf2.setEditable(false);

      laneBox.add(laneLabel);
      laneBox.add(laneInput);


      // Breed input
      JPanel breedBox = new JPanel();
      breedBox.setLayout(new GridLayout(5, 1));

        JLabel breedLabel = new JLabel("Breed");
        breedLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

        ButtonGroup breedButtons = new ButtonGroup();
          JRadioButton b1 = new JRadioButton("Option 1");
          JRadioButton b2 = new JRadioButton("Option 2");
          JRadioButton b3 = new JRadioButton("Option 3");
          b1.setToolTipText("Adds effect xyz");
          b2.setToolTipText("Adds effect xyz");
          b3.setToolTipText("Adds effect xyz");
          breedButtons.add(b1);
          breedButtons.add(b2);
          breedButtons.add(b3);
      
        breedBox.add(breedLabel);
        breedBox.add(b1);
        breedBox.add(b2);
        breedBox.add(b3);


      // Hair colour input
      JPanel hairBox = new JPanel();
      hairBox.setLayout(new GridLayout(5, 1));

        JLabel hairLabel = new JLabel("Hair colour");
        hairLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

        ButtonGroup hairButtons = new ButtonGroup();
          JRadioButton h1 = new JRadioButton("Black");
          JRadioButton h2 = new JRadioButton("Brown");
          JRadioButton h3 = new JRadioButton("Blonde");
          h1.setToolTipText("Adds effect xyz");
          h2.setToolTipText("Adds effect xyz");
          h3.setToolTipText("Adds effect xyz");
          hairButtons.add(h1);
          hairButtons.add(h2);
          hairButtons.add(h3);
      
        hairBox.add(hairLabel);
        hairBox.add(h1);
        hairBox.add(h2);
        hairBox.add(h3);


      // Saddle input
      JPanel saddleBox = new JPanel();
      saddleBox.setLayout(new GridLayout(5, 1));

        JLabel saddleLabel = new JLabel("Saddle");
        saddleLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

        ButtonGroup saddleButtons = new ButtonGroup();
          JRadioButton s1 = new JRadioButton("Option 1");
          JRadioButton s2 = new JRadioButton("Option 2");
          JRadioButton s3 = new JRadioButton("Option 3");
          s1.setToolTipText("Adds effect xyz");
          s2.setToolTipText("Adds effect xyz");
          s3.setToolTipText("Adds effect xyz");
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
          hs1.setToolTipText("Adds effect xyz");
          hs2.setToolTipText("Adds effect xyz");
          hs3.setToolTipText("Adds effect xyz");
          horseshoeButtons.add(hs1);
          horseshoeButtons.add(hs2);
          horseshoeButtons.add(hs3);
      
        horseshoeBox.add(horseshoeLabel);
        horseshoeBox.add(hs1);
        horseshoeBox.add(hs2);
        horseshoeBox.add(hs3);

    
      // Powerup input
      JPanel powerupBox = new JPanel();
      powerupBox.setLayout(new GridLayout(5, 1));

        JLabel powerupLabel = new JLabel("Powerup");
        powerupLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

        ButtonGroup powerupButtons = new ButtonGroup();
          JRadioButton p1 = new JRadioButton("Option 1");
          JRadioButton p2 = new JRadioButton("Option 2");
          JRadioButton p3 = new JRadioButton("Option 3");
          p1.setToolTipText("Adds effect xyz");
          p2.setToolTipText("Adds effect xyz");
          p3.setToolTipText("Adds effect xyz");
          powerupButtons.add(p1);
          powerupButtons.add(p2);
          powerupButtons.add(p3);
      
        powerupBox.add(powerupLabel);
        powerupBox.add(p1);
        powerupBox.add(p2);
        powerupBox.add(p3);


    leftColumnPanel.add(nameBox);
    leftColumnPanel.add(hairBox);
    leftColumnPanel.add(confidenceBox);
    leftColumnPanel.add(saddleBox);
    leftColumnPanel.add(laneBox);
    leftColumnPanel.add(horseshoeBox);
    leftColumnPanel.add(breedBox);
    leftColumnPanel.add(powerupBox);

    this.add(leftColumnPanel, BorderLayout.WEST);
    


    // Right column
    JPanel rightColumnPanel = new JPanel();
    rightColumnPanel.setPreferredSize(new Dimension(200, 100));
    rightColumnPanel.setLayout(new GridLayout(3, 1));

    this.add(rightColumnPanel, BorderLayout.EAST);




    // Center panel
    JPanel centerPanel = new JPanel();
    centerPanel.setPreferredSize(new Dimension(100, 100));

    this.add(centerPanel, BorderLayout.CENTER);

    this.setVisible(true); 






    /* 
     * Function for submit button.
     * Stores customisation data in a Horse object.
     * Allows for storage of Horses in a RaceData object.
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
        } else {  // If all inputs are valid

          // Store horse data in variables
          String horseName = nameInput.getText();
          double horseConfidence = (double) confidenceInput.getValue();
          horseConfidence = Math.round(horseConfidence * 100.0) / 100.0;
          int horseLane = (int) laneInput.getValue();

          // Placeholder image
          ImageIcon symbol = new ImageIcon("Part2\\images\\placeholder.png");
          
          // Create horse object
          Horse horse = new Horse(symbol, horseName, horseConfidence, horseLane);
          
          // Store customisation data
            JRadioButton selectedRadioButton;

            // Store breed
            selectedRadioButton = (JRadioButton) breedButtons.getSelection();
            String breedInput = selectedRadioButton.getText();

            // Store hair colour
            selectedRadioButton = (JRadioButton) hairButtons.getSelection();
            String hairInput = selectedRadioButton.getText();

            // Store saddle type
            selectedRadioButton = (JRadioButton) saddleButtons.getSelection();
            String saddleInput = selectedRadioButton.getText();

            // Store horseshoe type
            selectedRadioButton = (JRadioButton) horseshoeButtons.getSelection();
            String horseshoeInput = selectedRadioButton.getText();

            // Store powerup
            selectedRadioButton = (JRadioButton) powerupButtons.getSelection();
            String accessoryInput = selectedRadioButton.getText();

          HorseCustomisation horseCustomisation = new HorseCustomisation(horse, breedInput, hairInput, saddleInput, horseshoeInput, accessoryInput);
          System.out.println(breedInput + hairInput + saddleInput + horseshoeInput + accessoryInput);

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
