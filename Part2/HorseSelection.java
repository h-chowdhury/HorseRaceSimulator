package Part2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 * This class defines the horse selection window of the program.
 * 
 * @author Humayra Chowdhury
 * @version Version 2.3
 */
public class HorseSelection extends JFrame {

  private RaceData raceData;
  private int numberOfLanes;

  public HorseSelection(RaceData RD) {

    // Storing the selection values from previous page
    raceData = RD;
    numberOfLanes = raceData.getNumberOfLanes();


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

    this.add(rightColumnPanel, BorderLayout.EAST);



    // Bottom panel
    JPanel bottomPanel = new JPanel();
    bottomPanel.setPreferredSize(new Dimension(100, 200));

    this.add(bottomPanel, BorderLayout.SOUTH);



    // Center panel
    JPanel centerPanel = new JPanel();
    centerPanel.setPreferredSize(new Dimension(100, 100));

    this.add(centerPanel, BorderLayout.CENTER);









    // Submit button - submit all data
    JButton submitButton = new JButton("Submit");
    submitButton.setSize(200, 100);
    submitButton.setFont(new Font("Dialog", Font.BOLD, 30));

    // This allows for the submit button to process the input data, store it in an
    // object of type RaceData, pass this object to a RaceDisplay object, and
    // display the RaceDisplay window
    submitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed (ActionEvent e) {
        String horseName = nameInput.getText();
        double horseConfidence = (double) confidenceInput.getValue();
        int horseLane = (int) laneInput.getValue();

        submitButton.setEnabled(false);
        RaceDisplay raceDisplayPage = new RaceDisplay(raceData);
        raceDisplayPage.setVisible(true);
        dispose();
      }
    });

    bottomPanel.add(submitButton);

  }

  public RaceData getRaceData () {
    return this.raceData;
  }

}
