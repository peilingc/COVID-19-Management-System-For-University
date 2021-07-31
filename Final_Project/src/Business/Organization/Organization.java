/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Person.PersonDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author PeiLingChiang
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private PersonDirectory personDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter=0;
    
    public enum Type{
        
        //University
        UniversityAdminOrg("University Admin Organization"),
        StudentOrg("Student Organization"),
        TestingOrg("Testing Organization"),
        VaccinationOrg("Vaccination Organization"),
        QuarantineOrg("Quarantine Organization"),
        ContactTracingOrg("Contact Tracing Organization"),
        
        //CDC medical team
        CDC_StaffOrg("Medical Team Organization"),
        CDC_DataAnalystOrg("Data Analysis Organization"),
        
        //Hospital
        DoctorOrg("Doctor Organization"),
        HospitalAdminOrg("HospitalAdmin Organization"),
        
        //Pharmaceutical manufacturer
//        SupplierOrg("Supplier Organization"),
        CompanyAdminOrg("CompanyAdmin Organization");
        
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        personDirectory = new PersonDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = counter;
        ++counter;
    }
    
    public Organization(){
        
    }
    
    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }

    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
