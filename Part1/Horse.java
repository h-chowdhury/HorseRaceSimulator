
/**
 * Horse defines the attributes and actions of a 
 * race horse. 
 * 
 * Horse attributes should only be accessed using 
 * the methods provided.
 * 
 * @author Humayra Chowdhury
 * @version Version 1.0 
 */
public class Horse
{
    //Fields of class Horse
    private char horseSymbol;
    private String horseName;
    private double horseConfidence;
    private int distanceTravelled;
    private boolean fallen;



    //Constructor of class Horse
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
    
    
    
    //Other methods of class Horse
    public void fall()
    {
        this.fallen = true;
        return;
    }
    
    public double getConfidence()
    {
        return this.horseConfidence;
    }
    
    public int getDistanceTravelled()
    {
        return this.distanceTravelled;
    }
    
    public String getName()
    {
        return this.horseName;
    }
    
    public char getSymbol()
    {
        return this.horseSymbol;
    }
    
    public void goBackToStart()
    {
        this.distanceTravelled = 0;
        return;
    }
    
    public boolean hasFallen()
    {
        return this.fallen;
    }

    public void moveForward()
    {
        this.distanceTravelled++;
        return;
    }

    public void setConfidence(double newConfidence)
    {
        this.horseConfidence = newConfidence;
        return;
    }
    
    public void setSymbol(char newSymbol)
    {
        this.horseSymbol = newSymbol;
        return;
    }
    
} // END class Horse
