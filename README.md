# Horse Race Simulator


## Project Description
This simulator runs a race containing several horses.

There are two available versions of the simulator, one which runs in the terminal and the other 
which runs a functioning, user-friendly GUI, built using Java's Swing library. Both versions have 
customisable features.

The terminal-based simulator allows the user to customise the length and number of lanes on the 
race track, alongside each horses name, representative symbol, alongside its level of confidence, 
a value which dictates a horses stability and speed.

The GUI-based simulator does the same but with a more intuitive interface, using Java Swing features 
such as text areas, sliders, and buttons for inputs. There is also further customisation options
available to users. Users can select various weather conditions and horse features (breed, saddles, accessories)
which all effect the performance of horses in the race, altering, at a pre-set rate, their speeds and how likely they are to fall out of the race.

The simulator displays the horses and their movement along the race track, eventually displaying the
winner upon the end of the race.


## Setup Instructions
### 1. Clone the repository to your local machine:
      
      git clone https://github.com/h-chowdhury/HorseRaceSimulator.git

### 2. Install all dependencies (see below)

### 3. Run the project

  **Running the terminal version:**
    - Navigate to the project directory's 'Part1' folder and compile the project:

        `javac FILENAME.java`
      
      where FILENAME should be replaced with the name of each java file found in the folder.
    
    - Run the project:

        `java Main`

  **Running the GUI version:**
    - Navigate to the project directory
    - Compile the Java files into the 'bin' folder in 'Part2':

        `javac -d Part2/bin Part2/*.java`

    - Run the project:

        `java -cp Part2/bin Part2.StartRaceGUI`


## Dependencies
### Ensure all dependencies are installed before running the project.
- Java 8 or higher must be installed.
- Note that no additional items are required for download when running the GUI as it is
built only using Swing which is part of the standard JDK. 
- This is also true for the terminal version of the project.


## Usage Guidelines

### Terminal version
  - Starting a race:
    - Follow the terminal set up instructions above to launch the Main class.
    - The Main class will invoke the startRace method.
    - The terminal will then display instructions for user input before running and displaying the race.

  - User input:
    - Note that all input is validated, meaning invalid values will re-prompt the user until 
      valid rather than cause the simulator to crash.
    

### GUI version
  - Starting a race:
    - Follow the GUI set up instructions above to launch the StartRaceGUI class.
    - The StartRaceGUI class will invoke the startRaceGUI method.
    - The launch window of the simulator will be displayed containing a 'Start' button.
    - The program will then redirect to a track customisation window followed by a
      horse customisation window before displaying the race.

  - Customisation:
    - Both the track and horse customisation pages contain sliders, spinners, text inputs,
      and buttons to ensure all user input is valid and intuitive.
    - These input features have pre-set limits and approved values.
    - Customisation effects can be seen upon hovering above any option.

    - Track customisation:
      - Users can select the length and number of lanes, the number of horses, and weather conditions.
      - Each weather condition adds a unique effect which can alter the horses speeds and chances of falling
        out of a race.

    - Horse customisation:
      - Users can select a lane and confidence level for each horse, with pre-approved values to choose from.
      - Users can customise the appearance of each horse which in turn affects its performance.
      - Customisable features include the horses breed, hair colour, alongside its equipped saddle, horseshoe,
        and power-up ability.
      - Such features have a unique effect on the given horses speed, chance of falling, and movement.
      
