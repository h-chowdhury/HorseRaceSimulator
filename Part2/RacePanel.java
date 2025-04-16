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
 * @version Version 1.5
 */
public class RacePanel extends JPanel implements ActionListener {
  final int PANEL_HEIGHT = 620;
  final int PANEL_WIDTH = 1090;

  private RaceData raceData;
  private int numberOfHorses;
  private int trackLength;
  int FINISH_LINE_X;

  Image[] horseSymbols;
  Timer timer;

  int[] xVelocity = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
  int[] yVelocity = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
  int[] xPos = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
  int[] yPos = {5, 30, 55, 80, 105, 130, 155, 180, 205, 230, 255, 280, 305, 330, 355};

  RacePanel (RaceData RD) {

    raceData = RD;
    numberOfHorses = raceData.getNumberOfHorses();
    trackLength = raceData.getLengthOfTrack();
    horseSymbols = new Image[numberOfHorses];
    FINISH_LINE_X = (PANEL_WIDTH-60) * (trackLength/500); // PANEL_WIDTH-60 is full length (500m)

    this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    this.setBackground(Color.green);

    // set placeholder images into image array
    for (int i=0; i<numberOfHorses; i++) {
      horseSymbols[i]= new ImageIcon("C:\\Users\\hummu\\Documents\\Uni\\Year 1\\Semester B\\Object Oriented Programming\\Project\\HorseRaceSimulator\\Part2\\images\\placeholder.png").getImage();
    }

    timer = new Timer(100, this);
    timer.start();
  
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g); // paints bg
    Graphics2D g2D = (Graphics2D) g;

    // update each horse repeatedly
    for (int  i=0; i<numberOfHorses; i++) {
      g2D.drawImage(horseSymbols[i], xPos[i], yPos[i], null);
    }
    
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    // update each horses x position repeatedly
    for (int i=0; i<numberOfHorses; i++) {
      if (xPos[i]<= FINISH_LINE_X) {
        xPos[i] = xPos[i] + xVelocity[i];
      }
    }
    repaint();
  }

}
