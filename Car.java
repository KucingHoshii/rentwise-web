package model;

import java.util.Base64;

public class Car {
    private String carId;
    private String carModel;
    private double carPrice;
    private String carAvailability;
    private String carLocation;
    private String carType;
    private byte[] carPic;
    private String carPicString; 

    // Getters and setters
    public String getCarId() {
        return carId;
    }
    public void setCarId(String carId) {
        this.carId = carId;
    }
    public String getCarModel() {
        return carModel;
    }
    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
    public double getCarPrice() {
        return carPrice;
    }
    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }
    public String getCarAvailability() {
        return carAvailability;
    }
    public void setCarAvailability(String carAvailability) {
        this.carAvailability = carAvailability;
    }
    public String getCarLocation() {
        return carLocation;
    }
    public void setCarLocation(String carLocation) {
        this.carLocation = carLocation;
    }
    public String getCarType() {
        return carType;
    }
    public void setCarType(String carType) {
        this.carType = carType;
    }
    public byte[] getCarPic() {
        return carPic;
    }
    public void setCarPic(byte[] carPic) {
        this.carPic = carPic;
    }
    public String getCarPicBase64() {
        return Base64.getEncoder().encodeToString(this.carPic);
    }
    public void setCarPicString(String carPicString) {
        this.carPicString = carPicString;
    }
}
