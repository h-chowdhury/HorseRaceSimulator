package Part2;

/**
 * Defines the attributes and actions of a race horse.
 * 
 * @author Humayra Chowdhury
 * @version Version 1.8
 */
public class Horse
{
    //Fields of class Horse
    private char horseSymbol;
    private final String horseName;
    private double horseConfidence;
    private int horseLane;
    private boolean fallen;

    private int xPos;
    private int yPos;
    private int xVelocity;
    private int yVelocity;


    // Constructor of class Horse
    /**
     * Constructor for objects of class Horse
     */
    public Horse(char horseSymbol, String horseName, double horseConfidence, int horseLane)
    {
       this.horseSymbol = horseSymbol;
       this.horseName = horseName;
       this.horseConfidence = horseConfidence;
       this.horseLane = horseLane;
       this.fallen = false;
    }
    
    
    /**
     * Marks the horse as fallen.
     */
    public void fall()
    {
        this.fallen = true;
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
     * Gets the horses X position.
     * @return A integer representing the horses X position.
     */
    public int getXpos()
    {
        return this.xPos;
    }


    /**
     * Gets the horses Y position.
     * @return A integer representing the horses Y position.
     */
    public int getYpos()
    {
        return this.yPos;
    }


    /**
     * Gets the horses X velocity.
     * @return A integer representing the horses X velocity.
     */
    public int getXVelocity()
    {
        return this.xVelocity;
    }


    /**
     * Gets the horses Y velocity.
     * @return A integer representing the horses Y velocity.
     */
    public int getYVelocity()
    {
        return this.yVelocity;
    }


    /**
     * Gets the lane the horse is riding in.
     * @return An integer representing the lane number.
     */
    public int getLane()
    {
        return this.horseLane;
    }
    

    /**
     * Resets the horse's distance travelled to 0.
     * Resets the horse's fallen state by default.
     */
    public void goBackToStart()
    {
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
     * Sets the lane the horse is riding in.
     * @param laneNumber An integer representing the lane number.
     */
    public void setLane(int laneNumber)
    {
        this.horseLane = laneNumber;
    }


    /**
     * Sets the horses X position.
     * @param A integer representing the horses X position.
     */
    public void setXpos(int x)
    {
        this.xPos = x;
    }


    /**
     * Sets the horses Y position.
     * @param A integer representing the horses Y position.
     */
    public void setYpos(int y)
    {
        this.yPos = y;
    }

    
    /**
     * Sets the horses X velocity.
     * @param A integer representing the horses X velocity.
     */
    public void setXVelocity(int x)
    {
        this.xVelocity = x;
    }


    /**
     * Sets the horses Y velocity.
     * @param A integer representing the horses Y velocity.
     */
    public void setYVelocity(int y)
    {
        this.yVelocity = y;
    }


} // END class Horse
