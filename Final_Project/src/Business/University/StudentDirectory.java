/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.University;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PeiLingChiang 
 */
public class StudentDirectory {
    private List<Student> studentList;

    public StudentDirectory() {
        studentList = new ArrayList();
    }
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
    
    public Student createStudent(String name)
    {
        Student student = new Student();
        student.setName(name);
        studentList.add(student);
        return student;
    }
    
}

