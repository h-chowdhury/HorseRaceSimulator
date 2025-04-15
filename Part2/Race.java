package Part2;

import java.util.concurrent.TimeUnit;
import java.lang.Math;

/**
 * A variable-numbered horse race, each horse running in its own lane
 * for a given distance
 * 
 * @author Humayra Chowdhury
 * @version 3.1
 */
public class Race
{
    private int raceLength;
    private Horse[] laneHorses;
    private int laneCount;

    /**
     * Constructor for objects of class Race
     * Initially there are no horses in the lanes
     * 
     * @param RD the RaceData object holding information about the race
     * equal to or exceed the number of horses.
     */
    public Race(RaceData RD)
    {
        int distance = RD.getLengthOfTrack();
        int numberOfHorses = RD.getNumberOfHorses();
        int numberOfLanes = RD.getNumberOfLanes();
        
        // initialise instance variables
        raceLength = distance;
        laneHorses = new Horse[numberOfHorses];
        for (int i=0; i<numberOfHorses; i++) {
            laneHorses[i] = null;
        }
        laneCount = numberOfLanes;
    }
    
    /**
     * Adds a horse to the race in a given lane
     * 
     * @param theHorse the horse to be added to the race
     * @param laneNumber the lane that the horse will be added to
     */
    public void addHorse(Horse theHorse, int laneNumber)
    {
        laneHorses[laneNumber-1] = theHorse;
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
        resetLanes();
                      
        while (!finished)
        {
            //move each horse
            moveHorses();
          
            //print the race positions
            printRace();

            
            //if any of the horses has won the race is finished
            boolean anyWon = raceWonByAny();

            //if all of the three horses have fallen the race is finished
            boolean allFallen = allHaveFallen();

            if (allFallen || anyWon) {
                finished = true;
            }
        
            //wait for 100 milliseconds
            try{ 
                TimeUnit.MILLISECONDS.sleep(100);
            }catch(Exception e){}
        }
    }

    /***
     * Reset all lane horse distances to 0
     * Uses goBackToStart() method
     */
    private void resetLanes() {
        for (int i=0; i<laneHorses.length; i++) {
            laneHorses[i].goBackToStart();
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
            if (Math.random() < (0.1*theHorse.getConfidence()/16))
            {
                theHorse.fall();
            }
        }
    }

    /**
     * Randomly make all horses move forward or fall depending
     * on their confidence rating
     * Uses moveHorse() method
     */
    private void moveHorses () {
        for (int i=0; i<laneHorses.length; i++) {
            moveHorse(laneHorses[i]);
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

    /** 
     * Determines if any horse has won the race
     * Uses the raceWonBy method
     */
    private boolean raceWonByAny()
    {
        for (int i=0; i<laneHorses.length; i++) {
            if (raceWonBy(laneHorses[i]) == true) {
                System.out.println("And the winner is... " + laneHorses[i].getName().toUpperCase() + "!");
                return true;
            }
        }

        return false;
    }

    /** 
     * Determines if all horses have fallen
     * Ends the race if this is true.
     */
    private boolean allHaveFallen() {
        for (int i=0; i<laneHorses.length; i++) {
            if (laneHorses[i].hasFallen() != true) {
                return false;
            }  
        }

        System.out.println("All horses have fallen! There is no winner.");
        return true;
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

        if (laneCount > laneHorses.length) {
            for (int i=laneHorses.length; i<=laneCount; i++) {
                printLane(null);
                System.out.println();
            }
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
        // print blank lane
        if (theHorse == null) {
            //print a | for the beginning of the lane
            System.out.print('|');

            // print blank spaces
            multiplePrint(' ', raceLength + 1);

            // print a | for the end of the lane
            System.out.print('|');

        }
        else {
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

