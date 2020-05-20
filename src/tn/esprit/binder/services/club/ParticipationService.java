/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.services.club;

import tn.esprit.binder.Iservices.club.IParticipationService;
import tn.esprit.binder.utils.MyConnection;
import tn.esprit.binder.entities.clubs.member;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author Sam
 */
public class ParticipationService  implements IParticipationService{
    
    
    
    
         Connection cn = MyConnection.getInstance().getCnx();
    Statement st; //execute la req
    PreparedStatement pst;
    FileInputStream fls;


    @Override
    public void addMember(member m) throws SQLException {
        
   
        
        
         try {
 
 
           Connection con =MyConnection.getInstance().getCnx();
            //Excecute la requete et envoie dans ResultSet
 
 
            
             System.out.println("test id"+m.toString());
            String RequeteAjout = "INSERT INTO `participation`(`name`, `classe`, `id_club`) VALUES ('"+m.getName()+"','"+m.getClasse()+"','"+m.getId_club()+"')";
            /*TFPrenom.getText(), TFNom.getText(), TFPoste.getText(), TFDate_de_naissance.getText() , TFNationalite.getText()*/
              
           pst = con.prepareStatement(RequeteAjout);
            pst.executeUpdate(RequeteAjout);
            JOptionPane.showMessageDialog(null,"Ajout avec succes");
        
          
            //TEST DEBUG///

        } 
        
        catch (SQLException e) {
            System.out.println("Ajout impossible à effectuer.\nErreur :" + e);
        }
    
        
        
    }
    
    
    
     public ObservableList<String> readAllPu() throws SQLException {
        ObservableList<String> arr = FXCollections.observableArrayList();
        pst = cn.prepareStatement("SELECT name FROM club");
       ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            
            String subject = rs.getString("name");
            System.out.println(subject+"vvvvvvvvv");
            arr.add(subject);
        }
        return arr;
    }
     
     
      public ObservableList<String> readAllCL() throws SQLException {
        ObservableList<String> arr = FXCollections.observableArrayList();
        pst = cn.prepareStatement("SELECT name FROM classe");
       ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            
            String subject = rs.getString("name");
            System.out.println(subject+"vvvvvvvvv");
            arr.add(subject);
        }
        return arr;
    }
      
      
      
       

    }
    

