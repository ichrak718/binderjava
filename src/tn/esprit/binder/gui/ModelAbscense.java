/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.gui;

import java.util.Date;


/**
 *
 * @author Rahma
 */
public class ModelAbscense {

    /*static Object getSelectionModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

 

  
    private Integer id;
    private String pupl;
    private int nbr;
    private String date;
    private String subject;
    private String groupe;
     private String hour;
    

    public ModelAbscense(Integer id, String pupl, String groupe, int nbr, String date, String subject, String hour) {
        this.id = id;
        this.pupl = pupl;
        this.nbr = nbr;
        this.subject = subject;
        this.date=date;
        this.groupe = groupe;
        this.hour = hour;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPupl() {
        return pupl;
    }

    public void setPupl(String pupl) {
        this.pupl = pupl;
    }

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }
       public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
    
}
