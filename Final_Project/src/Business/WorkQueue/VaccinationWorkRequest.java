/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author PeiLingChiang
 */
public class VaccinationWorkRequest extends WorkRequest {
    //Status: sent or completed
    @Override
    public String toString(){
        return this.getSender().toString();
    }
}
