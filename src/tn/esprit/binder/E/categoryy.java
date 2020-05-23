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
public class categoryy {
    private Integer id;
    private String type;

    @Override
    public String toString() {
        return "categoryy{" + "id=" + id + ", type=" + type + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public categoryy(Integer id, String type) {
        this.id = id;
        this.type = type;
    }
    
}
