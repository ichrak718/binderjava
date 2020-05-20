/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.services.club;


import tn.esprit.binder.utils.MyConnection;
import tn.esprit.binder.entities.clubs.club;
import tn.esprit.binder.entities.clubs.teacher;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javax.swing.JOptionPane;
import tn.esprit.binder.Iservices.club.IClubService;

/**
 *
 * @author Sam
 */
public class ClubService implements IClubService{
         Connection cn = MyConnection.getInstance().getCnx();
    Statement st; //execute la req
    PreparedStatement pst;
    FileInputStream fls;
   
   // final ObservableList options = FXCollections.observableArrayList();
    // ComboBox combobox = new ComboBox(options);
    
    
     @Override
    public List<club> getAll() {
List<club> clubs = new ArrayList<>();
        String req = "select * from club ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = cn.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                club c = new club(
                       resultSet.getInt("id"),
                       resultSet.getString("name"),
                        resultSet.getString("specialty"),
                        resultSet.getString("responsible")
                        
                      
                        
                       
                        
                );
                clubs.add(c); 
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clubs;
    }
    
    


@Override
    public void deleteClub(int id) {
String req = "delete from club where id =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = cn.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"supprition avec succes");

        } catch (SQLException ex) {
            ex.printStackTrace();
          
        }
                
    }
    
    
    
     @Override
    public void addClub(club c) throws SQLException {
                 try {
 
 
           Connection con =MyConnection.getInstance().getCnx();
            //Excecute la requete et envoie dans ResultSet
 
 
 
            String RequeteAjout = "INSERT INTO `club`( `id`,`name`, `specialty`,`responsible`) VALUES ('"+c.getId()+"','"+c.getName()+"','"+c.getSpecialty()+"','"+c.getResponsible()+"')";
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
    
    
    @Override
    public List<club> rechercheClub(String str) {
          List<club> club=new ArrayList<club>();
        String sql = "SELECT * FROM club WHERE name LIKE ? ";
        PreparedStatement statement;
        
        try {

         statement= cn.prepareStatement(sql);
            statement.setString(1,"%" + str + "%");
            //statement.setString(2, "%" + str + "%");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
               club c = new club();
               // c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                 c.setSpecialty(rs.getString(3));
                  c.setResponsible(rs.getString(4));
                
               club.add(c);
            }
        } catch (SQLException ex) {
            
        }
        return club;
    }
    
    
    
     @Override
    public boolean updateClub(club c) throws SQLException {
        String req = "UPDATE `club` SET `name`= '"+ c.getName()+"',`specialty`= '"+ c.getSpecialty()+"',`responsible`= '"+ c.getResponsible()+"' ";
         st = cn.createStatement();
        if(st.executeUpdate(req) == 1)
        {
            System.out.println("succes !");
        return true;   
        }
        else 
        {
            System.out.println(" introuvable");
            return false;
        }
        }

    @Override
    public void deleteClubmodified(int id) {
     
String req = "delete from club where id =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = cn.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
           

        } catch (SQLException ex) {
            ex.printStackTrace();
          
        }
                
    }

    @Override
    public void addClubmodify(club c) throws SQLException {
                    try {
 
 
           Connection con =MyConnection.getInstance().getCnx();
            //Excecute la requete et envoie dans ResultSet
 
 
 
            String RequeteAjout = "INSERT INTO `club`( `id`,`name`, `specialty`,`responsible`) VALUES ('"+c.getId()+"','"+c.getName()+"','"+c.getSpecialty()+"','"+c.getResponsible()+"')";
            /*TFPrenom.getText(), TFNom.getText(), TFPoste.getText(), TFDate_de_naissance.getText() , TFNationalite.getText()*/
              
       
           pst = con.prepareStatement(RequeteAjout);
            pst.executeUpdate(RequeteAjout);
             JOptionPane.showMessageDialog(null,"modifier avec succes");
           
        
          
            //TEST DEBUG///

        } 
        
        catch (SQLException e) {
            System.out.println("update impossible à effectuer.\nErreur :" + e);
        }
    
    }
    
    public ObservableList<String> readAllT() throws SQLException {
        ObservableList<String> arr = FXCollections.observableArrayList();
        pst = cn.prepareStatement("SELECT fullname FROM teacher");
       ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            
            String subject = rs.getString("fullname");
            System.out.println(subject+"vvvvvvvvv");
            arr.add(subject);
        }
        return arr;
    }}
    
    
    
    

