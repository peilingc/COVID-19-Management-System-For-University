/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Busines.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author PeiLingChiang
 */
public abstract class Role {
    
    public enum RoleType{
        
        //university
        Student("Student"),  //student register hospital -> patient
        TestingStaff("TestingStaff"),
        VaccinationStaff("VaccinationStaff"),
        QuarantineStaff("QuarantineStaff"),
        ContactTracingStaff("ContactTracingStaff"),
        
        //cdc team
        CDC_Staff("CDC_Staff"),
        CDC_Analyst("CDC_Analyst"),
        
        //hospital
        Doctor("Doctor"),
        HospitalAdmin("HospitalAdmin"),  //customer of medical product
        
        //pharmaceutical manufacturer 
//        Supplier("Supplier"),

        CompanyAdmin("CompanyAdmin"),
        //system admin
        SystemAdmin("SystemAdmin");
        
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
                                          UserAccount account, 
                                          Organization organization, 
                                          Enterprise enterprise, 
                                          EcoSystem business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}