/**
 * This is the main class of the program.
 * It currently acts as the main entry point.
 * 
 * @author Humayra Chowdhury
 * @version Version 1.1
 */
public class Main
{
  /**
   * Main method containing runs of Race class methods.
   * @param args An array of command-line arguments passed to the program.
   */
  public static void main(String[] args) 
  {
    // Create Race object of distance 20m
    Race race = new Race(20);

    // Create Horse objects
    Horse horse1 = new Horse('♞', "Valkyrie", 0.8);
    Horse horse2 = new Horse('♘', "Slow Dancer", 0.7);
    Horse horse3 = new Horse('♞', "Silver Bullet", 0.6);

    // Add horses to the race
    race.addHorse (horse1, 1);
    race.addHorse (horse2, 2);
    race.addHorse (horse3, 3);

    // Start the race
    race.startRace();
    
  }

}