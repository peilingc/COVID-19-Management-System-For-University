/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital;

import Business.Person.Person;

/**
 *
 * @author Jiaqi Wang
 */
public class Doctor extends Person{
   private String jobTitle;
   private String department;
   private PatientDirectory patientDirentory;
    
    public Doctor(){
        patientDirentory = new PatientDirectory();
    }

    public Doctor(String name,String jobTitle, String department) {
        this.name=name;
        this.jobTitle = jobTitle;
        this.department = department;
    }
   
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public PatientDirectory getPatientDirentory() {
        return patientDirentory;
    }

    public void setPatientDirentory(PatientDirectory patientDirentory) {
        this.patientDirentory = patientDirentory;
    }

    @Override
    public String toString() {
        return this.getName();
    }
   
}
