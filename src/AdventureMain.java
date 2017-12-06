
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kiran
 */
public class AdventureMain {

    // create a private array of locations
    private ArrayList<LocationObject> locations;
    // create a private string of the initial location so it can be referenced later in the main method
    private String initialLocationName;
    // create a private string of the initial direction so it can be referenced later in the main method
    private String initialDirection;
    // create a private graphics interface
    private Interface gui;

    /**
     * @param args the command line arguments
     */
    public void getLocationInfo() {
        // create a blank file reader
        FileReader file = null;
        try {
            // creating the file reader
            file = new FileReader("src/pics.txt");

        } catch (Exception e) {
            // handle any errors
            // print out the lovely red errors
            e.printStackTrace();
            // exit the program
            System.exit(0);
        }

        // use a scanner with the file
        Scanner in = new Scanner(file);
        // create an array of locations which can initialy store 96 locations
        locations = new ArrayList<>();
        // initially read in the first location (special case) amd move to the next line
        initialLocationName = in.nextLine();
        // initially read in the direction of the first location and move to the next line
        initialDirection = in.nextLine();
        // create a location object to store the intial location
        LocationObject initialLocation = new LocationObject(initialLocationName);
        // set the direction of the initial location
        initialLocation.setDirection(initialDirection);




        // while there are items to read in the text file
        while (in.hasNext()) {

            // read in the location name of the next 4 locations and move to the next line
            String generalLocationName = in.nextLine();
            // create a for loop to go through the next 4 locations, so a general location name can be applied to all of them
            for (int j = 0; j < 4; j++) {
                // create a location object 
                LocationObject location = new LocationObject(generalLocationName);

                // store the direction
                String direction = in.next();
                // set the direction of the location
                location.setDirection(direction);
                // store the image name within the location
                String imageName = in.next();
                // set the image name of the location
                location.setImage(imageName);
                // get the image of the location
                location.getImage();
                // store if the front is blocked or not
                String isFrontBlockedString = in.next();
                // create a boolean to store if the front is blocked or not
                boolean isFrontBlocked = false;
                // if the string is 'true'
                if (isFrontBlockedString.equals("true")) {
                    // the front is blocked
                    isFrontBlocked = true;
                }// the string does not read 'true'
                else {
                    // the front is not blocked
                    isFrontBlocked = false;
                }
                // set if the front os blocked for the image or not
                location.setIsFrontBlocked(isFrontBlocked);
                // if the front is not blocked
                if (isFrontBlocked == false) {
                    // store the location that will be reacched if the user goes straight
                    String locationGoIfMoveStraight = in.next();
                    // set the new location if the user moves forward
                    location.setLocationifMoveStraight(locationGoIfMoveStraight);
                    // store the direction of the new location if the user moves forward and move to the next line
                    String directionLocationAhead = in.nextLine();
                    // set the direction of the new location if the user moves straight
                    location.setDirectionLocationifMoveStrsight(directionLocationAhead);

                }// the front is blocked
                else {
                    // move to the next line to scan in the next location
                    in.nextLine();

                }
                // store the location just created in an array of locations
                locations.add(location);

            }




        }

        for (int j = 0; j < locations.size(); j++) {
            System.out.println(locations.get(j));

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create an object to run the class
        AdventureMain game = new AdventureMain();
        // scan in all of the locations
        game.getLocationInfo();

    }
}
