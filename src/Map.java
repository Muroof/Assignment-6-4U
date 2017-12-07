
import java.awt.image.BufferedImage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kiran
 */
public class Map {
    
    // create a private two dimensional buffered image array to store the layout of the schoo;
    private BufferedImage [][] layout;
    
    public Map(int rows, int columns, String folder){
        // creating an array to store the layout in a sort of grid
        layout = new BufferedImage [rows][columns];
        // go through each row
    }
}
