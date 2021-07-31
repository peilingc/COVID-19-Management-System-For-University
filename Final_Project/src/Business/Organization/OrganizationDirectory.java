/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Hospital.Doctor;
import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author PeiLingChiang
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.StudentOrg.getValue())){
            organization = new StudentOrganization();
            organizationList.add(organization);
        }
        else  if (type.getValue().equals(Type.TestingOrg.getValue())){
            organization = new TestingOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.VaccinationOrg.getValue())){
            organization = new VaccinationOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.QuarantineOrg.getValue())){
            organization = new QuarantineOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.ContactTracingOrg.getValue())){
            organization = new ContactTracingOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.CDC_StaffOrg.getValue())){
            organization = new CDC_StaffOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.CDC_DataAnalystOrg.getValue())){
            organization = new CDC_AnalystOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.DoctorOrg.getValue())){
            organization = new DoctorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type. HospitalAdminOrg.getValue())){
            organization = new HospitalAdminOrganization();
            organizationList.add(organization);
        }

//        else if (type.getValue().equals(Type.SupplierOrg.getValue())){
//            organization = new SupplierOrganization();
//            organizationList.add(organization);
//        }
        
        else if (type.getValue().equals(Type.CompanyAdminOrg.getValue())){
            organization = new CompanyAdminOrganization();
            organizationList.add(organization);
        }
                          
        else if (type.getValue().equals(Type.StudentOrg.getValue())){
            organization = new StudentOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.UniversityAdminOrg.getValue())){
            organization = new UniversityAdminOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.DoctorOrg.getValue())){
            organization = new DoctorOrganization();
            organizationList.add(organization);
        }
        
        return organization;
    }
}