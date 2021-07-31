/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jiaqi Wang
 * @author PeiLingChiang
 */
public class WardDirectory {
    List<Ward> wardList;
    
    public WardDirectory() {
        wardList = new ArrayList();
    }

    public List<Ward> getWardList() {
        return wardList;
    }

    public void setWardList(List<Ward> wardList) {
        this.wardList = wardList;
    }
    
    public Ward addWard(){
        Ward w = new Ward();
        wardList.add(w);
        return w;
    }
    
    public Ward addWard(int id, int capacity, int remaining, String dep){
        Ward w = new Ward();
        w.setCapacity(capacity);
        w.setRemainingBeds(remaining);
        w.setWardID(id);
        w.setDepartment(dep);
        wardList.add(w);
        return w;
    }
    public void removeWard(Ward w){
        wardList.remove(w);
    }
    
    public Ward searchWard(int keyword){
        for (Ward w : wardList) {
            if(w.getWardID()==(keyword)){
                return w;
            }
        }
        return null;
    }
}
