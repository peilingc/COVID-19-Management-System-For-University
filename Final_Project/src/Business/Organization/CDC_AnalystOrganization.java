/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CDC_DataAnalystRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author JiaqiWang
 */
public class CDC_AnalystOrganization extends Organization{
    public CDC_AnalystOrganization(){
        super(Type.CDC_DataAnalystOrg.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new CDC_DataAnalystRole());
        return roles;
    }
}
