/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author afiqa
 */
public class Rental {
    private int rentalId;
    private int carId;
    private String studentId;
    private int rentalDuration;
    private Date startDate;
    private Time startTime;
    private Date returnDate;
    private Time returnTime;
    private double rentalFees;
    private String rentalStatus;
    private Car car; 

    /**
     * @return the rentalId
     */
    public int getRentalId() {
        return rentalId;
    }

    /**
     * @param rentalId the rentalId to set
     */
    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    /**
     * @return the carId
     */
    public int getCarId() {
        return carId;
    }

    /**
     * @param carId the carId to set
     */
    public void setCarId(int carId) {
        this.carId = carId;
    }

    /**
     * @return the studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * @return the rentalDuration
     */
    public int getRentalDuration() {
        return rentalDuration;
    }

    /**
     * @param rentalDuration the rentalDuration to set
     */
    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
        /**
     * @return the startDate
     */
    public Time getStartTime() {
        return startTime;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStarTime(Time startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the returnDate
     */
    public Date getReturnDate() {
        return returnDate;
    }

    /**
     * @param returnDate the returnDate to set
     */
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    
        /**
     * @return the returnTime
     */
    public Time getReturnTime() {
        return returnTime;
    }

    /**
     * @param returnDate the returnDate to set
     */
    public void setReturnTime(Time returnTime) {
        this.returnTime = returnTime;
    }

    /**
     * @return the rentalFees
     */
    public double getRentalFees() {
        return rentalFees;
    }

    /**
     * @param rentalFees the rentalFees to set
     */
    public void setRentalFees(double rentalFees) {
        this.rentalFees = rentalFees;
    }

    /**
     * @return the paymentId
     */
    public String getRentalStatus() {
        return rentalStatus;
    }

    /**
     * @param paymentId the paymentId to set
     */
    public void setRentalStatus(String rentalStatus) {
        this.rentalStatus = rentalStatus;
    }
    
        
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    
    
}
