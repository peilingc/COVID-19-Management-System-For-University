/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Busines.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.CDC.StaffRole.CDC_StaffWorkAreaJPanel;

/**
 *
 * @author PeiLingChiang
 */
public class CDC_StaffRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system) {
        return new CDC_StaffWorkAreaJPanel(userProcessContainer, account, organization,enterprise, system);
    }
    
}
