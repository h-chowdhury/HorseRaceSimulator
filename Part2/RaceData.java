package Part2;

/**
 * This class defines the variables involved in a race.
 * It stores the data which can be accessed with getters
 * and setters.
 * 
 * @author Humayra Chowdhury
 * @version Version 1.4
 */
public class RaceData {
  private int numberOfHorses;
  private int lengthOfTrack;
  private int numberOfLanes;
  // private String trackShape;
  // private String weather;
  private Horse[] horses;

  
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

  public Horse[] getHorsesArray() {
    return horses;
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
      initialiseHorsesArray();
  }

  public void setLengthOfTrack(int lengthOfTrack) {
      this.lengthOfTrack = lengthOfTrack;
  }

  public void setNumberOfLanes(int numberOfLanes) {
      this.numberOfLanes = numberOfLanes;
  }

  public void setHorsesArray(Horse h, int index) {
    this.horses[index] = h;
}

  /* public void setTrackShape(String trackShape) {
      this.trackShape = trackShape;
  } */

  /* public void setWeather(String weather) {
      this.weather = weather;
  } */


  private void initialiseHorsesArray () {
    for (int i=0; i<numberOfHorses; i++) {
        horses[i] = null;
    }
  }
  
}
