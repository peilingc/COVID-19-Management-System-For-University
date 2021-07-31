/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import Business.Hospital.Doctor;
import Business.Pharmaceutical_Manufacturer.Supplier;
import Business.University.Student;
import java.util.ArrayList;

/**
 *
 * @author PeiLingChiang
 */
public class PersonDirectory {
    
    private ArrayList<Person> personList;
    private ArrayList<Student> studentList;
    private ArrayList<Doctor> doctorList;

    public PersonDirectory() {
        personList = new ArrayList();
        studentList = new ArrayList();
        doctorList = new ArrayList();
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(ArrayList<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    public Person createPerson(String name){
        Person person = new Person();
        person.setName(name);
        personList.add(person);
        return person;
    }
    
    public Student createStudent(String name, int phoneNumber, String address, String State, 
                                 String zipcode, String gender, int age, String country_of_citizenship, int classroomID)
    {
        Student student = new Student();
        student.setName(name);
        student.setPhoneNumber(phoneNumber);
        student.setAddress(address);
        student.setState(State);
        student.setZipcode(zipcode);
        student.setGender(gender);
        student.setAge(age);
        student.setCountry_of_citizenship(country_of_citizenship);
        student.setClassroomID(classroomID);
        studentList.add(student);
        personList.add(student);
        return student;
    }
    
    public Student createStudent_simple(String name){
        Student student = new Student();
        student.setName(name);
        studentList.add(student);
        personList.add(student);
        return student;
    }
    
    public Doctor createDoctor(String name){
        Doctor doctor = new Doctor();
        doctor.setName(name);
        doctorList.add(doctor);
        personList.add(doctor);
        return doctor;
    }

}