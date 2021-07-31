/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Busines;

import Business.Enterprise.Enterprise;
import Business.Hospital.Doctor;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Person.Person;
import Business.Role.AdminRole;
import Business.Role.CDC_DataAnalystRole;
import Business.Role.CDC_StaffRole;
import Business.Role.CompanyAdminRole;
import Business.Role.ContactTracingStaffRole;
import Business.Role.DoctorRole;
import Business.Role.HospitalAdminRole;
import Business.Role.QuarantineStaffRole;
import Business.Role.StudentRole;
import Business.Role.SystemAdminRole;
import Business.Role.TestingStaffRole;
import Business.Role.UniversityAdminRole;
import Business.Role.VaccinationStaffRole;
import Business.University.Student;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.FoundDeadWorkRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author PeiLingChiang
 */
public class ConfigureASystem {
     
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        Network network = system.createAndAddNetwork();
        network.setName("Boston");
       
        //create 4 enterprises
        Enterprise h = network.getEnterpriseDirectory().createEnterprise("Hospital", Enterprise.EnterpriseType.Hospital);
        Enterprise u = network.getEnterpriseDirectory().createEnterprise("University", Enterprise.EnterpriseType.University);
        Enterprise cdc = network.getEnterpriseDirectory().createEnterprise("CDC_MedicalTeam", Enterprise.EnterpriseType.CDC_MedicalTeam);
        Enterprise p = network.getEnterpriseDirectory().createEnterprise("PharmaceuticalManufacturer", Enterprise.EnterpriseType.PharmaceuticalManufacturer);
        
        //create 4 enterprise admins
        Person person1 = h.getPersonDirectory().createPerson("h");
        h.getUserAccountDirectory().createUserAccount("h", "h", person1, new AdminRole());
        
        Person person2 = u.getPersonDirectory().createPerson("u");
        u.getUserAccountDirectory().createUserAccount("u", "u", person2, new AdminRole());
        
        Person person3 = cdc.getPersonDirectory().createPerson("cdc");
        cdc.getUserAccountDirectory().createUserAccount("cdc", "cdc", person3, new AdminRole());
        
        Person person4 = p.getPersonDirectory().createPerson("p");
        p.getUserAccountDirectory().createUserAccount("p", "p", person4, new AdminRole());
        
        //create each organization
        Organization docOrg = h.getOrganizationDirectory().createOrganization(Organization.Type.DoctorOrg);
        Organization haOrg = h.getOrganizationDirectory().createOrganization(Organization.Type.HospitalAdminOrg);
        
        Organization stuOrg = u.getOrganizationDirectory().createOrganization(Organization.Type.StudentOrg);
        Organization uaOrg = u.getOrganizationDirectory().createOrganization(Organization.Type.UniversityAdminOrg);
        Organization testOrg = u.getOrganizationDirectory().createOrganization(Organization.Type.TestingOrg);
        Organization vacOrg = u.getOrganizationDirectory().createOrganization(Organization.Type.VaccinationOrg);
        Organization quaOrg = u.getOrganizationDirectory().createOrganization(Organization.Type.QuarantineOrg);
        Organization conOrg = u.getOrganizationDirectory().createOrganization(Organization.Type.ContactTracingOrg);
        
        Organization daOrg = cdc.getOrganizationDirectory().createOrganization(Organization.Type.CDC_DataAnalystOrg);
        Organization cdcStaffOrg = cdc.getOrganizationDirectory().createOrganization(Organization.Type.CDC_StaffOrg);
        

//        Organization supOrg = p.getOrganizationDirectory().createOrganization(Organization.Type.SupplierOrg);

        Organization caOrg = p.getOrganizationDirectory().createOrganization(Organization.Type.CompanyAdminOrg);
        
        
        
        //create each org staff in university
        //create students
        Student s1 = stuOrg.getPersonDirectory().createStudent("s1", 857666444, "407 Squire Rd", "MA", "02151", "male", 24, "USA", 1);
        Student s2 = stuOrg.getPersonDirectory().createStudent("s2", 857665434, "207 Porter St", "MA", "02128", "male", 25, "UK", 1);
        Student s3 = stuOrg.getPersonDirectory().createStudent("s3", 857667544, "660 Washington St", "MA", "02111", "female", 23, "USA", 1);
        Student s4 = stuOrg.getPersonDirectory().createStudent("s4", 857987444, "334 Massachusetts Ave", "MA", "02115", "female", 24, "USA", 1);
        Student s5 = stuOrg.getPersonDirectory().createStudent("s5", 857609844, "25 Evans Way", "MA", "02115", "male", 24, "USA", 1);
        Student s6 = stuOrg.getPersonDirectory().createStudent("s6", 857609887, "50 Goddard Ave", "MA", "02445", "male", 26, "USA", 1);
        
        system.getStudentDir().getStudentList().add(s1);
        system.getStudentDir().getStudentList().add(s2);
        system.getStudentDir().getStudentList().add(s3);
        system.getStudentDir().getStudentList().add(s4);
        system.getStudentDir().getStudentList().add(s5);
        system.getStudentDir().getStudentList().add(s6);
        
        UserAccount ua1 = stuOrg.getUserAccountDirectory().createUserAccount("s1", "s1", s1, new StudentRole());
        UserAccount ua2 = stuOrg.getUserAccountDirectory().createUserAccount("s2", "s2", s2, new StudentRole());
        UserAccount ua3 = stuOrg.getUserAccountDirectory().createUserAccount("s3", "s3", s3, new StudentRole());
        UserAccount ua4 = stuOrg.getUserAccountDirectory().createUserAccount("s4", "s4", s4, new StudentRole());
        UserAccount ua5 = stuOrg.getUserAccountDirectory().createUserAccount("s5", "s5", s5, new StudentRole());
        UserAccount ua6 = stuOrg.getUserAccountDirectory().createUserAccount("s6", "s6", s6, new StudentRole());
        
        //3 dead students 
        s1.setTestingStatus("dead");
        s2.setTestingStatus("dead");
        s3.setTestingStatus("dead");
        
        Date in = new Date();
        LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
        
        FoundDeadWorkRequest wr1 = new FoundDeadWorkRequest();
        wr1.setMessage(s1.getName());
        
        FoundDeadWorkRequest wr2 = new FoundDeadWorkRequest();
        wr2.setMessage(s2.getName());
        
        //ldt = ldt.minusDays(2);
        Date out = Date.from(ldt.minusDays(2).atZone(ZoneId.systemDefault()).toInstant());
        wr1.setRequestDate(out);
        //System.out.println( "1: "+wr1.getRequestDate());
        wr2.setRequestDate(out);
        //System.out.println( "2: "+wr2.getRequestDate());

        
        FoundDeadWorkRequest wr3 = new FoundDeadWorkRequest();
        wr3.setMessage(s3.getName());
        //ldt = ldt.minusDays(1);
        out = Date.from(ldt.minusDays(3).atZone(ZoneId.systemDefault()).toInstant());
        wr3.setRequestDate(out);
        
        daOrg.getWorkQueue().getWorkRequestList().add(wr1);
        daOrg.getWorkQueue().getWorkRequestList().add(wr2);
        daOrg.getWorkQueue().getWorkRequestList().add(wr3);
        
        //3 positive but missing students
        s4.setTestingStatus("positive");
        s5.setTestingStatus("positive");
        s6.setTestingStatus("positive");
        
        s4.setContactStatus("quarantine");
        s5.setContactStatus("quarantine");
        s6.setContactStatus("quarantine");
        
        s4.setQuarantineStartDate(LocalDate.now().minusDays(1));
        s5.setQuarantineStartDate(LocalDate.now().minusDays(1));
        s6.setQuarantineStartDate(LocalDate.now().minusDays(1));
        
        //create 5 kinds of staff 
        Person universityAdmin = uaOrg.getPersonDirectory().createPerson("ua1");
        uaOrg.getUserAccountDirectory().createUserAccount("ua1", "ua1", universityAdmin, new UniversityAdminRole());
        
        Person testingStaff = testOrg.getPersonDirectory().createPerson("t1");
        testOrg.getUserAccountDirectory().createUserAccount("t1", "t1", testingStaff, new TestingStaffRole());
        
        Person vacStaff = vacOrg.getPersonDirectory().createPerson("v1");
        vacOrg.getUserAccountDirectory().createUserAccount("v1", "v1", vacStaff, new VaccinationStaffRole());
        
        Person contactStaff = conOrg.getPersonDirectory().createPerson("c1");
        conOrg.getUserAccountDirectory().createUserAccount("c1", "c1", contactStaff, new ContactTracingStaffRole());
        
        Person quaStaff = quaOrg.getPersonDirectory().createPerson("q1");
        quaOrg.getUserAccountDirectory().createUserAccount("q1", "q1", quaStaff, new QuarantineStaffRole());
        
        
        
        
        //create each org staff in hospital
        //create doctor
        Doctor d1 = docOrg.getPersonDirectory().createDoctor("d1");
        d1.setDepartment("emergency");
        d1.setJobTitle("consultant");
        system.getDoctorDir().addDoctor(d1);
        
        Doctor d2 = docOrg.getPersonDirectory().createDoctor("d2");
        d2.setDepartment("ICU");
        d2.setJobTitle("head of dept.");
        system.getDoctorDir().addDoctor(d2);
        
        docOrg.getUserAccountDirectory().createUserAccount("d1", "d1", d1, new DoctorRole());
        docOrg.getUserAccountDirectory().createUserAccount("d2", "d2", d2, new DoctorRole());
        
        //create hospital admin
        Person ha1 = haOrg.getPersonDirectory().createPerson("ha1");
        haOrg.getUserAccountDirectory().createUserAccount("ha1", "ha1", ha1, new HospitalAdminRole());
                
        
        
        //create each CDC staff in CDC
        //create data analyst
        Person da1 = daOrg.getPersonDirectory().createPerson("da1");
        daOrg.getUserAccountDirectory().createUserAccount("da1", "da1", da1, new CDC_DataAnalystRole());
        
        //create medical team staff
        Person m1 = cdcStaffOrg.getPersonDirectory().createPerson("m1");
        cdcStaffOrg.getUserAccountDirectory().createUserAccount("m1", "m1", m1, new CDC_StaffRole());
        
        
        
        
        //create each staff in PM
        //create supplier
        
//        Person sup1 = supOrg.getPersonDirectory().createPerson("sup1");
//        supOrg.getUserAccountDirectory().createUserAccount("sup1", "sup1", sup1, new SupplierRole());
//        

        
        //create company
        Person ca1 = caOrg.getPersonDirectory().createPerson("ca1");
        caOrg.getUserAccountDirectory().createUserAccount("ca1", "ca1", ca1, new CompanyAdminRole());
        
        
        //create essential list
        //create wards
        system.getWardDir().addWard(1, 15, 15, "emergency");
        system.getWardDir().addWard(2, 5, 5, "covid-19");
        
        //create Products or something else
        //寫在這邊！！
       
        
        //create system admin
        Person person = system.getPersonDirectory().createPerson("sysadmin");
        system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", person, new SystemAdminRole());
        
        return system;
    }
    
}
