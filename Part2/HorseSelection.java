package Part2;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

/**
 * This class defines the horse selection window of the program.
 * 
 * @author Humayra Chowdhury
 * @version Version 1.2
 */
public class HorseSelection extends JFrame {

  private int numberOfHorses;
  private int lengthOfTrack;
  private int numberOfLanes;

  public HorseSelection(RaceData raceData) {

    // Storing the selection values from previous page
    this.numberOfHorses = raceData.getNumberOfHorses();
    this.lengthOfTrack = raceData.getLengthOfTrack();
    this.numberOfLanes = raceData.getNumberOfLanes();

    // Creating main frame
    this.setTitle("Horse Racing Simulator"); 
    this.setVisible(true); 
    this.setSize(1000, 800);
    this.setResizable(false); // prevents resizing window
    this.getContentPane().setBackground(Color.white);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout(5, 5));
  }


  
}
