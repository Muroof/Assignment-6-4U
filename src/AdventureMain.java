
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

    private ArrayList<ImageObject> images;
    // create a private string of the initial location so it can be referenced later in the main method
    private String initialLocation;
    // create a private string of the initial direction so it can be referenced later in the main method
    private String initialDirection;
    // create a private graphics interface
    private Interface gui;
    private int initialLocationPositionWithinArray;
    private ImageObject currentImage;

    // initializing GUI interface
    public AdventureMain() {
        gui = new Interface(this);
        ImageLoader load = new ImageLoader();
        //BufferedImage image =load.loadImage(images.get(1).getImageName());
//        gui.setImage(image);
//        gui.setVisible(true);
        // set the current image to be the starting image
        //this.currentImage = images.get(initialLocationPositionWithinArray);
        // NEED TO SET INITIAL IMAGE HERE
        //gui.setImage(images.get(initialLocationPositionWithinArray).getImageName());
        gui.setImage(ImageObject.loadImage(currentImage.getImageName()));

    }

    public void moveForward() {
        // if the front is not blocked
        if (!this.currentImage.isFrontBlocked()) {
            int i = 0;
            // search the array for the next image to go to
            while ((!images.get(i).getLocation().getLocationName().equals(this.currentImage.getNextLocation())) || ((!images.get(i).getNextDirection().equals(this.currentImage.getNextDirection())))) {
                // increase the comparison position
                i++;
            }
            // move to that imageObject
            this.currentImage = images.get(i);
            // UPDATE THE GUI WORK ON THIS!!!!!!!!!!!!

        }
    }

    public void moveRight() {
        int i = 0;
        // search for the location within the array
        while (!locations.get(i).getLocationName().equals(this.currentImage.getLocation().getLocationName())) {
            // increase the comparison position
            i++;
        }
        // if they are facing north
        if (this.currentImage.getDirection().equals("N")) {
            // set them to be in the east direction of the same location
            this.currentImage = locations.get(i).getEImg();
            // UPDATE THE GUI

        } else if (this.currentImage.getDirection().equals("E")) {
            // set them to be in the south direction of the same location
            this.currentImage = locations.get(i).getSImg();
            //UPDATE THE GUI

        } else if (this.currentImage.getDirection().equals("S")) {
            // set them to be in the west direction of the same location
            this.currentImage = locations.get(i).getWImg();
            //UPDATE THE GUI

        } else if (this.currentImage.getDirection().equals("W")) {
            // set them to be in the nortj direction of the same location
            this.currentImage = locations.get(i).getNImg();
            //UPDATE THE GUI

        }

    }

    public void moveLeft() {
        int i = 0;
        // search for the location within the array
        while (!locations.get(i).getLocationName().equals(this.currentImage.getLocation().getLocationName())) {
            // increase the comparison position
            i++;
        }
        // if they are facing north
        if (this.currentImage.getDirection().equals("N")) {
            // set them to be in the west direction of the same location
            this.currentImage = locations.get(i).getWImg();
            // UPDATE THE GUI

        } else if (this.currentImage.getDirection().equals("E")) {
            // set them to be in the north direction of the same location
            this.currentImage = locations.get(i).getNImg();
            //UPDATE THE GUI

        } else if (this.currentImage.getDirection().equals("S")) {
            // set them to be in the east direction of the same location
            this.currentImage = locations.get(i).getEImg();
            //UPDATE THE GUI

        } else if (this.currentImage.getDirection().equals("W")) {
            // set them to be in the south direction of the same location
            this.currentImage = locations.get(i).getSImg();
            //UPDATE THE GUI

        }
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
            }
        }

        int whereStartingLocationIs = 0;
        // find the spot in the array where the initial location is
        while ((!images.get(whereStartingLocationIs).getDirection().equals(initialDirection)) || (!images.get(whereStartingLocationIs).getLocation().getLocationName().equals(initialLocation))) {
            // increase the comparison position
            whereStartingLocationIs++;
        }

        // store the integer where the initial location is at
        this.initialLocationPositionWithinArray = whereStartingLocationIs;

        // UPDATE THE GUI WITH STARTING IMAGE HERE NOT IN THE CONSTRUCTOR !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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
