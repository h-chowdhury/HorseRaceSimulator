package Part2;

import javax.swing.ImageIcon;

/**
 * Defines the attributes and actions of a race horse.
 * 
 * @author Humayra Chowdhury
 * @version Version 2.1
 */
public class Horse
{
    //Fields of class Horse
    private ImageIcon horseSymbol;
    private final String horseName;
    private double horseConfidence;
    private int horseLane;
    private boolean fallen;

    private int xPos;
    private int yPos;
    private double xVelocity;
    private double yVelocity;

    private HorseCustomisation horseCustomisation;


    // Constructor of class Horse
    /**
     * Constructor for objects of class Horse
     */
    public Horse(ImageIcon horseSymbol, String horseName, double horseConfidence, int horseLane)
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
    public ImageIcon getSymbol()
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
    public double getXVelocity()
    {
        return this.xVelocity;
    }


    /**
     * Gets the horses Y velocity.
     * @return A integer representing the horses Y velocity.
     */
    public double getYVelocity()
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
     * Gets the HorseCustomisation object belonging to the Horse.
     * @return A HorseCustomisation object.
     */
    public HorseCustomisation getHorseCustomisation () {
        return this.horseCustomisation;
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
    public void setSymbol(ImageIcon newSymbol)
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
     * @param x An integer representing the horses X position.
     */
    public void setXpos(int x)
    {
        this.xPos = x;
    }


    /**
     * Sets the horses Y position.
     * @param y Am integer representing the horses Y position.
     */
    public void setYpos(int y)
    {
        this.yPos = y;
    }

    
    /**
     * Sets the horses X velocity.
     * @param x An integer representing the horses X velocity.
     */
    public void setXVelocity(double x)
    {
        this.xVelocity = x;
    }


    /**
     * Sets the horses Y velocity.
     * @param y An integer representing the horses Y velocity.
     */
    public void setYVelocity(double y)
    {
        this.yVelocity = y;
    }


    /**
     * Sets the HorseCustomisation object belonging to the Horse.
     * @param HorseCustomisation A horseCustomisation object.
     */
    public void setHorseCustomisation (HorseCustomisation horseCustomisation) {
        this.horseCustomisation = horseCustomisation;
    }


} // END class Horse
