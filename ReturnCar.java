/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class ReturnCar {
    private int id;
    private String staffID;
    private String car_id;
    private String student_id;
    private String returnDate;
    private String returnTime;
    private String damage;
    private String carCondition;
    private String addCharge;

    public ReturnCar(int id, String staffID, String car_id, String student_id, String returnDate, String returnTime, String damage, String carCondition, String addCharge) {
        this.id = id;
        this.staffID = staffID;
        this.car_id = car_id;
        this.student_id = student_id;
        this.returnDate = returnDate;
        this.returnTime = returnTime;
        this.damage = damage;
        this.carCondition = carCondition;
        this.addCharge = addCharge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getCarCondition() {
        return carCondition;
    }

    public void setCarCondition(String carCondition) {
        this.carCondition = carCondition;
    }

    public String getAddCharge() {
        return addCharge;
    }

    public void setAddCharge(String addCharge) {
        this.addCharge = addCharge;
    }
}
