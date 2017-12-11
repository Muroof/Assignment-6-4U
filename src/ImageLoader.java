
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 */
public class ImageLoader extends JComponent {

    public static BufferedImage loadImage(String imageName) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("images//" + imageName));
        } catch (Exception e) {
            e.printStackTrace();

        }
        return image;
    }

    BufferedImage image = null;

    /**
     * Draws an image to the entire component
     *
     * @param g graphics object to draw
     */
    @Override
    public void paintComponent(Graphics g) {
        if (image != null) {
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
        }
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        this.repaint();
    }
}
