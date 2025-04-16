package Part2;

/**
 * This class defines the variables involved in a race.
 * It stores the data which can be accessed with getters
 * and setters.
 * 
 * @author Humayra Chowdhury
 * @version Version 1.5
 */
public class RaceData {
  private int numberOfHorses;
  private int lengthOfTrack;
  private int numberOfLanes;
  // private String trackShape;
  // private String weather;
  private Horse[] lanes;

  
  // Getters
  public int getNumberOfHorses() {
    return numberOfHorses;
  }

  public int getLengthOfTrack() {
      return lengthOfTrack;
  }

  public int getNumberOfLanes() {
      return numberOfLanes;
  }

  public Horse getLanes(int index) {
    return lanes[index];
}

public Horse[] getLanesArray() {
    return lanes;
}

  /* public String getTrackShape() {
      return trackShape;
  } */

  /* public String getWeather() {
      return weather;
  } */


  // Setters
  public void setNumberOfHorses(int numberOfHorses) {
      this.numberOfHorses = numberOfHorses;
  }

  public void setLengthOfTrack(int lengthOfTrack) {
      this.lengthOfTrack = lengthOfTrack;
  }

  public void setNumberOfLanes(int numberOfLanes) {
      this.numberOfLanes = numberOfLanes;
      lanes = new Horse[numberOfLanes];
      initialiseLanesArray();
  }

  public void setLanes(Horse h, int index) {
    this.lanes[index] = h;
}

  /* public void setTrackShape(String trackShape) {
      this.trackShape = trackShape;
  } */

  /* public void setWeather(String weather) {
      this.weather = weather;
  } */


  private void initialiseLanesArray () {
    for (int i=0; i<numberOfLanes; i++) {
        lanes[i] = null;
    }
  }
  
}
