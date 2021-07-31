/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CDC_StaffRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author PeiLingChiang
 */
public class CDC_StaffOrganization extends Organization{
    
    public CDC_StaffOrganization(){
        super(Type.CDC_StaffOrg.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new CDC_StaffRole());
        return roles;
    }
    
}
