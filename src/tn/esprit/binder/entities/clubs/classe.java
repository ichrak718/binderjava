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
public class classe {
    private int id;
    private String name;

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

    public classe(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public classe() {
    }

    @Override
    public String toString() {
        return "classe{" + "id=" + id + ", name=" + name + '}';
    }
    
    
}
