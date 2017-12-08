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

    public Location(String locationName, ImageObject NImg, ImageObject EImg, ImageObject SImg, ImageObject WImg) {
        this.locationName = locationName;
        this.NImg = NImg;
        this.EImg = EImg;
        this.SImg = SImg;
        this.WImg = WImg;

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

    public void setSImg(ImageObject SImg) {
        this.SImg = SImg;
    }

    public ImageObject getEImg() {
        return EImg;
    }

    public ImageObject getEImg() {
        return EImg;
    }

    public ImageObject getEImg() {
        return EImg;
    }

    public ImageObject getEImg() {
        return EImg;
    }

}
