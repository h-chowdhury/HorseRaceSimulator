package Part2;

/**
 * This is the main class of the program.
 * It currently acts as the main entry point.
 * 
 * @author Humayra Chowdhury
 * @version Version 1.2
 */
public class StartRaceGUI
{
  /**
   * Main method containing the run of startRaceGUI()
   * @param args An array of command-line arguments passed to the program.
   */
  public static void main(String[] args) 
  {
    startRaceGUI();
  }

   /**
   * Displays the launch page of the GUI
   */
  public static void startRaceGUI() {
    new LaunchPage();
  }

}
