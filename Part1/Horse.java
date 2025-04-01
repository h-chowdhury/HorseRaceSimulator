/**
 * Defines the attributes and actions of a race horse.
 * 
 * @author Humayra Chowdhury
 * @version Version 1.3
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
    

} // END class Horse
