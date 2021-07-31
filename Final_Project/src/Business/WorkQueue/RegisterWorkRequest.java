/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Hospital.Doctor;
import Business.Hospital.Patient;

/**
 *
 * @author PeiLingChiang
 */
public class RegisterWorkRequest extends WorkRequest {
    // Status: Registering or Registered
    private Doctor doctor;
    private Patient patient;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    @Override
    public String toString(){
        return this.getRequestDate().toString();
    }
}
