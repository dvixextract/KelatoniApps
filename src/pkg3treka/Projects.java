/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3treka;

/**
 *
 * @author User
 */
public class Projects {

    private String ProjCode;
    private String ProjName;
    private String ProjDuration;
    private String ProjNumOfTasks;
    private String ProjNumOfSprints;
    private String ProjDescriptions;
    private String ProjTeam;
    
    public Projects(String ProjCod,String ProjNam,String ProjDuratn,String ProjNumOfTask,String ProjNumOfSprint,String ProjDescription,String ProjTea){
    
        this.ProjCode = ProjCod;
        this.ProjName = ProjNam;
        this.ProjDuration = ProjDuratn;
        this.ProjNumOfTasks = ProjNumOfTask;
        this.ProjNumOfSprints = ProjNumOfSprint;
        this.ProjDescriptions = ProjDescription;
        this.ProjTeam = ProjTea;
        
    
    }
    /**
     * @return the ProjCode
     */
    public String getProjCode() {
        return ProjCode;
    }

    /**
     * @param ProjCode the ProjCode to set
     */
    public void setProjCode(String ProjCode) {
        this.ProjCode = ProjCode;
    }

    /**
     * @return the ProjName
     */
    public String getProjName() {
        return ProjName;
    }

    /**
     * @param ProjName the ProjName to set
     */
    public void setProjName(String ProjName) {
        this.ProjName = ProjName;
    }

    /**
     * @return the ProjDuration
     */
    public String getProjDuration() {
        return ProjDuration;
    }

    /**
     * @param ProjDuration the ProjDuration to set
     */
    public void setProjDuration(String ProjDuration) {
        this.ProjDuration = ProjDuration;
    }

    /**
     * @return the ProjNumOfTasks
     */
    public String getProjNumOfTasks() {
        return ProjNumOfTasks;
    }

    /**
     * @param ProjNumOfTasks the ProjNumOfTasks to set
     */
    public void setProjNumOfTasks(String ProjNumOfTasks) {
        this.ProjNumOfTasks = ProjNumOfTasks;
    }

    /**
     * @return the ProjNumOfSprints
     */
    public String getProjNumOfSprints() {
        return ProjNumOfSprints;
    }

    /**
     * @param ProjNumOfSprints the ProjNumOfSprints to set
     */
    public void setProjNumOfSprints(String ProjNumOfSprints) {
        this.ProjNumOfSprints = ProjNumOfSprints;
    }

    /**
     * @return the ProjDescriptions
     */
    public String getProjDescriptions() {
        return ProjDescriptions;
    }

    /**
     * @param ProjDescriptions the ProjDescriptions to set
     */
    public void setProjDescriptions(String ProjDescriptions) {
        this.ProjDescriptions = ProjDescriptions;
    }

    /**
     * @return the ProjTeam
     */
    public String getProjTeam() {
        return ProjTeam;
    }

    /**
     * @param ProjTeam the ProjTeam to set
     */
    public void setProjTeam(String ProjTeam) {
        this.ProjTeam = ProjTeam;
    }


    
}
