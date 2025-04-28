import java.util.Scanner;

/**
 * This is the input helper class.
 * It contains methods that help with input validation.
 * 
 * @author Humayra Chowdhury
 * @version Version 1.1
 */
class InputHelper {

  /***
   * Recieve an input as an String
   */
  public String getString(String prompt) {
    Scanner scanner = new Scanner(System.in);
    String input = "";

    while (input.length() == 0 || input == null) {
      System.out.println(prompt);
      input = scanner.nextLine();
    }
    return input;
  }

  /***
   * Recieve and validate an input as an integer
   * e.g. getInt('a') will re-prompt for an integer
   */
  public int getInt(String prompt) {
    int input = 0;
    boolean valid = false;

    while (!valid) {
      try {
        input = Integer.parseInt(getString(prompt));
        valid = true;
      } catch (NumberFormatException e) {
        System.out.println("Please enter a valid integer.");
      }
    }
    return input;
  }

    /***
   * Recieve and validate an input as a positive integer
   * e.g. getInt(-1) will re-prompt for a positive integer
   */
  public int getPosInt(String prompt) {
    int input = 0;

    while (input <= 0) {
      input = getInt(prompt);
    }
    return input;
  }

   /***
   * Recieve and validate an input as an integer larger than the one provided
   * e.g. getInt(10) will re-prompt for a positive integer if 9 is provided
   */
  public int getLargerInt(int n, String prompt) {
    int input = 0;

    while (input < n) {
      input = getInt(prompt);
    }
    return input;
  }

  /***
   * Recieve and validate an input as an integer
   * e.g. getInt('a') will re-prompt for an integer
   */
  public double getDouble(String prompt) {
    double input = 0.0;
    boolean valid = false;

    while (!valid) {
      try {
        input = Double.parseDouble(getString(prompt));
        valid = true;
      } catch (NumberFormatException e) {
        System.out.println("Please enter a valid double.");
      }
    }
    return input;
  }

  /***
   * Recieve and validate an input as an character
   * e.g. getChar("aaa") will re-prompt for an char
   */
  public char getChar(String prompt) {
    String input = getString(prompt);

    while (input.length() != 1 || input == null) {
      input = getString(prompt);
    }
    return input.charAt(0);
  }

  /***
   * Recieve and validate a double input between 0-1
   * e.g. getConfidence(100) will re-prompt for a value
   */
  public double getConfidence(String prompt) {
    double confidence = getDouble(prompt);

    while (confidence <= 0 || confidence >= 1) {
      confidence = getDouble(prompt);
    }

    return confidence;
  }


  /***
   * Recieve and validate the lane input.
   */
  public int getLane(Horse[] lanes, String prompt) {
    int lane = getPosInt(prompt);

    while (lane > lanes.length || lane < 1 || lanes[lane-1] != null) {
      lane = getPosInt(prompt);
    }

    return lane;
  }
  
}
