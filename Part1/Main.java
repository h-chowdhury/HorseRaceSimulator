/**
 * This is the main class of the program.
 * It currently acts as the main entry point.
 * 
 * @author Humayra Chowdhury
 * @version Version 1.3
 */
public class Main
{
  /**
   * Main method containing runs of Race class methods.
   * @param args An array of command-line arguments passed to the program.
   */
  public static void main(String[] args) 
  {
    // User input for all fields:
    InputHelper inputHelper = new InputHelper();

    System.out.println("Welcome to the Horse Race Simulator!\n");
    int distance = inputHelper.getPosInt("\nEnter the distance of the race (m): ");
    int noOfHorses = inputHelper.getPosInt("\nEnter the number of horses: ");

    // Create race object
    Race race = new Race(distance, noOfHorses);

    // Create Horse objects
    Horse horse;
    Horse[] horses = new Horse[noOfHorses];

    for (int i=0; i<noOfHorses; i++) {
      System.out.println("\n\nHORSE #" + ((int) i+1));
      char symbol = inputHelper.getChar("Enter the symbol representing the horse: ");
      String name = inputHelper.getString("Enter the horse's name: ");
      double confidence = inputHelper.getConfidence("Enter the horse's confidence (0-1): ");

      horse = new Horse(symbol, name, confidence);
      horses[i] = horse;
    }

    // Add horses to the race
    for (int i=0; i<noOfHorses; i++) {
      race.addHorse(horses[i], i+1);
    }

    // Start the race
    race.startRace();
  }

}