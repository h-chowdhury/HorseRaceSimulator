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
import javax.swing.SpinnerNumberModel;

/**
 * This class defines the horse selection window of the program.
 * 
 * @author Humayra Chowdhury
 * @version Version 4.3
 */
public class HorseSelection extends JFrame {

  private RaceData raceData;
  private int numberOfLanes;
  private int numberOfHorses;

  JLabel saddleImageIcon;
  JLabel horseshoeImageIcon;
  JLabel accessoryImageIcon;
  JLabel horseImageIcon;

  JLabel horseImageFull;
  JLabel saddleImageFull;
  JLabel accessoryImageFull;

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

      // Create images to place icons in
      saddleImageIcon = new JLabel(new ImageIcon());
      horseshoeImageIcon = new JLabel(new ImageIcon());
      accessoryImageIcon = new JLabel(new ImageIcon());
      horseImageIcon = new JLabel(new ImageIcon());

      saddleImageIcon.setSize(260, 205);
      horseshoeImageIcon.setSize(260, 205);
      accessoryImageIcon.setSize(260, 205);
      horseImageIcon.setSize(260, 205);
      
      // Set default images for icons
      rightColumnPanel.add(saddleImageIcon);
      saddleImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-saddleRed.png")); // default

      rightColumnPanel.add(horseshoeImageIcon);
      horseshoeImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-horseshoeRusty.png")); // default

      rightColumnPanel.add(accessoryImageIcon);
      accessoryImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-accessoryRed.png")); // default

      rightColumnPanel.add(horseImageIcon);
      horseImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-arabianBlack.png")); // default

    this.add(rightColumnPanel, BorderLayout.EAST);



    // Center panel
    JPanel centerPanel = new JPanel();
    centerPanel.setLayout(null);
    centerPanel.setPreferredSize(new Dimension(100, 100));

      // Create images to place horse body in
      saddleImageFull = new JLabel(new ImageIcon());
      saddleImageFull.setBounds(-90, -90, 1075, 820);

      accessoryImageFull = new JLabel(new ImageIcon());
      accessoryImageFull.setBounds(-90, -90, 1075, 820);

      horseImageFull = new JLabel(new ImageIcon());
      horseImageFull.setBounds(-90, -90, 1075, 820);

      // Set default images
      saddleImageFull.setIcon(new ImageIcon("Part2\\images\\full-saddleRed.png"));
      accessoryImageFull.setIcon(new ImageIcon("Part2\\images\\full-accessoryRed.png"));
      horseImageFull.setIcon(new ImageIcon("Part2\\images\\arabianBlack.png"));

      centerPanel.add(saddleImageFull);
      centerPanel.add(accessoryImageFull);
      centerPanel.add(horseImageFull);

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



          // Add action listeners for breed buttons
          b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // display arabian horse icon and body
              if (h1.isSelected()) 
              { // black hair
                horseImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-arabianBlack.png"));
                horseImageFull.setIcon(new ImageIcon("Part2\\images\\arabianBlack.png"));
              } 
              else if (h2.isSelected()) 
              { // brown hair 
                horseImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-arabianBrown.png"));
                horseImageFull.setIcon(new ImageIcon("Part2\\images\\arabianBrown.png"));
              } 
              else if (h3.isSelected()) 
              { // blonde hair
                horseImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-arabianBlonde.png"));
                horseImageFull.setIcon(new ImageIcon("Part2\\images\\arabianBlonde.png"));
              } 
            }
          });

          b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // display mustang horse icon and body
              if (h1.isSelected()) 
              { // black hair
                horseImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-mustangBlack.png"));
                horseImageFull.setIcon(new ImageIcon("Part2\\images\\mustangBlack.png"));
              }
              else if (h2.isSelected()) 
              { // brown hair 
                horseImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-mustangBrown.png"));
                horseImageFull.setIcon(new ImageIcon("Part2\\images\\mustangBrown.png"));
              } 
              else if (h3.isSelected()) 
              { // blonde hair
                horseImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-mustangBlonde.png"));
                horseImageFull.setIcon(new ImageIcon("Part2\\images\\mustangBlonde.png"));
              } 
            }
          });

          b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // display friesan horse icon and body
              if (h1.isSelected()) 
              { // black hair
                horseImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-friesanBlack.png"));
                horseImageFull.setIcon(new ImageIcon("Part2\\images\\friesanBlack.png"));
              }
              else if (h2.isSelected()) 
              { // brown hair 
                horseImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-friesanBrown.png"));
                horseImageFull.setIcon(new ImageIcon("Part2\\images\\friesanBrowm.png"));
              }
              else if (h3.isSelected()) 
              { // blonde hair
                horseImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-friesanBlonde.png"));
                horseImageFull.setIcon(new ImageIcon("Part2\\images\\friesanBlonde.png"));
              } 
            }
          });



          // Add action listeners for hair colour buttons
            h1.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                // display black hair horse icon and body
                if (b1.isSelected()) 
                { // arabian horse
                  horseImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-arabianBlack.png"));
                  horseImageFull.setIcon(new ImageIcon("Part2\\images\\arabianBlack.png"));
                }
                else if (b2.isSelected()) 
                { // mustang horse
                  horseImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-mustangBlack.png"));
                  horseImageFull.setIcon(new ImageIcon("Part2\\images\\mustangBlack.png"));
                } 
                else if (b3.isSelected()) 
                { // friesan horse
                  horseImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-friesanBlack.png"));
                  horseImageFull.setIcon(new ImageIcon("Part2\\images\\friesanBlack.png"));
                } 
              }
             });

            h2.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                // display brown hair horse icon and body
                if (b1.isSelected()) 
                { // arabian horse
                  horseImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-arabianBrown.png"));
                  horseImageFull.setIcon(new ImageIcon("Part2\\images\\arabianBrown.png"));
                } // mustang horse
                else if (b2.isSelected()) 
                {
                  horseImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-mustangBrown.png"));
                  horseImageFull.setIcon(new ImageIcon("Part2\\images\\mustangBrown.png"));
                } 
                else if (b3.isSelected()) 
                { // friesan horse
                  horseImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-friesanBrown.png"));
                  horseImageFull.setIcon(new ImageIcon("Part2\\images\\friesanBrown.png"));
                } 
              }
            });

            h3.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                // display blonde hair horse icon and body
                if (b1.isSelected()) 
                { // arabian horse
                  horseImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-arabianBlonde.png"));
                  horseImageFull.setIcon(new ImageIcon("Part2\\images\\arabianBlonde.png"));
                }
                else if (b2.isSelected()) 
                { // mustang horse
                  horseImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-mustangBlonde.png"));
                  horseImageFull.setIcon(new ImageIcon("Part2\\images\\mustangBlonde.png"));
                } 
                else if (b3.isSelected()) 
                { // friesan horse
                  horseImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-friesanBlonde.png"));
                  horseImageFull.setIcon(new ImageIcon("Part2\\images\\friesanBlonde.png"));
                } 
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
          JRadioButton s1 = new JRadioButton("Blaze"); // +5% speed
          JRadioButton s2 = new JRadioButton("Geo"); // +10% stability
          JRadioButton s3 = new JRadioButton("Wind"); // +10% speed -5% stability
          s1.setToolTipText("Invigorates the horses inner flame. \n+5% speed");
          s2.setToolTipText("Enhances the horses footing with the power of soil.\n+10% stability");
          s3.setToolTipText("Embraces the vigorous winds at a cost.\n+10% speed, -5% stability");
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
              saddleImageFull.setIcon(new ImageIcon("Part2\\images\\full-saddleRed.png"));
            }
          });

          s2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // display verdant saddle icon
              saddleImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-saddleGreen.png"));

              // display verdant saddle on horse body
              saddleImageFull.setIcon(new ImageIcon("Part2\\images\\full-saddleGreen.png"));
            }
          });

          s3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // display azure saddle icon
              saddleImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-saddleBlue.png"));
              
              // display azure saddle on horse body
              saddleImageFull.setIcon(new ImageIcon("Part2\\images\\full-saddleBlue.png"));
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
          hs1.setToolTipText("An old, but trustworthy racing companion.\n+10% stability");
          hs2.setToolTipText("A mediocre but sturdy component.\n+5% speed");
          hs3.setToolTipText("Worn by the fastest, but comes at a cost.\n+10% speed, -5% stability");
          hs1.setSelected(true);
          horseshoeButtons.add(hs1);
          horseshoeButtons.add(hs2);
          horseshoeButtons.add(hs3);


        // Add action listeners for horseshoe buttons
          hs1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // display Rusted horseshoe icon
              horseshoeImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-horseshoeRusty.png"));
            }
          });

          hs2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // display Silver horseshoe icon
              horseshoeImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-horseshoeSilver.png"));
            }
          });

          hs3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // display Golden horseshoe icon
              horseshoeImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-horseshoeGolden.png"));
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
          JRadioButton p1 = new JRadioButton("Ruby Patch"); // +5% speed for the whole race
          JRadioButton p2 = new JRadioButton("Emerald Patch"); // +10% chance each second to move forward
          JRadioButton p3 = new JRadioButton("Sapphire Patch"); // +5% chance each second to ignore falls
          p1.setToolTipText("+5% speed for the whole race");
          p2.setToolTipText("+10% chance each second to move forward");
          p3.setToolTipText("+5% chance each second to ignore falls");
          p1.setSelected(true);
          powerupButtons.add(p1);
          powerupButtons.add(p2);
          powerupButtons.add(p3);


        // Add action listeners for powerup buttons
          p1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // display Ruby Patch icon
              accessoryImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-accessoryRed.png"));

              // display Ruby Patch on horse body
              accessoryImageFull.setIcon(new ImageIcon("Part2\\images\\full-accessoryRed.png"));
            }
          });

          p2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // display Emerald Patch icon
              accessoryImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-accessoryGreen.png"));

              // display Emerald Patch on horse body
              accessoryImageFull.setIcon(new ImageIcon("Part2\\images\\full-accessoryGreen.png"));
            }
          });

          p3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // display Sapphire Patch icon
              accessoryImageIcon.setIcon(new ImageIcon("Part2\\images\\icon-accessoryBlue.png"));

              // display Sapphire Patch on horse body
              accessoryImageFull.setIcon(new ImageIcon("Part2\\images\\full-accessoryBlue.png"));
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

          ImageIcon symbol = (ImageIcon) horseImageIcon.getIcon();

          // Resize symbol
          Image scaledSymbol = symbol.getImage().getScaledInstance(65, 51, Image.SCALE_SMOOTH);
          symbol = new ImageIcon(scaledSymbol);
      
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
              breedInput = "Friesan"; // -5% speed, +10% stability
              horse.setXVelocity(horse.getXVelocity() * 0.95);
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
              saddleInput = "Blaze"; // +5% speed
              horse.setXVelocity(horse.getXVelocity() * 1.05);

            } else if (s2.isSelected()) {
              saddleInput = "Geo"; // +10% stability
              //

            } else if (s3.isSelected()) {
              saddleInput = "Wind"; // +10% speed -5% stability
              horse.setXVelocity(horse.getXVelocity() * 1.1);

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
              accessoryInput = "Ruby Patch"; // +5% speed
              horse.setXVelocity(horse.getXVelocity() * 1.05);

            } else if (p2.isSelected()) {
              accessoryInput = "Emerald Patch";  // +10% chance each second of moving forward

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
