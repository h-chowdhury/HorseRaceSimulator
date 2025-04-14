package Part2;

/**
 * Defines the attributes and actions of a race horse.
 * 
 * @author Humayra Chowdhury
 * @version Version 1.4
 */
public class Horse
{
    //Fields of class Horse
    private char horseSymbol;
    private final String horseName;
    private double horseConfidence;
    private int distanceTravelled;
    private boolean fallen;


    // Constructor of class Horse
    /**
     * Constructor for objects of class Horse
     */
    public Horse(char horseSymbol, String horseName, double horseConfidence)
    {
       this.horseSymbol = horseSymbol;
       this.horseName = horseName;
       this.horseConfidence = horseConfidence;
       this.distanceTravelled = 0;
       this.fallen = false;
    }
    
    
    /**
     * Marks the horse as fallen.
     */
    public void fall()
    {
        if (this.distanceTravelled != 0)
        {
            this.fallen = true;
        }
    }
    

    /**
     * Gets the horse's confidence level.
     * @return A double representing the horse's confidence level.
     */
    public double getConfidence()
    {
        return this.horseConfidence;
    }


    /**
     * Gets the distance travelled by the horse.
     * @return An integer representing the distance travelled in metres.
     */
    public int getDistanceTravelled()
    {
        return this.distanceTravelled;
    }

    
    /**
     * Gets the name of the horse.
     * @return A String representing the horse's name.
     */
    public String getName()
    {
        return this.horseName;
    }
    

    /**
     * Gets the symbol representing the horse.
     * @return A char symbol representing the horse.
     */
    public char getSymbol()
    {
        return this.horseSymbol;
    }
    

    /**
     * Resets the horse's distance travelled to 0.
     * Resets the horse's fallen state by default.
     */
    public void goBackToStart()
    {
        this.distanceTravelled = 0;
        this.fallen = false;
    }
    

    /**
     * Gets the status of the horse.
     * @return A boolean representing true if the horse has fallen
     * and false if otherwise.
     */
    public boolean hasFallen()
    {
        return this.fallen;
    }


    /**
     * Increments the horse's distance travelled by 1 metre.
     */
    public void moveForward()
    {
        this.distanceTravelled++;
    }


    /**
     * Sets the horse's confidence level to a new value between 0 and 1.
     * @param newConfidence The new confidence level.
     */
    public void setConfidence(double newConfidence)
    {
        if (newConfidence > 0 && newConfidence < 1) {
            this.horseConfidence = newConfidence;
        }
    }
    

    /**
     * Sets the symbol representing the horse to a new character.
     * @param newSymbol The new representing symbol.
     */
    public void setSymbol(char newSymbol)
    {
        this.horseSymbol = newSymbol;
    }
    

    /**
     * Temporary main method for testing the Horse class.
     * It creates a Horse object and tests all methods of the class.
     * @param args Command-line arguments (not used).
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

} // END class Horse
