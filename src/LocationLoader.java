
import java.awt.image.BufferedImage;
import java.io.FileReader;
import java.net.URL;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ranam3235
 */
public class LocationLoader {

    private BufferedImage image;
    private BufferedImage[] images;
    private String[] locationName;
    private String[] direction;
    private String[] imageName;
    private boolean[] canMoveForward;

    /**
     * @param args the command line arguments
     */
    public void getLocationInfo() {
        // create a blank file reader
        FileReader file = null;
        try {

            URL url = LocationLoader.class.getResource("pics.txt");

            System.out.println(url);
            // creating the file reader
            file = new FileReader("src/pics.txt");

        } catch (Exception e) {
            // handle any errors
            // print out the lovely red errors
            e.printStackTrace();
            // exit the program
            System.exit(0);
        }
        // use a scanner with the file
        Scanner in = new Scanner(file);
        // get the first locationName (simply for testing reasons)
        String initialLocationName = in.nextLine();
        // move to the next line
        in.nextLine();
        String initialDirection = in.nextLine();

        int[] array = new int[122];





        // make another array for space, double the size of the previous
        int[] temp = new int[array.length * 2];
        // copy values from original array into new array
        for (int i = 0; i < array.length; i++) {
            // fill the temporary array with all the values of the previous array
            temp[i] = array[i];
        }
        // set the tremporary array to be the new array
        array = temp;
        // insert the number at the end of the list
        //array[numItems] = num;
        // increase the number of items
        // numItems++;

        for (int i = 0; i < array.length; i++) {
        }


    }
}
