package Part2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * This class defines the race panel.
 * The horse race animation will be displayed within this panel.
 * 
 * @author Humayra Chowdhury
 * @version Version 1.9
 */
public class RacePanel extends JPanel implements ActionListener {
  final int PANEL_HEIGHT = 620;
  final int PANEL_WIDTH = 1090;

  private RaceData raceData;
  private int numberOfHorses;
  private int trackLength;
  private int laneCount;
  private Horse[] lanes;
  final int MAX_LANES = 20;
  double FINISH_LINE_X;

  Image[] horseSymbols;
  Timer timer;

  int[] xVelocity = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
  int[] yVelocity = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
  
  int[] xPosHorse = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
  int[] yPosHorse = {7, 32, 57, 82, 107, 132, 157, 182, 207, 232, 257, 282, 307, 332, 357, 382, 407, 432, 457, 482};

  int[] xPosTrack = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
  int[] yPosTrack = {5, 30, 55, 80, 105, 130, 155, 180, 205, 230, 255, 280, 305, 330, 355, 380, 405, 430, 455, 480};


  RacePanel (RaceData RD) {

    raceData = RD;
    numberOfHorses = raceData.getNumberOfHorses();
    trackLength = raceData.getLengthOfTrack();
    laneCount = raceData.getNumberOfLanes();
    lanes = raceData.getLanesArray();
    horseSymbols = new Image[laneCount];
    FINISH_LINE_X = (PANEL_WIDTH-45) * ((double) trackLength/500.0); // PANEL_WIDTH-60 is full length (500m)

    this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    this.setBackground(new Color(0xE7D176));

    // set placeholder images into image array
    for (int i=0; i<laneCount; i++) {
      horseSymbols[i]= new ImageIcon("C:\\Users\\hummu\\Documents\\Uni\\Year 1\\Semester B\\Object Oriented Programming\\Project\\HorseRaceSimulator\\Part2\\images\\placeholder.png").getImage();
    }

    timer = new Timer(100, this);
    timer.start();
  
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g); // paints bg
    Graphics2D g2D = (Graphics2D) g;

    // draw track lines
    for (int i=0; i<=laneCount; i++) {
      g2D.drawLine(xPosTrack[i], yPosTrack[i], (int) FINISH_LINE_X, yPosTrack[i]);
    }

    // draw start line
    g2D.drawLine(xPosTrack[0], yPosTrack[0], xPosTrack[0], yPosTrack[laneCount]);

    // draw finish line
    g2D.drawLine((int) FINISH_LINE_X, yPosTrack[0], (int) FINISH_LINE_X, yPosTrack[laneCount]);

    // update each horse repeatedly
    for (int  i=0; i<laneCount; i++) {
      if (lanes[i] != null) {
        g2D.drawImage(horseSymbols[i], xPosHorse[i], yPosHorse[i], null);
      }
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    // update each horses x position repeatedly
    for (int i=0; i<laneCount; i++) {
      // Check if the lane value is null (empty lane)
      if (lanes[i] != null && xPosHorse[i]<= FINISH_LINE_X && (lanes[i].hasFallen() == false)) {

        //the probability that the horse will move forward depends on the confidence;
        if (Math.random() < lanes[i].getConfidence())
        {
          xPosHorse[i] = xPosHorse[i] + xVelocity[i];
        }
        
        //the probability that the horse will fall is very small (max is 0.1)
        //but will also will depends exponentially on confidence 
        //so if you double the confidence, the probability that it will fall is *2
        if (Math.random() < (0.1*lanes[i].getConfidence()/16))
        {
          lanes[i].fall();
          // Set horse icon to an X to indicate it has fallen
          horseSymbols[i]= new ImageIcon("C:\\Users\\hummu\\Documents\\Uni\\Year 1\\Semester B\\Object Oriented Programming\\Project\\HorseRaceSimulator\\Part2\\images\\cross.png").getImage();
        }
        
      }
    }
    repaint();
  }

}
