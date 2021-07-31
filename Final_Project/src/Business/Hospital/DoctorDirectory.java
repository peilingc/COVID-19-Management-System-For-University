/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PeiLingChiang
 * @author Jiaqi Wang
 */
public class DoctorDirectory {
    private List<Doctor> doctorList;

    //not sure
    public DoctorDirectory() {
        doctorList = new ArrayList();
    }
    //
    
    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }
    
    public void addDoctor(Doctor d){
        doctorList.add(d);
    }
    
    public void removeDoctor(Doctor d){
        doctorList.remove(d);
    }
    public Doctor searchDoctorByName(String name)
    {
        for(Doctor d:this.doctorList)
        {
            if(d.getName().equals(name))
                return d;
        }
        return null;
    }
}
