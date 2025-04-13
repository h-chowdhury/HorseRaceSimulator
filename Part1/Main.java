import java.util.Scanner;

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
    // User input for all fields:
    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to the Horse Race Simulator!\n");

    System.out.println("\nEnter the distance of the race (m): ");
    int distance = Integer.parseInt(scanner.nextLine());

    System.out.println("\nEnter the number of horses: ");
    int noOfHorses = Integer.parseInt(scanner.nextLine());


    // Create race object
    Race race = new Race(distance, noOfHorses);


    // Create Horse objects
    Horse horse;
    Horse[] horses = new Horse[noOfHorses];

    for (int i=0; i<noOfHorses; i++) {
      System.out.println("\n\nHORSE #" + ((int) i+1));
      System.out.println("Enter the symbol representing the horse: ");
      char symbol = scanner.nextLine().charAt(0);

      System.out.println("Enter the horse's name: ");
      String name = scanner.nextLine();

      System.out.println("Enter the horse's confidence (0-1): ");
      double confidence = Double.parseDouble(scanner.nextLine());

      horse = new Horse(symbol, name, confidence);
      horses[i] = horse;
    }


    // Add horses to the race
    for (int i=0; i<noOfHorses; i++) {
      race.addHorse(horses[i], i);
    }

    // Start the race
    race.startRace();
  }
}