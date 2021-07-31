/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital;

import Business.University.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jiaqi Wang
 * @author PeiLingChiang
 */
public class PatientDirectory {
    private List<Patient> patientList;

    public PatientDirectory() {
        patientList = new ArrayList();
    }
    
    
    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }
    
    public Patient addPatient(Student s){
        Patient p = new Patient();
        p.setStudent(s);
        patientList.add(p);
        return p;
    }
    
    public void removePatient(Patient p){
        patientList.remove(p);
    }
}
