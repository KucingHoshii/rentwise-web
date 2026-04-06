/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author afiqa
 */
public class User {
    private String student_id;
    private String student_name;
    private String student_password;
    private String student_email;
    private int student_contact;
    private String student_address;
    private byte[] student_image; // New field for profile picture


    /**
     * @return the student_id
     */
    public String getStudent_id() {
        return student_id;
    }

    /**
     * @param student_id the student_id to set
     */
    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    /**
     * @return the student_name
     */
    public String getStudent_name() {
        return student_name;
    }

    /**
     * @param student_name the student_name to set
     */
    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    /**
     * @return the student_password
     */
    public String getStudent_password() {
        return student_password;
    }

    /**
     * @param student_password the student_password to set
     */
    public void setStudent_password(String student_password) {
        this.student_password = student_password;
    }

    /**
     * @return the student_email
     */
    public String getStudent_email() {
        return student_email;
    }

    /**
     * @param student_email the student_email to set
     */
    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    /**
     * @return the student_contact
     */
    public int getStudent_contact() {
        return student_contact;
    }

    /**
     * @param student_contact the student_contact to set
     */
    public void setStudent_contact(int student_contact) {
        this.student_contact = student_contact;
    }
    
     public String getAddress() {
        return student_address;
    }

    public void setAddress(String student_address) {
        this.student_address = student_address;
    }

    public byte[] getStudentImage() {
        return student_image;
    }

    public void setStudentImage(byte[] StudentImage) {
        this.student_image = student_image;
    } 
    
    
    
}
