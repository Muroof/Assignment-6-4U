
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

    // instance variable
    private BufferedImage image;

    // constructor
    public ImageLoader() {
        image = null;
    }

    /**
     *
     * @param g paint component to set the width and height of the image to the
     * screen layout
     */
    @Override
    public void paintComponent(Graphics g) {
        if (image != null) {
            g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
        }
    }

    /**
     *
     * @param img set the image that is received
     */
    public void setImage(BufferedImage img) {
        System.out.println(this.getWidth());
        // store the image
        this.image = img;
        // repaint to draw
        repaint();
    }
}