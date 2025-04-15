package Part2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * This class defines the race panel.
 * The horse race will be displayed within this panel.
 * 
 * @author Humayra Chowdhury
 * @version Version 1.0
 */
public class RacePanel extends JPanel {
  final int PANEL_HEIGHT = 620;
  final int PANEL_WIDTH = 1090;


  RacePanel () {
    this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    this.setBackground(Color.red);

  
  }



  
}
