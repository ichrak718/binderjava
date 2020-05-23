/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.E;

/**
 *
 * @author Rahma
 */
public class Abscense {
     private Integer id;
    private String pupl;
    private int nbr;
    private String date;
    private String subject;
    private String groupe;
     private String hour;
     
       public Abscense() {
        
    }

    public Abscense(Integer id, String pupl, int nbr, String date, String subject, String groupe, String hour) {
           this.id = id;
        this.pupl = pupl;
        this.nbr = nbr;
        this.date = date;
        this.subject = subject;
        this.groupe = groupe;
        this.hour = hour;
    }

 

   /* public Abscense() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    @Override
    public String toString() {
        return "Abscense{" + "id=" + id + ", pupl=" + pupl + ", nbr=" + nbr + ", date=" + date + ", subject=" + subject + ", groupe=" + groupe + ", hour=" + hour + '}';
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
