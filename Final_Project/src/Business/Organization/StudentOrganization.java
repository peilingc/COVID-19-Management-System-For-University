/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.StudentRole;
import java.util.ArrayList;

/**
 *
 * @author PeiLingChiang
 */
public class StudentOrganization extends Organization{

    public StudentOrganization() {
        super(Type.StudentOrg.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new StudentRole());
        return roles;
    }
    
}
