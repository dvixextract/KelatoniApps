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
public class Teams {
    private String Tnames;
    private String Tmembers;

    public Teams(String teamnames, String membrs) {
        this.Tnames = teamnames;
        this.Tmembers = membrs;
    }
    public Teams(String teamnames) {
        this.Tnames = teamnames;

    }

    /**
     * @return the Tnames
     */
    public String getTnames() {
        return Tnames;
    }

    /**
     * @param Tnames the Tnames to set
     */
    public void setTnames(String Tnames) {
        this.Tnames = Tnames;
    }

    /**
     * @return the Tmembers
     */
    public String getTmembers() {
        return Tmembers;
    }

    /**
     * @param Tmembers the Tmembers to set
     */
    public void setTmembers(String Tmembers) {
        this.Tmembers = Tmembers;
    }
    
}
