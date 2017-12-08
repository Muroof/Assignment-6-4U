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
    // create an instance variable that stores true/false if 
    private boolean isFrontBlocked;
    // if the player can move to a new location
    private ImageObject nextImage;
    // location of the image (as the image is a n, e, s, w of an image)
    private Location location;

    public ImageObject(String imageName, String direction, Location location, boolean isFrontBlocked) {
        this.imageName = imageName;
        this.direction = direction;
        this.location = location;
        this.isFrontBlocked = isFrontBlocked;
        this.nextImage = nextImage;

    }

    public void setNextImage(ImageObject image) {
        this.nextImage = image;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setIsFrontBlocked(boolean isFrontBlocked) {
        this.isFrontBlocked = isFrontBlocked;
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

    public ImageObject getNextImage() {
        return nextImage;
    }

    public boolean isFrontBlocked() {
        return isFrontBlocked;
    }
}
