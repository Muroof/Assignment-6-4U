
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
public class Location {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // create a blank file reader
        FileReader file = null;
        try{
            
            URL url = Location.class.getResource("pics.txt");
            
            System.out.println(url);
            // creating the file reader
            file = new FileReader("src/pics.txt");
            
        }catch(Exception e){
            // handle any errors
            // print out the lovely red errors
            e.printStackTrace();
            // exit the program
            System.exit(0);
        }
        // use a scanner with the file
        Scanner in = new Scanner(file);
        // get the first locationName (simply for testing reasons)
        String locationName = in.next();
        // move to the next line
        in.nextLine();

        // print the locatioName stores (for testing reasons)
        System.out.println(locationName);
    }
}
