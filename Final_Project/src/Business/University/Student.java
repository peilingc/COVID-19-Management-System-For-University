/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.University;

import Business.Person.Person;
import java.time.LocalDate;


/**
 *
 * @author PeiLingChiang 
 */
public class Student extends Person{
    
    private int phoneNumber;
    private String address;
    private String State;
    private String zipcode;
    private String gender;
    private int age;
    private String country_of_citizenship;
    private int classroomID;
    private String testingStatus;       // "", "negative", "positive", "immune", "dead"
    private String registeringStatus;   // "", "Registering", "Registered"
    private String contactStatus;       // "", "close contact", "quarantine", "hospital"
    private boolean ContactTraced;      
    private LocalDate QuarantineStartDate;
    
    private String height;
    private double weight;
    private String bloodtype;
    private boolean pregant;
    private String medicalHistory;
    private String adverseReactions;
    private String emergencyContactName;
    private int emergencyContactPhone;

    public Student() {
        //init, not null
        this.testingStatus = ""; 
        this.contactStatus = "";
        this.registeringStatus="";
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry_of_citizenship() {
        return country_of_citizenship;
    }

    public void setCountry_of_citizenship(String country_of_citizenship) {
        this.country_of_citizenship = country_of_citizenship;
    }

    public int getClassroomID() {
        return classroomID;
    }

    public void setClassroomID(int classroomID) {
        this.classroomID = classroomID;
    }

    public String getTestingStatus() {
        return testingStatus;
    }

    public void setTestingStatus(String testingStatus) {
        this.testingStatus = testingStatus;
    }

    public String getContactStatus() {
        return contactStatus;
    }

    public void setContactStatus(String contactStatus) {
        this.contactStatus = contactStatus;
    }

    public boolean isContactTraced() {
        return ContactTraced;
    }

    public void setContactTraced(boolean ContactTraced) {
        this.ContactTraced = ContactTraced;
    }

    public LocalDate getQuarantineStartDate() {
        return QuarantineStartDate;
    }

    public void setQuarantineStartDate(LocalDate QuarantineStartDate) {
        this.QuarantineStartDate = QuarantineStartDate;
    }

    public String getRegisteringStatus() {
        return registeringStatus;
    }

    public void setRegisteringStatus(String registeringStatus) {
        this.registeringStatus = registeringStatus;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    public boolean isPregant() {
        return pregant;
    }

    public void setPregant(boolean pregant) {
        this.pregant = pregant;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getAdverseReactions() {
        return adverseReactions;
    }

    public void setAdverseReactions(String adverseReactions) {
        this.adverseReactions = adverseReactions;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public int getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(int emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }
    
}