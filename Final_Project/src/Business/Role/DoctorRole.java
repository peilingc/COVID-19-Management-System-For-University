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
import userinterface.Hospital.DoctorRole.DoctorWorkAreaJPanel;
import userinterface.Hospital.HospitalAdminRole.DoctorManagementJPanel;

/**
 *
 * @author PeiLingChiang
 */
public class DoctorRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system) {

        return new DoctorWorkAreaJPanel(userProcessContainer, account, organization, system);
    }
    
}
