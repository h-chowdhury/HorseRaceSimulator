package Part2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

/**
 * This class defines the horse selection window of the program.
 * 
 * @author Humayra Chowdhury
 * @version Version 4.0
 */
public class HorseSelection extends JFrame {

  private RaceData raceData;
  private int numberOfLanes;
  private int numberOfHorses;

  JLabel saddleImageIcon;
  JLabel horseshoeImageIcon;
  JLabel accessoryImageIcon;
  JLabel horseImageIcon;

  /**
   * Constructor of HorseSelection
   */
  public HorseSelection(RaceData RD) {

    // Storing the selection values from previous page
    raceData = RD;
    numberOfLanes = raceData.getNumberOfLanes();
    numberOfHorses = raceData.getNumberOfHorses();

    // Creating main frame
    this.setTitle("Horse Racing Simulator - Horse Selection"); 
    this.setSize(1500, 800);
    this.setResizable(false); // prevents resizing window
    this.getContentPane().setBackground(Color.white);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout(5, 5));

      // Set window icon
      this.setIconImage(new ImageIcon("Part2\\images\\windowIcon.png").getImage());
  


    // Title panel
    JPanel titlePanel = new JPanel();
    titlePanel.setLayout(new BorderLayout());
    titlePanel.setPreferredSize(new Dimension(100, 100));
    titlePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    JLabel title = new JLabel("Horse Customisation [" + (((int) raceData.getHorsesProcessed()) + 1) + "/" + numberOfHorses + "]");
    title.setFont(new Font("Dialog", Font.BOLD, 50));

      // Submit button
      JButton submitButton = new JButton("Submit");
      submitButton.setSize(200, 100);
      submitButton.setFont(new Font("Dialog", Font.BOLD, 30));

    titlePanel.add(title, BorderLayout.CENTER);
    titlePanel.add(submitButton, BorderLayout.EAST);

    this.add(titlePanel, BorderLayout.NORTH);



    // Right column
    JPanel rightColumnPanel = new JPanel();
    rightColumnPanel.setPreferredSize(new Dimension(235, 100));
    rightColumnPanel.setLayout(new GridLayout(4, 1));

    saddleImageIcon = new JLabel(new ImageIcon());
    horseshoeImageIcon = new JLabel(new ImageIcon());
    accessoryImageIcon = new JLabel(new ImageIcon());
    horseImageIcon = new JLabel(new ImageIcon());
    
    rightColumnPanel.add(saddleImageIcon);
    saddleImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-saddleRed.png")); // default

    rightColumnPanel.add(horseshoeImageIcon);
    rightColumnPanel.add(accessoryImageIcon);
    rightColumnPanel.add(horseImageIcon);

    this.add(rightColumnPanel, BorderLayout.EAST);



    // Center panel
    JPanel centerPanel = new JPanel();
    centerPanel.setPreferredSize(new Dimension(100, 100));

    this.add(centerPanel, BorderLayout.CENTER);

    this.setVisible(true); 




    // Left column
    JPanel leftColumnPanel = new JPanel(); 
    leftColumnPanel.setPreferredSize(new Dimension(365, 100));
    leftColumnPanel.setLayout(new GridLayout(4, 2, 30, 10));
    leftColumnPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

      // Name input
      JPanel nameBox = new JPanel();
      nameBox.setLayout(new GridLayout(2, 1));
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        JTextArea nameInput = new JTextArea();
        nameInput.setSize(20, 5);
      nameBox.add(nameLabel);
      nameBox.add(nameInput);


      // Confidence input
      JPanel confidenceBox = new JPanel();
      confidenceBox.setLayout(new GridLayout(2, 1));
        JLabel confidenceLabel = new JLabel("Confidence");
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
        JLabel laneLabel = new JLabel("Lane");
        laneLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        JSpinner laneInput = new JSpinner(new SpinnerNumberModel(1, 1, numberOfLanes, 1));
        
        // Prevent user from directly typing in the lane
        JComponent editor2 = laneInput.getEditor();
        JFormattedTextField tf2 = ((JSpinner.DefaultEditor) editor2).getTextField();
        tf2.setEditable(false);

      laneBox.add(laneLabel);
      laneBox.add(laneInput);


      // Breed input
      JPanel breedBox = new JPanel();
      breedBox.setLayout(new GridLayout(5, 1));

        JLabel breedLabel = new JLabel("Breed");
        breedLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

        ButtonGroup breedButtons = new ButtonGroup();
          JRadioButton b1 = new JRadioButton("Arabian"); // +10% speed
          JRadioButton b2 = new JRadioButton("Mustang"); // +5% stability
          JRadioButton b3 = new JRadioButton("Friesan"); // -5% speed, +10% stability
          b1.setToolTipText("+10% speed");
          b2.setToolTipText("+5% stability");
          b3.setToolTipText("-5% speed, +10% stability");
          b1.setSelected(true);
          breedButtons.add(b1);
          breedButtons.add(b2);
          breedButtons.add(b3);


          // Add action listeners for breed buttons
            b1.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                  // placeholder for Arabian
              }
            });
            b2.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                  // placeholder for Mustang
              }
            });
            b3.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                  // placeholder for Friesan
              }
            });

      
        breedBox.add(breedLabel);
        breedBox.add(b1);
        breedBox.add(b2);
        breedBox.add(b3);


      // Hair colour input
      JPanel hairBox = new JPanel();
      hairBox.setLayout(new GridLayout(5, 1));

        JLabel hairLabel = new JLabel("Hair colour");
        hairLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

        ButtonGroup hairButtons = new ButtonGroup();
          JRadioButton h1 = new JRadioButton("Black");
          JRadioButton h2 = new JRadioButton("Brown");
          JRadioButton h3 = new JRadioButton("Blonde");
          h1.setSelected(true);
          hairButtons.add(h1);
          hairButtons.add(h2);
          hairButtons.add(h3);


          // Add action listeners for hair colour buttons
            h1.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                  // placeholder for Black hair
              }
            });
            h2.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                  // placeholder for Brown hair
              }
            });
            h3.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                  // placeholder for Blonde hair
              }
            });

      
        hairBox.add(hairLabel);
        hairBox.add(h1);
        hairBox.add(h2);
        hairBox.add(h3);


      // Saddle input
      JPanel saddleBox = new JPanel();
      saddleBox.setLayout(new GridLayout(5, 1));

        JLabel saddleLabel = new JLabel("Saddle");
        saddleLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

        ButtonGroup saddleButtons = new ButtonGroup();
          JRadioButton s1 = new JRadioButton("Crimson"); // +5% speed, -5% stability
          JRadioButton s2 = new JRadioButton("Verdant"); // +10% speed
          JRadioButton s3 = new JRadioButton("Azure"); // -5% speed, +10% stability
          s1.setToolTipText("+5% speed, -5% stability");
          s2.setToolTipText("+10% speed");
          s3.setToolTipText("-5% speed, +10% stability");
          s1.setSelected(true);
          saddleButtons.add(s1);
          saddleButtons.add(s2);
          saddleButtons.add(s3);


        // Add action listeners for saddle buttons
          s1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // display crimson saddle icon
                saddleImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-saddleRed.png"));

                // display crimson saddle on horse body
            }
          });
          s2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // display verdant saddle icon
                saddleImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-saddleGreen.png"));

                // display verdant saddle on horse body
            }
          });
          s3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // display azure saddle icon
                saddleImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-saddleBlue.png"));
                // display azure saddle on horse body
            }
          });

      
      saddleBox.add(saddleLabel);
      saddleBox.add(s1);
      saddleBox.add(s2);
      saddleBox.add(s3);


      // Horseshoe input
      JPanel horseshoeBox = new JPanel();
      horseshoeBox.setLayout(new GridLayout(5, 1));

        JLabel horseshoeLabel = new JLabel("Horseshoe");
        horseshoeLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

        ButtonGroup horseshoeButtons = new ButtonGroup();
          JRadioButton hs1 = new JRadioButton("Rusted"); // +10% stability
          JRadioButton hs2 = new JRadioButton("Silver"); // +5% speed
          JRadioButton hs3 = new JRadioButton("Golden"); // +10% speed, -5% stability
          hs1.setToolTipText("+10% stability");
          hs2.setToolTipText("+5% speed");
          hs3.setToolTipText("+10% speed, -5% stability");
          hs1.setSelected(true);
          horseshoeButtons.add(hs1);
          horseshoeButtons.add(hs2);
          horseshoeButtons.add(hs3);


        // Add action listeners for horseshoe buttons
          hs1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // placeholder for Rusted horseshoe
            }
          });
          hs2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // placeholder for Silver horseshoe
            }
          });
          hs3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // placeholder for Golden horseshoe
            }
          });
      

        horseshoeBox.add(horseshoeLabel);
        horseshoeBox.add(hs1);
        horseshoeBox.add(hs2);
        horseshoeBox.add(hs3);

    
      // Powerup input
      JPanel powerupBox = new JPanel();
      powerupBox.setLayout(new GridLayout(5, 1));

        JLabel powerupLabel = new JLabel("Power up");
        powerupLabel.setFont(new Font("Dialog", Font.PLAIN, 15));

        ButtonGroup powerupButtons = new ButtonGroup();
          JRadioButton p1 = new JRadioButton("Ruby Patch"); // +20% speed for first 3 seconds
          JRadioButton p2 = new JRadioButton("Emerald Patch"); // Cancel one fall during the race
          JRadioButton p3 = new JRadioButton("Sapphire Patch"); // +5% chance each second to ignore falls
          p1.setToolTipText("+20% speed for first 3 seconds of the race");
          p2.setToolTipText("Cancel one fall during the race");
          p3.setToolTipText("+5% chance each second to ignore falls");
          p1.setSelected(true);
          powerupButtons.add(p1);
          powerupButtons.add(p2);
          powerupButtons.add(p3);


        // Add action listeners for powerup buttons
          p1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // placeholder for Ruby Patch
            }
          });
          p2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // placeholder for Emerald Patch
            }
          });
          p3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // placeholder for Sapphire Patch
            }
          });
          
      
        powerupBox.add(powerupLabel);
        powerupBox.add(p1);
        powerupBox.add(p2);
        powerupBox.add(p3);


    leftColumnPanel.add(nameBox);
    leftColumnPanel.add(hairBox);
    leftColumnPanel.add(confidenceBox);
    leftColumnPanel.add(saddleBox);
    leftColumnPanel.add(laneBox);
    leftColumnPanel.add(horseshoeBox);
    leftColumnPanel.add(breedBox);
    leftColumnPanel.add(powerupBox);

    this.add(leftColumnPanel, BorderLayout.WEST);



    /* 
     * Function for submit button.
     * Stores customisation data in a Horse object.
     * Allows for storage of Horses in a RaceData object.
     * Passes this object and data to RaceDisplay.
     */
    submitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed (ActionEvent e) {
        // Check if chosen lane is taken OR name is empty
        if ((raceData.getLanes(((int) laneInput.getValue()) - 1)) != null || nameInput.getText().trim().isEmpty()) {

          // If chosen lane is taken, display error
          if ((raceData.getLanes(((int) laneInput.getValue()) - 1)) != null) {
            javax.swing.JOptionPane.showMessageDialog(null, 
            "The chosen lane has already been filled. Please enter a different lane.",
            "Invalid Input", javax.swing.JOptionPane.WARNING_MESSAGE);
        
            // Re-enable the button since submission was stopped
            submitButton.setEnabled(true);
            return;
          }
          // If name is empty, display error
          else if (nameInput.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, 
            "Please enter a name.",
            "Invalid Input", javax.swing.JOptionPane.WARNING_MESSAGE);
        
            // Re-enable the button since submission was stopped
            submitButton.setEnabled(true);
            return;
          }
        } else {  // If all inputs are valid

          // Store horse data in variables
          String horseName = nameInput.getText();
          double horseConfidence = (double) confidenceInput.getValue();
          horseConfidence = Math.round(horseConfidence * 100.0) / 100.0;
          int horseLane = (int) laneInput.getValue();

          // Placeholder image
          ImageIcon symbol = new ImageIcon("Part2\\images\\placeholder.png");
          
          // Create horse object
          Horse horse = new Horse(symbol, horseName, horseConfidence, horseLane);
          
          // Store customisation data

            // Store breed
            String breedInput = null;
            if (b1.isSelected()) { 
              breedInput = "Arabian"; // +10% speed
              horse.setXVelocity(horse.getXVelocity() * 1.1);

            } else if (b2.isSelected()) {
              breedInput = "Mustang"; // +5% stability

            } else if (b3.isSelected()) {
              breedInput = "Friesan"; // -5% stability

            }

            // Store hair colour
            String hairInput = null;
            if (h1.isSelected()) {
              hairInput = "Black";
            } else if (h2.isSelected()) {
              hairInput = "Brown";
            } else if (h3.isSelected()) {
              hairInput = "Blonde";
            }

            // Store saddle type
            String saddleInput = null;
            if (s1.isSelected()) {
              saddleInput = "Crimson"; // +5% speed, -5% stability
              horse.setXVelocity(horse.getXVelocity() * 1.05);

            } else if (s2.isSelected()) {
              saddleInput = "Verdant"; // +10% speed
              horse.setXVelocity(horse.getXVelocity() * 1.1);

            } else if (s3.isSelected()) {
              saddleInput = "Azure"; // -5% speed, +10% stability
              horse.setXVelocity(horse.getXVelocity() * 0.9);

            }

            // Store horseshoe type
            String horseshoeInput = null;
            if (hs1.isSelected()) {
              horseshoeInput = "Rusted"; // +10% stability

            } else if (hs2.isSelected()) {
              horseshoeInput = "Silver"; // +5% speed
              horse.setXVelocity(horse.getXVelocity() * 1.05);

            } else if (hs3.isSelected()) {
              horseshoeInput = "Golden"; // +10% speed, -5% stability
              horse.setXVelocity(horse.getXVelocity() * 1.1);

            }

            // Store powerup
            String accessoryInput = null;
            if (p1.isSelected()) {
              accessoryInput = "Ruby Patch"; // +20% speed for first 3 seconds

            } else if (p2.isSelected()) {
              accessoryInput = "Emerald Patch";  // Cancel one fall during the race

            } else if (p3.isSelected()) {
              accessoryInput = "Sapphire Patch"; // +5% chance each second to ignore falls

            }

          // Create and store horseCustomisation object
          HorseCustomisation horseCustomisation = new HorseCustomisation(horse, breedInput, hairInput, saddleInput, horseshoeInput, accessoryInput);
          horse.setHorseCustomisation(horseCustomisation);

          // Assign horse to lane
          raceData.setLanes(horse, horseLane-1);
          raceData.increaseHorsesProcessed();
  
          // Display new HorseSelection window for each horse
          if (raceData.getHorsesProcessed() < numberOfHorses) {
            HorseSelection horseSelectionPage = new HorseSelection(raceData);
            horseSelectionPage.setVisible(true);
            dispose();
          } else {
            // Redirect to RaceDisplay window when all horses are processed
            submitButton.setEnabled(false);
            RaceDisplay raceDisplayPage = new RaceDisplay(raceData);
            raceDisplayPage.setVisible(true);
            dispose();
          }

        }
      }
    });

  }

}
