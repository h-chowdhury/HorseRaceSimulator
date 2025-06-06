package Part2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class defines the launch window of the program
 * It currently acts as the main entry point.
 * 
 * @author Humayra Chowdhury
 * @version Version 1.7
 */
public class LaunchPage extends JFrame {
  
  public LaunchPage () {

    // Main frame
    JFrame frame = new JFrame();
    frame.setTitle("Eccentric Equestrian 2D"); 
    frame.setVisible(true); 
    frame.setSize(1500, 800);
    frame.setResizable(false); // prevents resizing window
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setBackground(Color.black);

    // Set window icon
    frame.setIconImage(new ImageIcon("Part2\\images\\windowIcon.png").getImage());
    

      // Title label
      JPanel titlePanel = new JPanel();
        JLabel title = new JLabel("Welcome to Eccentric Equestrian 2D!");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setFont(new Font("Dialog", Font.BOLD, 50));
      titlePanel.add(title);


      JPanel contentPanel = new JPanel();
      contentPanel.setLayout(new GridLayout(2, 1));

        // Description label
        JLabel description = new JLabel("<html><body>This simulation runs <br>a race on a set of horses.<br> As the user, you will be<br>able to customise the track<br>and design your own horses<br>to participate in the race.</body></html>");
        description.setHorizontalAlignment(JLabel.CENTER);
        description.setVerticalAlignment(JLabel.CENTER);
        description.setFont(new Font("Dialog", Font.BOLD, 25));

        // Start button
        JButton startButton = new JButton("Start Simulation");
        startButton.setSize(200, 100);
        startButton.setFont(new Font("Dialog", Font.BOLD, 30));

        // Start button function - redirects to track selection page
        startButton.addActionListener (new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            TrackSelection trackSelectionPage = new TrackSelection();
            trackSelectionPage.setVisible(true);
            frame.dispose();
          }
        });

      contentPanel.add(description);
      contentPanel.add(startButton);

    frame.add(titlePanel);
    frame.add(contentPanel);

  }

}

