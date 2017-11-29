
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

    private BufferedImage images;
    private String locationName;
    private String direction;
    private String imageName;
    private boolean canMoveForward;

    // consrtructor using the name
    public LocationObject(String locationName) {
        this.locationName = locationName;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setImage(String imageName, BufferedImage image) {
        this.imageName = imageName;
        // load in the image
        this.images = image;

    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        String format = this.name + "\n";

        format += "Phone: " + this.phoneNumber + "\n";
        format += "Email: " + this.email + "\n";
        return format;
    }
}
}
