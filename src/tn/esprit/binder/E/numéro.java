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
public class numéro {
      private Integer id;
    private Integer num;

    @Override
    public String toString() {
        return "num\u00e9ro{" + "id=" + id + ", num=" + num + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public numéro(Integer id, Integer num) {
        this.id = id;
        this.num = num;
    }
    
}
