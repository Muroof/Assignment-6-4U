
import java.awt.image.BufferedImage;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author manok5757
 */
public class LocationObject {
    // create an instance variable to store the image of a particular location

    private BufferedImage image;
    // create an instance variable to store the general location name of a specific location
    private String locationName;
    // create an instance variable to store the direction of a specific location
    private String direction;
    // create an instance variable top 
    private String imageName;
    // create an instance variable that stores true/false if 
    private boolean isFrontBlocked;

    // consrtructor using the name
    public LocationObject(String locationName) {
        this.locationName = locationName;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setImage(String imageName) {
        this.imageName = imageName;


    }

    public void setIsFrontBlocked(boolean isFrontBlocked) {
        this.isFrontBlocked = isFrontBlocked;
    }

    public boolean getIsFrontBlocked() {
        return this.isFrontBlocked;
    }

    public String getDirection() {
        return this.direction;
    }

    public String getLocationName() {
        return this.locationName;
    }

    // constructor for images (loads images)
    public BufferedImage loadImage(String imageName) {
        BufferedImage currentImage = loadImage(this.imageName);
        this.image = currentImage;
        return this.image;

        
    }
//
//    @Override
//    public String toString() {
//        String format = this.name + "\n";
//
//        format += "Phone: " + this.phoneNumber + "\n";
//        format += "Email: " + this.email + "\n";
//        return format;
//    }
}
