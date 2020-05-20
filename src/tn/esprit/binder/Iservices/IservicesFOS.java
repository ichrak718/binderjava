/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.Iservices;


import tn.esprit.binder.entities.FOSUser;


/**
 *
 * @author Asus
 */
public interface IservicesFOS<C> {

    public void ajouterUser(FOSUser u);
    public FOSUser getUserByUsername(String username);
 
       

}
