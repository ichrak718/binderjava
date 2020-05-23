/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.ent;

/**
 *
 * @author Rahma
 */
public class seance {
      private Integer id;
    private String heure;

    @Override
    public String toString() {
        return "seance{" + "id=" + id + ", heure=" + heure + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public seance(Integer id, String heure) {
        this.id = id;
        this.heure = heure;
    }
    
}
