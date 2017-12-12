
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author Kiran
 * @author Maloof
 */
public class ImageObject {

    // create an instance variable to store the direction of a specific imageObject
    private String direction;
    // create an instance variable to store the image name of an imageObject 
    private String imageName;
    // create an instance variable that stores true/false if the front is blocked
    private boolean isFrontBlocked;
    // create an instance variable to store the name of the next location to move to if possible
    private String nextLocation;
    // create an instance variable to store the direction of the next ImageObject to move to
    private String nextDirection;
    // create an instance variable to store thelocation of an imageObject (as the imageObject is a n, e, s, w of a location)
    private Location location;

    /**
     *
     * @param location the location that an imageObject is found within
     * @param direction the direction an imageObject is facing
     */
    public ImageObject(Location location, String direction) {
        // set the location that the imageObject is in to be the location passed
        this.location = location;
        // set the direction of the imageObject to be the passed in direction
        this.direction = direction;
    }

    /**
     *
     * @param imageName the name of the image that is to be made into a buffered
     * image
     * @return the image of an imageObject
     */
    public static BufferedImage loadImage(String imageName) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("images//" + imageName));
        } catch (Exception e) {
            e.printStackTrace();

        }
        return image;
    }

    /**
     *
     * @param imageName the image name of an imageObject
     */
    public void setImageName(String imageName) {
        // set the image name of the imageObject to be the image name passed in
        this.imageName = imageName;
    }

    /**
     *
     * @param isFrontBlocked if the front of an imageObject is blocked or not
     */
    public void setIsFrontBlocked(boolean isFrontBlocked) {
        // set the front to be blocked or nor dependent on the boolean passed in
        this.isFrontBlocked = isFrontBlocked;
    }

    /**
     *
     * @param location the name of the next location the nextI imageObject can
     * be found in
     */
    public void setNextLocation(String location) {
        // set the name of the next location to be the location name passed in
        this.nextLocation = location;
    }

    /**
     *
     * @param nextDirection the direction of the next imageObject to advance to
     */
    public void setNextDirection(String nextDirection) {
        // set the direction of the next imageObject to be the direction passed in 
        this.nextDirection = nextDirection;
    }

    /**
     * Returns the image name of an imageObject
     *
     * @return the image name of an imageObject
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * Returns the direction an imageObject is facing
     *
     * @return the direction of an imageObject
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Returns the location an imageObject is within
     *
     * @return the location an imageObject is within
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Returns the name of the next location to advance to
     *
     * @return the name of the next location to advance to
     */
    public String getNextLocation() {
        return nextLocation;
    }

    /**
     * Returns the direction of the next imageObject to advance to
     *
     * @return the direction of the next imageObject to advance to
     */
    public String getNextDirection() {
        return nextDirection;
    }

    /**
     * Returns whether the front of an imageObject is blocked or not
     *
     * @return whether the front of an imageObject is blocked or not
     */
    public boolean isFrontBlocked() {
        return isFrontBlocked;
    }

}
