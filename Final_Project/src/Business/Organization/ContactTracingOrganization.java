/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.ContactTracingStaffRole;
import java.util.ArrayList;

/**
 *
 * @author PeiLingChiang
 */
public class ContactTracingOrganization extends Organization{

    public ContactTracingOrganization() {
        super(Type.ContactTracingOrg.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new ContactTracingStaffRole());
        return roles;
    }
    
}
