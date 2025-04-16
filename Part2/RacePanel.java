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
 * @version Version 1.1
 */
public class RacePanel extends JPanel implements ActionListener {
  final int PANEL_HEIGHT = 620;
  final int PANEL_WIDTH = 1090;

  Image horse;
  Timer timer;

  int x = 0;
  int y = 0;

  RacePanel () {
    this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    this.setBackground(Color.green);

    horse = new ImageIcon("C:\\Users\\hummu\\Documents\\Uni\\Year 1\\Semester B\\Object Oriented Programming\\Project\\HorseRaceSimulator\\Part2\\images\\placeholder.png").getImage();
    timer = new Timer(100, this);
    timer.start();
  
  }

  public void paint(Graphics g) {
    super.paint(g); // paints bg
    Graphics2D g2D = (Graphics2D) g;
    g2D.drawImage(horse, x, y, null);
    

  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }

}
