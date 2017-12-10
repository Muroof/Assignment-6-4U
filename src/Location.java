/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maloof
 */
public class Location {

    private ImageObject NImg, EImg, SImg, WImg;

    private String locationName;

    public Location(String locationName) {
        this.locationName = locationName;

    }

    public void setNImg(ImageObject NImg) {
        this.NImg = NImg;
    }

    public void setEImg(ImageObject EImg) {
        this.EImg = EImg;
    }

    public void setSImg(ImageObject SImg) {
        this.SImg = SImg;
    }

    public void setWImg(ImageObject WImg) {
        this.WImg = WImg;
    }

    public ImageObject getEImg() {
        return EImg;
    }

    public ImageObject getNImg() {
        return NImg;
    }

    public ImageObject getSImg() {
        return SImg;
    }

    public ImageObject getWImg() {
        return WImg;
    }

    
}

