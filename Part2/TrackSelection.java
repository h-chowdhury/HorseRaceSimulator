package Part2;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class defines the track selection window of the program.
 * 
 * @author Humayra Chowdhury
 * @version Version 1.1
 */
public class TrackSelection extends JFrame implements ChangeListener {

  JLabel noOfTracksLabel;
  JSlider noOfTracksSlider;

  public TrackSelection() {

    noOfTracksLabel = new JLabel();

    noOfTracksSlider = new JSlider(1, 15, 1);
    noOfTracksSlider.setPreferredSize(new Dimension(400, 200));
    noOfTracksSlider.setPaintTicks(true);
    noOfTracksSlider.setMinorTickSpacing(1);
    noOfTracksSlider.setPaintTrack(true);
    noOfTracksSlider.setMajorTickSpacing(1);
    noOfTracksSlider.setPaintLabels(true);
    noOfTracksSlider.addChangeListener(this);

    noOfTracksLabel.setText(noOfTracksSlider.getValue() + " horses");
  
    this.setTitle("Horse Racing Simulator"); 
    this.setVisible(true); 
    this.setSize(1000, 800);
    this.setResizable(false); // prevents resizing window
    this.setLayout(new java.awt.GridLayout(2, 1, 5, 5));
    this.getContentPane().setBackground(Color.white);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.add(noOfTracksLabel);
    this.add(noOfTracksSlider);
  }

  @Override 
  public void stateChanged(ChangeEvent e) {
    noOfTracksLabel.setText(noOfTracksSlider.getValue() + " horses");
  }

  
}
