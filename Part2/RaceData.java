package Part2;

/**
 * This class defines the variables involved in a race.
 * It stores the data which can be accessed with getters
 * and setters.
 * 
 * @author Humayra Chowdhury
 * @version Version 1.6
 */
public class RaceData {
  private int numberOfHorses;
  private int lengthOfTrack;
  private int numberOfLanes;
  // private String trackShape;
  // private String weather;
  private Horse[] lanes;
  private int horsesProcessed = 0;

  
  // Getters

  /**
   * Gets the number of horses in the race.
   * @return An integer representing the number of horses.
   */
  public int getNumberOfHorses() {
    return numberOfHorses;
  }


  /**
   * Gets the length of the track.
   * @return An integer representing the length of the 
   * race track in metres.
   */
  public int getLengthOfTrack() {
      return lengthOfTrack;
  }


  /**
   * Gets the number of lanes on the race track.
   * @return An integer representing the number of lanes 
   * on the track.
   */
  public int getNumberOfLanes() {
      return numberOfLanes;
  }


  /**
   * Gets an item stored in the lanes array.
   * @param index The index the item is to be found in the array.
   * @return An object of type Horse, or null.
   */
  public Horse getLanes(int index) {
    return lanes[index];
  }


  /** 
   * Gets the lanes array.
   * @return An array of type Horse.
   */
  public Horse[] getLanesArray() {
    return lanes;
  }
  

  /* public String getTrackShape() {
      return trackShape;
  } */


  /* public String getWeather() {
      return weather;
  } */


  /** 
   * Gets the number of horses that have been processed.
   * Used in tracking how many new horseSelection windows are displayed.
   * @return An integer representing the number of processed horses.
   */
  public int getHorsesProcessed () {
      return horsesProcessed;
  }


  // Setters

   /**
   * Sets the number of horses participating in the race.
   * @param numberOfHorses integer representing the amount of horses.
   */
  public void setNumberOfHorses(int numberOfHorses) {
      this.numberOfHorses = numberOfHorses;
  }


  /**
   * Sets the length of the track in the race.
   * @param lengthOfTrack integer representing the length of the track in metres.
   */
  public void setLengthOfTrack(int lengthOfTrack) {
      this.lengthOfTrack = lengthOfTrack;
  }


  /**
   * Sets the number of lanes on the race track.
   * @param numberOfLanes integer representing the amount of lanes in the race.
   */
  public void setNumberOfLanes(int numberOfLanes) {
      this.numberOfLanes = numberOfLanes;
      lanes = new Horse[numberOfLanes];
      initialiseLanesArray();
  }


   /**
   * Assigns a horse to a lane on the race track.
   * @param h a Horse object.
   * @param index the index the horse is to be placed at in the lanes array.
   * Note that the index is the lane number - 1 as arrays are 0 indexed.
   */
  public void setLanes(Horse h, int index) {
    this.lanes[index] = h;
  }


  /* public void setTrackShape(String trackShape) {
      this.trackShape = trackShape;
  } */


  /* public void setWeather(String weather) {
      this.weather = weather;
  } */


   /**
   * Increases the horsesProcessed value by 1.
   * Used to keep track of the number of new HorseSelection windows displayed.
   */
  public void increaseHorsesProcessed() {
    horsesProcessed++;
  }


  /**
   * Sets every value of the lanes array to null by default.
   */
  private void initialiseLanesArray () {
    for (int i=0; i<numberOfLanes; i++) {
        lanes[i] = null;
    }
  }
  
}
