

import java.awt.image.BufferedImage;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kiran
 * @author Maloof
 */
public class AdventureMain {

    // create a private array of locations
    private ArrayList<Location> locations;
<<<<<<< HEAD

    private ArrayList<ImageObject> images;
    // create a private string of the initial location so it can be referenced later in the main method
    private String initialLocation;
    // create a private string of the initial direction so it can be referenced later in the main method
    private String initialDirection;
=======
    
    private ArrayList<ImageObject> images;
//    // create a private string of the initial location so it can be referenced later in the main method
//    private String initialLocationName;
//    // create a private string of the initial direction so it can be referenced later in the main method
//    private String initialDirection;
>>>>>>> master
    // create a private graphics interface
    private Interface gui;
    private int initialLocationPositionWithinArray;

    // initializing GUI interface
    public AdventureMain() {
        gui = new Interface(this);
ImageLoader load = new ImageLoader();
    //BufferedImage image =load.getImage(images.get(1).getImageName());
    //gui.setImage(image);
        gui.setVisible(true);

    }

    // set the intial location of the user
    public void initialSetPosition() {
        // load in the initial image
        //gui.setImage(locations.get(this.initialLocationPositionWithinArray).getImage());

    }

    /**
     *
     */
    public void moveRight() {
        //if(locations.)
    }

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
<<<<<<< HEAD
        // create an array of locations
        locations = new ArrayList<>();
        // create an array of imageObjects (individual places within the location)
        images = new ArrayList<>();
        // initially read in the first location (special case) amd move to the next line
        initialLocation = in.nextLine();
        // initially read in the direction of the first location and move to the next line
        initialDirection = in.nextLine();
        // while there are items to read in the text file
        while (in.hasNext()) {
            // read in the location name of the next 4 imageObjects and move to the next line
            String locationName = in.nextLine();
            // create a location with the previously scanned string as its name
            Location location = new Location(locationName);
            // create a for loop to go through the next 4 imageObjects, so a general location name can be applied to all of them
            for (int j = 0; j < 4; j++) {
                // scan in the direction of the imageObject\
=======
//        // create an array of locations which can initialy store 96 locations
//        locations = new ArrayList<>();
//        // initially read in the first location (special case) amd move to the next line
//        String initialImageName = in.nextLine();
//        // initially read in the direction of the first location and move to the next line
//        String initialDirection = in.nextLine();
//        
//        String initial
//        // create a location object to store the intial location
//        LocationObject initialLocation = new LocationObject(initialLocationName);
//        // set the direction of the initial location
//        initialLocation.setDirection(initialDirection);
        
        String location = in.nextLine();
        String direction = in.nextLine();




        // while there are items to read in the text file
        while (in.hasNext()) {

            // read in the location name of the next 4 locations and move to the next line
            String locationName = in.nextLine();
            Location location = new Location(locationName);
            
            // create a for loop to go through the next 4 locations, so a general location name can be applied to all of them
            for (int j = 0; j < 4; j++) {
                
                
                
                
                
                
                // create a location object 
                ImageObject image = new ImageObject(generalLocationName);
                
                

                // store the direction
>>>>>>> master
                String direction = in.next();
                // create an image object with the scanned in variables
                ImageObject image = new ImageObject(location, direction);

                // scan in the image name of the ImageObject
                String imageName = in.next();
                // set the image name of the imageObject
                image.setImageName(imageName);
                // create a boolean to set if the front is blocked or not
                boolean isFrontBlocked = false;
                // scan in the next string
                String isFrontBlock = in.next();
                // if the front is blocked
                if (isFrontBlock.equals("true")) {
                    // the front is not blocked
                    isFrontBlocked = true;
                    // set the front to be blocked
                    image.setIsFrontBlocked(isFrontBlocked);
                }// the front is not blocked
                else {
                    // set the front to not be blocked
                    isFrontBlocked = false;
                    // set the front to be not blocked
                    image.setIsFrontBlocked(isFrontBlocked);
                }

                // if the front is not blocked keep on reading
                if (isFrontBlocked == false) {
                    // scan in the next location to move to if moving straight
                    String nextLocation = in.next();
                    // set the next location
                    image.setNextLocation(locationName);
                    // scan in the direction of the next imageObject
                    String nextDirection = in.nextLine();
                    // set the next direction within the next location
                    image.setNextDirection(nextDirection);
                }// the front is blocked
                else {
                    // move to the next line
                    in.nextLine();
                }
<<<<<<< HEAD
                // store the imageObject created in the array of imageObjects
                images.add(image);
                // if it is the north image
                if (direction.equals("N")) {
                    // set this image to be the north image in the location
                    location.setNImg(image);
                } // if it is the east image
                else if (direction.equals("E")) {
                    // set this to be the east image in the location
                    location.setEImg(image);
                } // if it is the south image 
                else if (direction.equals("S")) {
                    // set this to be the south image in the location
                    location.setSImg(image);
                } // if it is the west image 
                else if (direction.equals("W")) {
                    // set this to be the west image in the location
                    location.setWImg(image);
                }
                // add the location to the array of locations
                locations.add(location);
=======
                // store the location just created in an array of locations
                location.add(location);
                
>>>>>>> master
            }
        }

//        int whereStartingLocationIs =0;
//        // find the spot in the array where the initial location is
//        while((!locations.get(whereStartingLocationIs).getLocationName().equals(initialLocationName) )|| !locations.get(whereStartingLocationIs).getDirection().equals(initialDirection)){
//            // increase the comparison position
//            whereStartingLocationIs++;
//        }
//        
//        // store the integer where the initial location is at
//        this.initialLocationPositionWithinArray = whereStartingLocationIs;
//        //System.out.println(whereStartingLocationIs);
//        System.out.println(initialLocationPositionWithinArray);
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

