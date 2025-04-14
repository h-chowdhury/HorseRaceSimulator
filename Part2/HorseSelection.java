package Part2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class defines the horse selection window of the program.
 * 
 * @author Humayra Chowdhury
 * @version Version 1.6
 */
public class HorseSelection extends JFrame {

  private RaceData raceData;

  public HorseSelection(RaceData RD) {

    // Storing the selection values from previous page
    raceData = RD;

    // Creating main frame
    this.setTitle("Horse Racing Simulator - Horse Selection"); 
    this.setVisible(true); 
    this.setSize(1500, 800);
    this.setResizable(false); // prevents resizing window
    this.getContentPane().setBackground(Color.white);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout(10, 10));

    JPanel titlePanel = new JPanel();
    JPanel leftColumnPanel = new JPanel(); 
    JPanel rightColumnPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    JPanel centerPanel = new JPanel();

    titlePanel.setPreferredSize(new Dimension(100, 100));
    leftColumnPanel.setPreferredSize(new Dimension(400, 100));
    rightColumnPanel.setPreferredSize(new Dimension(400, 100));
    bottomPanel.setPreferredSize(new Dimension(100, 200));
    centerPanel.setPreferredSize(new Dimension(100, 100));

    this.add(titlePanel, BorderLayout.NORTH);
    this.add(leftColumnPanel, BorderLayout.WEST);
    this.add(rightColumnPanel, BorderLayout.EAST);
    this.add(bottomPanel, BorderLayout.SOUTH);
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
