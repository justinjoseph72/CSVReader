package com.justin.model;

public class PropertyInfo {


    private Integer propertyReference;

    private Integer price;

    private Integer noOfBedrooms;

    private Integer noOfBathrooms;

    private String houseNumber;

    private String address;

    private String region;

    private String postcode;

    private String propertyType;

    public Integer getPropertyReference() {
        return propertyReference;
    }

    public void setPropertyReference(Integer propertyReference) {
        this.propertyReference = propertyReference;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNoOfBedrooms() {
        return noOfBedrooms;
    }

    public void setNoOfBedrooms(Integer noOfBedrooms) {
        this.noOfBedrooms = noOfBedrooms;
    }

    public Integer getNoOfBathrooms() {
        return noOfBathrooms;
    }

    public void setNoOfBathrooms(Integer noOfBathrooms) {
        this.noOfBathrooms = noOfBathrooms;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    @Override
    public String toString() {
        return "PropertyInfo{" +
                "propertyReference=" + propertyReference +
                ", price=" + price +
                ", noOfBedrooms=" + noOfBedrooms +
                ", noOfBathrooms=" + noOfBathrooms +
                ", houseNumber='" + houseNumber + '\'' +
                ", address='" + address + '\'' +
                ", region='" + region + '\'' +
                ", postcode='" + postcode + '\'' +
                ", propertyType='" + propertyType + '\'' +
                '}';
    }
}
