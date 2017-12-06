
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

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
    // create an instance variable to store the next direction if the user can move straight
    private String locationGoIfMoveStraight;
    // create an instance variable to store the direction of the location that will be reached if the user moves forward
    private String DirectionoflocationIfMoveStraight;
    // create an instance variable that stores true/false if 
    private boolean isFrontBlocked;

    public class JImage extends JComponent {
        BufferedImage img = null;

        /**
         * Draws an image to the entire component
         *
         * @param g graphics object to draw
         */
        public void paintComponent(Graphics g) {
            if (img != null) {
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
            }
        }

        public void setImage(BufferedImage img) {
            this.img = img;
            this.repaint();
        }
    }
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
    
    public void setLocationifMoveStraight(String locationGoIfMoveStraight){
        this.locationGoIfMoveStraight = locationGoIfMoveStraight;
    }

    public void setDirectionLocationifMoveStrsight(String directionLocationInFront){
        this.DirectionoflocationIfMoveStraight = directionLocationInFront;
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
    
    public String getLocationifMoveStraight(){
        return this.locationGoIfMoveStraight;
    }
    
    public String getDirectionofLocationinFront(){
        return this.DirectionoflocationIfMoveStraight;
    }

    // constructor for images (loads images)
    public BufferedImage getImage() {
        BufferedImage img = null;
        try{
            img = ImageIO.read(new File("images//" + imageName));
        }catch(Exception e){
            e.printStackTrace();
        }

        BufferedImage currentImage = img;
        this.image = currentImage;
        return image;

    }

    public String toString() {
        String format = this.locationName + "\n";

        format += "Direction: " + this.direction + "\n";
        format += "Image Name: " + this.imageName + "\n";
        format += "Is Front Blocked: " + this.isFrontBlocked + "\n";
        format += "Next Location: " + this.locationGoIfMoveStraight + "\n";
        format += "Direction of Next Location: " + this.DirectionoflocationIfMoveStraight + "\n";
        return format;
    }
}
