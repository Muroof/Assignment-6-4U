/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Kiran
 * @author Maloof
 */
public class Location {

    // create instances variables for the four imageObjects found within a location (N, E, S, and W imageObjects)
    private ImageObject NImg, EImg, SImg, WImg;
    // create an instance variable to store the name of a location
    private String locationName;

    /**
     * constructor for a location
     *
     * @param locationName the name of the location
     */
    public Location(String locationName) {
        // set the location name to be the string passed in
        this.locationName = locationName;
    }

    /**
     * Returns the name of the location
     *
     * @return the name of the location
     */
    public String getLocationName() {
        return this.locationName;
    }

    /**
     *
     * @param Img the imageObject being entered into a location
     * @param direction the direction if the imageObject
     */
    public void setImg(ImageObject Img, String direction) {
        // if the imageObject is facing north
        if (direction.equals("N")) {
            // set the north imageObject to be the imageObject passed in
            this.NImg = Img;
        } // else if the imageObject is facing east
        else if (direction.equals("E")) {
            // set the east imageObject to be the imageObject passed in
            this.EImg = Img;
        } // else if the imageObject is facing south
        else if (direction.equals("S")) {
            // set the south imageObject to be the imageObject passed in
            this.SImg = Img;
        } // else if the imageObject is facing west
        else if (direction.equals("W")) {
            // set the west imageObject to be the imageObject passed in
            this.WImg = Img;
        }

    }

    /**
     * Returns the imageObject within a location at any given direction (N, E,
     * S, or W)
     *
     * @param direction the direction an imageObject is facing
     * @return the imageObject within a location at any given direction (N, E,
     * S, or W)
     */
    public ImageObject getImg(String direction) {
        // if the direction of the desired imageObject is north (or statement as when the next direction of a location is scanned in it has a space before its direction)
        if (direction.equals("N") || direction.equals(" N")) {
            // return the north imageObject 
            return this.NImg;
        } // else if the direction of the desired imageObject is east
        else if (direction.equals("E") || direction.equals(" E")) {
            // return the east imageObject 
            return this.EImg;
        } // else if the direction of the desired imageObject is south 
        else if (direction.equals("S") || direction.equals(" S")) {
            // return the south imageObject 
            return this.SImg;
        } // else if the direction of the desired imageObject is west 
        else if (direction.equals("W") || direction.equals(" W")) {
            // return the west imageObject 
            return this.WImg;
        } else {
            // a valid direction is not entered
            return null;
        }

    }

}
