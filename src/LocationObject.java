
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
    private boolean canMoveForward;

    // consrtructor using the name
    public LocationObject(String locationName) {
        this.locationName = locationName;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setImage(String imageName) {
        this.imageName = imageName;
        // load in the image


    }

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

