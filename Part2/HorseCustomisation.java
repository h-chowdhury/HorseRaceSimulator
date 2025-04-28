package Part2;

/**
 * Defines the customisable attributes of a Horse
 * 
 * @author Humayra Chowdhury
 * @version Version 1.2
 */
public class HorseCustomisation {

    private Horse horse;

    private String breedType;
    private String hairType;
    private String saddleType;
    private String horseshoeType;
    private String accessoryType;

    public HorseCustomisation (Horse horse, String breedType, String hairType, String saddleType, String horseshoeType, String accessoryType) {
        this.horse = horse;
        this.breedType = breedType;
        this.hairType = hairType;
        this.saddleType = saddleType;
        this.horseshoeType = horseshoeType;
        this.accessoryType = accessoryType;
    }


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
}
