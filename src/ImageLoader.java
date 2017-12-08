
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

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
public class ImageLoader extends JComponent{
    private BufferedImage image;
    
    BufferedImage img = null;
    
    /**
     * Draws an image to the entire component
     * @param g graphics object to draw
     */
    @Override
    public void paintComponent(Graphics g){
        if(img != null){
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
        }
    }
    
    public void setImage(BufferedImage img){
        this.img = img;
        this.repaint();
    }
    
    // constructor for images (loads images)
    public BufferedImage getImage(String imageName) {
        BufferedImage img = null;
        try {

            img = ImageIO.read(new File("images//" + imageName));
        } catch (Exception e) {
            e.printStackTrace();
        }

        BufferedImage currentImage = img;
        this.image = currentImage;
        return image;

    }
}

