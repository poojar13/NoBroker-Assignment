package com.example.pooja.nobrokersampleapp.Model.Pojo;

/**
 * Created by pooja on 13/1/18.
 */

public class PropertyData {

    public  String title;
    public  String secondaryTitle;
    public  String furnishingState;
    public  String photos;
    public  String deposit;
    public  long propertyArea;
    public  String bathroom;
    public  String type;

    public String getSecondaryTitle() {
        return secondaryTitle;
    }

    public void setSecondaryTitle(String secondaryTitle) {
        this.secondaryTitle = secondaryTitle;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFurnishingState() {
        return furnishingState;
    }

    public void setFurnishingState(String furnishingState) {
        this.furnishingState = furnishingState;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public long getPropertyArea() {
        return propertyArea;
    }

    public void setPropertyArea(long propertyArea) {
        this.propertyArea = propertyArea;
    }

    public String getBathroom() {
        return bathroom;
    }

    public void setBathroom(String bathroom) {
        this.bathroom = bathroom;
    }

}
