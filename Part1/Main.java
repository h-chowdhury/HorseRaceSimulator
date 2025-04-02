/**
 * This is the main class of the program.
 * It currently contains tests for Horse.
 * It will be repurposed in the future as the main entry point.
 * 
 * @author Humayra Chowdhury
 * @version Version 1.0
 */
public class Main
{
  /**
   * Main method containing tests for the Horse class
   * @param args An array of command-line arguments passed to the program.
   */
  public static void main(String[] args) 
  {
    // declaring a new Horse with test values
    Horse testHorse = new Horse('#', "Valkyrie", 0.8);


    // Various tests for all methods relating to class Horse

    // test fall() / hasFallen() / fallen
    System.out.println("\n\n// HORSE CLASS TESTS: fall(), hasFallen(), fallen");
    System.out.println("Initial state of fallen: " + testHorse.hasFallen());
    for (int i=1; i<=100; i++) {
      testHorse.moveForward();
    }
    System.out.println("State of fallen after moving 100 metres: " + testHorse.hasFallen());
    testHorse.fall();
    System.out.println("State of fallen after executing fall(): " + testHorse.hasFallen());
    testHorse.fall();
    testHorse.fall();
    testHorse.fall();
    System.out.println("State of fallen after executing fall() several times: " + testHorse.hasFallen());
    testHorse.goBackToStart();
    System.out.println("State of fallen after returning to start: " + testHorse.hasFallen());
    testHorse.fall();
    System.out.println("State of fallen after attempting to fall before horse moves: " + testHorse.hasFallen());


    // test getConfidence() / setConfidence()
    System.out.println("\n\n// HORSE CLASS TESTS: getConfidence(), setConfidence()");
    System.out.println("Initial value of confidence (0.8): " + testHorse.getConfidence());
    testHorse.setConfidence(0.7);
    System.out.println("Value of confidence when setting it to a valid double (0.7): " + testHorse.getConfidence());
    testHorse.setConfidence(5.5);
    System.out.println("Value of confidence when setting it to a invalid large double (5.5): " + testHorse.getConfidence());
    testHorse.setConfidence(-1.2);
    System.out.println("Value of confidence when setting it to a invalid small double (-1.2): " + testHorse.getConfidence());
    testHorse.setConfidence(1);
    System.out.println("Value of confidence when setting it to the upper boundary (1): " + testHorse.getConfidence());
    testHorse.setConfidence(0);
    System.out.println("Value of confidence when setting it to the lower boundary (0): " + testHorse.getConfidence());


    // test moveForward() / getDistanceTravelled()
    System.out.println("\n\n// HORSE CLASS TESTS: moveForward(), getDistanceTravelled()");
    testHorse.goBackToStart(); // reset distance to 0 from previous testing
    System.out.println("Value of distance at start of race: " + testHorse.getDistanceTravelled());
    testHorse.moveForward();
    System.out.println("Value of distance after executing moveForward() once (1 meter): " + testHorse.getDistanceTravelled());
    for (int i=1; i<100; i++) {
      testHorse.moveForward();
    }
    System.out.println("Value of distance executing moveForward() 99 times (100 metres total): " + testHorse.getDistanceTravelled());


    // test getName()
    System.out.println("\n\n// HORSE CLASS TESTS: getName()");
    System.out.println("Value of horseName (should output 'Valkyrie'): " + testHorse.getName());


    // test setSymbol() / getSymbol()
    System.out.println("\n\n// HORSE CLASS TESTS: setSymbol(), getSymbol()");
    System.out.println("Initial value of horseSymbol (#): " + testHorse.getSymbol());
    testHorse.setSymbol('@');
    System.out.println("Value of horseSymbol when setting it to a valid character (@): " + testHorse.getSymbol());
    

    // test goBackToStart()
    System.out.println("\n\n// HORSE CLASS TESTS: goBackToStart");
    System.out.println("Value of distance: " + testHorse.getDistanceTravelled());
    System.out.println("Value of fallen: " + testHorse.hasFallen());
    testHorse.fall();
    System.out.println("Value of fallen after fall() is executed: " + testHorse.hasFallen());
    testHorse.goBackToStart();
    System.out.println("Value of distance after goBackToStart() is executed: " + testHorse.getDistanceTravelled());
    System.out.println("Value of fallen after goBackToStart() is executed: " + testHorse.hasFallen());
    testHorse.goBackToStart();
    testHorse.goBackToStart();
    testHorse.goBackToStart();
    System.out.println("Value of distance after goBackToStart() is executed 3 times: " + testHorse.getDistanceTravelled());
    System.out.println("Value of fallen after goBackToStart() is executed 3 times: " + testHorse.hasFallen());

  }

}