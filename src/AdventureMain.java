
import jaco.mp3.player.MP3Player;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.FileReader;
import java.io.File;
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

    // create a mp3 player to allow for background sound to be played
    MP3Player sound = new MP3Player();
    // create a private array of locations
    private ArrayList<Location> locations;
    // create a private array of imageObjects
    private ArrayList<ImageObject> images;
    // create a private string of the initial location so it can be referenced later
    private String initialLocation;
    // create a private string of the initial direction so it can be referenced later
    private String initialDirection;
    // create a private graphics interface
    private Interface gui;
    // create a private int to store where the initial imageObject is within the array
    private int initialImageObjectPositionWithinArray;
    // create a private imageObject to keep track of the current imageObject
    private ImageObject currentImage;

    /**
     * constructor for the Adventure Main
     */
    public AdventureMain() {

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

        // use a scanner to scan the text file
        Scanner in = new Scanner(file);
        // create an empty array of locations
        locations = new ArrayList<>();
        // create an empty array of imageObjects (individual places within the location)
        images = new ArrayList<>();
        // initially read in the first location (special case) amd move to the next line
        initialLocation = in.nextLine();
        // initially read in the direction of the first location and move to the next line
        initialDirection = in.nextLine();
        // while there are items to read in the text file
        while (in.hasNext()) {
            // read in the location of the next 4 imageObjects and move to the next line
            String locationName = in.nextLine();
            // create a location with the previously scanned string as its name
            Location location = new Location(locationName);
            // create a for loop to go through the next 4 imageObjects, so a general location name can be applied to all 4 imgaeObjects
            for (int j = 0; j < 4; j++) {
                // scan in the direction of the imageObject
                String direction = in.next();
                // create an image object with the scanned in location and direction
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
                    //set the front to be blocked
                    isFrontBlocked = true;
                    // set the front of the imageObject to be blocked 
                    image.setIsFrontBlocked(isFrontBlocked);
                }// the front is not blocked
                else {
                    // set the front to not be blocked
                    isFrontBlocked = false;
                    // set the front of the imageObject to be not blocked
                    image.setIsFrontBlocked(isFrontBlocked);
                }

                // if the front is not blocked keep on reading
                if (isFrontBlocked == false) {
                    // scan in the next location to move to if moving forwards
                    String nextLocation = in.next();
                    // set the next location to move to 
                    image.setNextLocation(nextLocation);
                    // scan in the direction of the next imageObject and move to the next line
                    String nextDirection = in.nextLine();
                    // set the direction of the next imageObject to move to
                    image.setNextDirection(nextDirection);
                }// the front is blocked
                else {
                    // move to the next line
                    in.nextLine();
                }
                // store the imageObject created in the array of imageObjects
                images.add(image);
                // set the imageObject to be in its respective position within the location (based on its direction)
                location.setImg(image, direction);
            }
            // add the location to the array of locations
            locations.add(location);
        }
        // create an integer to track where the starting location is
        int whereStartingLocationIs = 0;
        // find the spot in the array where the initial location is
        // while the the imageIbject in the array being examined does not have the same direction or location as the starting direction and starting location
        while ((!images.get(whereStartingLocationIs).getDirection().equals(initialDirection)) || (!images.get(whereStartingLocationIs).getLocation().getLocationName().equals(initialLocation))) {
            // increase the comparison position
            whereStartingLocationIs++;
        }
        // store the integer where the initial imageObject is in within the array containing imageObjects
        this.initialImageObjectPositionWithinArray = whereStartingLocationIs;
        // set the currentImage object to be the starting ImageObject
        this.currentImage = images.get(initialImageObjectPositionWithinArray);
        // add the backgorund music to the list of songs to be played (although its the only song being played)
        sound.addToPlayList(new File("Background Beat.mp3"));
        // allow the song to repeat
        sound.setRepeat(true);
        // play the song
        sound.play();
        // initialze the gui using the Interface class
        gui = new Interface(this);
        gui.setVisible(true);
        // create a purple color
        Color purple = new Color(171, 7, 196);
        // set the purple color to be the background of the gui
        gui.getContentPane().setBackground(purple);
        // set the image on the screen to be the starting imageObject
        gui.setImage(this.currentImage.loadImage(currentImage.getImageName()));
    }

    /**
     * allows the user to move forward
     */
    public void moveForward() {
        // if the front is not currently blocked
        if (!this.currentImage.isFrontBlocked()) {
            // create a reference position
            int i = 0;
            // search the array for the next imageObject to go to by finding which location holds the next imageObject
            // while the current imageObjects next location does not equal the location names of locations at a reference positon within the location array
            while (!this.currentImage.getNextLocation().equals(locations.get(i).getLocationName())) {
                // increase the reference position
                i++;
            }
            // set the current imageObject to be the corresponding imageObject within the next location when moving straight 
            this.currentImage = locations.get(i).getImg(currentImage.getNextDirection());
            // update the gui by displaying the new image
            gui.setImage(ImageObject.loadImage(currentImage.getImageName()));
        }
    }

    /**
     * allows the user to turn right
     */
    public void turnRight() {
        // create a reference postion
        int i = 0;
        // search for the current location within the array
        // while the location name of the locations within the location array do not equal the location name of the current imageObject
        while (!locations.get(i).getLocationName().equals(this.currentImage.getLocation().getLocationName())) {
            // increase the comparison position
            i++;
        }
        // if the imageObject is facing north
        if (this.currentImage.getDirection().equals("N")) {
            // set the current imageObject to be the imageObject facing east within the same location
            this.currentImage = locations.get(i).getImg("E");
            // update the gui by displaying the new image
            gui.setImage(this.currentImage.loadImage(currentImage.getImageName()));
        } // else if the imageObject is facing east
        else if (this.currentImage.getDirection().equals("E")) {
            // set the current imageObject to be the imageObject facing south within the same location
            this.currentImage = locations.get(i).getImg("S");
            // update the gui by displaying the new image
            gui.setImage(this.currentImage.loadImage(currentImage.getImageName()));
        } // else if the imageObject is facing south 
        else if (this.currentImage.getDirection().equals("S")) {
            // set the current imageObject to be the imageObject facing west within the same location
            this.currentImage = locations.get(i).getImg("W");
            // update the gui by displaying the new image
            gui.setImage(this.currentImage.loadImage(currentImage.getImageName()));
        } // else if the imageObject is facing west
        else if (this.currentImage.getDirection().equals("W")) {
            // set the current imageObject to be the imageObject facing north within the same location
            this.currentImage = locations.get(i).getImg("N");
            // update the gui by displaying the new image
            gui.setImage(this.currentImage.loadImage(currentImage.getImageName()));
        }
    }

    /**
     * allows the user to turn left
     */
    public void turnLeft() {
        // create a reference position
        int i = 0;
        // search for the current location within the array
        // while the location name of the locations within the location array do not equal the location name of the current imageObject
        while (!locations.get(i).getLocationName().equals(this.currentImage.getLocation().getLocationName())) {
            // increase the comparison position
            i++;
        }
        // if the imageObject is facing north
        if (this.currentImage.getDirection().equals("N")) {
            // set the current imageObject to be the imageObject facing west within the same location

            this.currentImage = locations.get(i).getImg("W");
            // update the gui by displaying the new image
            gui.setImage(this.currentImage.loadImage(currentImage.getImageName()));
        } // else if the imageObject is facing east 
        else if (this.currentImage.getDirection().equals("E")) {
            // set the current imageObject to be the imageObject facing north within the same location
            this.currentImage = locations.get(i).getImg("N");
            // update the gui by displaying the new image
            gui.setImage(this.currentImage.loadImage(currentImage.getImageName()));
        } // else if the imageObject is facing south 
        else if (this.currentImage.getDirection().equals("S")) {
            // set the current imageObject to be the imageObject facing east within the same location
            this.currentImage = locations.get(i).getImg("E");
            // update the gui by displaying the new image
            gui.setImage(this.currentImage.loadImage(currentImage.getImageName()));
        } // else if the imageObject is facing west 
        else if (this.currentImage.getDirection().equals("W")) {
            // set the current imageObject to be the imageObject facing south within the same location
            this.currentImage = locations.get(i).getImg("S");
            // update the gui by displaying the new image
            gui.setImage(this.currentImage.loadImage(currentImage.getImageName()));
        }
    }

    /**
     * @param args the command line arguments
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create an object to run the class
        AdventureMain game = new AdventureMain();

    }
}
