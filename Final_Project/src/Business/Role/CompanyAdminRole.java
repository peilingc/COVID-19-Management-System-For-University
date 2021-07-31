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
import static java.time.Clock.system;
import javax.swing.JPanel;
import userinterface.PharmaceuticalManufacturer.CompanyAdminRole.CompanyAdminWorkAreaJPanel;
import userinterface.PharmaceuticalManufacturer.CompanyAdminRole.ManageSuppliersJPanel;
import userinterface.PharmaceuticalManufacturer.CompanyAdminRole.ManageProductJPanel;

/**
 *
 * @author Jiaqi Wang
 */
public class CompanyAdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system) {

        return new CompanyAdminWorkAreaJPanel(userProcessContainer,account,organization,system);
       
    }
    
}
