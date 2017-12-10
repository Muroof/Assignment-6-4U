
import java.awt.Graphics;
import java.awt.image.BufferedImage;
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
public class ImageLoader extends JComponent{
    
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
}

