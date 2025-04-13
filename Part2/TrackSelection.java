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
 * @version Version 1.2
 */
public class TrackSelection extends JFrame implements ChangeListener {

  JLabel noOfTracksLabel;
  JSlider noOfTracksSlider;

  public TrackSelection() {

    // Page title
    JLabel title = new JLabel("Track Selection");
    title.setFont(new Font("Dialog", Font.BOLD, 50));

    // Slider to select number of horses
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

    // Creating main frame
    this.setTitle("Horse Racing Simulator"); 
    this.setVisible(true); 
    this.setSize(1000, 800);
    this.setResizable(false); // prevents resizing window
    this.getContentPane().setBackground(Color.white);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout(5, 5));


    // --------------------- sub panels ---------------------

    JPanel titlePanel = new JPanel();
    titlePanel.add(title);

    JPanel contentPanel = new JPanel();
    contentPanel.setLayout(new GridLayout(1, 3));

    JPanel contentColumn1 = new JPanel();
    contentColumn1.setLayout(new GridLayout(2, 1));

    JPanel contentColumn2 = new JPanel();
    contentColumn2.setLayout(new GridLayout(2, 1));

    JPanel contentColumn3 = new JPanel();
    contentColumn3.setLayout(new BorderLayout());

    JPanel selectHorseNumPanel = new JPanel();
    selectHorseNumPanel.add(noOfTracksLabel);
    selectHorseNumPanel.add(noOfTracksSlider);

    JPanel selectTrackPanel = new JPanel();

    JPanel selectLengthPanel = new JPanel();

    JPanel selectLaneNumPanel = new JPanel();

    JPanel selectConditionPanel = new JPanel();


    // -------------------------------------------------------

    this.add(titlePanel, BorderLayout.NORTH);
    this.add(contentPanel, BorderLayout.CENTER);

    contentPanel.add(contentColumn1);
    contentPanel.add(contentColumn2);
    contentPanel.add(contentColumn3);

    contentColumn1.add(selectHorseNumPanel);
    contentColumn1.add(selectTrackPanel);
    contentColumn2.add(selectLengthPanel);
    contentColumn2.add(selectLaneNumPanel);
    contentColumn3.add(selectConditionPanel);
  } 

  @Override 
  public void stateChanged(ChangeEvent e) {
    noOfTracksLabel.setText(noOfTracksSlider.getValue() + " horses");
  }
  
}
