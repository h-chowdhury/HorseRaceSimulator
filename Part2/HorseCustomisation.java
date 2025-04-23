package Part2;

/**
 * Defines the customisable attributes of a Horse
 * 
 * @author Humayra Chowdhury
 * @version Version 1.1
 */
public class HorseCustomisation {

  private Horse horse;

  private String breedType;
  private String hairType;
  private String saddleType;
  private String horseshoeType;
  private String accessoryType;


  /**
   * Gets the horse pertaining to the HorseCustomisation object.
   * @return A horse object.
   */
  public Horse getHorse() {
    return horse;
  }

  /**
   * Gets the breed type of the horse.
   * @return The breed type.
   */
  public String getBreedType() {
      return breedType;
  }

  /**
   * Gets the hair type of the horse.
   * @return The hair type.
   */
  public String getHairType() {
      return hairType;
  }

  /**
   * Gets the saddle type used by the horse.
   * @return The saddle type.
   */
  public String getSaddleType() {
      return saddleType;
  }

  /**
   * Gets the horseshoe type applied to the horse.
   * @return The horseshoe type.
   */
  public String getHorseshoeType() {
      return horseshoeType;
  }

  /**
   * Gets the accessory type used for the horse.
   * @return The accessory type.
   */
  public String getAccessoryType() {
      return accessoryType;
  }

  /**
   * Sets the horse pertaining to the HorseCustomisation object.
   * @param horse A horse object.
   */
  public void setHorse(Horse horse) {
      this.horse = horse;
  }

  /**
   * Sets the breed type of the horse.
   * @param breedType The breed type.
   */
  public void setBreedType(String breedType) {
      this.breedType = breedType;
  }

  /**
   * Sets the hair type of the horse.
   * @param hairType The hair type.
   */
  public void setHairType(String hairType) {
      this.hairType = hairType;
  }

  /**
   * Sets the saddle type used by the horse.
   * @param saddleType The saddle type.
   */
  public void setSaddleType(String saddleType) {
      this.saddleType = saddleType;
  }

  /**
   * Sets the horseshoe type applied to the horse.
   * @param horseshoeType The horseshoe type.
   */
  public void setHorseshoeType(String horseshoeType) {
      this.horseshoeType = horseshoeType;
  }

  /**
   * Sets the accessory type used for the horse.
   * @param accessoryType The accessory type.
   */
  public void setAccessoryType(String accessoryType) {
      this.accessoryType = accessoryType;
  }

}
