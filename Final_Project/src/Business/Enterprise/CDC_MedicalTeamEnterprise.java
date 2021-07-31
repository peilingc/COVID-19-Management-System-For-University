/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author PeiLingChiang
 */
public class CDC_MedicalTeamEnterprise extends Enterprise{
    
    public CDC_MedicalTeamEnterprise(String name){
        super(name,Enterprise.EnterpriseType.CDC_MedicalTeam);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
