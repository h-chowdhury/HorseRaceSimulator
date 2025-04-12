import java.util.concurrent.TimeUnit;
import java.lang.Math;

/**
 * A variable-numbered horse race, each horse running in its own lane
 * for a given distance
 * 
 * @author Humayra Chowdhury
 * @version 2.0
 */
public class Race
{
    private int raceLength;
    private Horse[] laneHorses;

    /**
     * Constructor for objects of class Race
     * Initially there are no horses in the lanes
     * 
     * @param distance the length of the racetrack (in metres/yards...)
     */
    public Race(int distance, int noOfHorses)
    {
        // initialise instance variables
        raceLength = distance;
        laneHorses = new Horse[distance];
        for (int i=0; i<noOfHorses; i++) {
            laneHorses[i] = null;
        }
    }
    
    /**
     * Adds a horse to the race in a given lane
     * 
     * @param theHorse the horse to be added to the race
     * @param laneNumber the lane that the horse will be added to
     */
    public void addHorse(Horse theHorse, int laneNumber)
    {
        laneHorses[laneNumber+1] = theHorse;
    }
    
    /**
     * Start the race
     * The horse are brought to the start and
     * then repeatedly moved forward until the 
     * race is finished
     */
    public void startRace()
    {
        //declare a local variable to tell us when the race is finished
        boolean finished = false;
        
        //reset all the lanes (all horses not fallen and back to 0). 
        for (int i=0; i<laneHorses.length; i++) {
            laneHorses[i].goBackToStart();
        }
                      
        while (!finished)
        {
            //move each horse
            for (int i=0; i<laneHorses.length; i++) {
                moveHorse(laneHorses[i]);
            }
          
            //print the race positions
            printRace();

            
            //if any of the three horses has won the race is finished
            for (int i=0; i<laneHorses.length; i++) {
                if (raceWonBy(laneHorses[i]) == true) {
                    finished = true;
                    System.out.println("And the winner is... " + laneHorses[i].getName().toUpperCase() + "!");
                }
            }

            //if all of the three horses have fallen the race is finished
            boolean allHaveFallen = true;
            for (int i=0; i<laneHorses.length; i++) {
                if (laneHorses[i].hasFallen() != true) {
                    allHaveFallen = false;
                }  
            }

            if (allHaveFallen) {
                finished = true;
                System.out.println("All horses have fallen! There is no winner.");
            }

        
            //wait for 100 milliseconds
            try{ 
                TimeUnit.MILLISECONDS.sleep(100);
            }catch(Exception e){}
        }
    }
    
    /**
     * Randomly make a horse move forward or fall depending
     * on its confidence rating
     * A fallen horse cannot move
     * 
     * @param theHorse the horse to be moved
     */
    private void moveHorse(Horse theHorse)
    {
        //if the horse has fallen it cannot move, 
        //so only run if it has not fallen
        if  (!theHorse.hasFallen())
        {
            //the probability that the horse will move forward depends on the confidence;
            if (Math.random() < theHorse.getConfidence())
            {
               theHorse.moveForward();
            }
            
            //the probability that the horse will fall is very small (max is 0.1)
            //but will also will depends exponentially on confidence 
            //so if you double the confidence, the probability that it will fall is *2
            if (Math.random() < (0.1*theHorse.getConfidence()/4))
            {
                theHorse.fall();
            }
        }
    }
        
    /** 
     * Determines if a horse has won the race
     *
     * @param theHorse The horse we are testing
     * @return true if the horse has won, false otherwise.
     */
    private boolean raceWonBy(Horse theHorse)
    {
        if (theHorse.getDistanceTravelled() == raceLength)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /***
     * Print the race on the terminal
     */
    private void printRace()
    {
        System.out.print("\033\143");  //clear the terminal window
        
        multiplePrint('=',raceLength+3); //top edge of track
        System.out.println();

        for (int i=0; i<laneHorses.length; i++) {
            printLane(laneHorses[i]);
            System.out.println();
        }
        
        multiplePrint('=',raceLength+3); //bottom edge of track
        System.out.println();    
    }
    
    /**
     * print a horse's lane during the race
     * for example
     * |           X                      |
     * to show how far the horse has run
     */
    private void printLane(Horse theHorse)
    {
        //calculate how many spaces are needed before
        //and after the horse
        int spacesBefore = theHorse.getDistanceTravelled();
        int spacesAfter = raceLength - theHorse.getDistanceTravelled();
        
        //print a | for the beginning of the lane
        System.out.print('|');
        
        //print the spaces before the horse
        if (theHorse.getDistanceTravelled() == raceLength)
        {
            multiplePrint(' ',spacesBefore +1);
        }
        else {
            multiplePrint(' ',spacesBefore);
        }
        
        //if the horse has fallen then print dead
        //else print the horse's symbol
        if(theHorse.hasFallen() && theHorse.getDistanceTravelled() != raceLength)
        {
            System.out.print('X');
        }
        else
        {
            System.out.print(theHorse.getSymbol());
        }
        
        //print the spaces after the horse
        multiplePrint(' ',spacesAfter);
        
        //print the | for the end of the track
        if (theHorse.getDistanceTravelled() != raceLength)
        {
            System.out.print('|');
        }

        //print horse details
        System.out.print("   " + theHorse.getName().toUpperCase() + " (Current confidence " + theHorse.getConfidence() + ")");

    }
        
    
    /***
     * print a character a given number of times.
     * e.g. printmany('x',5) will print: xxxxx
     * 
     * @param aChar the character to Print
     */
    private void multiplePrint(char aChar, int times)
    {
        int i = 0;
        while (i < times)
        {
            System.out.print(aChar);
            i = i + 1;
        }
    }
}
