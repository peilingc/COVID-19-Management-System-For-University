/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.University.Student;

/**
 *
 * @author PeiLingChiang
 */
public class MissingWorkRequest extends WorkRequest{
    // Status: Sent / dead / contacted / hospital 
    
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    @Override
    public String toString(){
        return this.getRequestDate().toString();
    }
    
}
