/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital;

/**
 *
 * @author Jiaqi Wang
 */
public class Ward {
    private int wardID;
    private String Department;
    private int remainingBeds;
    private int capacity;

    public int getWardID() {
        return wardID;
    }

    public void setWardID(int wardID) {
        this.wardID = wardID;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRemainingBeds() {
        return remainingBeds;
    }

    public void setRemainingBeds(int remainingBeds) {
        this.remainingBeds = remainingBeds;
    }
    
    @Override
    public String toString(){
        return String.valueOf(this.wardID);
    }

    
}
