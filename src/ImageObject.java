/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maloof
 */
public class ImageObject {

    // create an instance variable to store the direction of a specific location
    private String direction;
    // create an instance variable top 
    private String imageName;
    // create an instance variable that stores true/false if the front is blocked
    private boolean isFrontBlocked;
    // the next location to move to if possible
    private String nextLocation;
    // the next directionwithin the location to move to
    private String nextDirection;
    // location of the image (as the image is a n, e, s, w of a location)
    private Location location;

    // constructor
    public ImageObject(Location location, String direction) {

        this.direction = direction;
        this.location = location;

    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setIsFrontBlocked(boolean isFrontBlocked) {
        this.isFrontBlocked = isFrontBlocked;
    }

    public void setNextLocation(String location) {
        this.nextLocation = location;
    }

    public void setNextDirection(String nextDirection) {
        this.nextDirection = nextDirection;
    }

    public String getImageName() {
        return imageName;
    }

    public String getDirection() {
        return direction;
    }

    public Location getLocation() {
        return location;
    }

    public String getNextLocation() {
        return nextLocation;
    }

    public String getNextDirection() {
        return nextDirection;
    }

    public boolean isFrontBlocked() {
        return isFrontBlocked;
    }
    
    public String toString() {
        String format = this.location + "\n";

        format += "Direction: " + this.direction + "\n";
        format += "Image Name: " + this.imageName + "\n";
        format += "Is Front Blocked: " + this.isFrontBlocked + "\n";
        format += "Next Location: " + this.nextLocation + "\n";
        format += "Direction of Next Location: " + this.nextDirection + "\n";
        return format;
    }
}

