/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3treka;

/**
 *
 * @author User
 */


public class User {

    private int phone;
    private String PHone;
    private String userName;
    private String password;
    private String name;
    private String surName;
    private String email;
    private String ROLE;
    private String ACCESSLEVEL;
    private String EMPLOYEETYPE;
    
       User(String nm, String surnme, String EMPLOYEETYP, String ACCESLEVEL, String ROL, String phon, String emal) {
        this.name = nm;
        this.surName = surnme;
        this.EMPLOYEETYPE = EMPLOYEETYP;
        this.ACCESSLEVEL = ACCESLEVEL;
        this.ROLE = ROL;
        this.PHone = phon;
        this.email = emal;
    }
//    
//    public User(int phone, String userName, String password, String name, String surName, String email, String ROLE, String ACCESSLEVEL, String EMPLOYEETYPE) {
//        this.phone = phone;
//        this.userName = userName;
//        this.password = password;
//        this.name = name;
//        this.surName = surName;
//        this.email = email;
//        this.ROLE = ROLE;
//        this.ACCESSLEVEL = ACCESSLEVEL;
//        this.EMPLOYEETYPE = EMPLOYEETYPE;
//    }

public User(String surName,String name,String ROLE,String ACCESSLEVEL ){
 
    this.surName = surName;
    this.name = name;
    this.ROLE = ROLE;
    this.ACCESSLEVEL = ACCESSLEVEL;
}
//     private String firstName;
//    private String lastName;
//
//    public User(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
//
//    User() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//    

    User(String name, String surname) {
        this.name = name;
        this.surName = surname;
    }



    /**
     * @return the PHone
     */
    public String getPHone() {
        return PHone;
    }

    /**
     * @param PHone the PHone to set
     */
    public void setPHone(String PHone) {
        this.PHone = PHone;
    }
 



//    /**
//     * @return the phone
//     */
//    public int getPhone() {
//        return phone;
//    }
//
//    /**
//     * @param phone the phone to set
//     */
//    public void setPhone(int phone) {
//        this.phone = phone;
//    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surName
     */
    public String getSurName() {
        return surName;
    }

    /**
     * @param surName the surName to set
     */
    public void setSurName(String surName) {
        this.surName = surName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the ROLE
     */
    public String getROLE() {
        return ROLE;
    }

    /**
     * @param ROLE the ROLE to set
     */
    public void setROLE(String ROLE) {
        this.ROLE = ROLE;
    }

    /**
     * @return the ACCESSLEVEL
     */
    public String getACCESSLEVEL() {
        return ACCESSLEVEL;
    }

    /**
     * @param ACCESSLEVEL the ACCESSLEVEL to set
     */
    public void setACCESSLEVEL(String ACCESSLEVEL) {
        this.ACCESSLEVEL = ACCESSLEVEL;
    }

    /**
     * @return the EMPLOYEETYPE
     */
    public String getEMPLOYEETYPE() {
        return EMPLOYEETYPE;
    }

    /**
     * @param EMPLOYEETYPE the EMPLOYEETYPE to set
     */
    public void setEMPLOYEETYPE(String EMPLOYEETYPE) {
        this.EMPLOYEETYPE = EMPLOYEETYPE;
    }
}
