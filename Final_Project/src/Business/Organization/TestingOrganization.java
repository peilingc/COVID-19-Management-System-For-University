/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Role.Role;
import Business.Role.TestingStaffRole;
import java.util.ArrayList;

/**
 *
 * @author PeiLingChiang
 */
public class TestingOrganization extends Organization{

    public TestingOrganization() {
        super(Type.TestingOrg.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new TestingStaffRole());
        return roles;
    }
     
}
