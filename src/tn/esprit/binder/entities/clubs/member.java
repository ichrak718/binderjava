/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.entities.clubs;

/**
 *
 * @author Sam
 */
public class member {
    private int id;
    private String name;
    private String classe;
    
    private int id_club;

    public member() {
    }

    public member(int id, String name, String classe, int id_club) {
        this.id = id;
        this.name = name;
        this.classe = classe;
        this.id_club = id_club;
    }

    public member(String name, String classe, int clubId) {
        this.name = name;
        this.classe = classe;
        this.id_club = clubId;
    }

    public member(int clubId, String name, String classe) {
        this.id_club = clubId;
        this.name = name;
        this.classe = classe;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getId_club() {
        return id_club;
    }

    public void setId_club(int id_club) {
        this.id_club = id_club;
    }

    @Override
    public String toString() {
        return "member{" + "id=" + id + ", name=" + name + ", classe=" + classe + ", id_club=" + id_club + '}';
    }

   
    

    
    
    
}
