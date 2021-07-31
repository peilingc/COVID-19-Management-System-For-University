/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author PeiLingChiang
 */
public class TestingWorkRequest extends WorkRequest{
    //Status: sent or completed
    
    private String testResult;    //positiv or negative

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }
    
    @Override
    public String toString(){
        return this.getSender().toString();
    }
}
