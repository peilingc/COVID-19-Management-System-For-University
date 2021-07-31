
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Busines;

import Business.Hospital.DoctorDirectory;
import Business.Hospital.PatientDirectory;
import Business.Hospital.WardDirectory;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Pharmaceutical_Manufacturer.MasterOrderCatalog;
import Business.Pharmaceutical_Manufacturer.SupplierDirectory;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.University.StudentDirectory;
import Business.UserAccount.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author PeiLingChiang
 */
public class EcoSystem extends Organization{

    private static EcoSystem business;
    private ArrayList<Network> networkList;
    private StudentDirectory studentDir;
    private UserAccountDirectory userAccountDir;
    private DoctorDirectory doctorDir;
    private PatientDirectory patientDir;
    private WardDirectory wardDir;
    private SupplierDirectory supplierDir;
    private MasterOrderCatalog moc;
    
    /**
    private EcoSystem(OrganizationDirectory organizationDir,StudentDirectory studentDir,DoctorDirectory doctorDir,PatientDirentory patientDirentory,WardDirectory wardDir,SupplierDirectory supplierDirectory,MasterOrderCatalog moc) {
        super(null);
        this.organizationDir=organizationDir;
        this.studentDir=studentDir;
        this.doctorDir=doctorDir;
        this.patientDirentory=patientDirentory;
        this.wardDir=wardDir;
        this.supplierDirectory=supplierDirectory;
        this.moc=moc;
    }
    
    public OrganizationDirectory getOrganizationDir() {
        return organizationDir;
    }
    **/ 
    
    public Network createAndAddNetwork(){
        Network network=new Network();
        networkList.add(network);
        return network;
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    public EcoSystem(){
        super(null);
        //enterpriseDir = new EnterpriseDirectory();
        //organizationDir = new OrganizationDirectory();
        doctorDir = new DoctorDirectory();
        wardDir = new WardDirectory();
        networkList=new ArrayList<Network>();
        studentDir = new StudentDirectory();
        userAccountDir = new UserAccountDirectory();
        patientDir = new PatientDirectory();
        supplierDir = new SupplierDirectory();
        moc = new MasterOrderCatalog();
    }
    
    public static EcoSystem getInstance(){
        if(business==null){
            business=new EcoSystem();
        }
        return business;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    
    public StudentDirectory getStudentDir() {
        return studentDir;
    }
    
    public UserAccountDirectory getUserAccountDir(){
        return userAccountDir;
    }

    public DoctorDirectory getDoctorDir() {
        return doctorDir;
    }

    public PatientDirectory getPatientDir() {
        return patientDir;
    }

    public WardDirectory getWardDir() {
        return wardDir;
    }
    
    public SupplierDirectory getSupplierDirectory() {
        return supplierDir;
    }

    public MasterOrderCatalog getMoc() {
        return moc;
    }
    
    public boolean checkIfUserIsUnique(String userName){
        if(!this.getUserAccountDirectory().checkIfUsernameIsUnique(userName)){
            return false;
        }
        for(Network network:networkList){
            
        }
        return true;
    }
}
