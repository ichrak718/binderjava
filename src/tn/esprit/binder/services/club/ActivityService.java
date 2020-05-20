/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.services.club;



import tn.esprit.binder.Iservices.club.IActivityService;
import tn.esprit.binder.utils.MyConnection;
import tn.esprit.binder.entities.clubs.activity;
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
import javax.swing.JOptionPane;

/**
 *
 * @author Sam
 */
public class ActivityService implements IActivityService{
      Connection cn = MyConnection.getInstance().getCnx();
    Statement st; //execute la req
    PreparedStatement pst;
    FileInputStream fls;
    
    
     @Override
    public List<activity> getAll() {
List<activity> activities = new ArrayList<>();
        String req = "select * from activity ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = cn.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                 activity c = new activity(
                        resultSet.getInt("id"),
                          resultSet.getInt("id_club"),
                       
                        resultSet.getString("about"),
                        resultSet.getString("duration"),
                        resultSet.getString("location"),
                        
                         resultSet.getString("dateA"),
                      
                          resultSet.getString("clubAC")
                        
                        
                      
                        
                       
                        
                );
                activities.add(c); 
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return activities;
    }
    
    
    
    @Override
    public void deleteActivity(int id) {
String req = "delete from activity where id =?";
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
    public void addActivity(activity c) throws SQLException {
                 try {
 
 
           Connection con =MyConnection.getInstance().getCnx();
            //Excecute la requete et envoie dans ResultSet
 
 
 
            String RequeteAjout = "INSERT INTO `activity`( `id`,`id_club`,`about`,`duration`, `location`,`dateA`,`clubAC`) VALUES ('"+c.getId()+"','"+c.getId_club()+"','"+c.getAbout()+"','"+c.getDuration()+"','"+c.getLocation()+"','"+c.getDateA()+"','"+c.getClubAC()+"')";
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
    public List<activity> rechercheActivity(String str) {
          List<activity> activity=new ArrayList<activity>();
        String sql = "SELECT * FROM activity WHERE about LIKE ? ";
        PreparedStatement statement;
        
        try {

         statement= cn.prepareStatement(sql);
            statement.setString(1,"%" + str + "%");
            //statement.setString(2, "%" + str + "%");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
               activity c = new activity();
                c.setId(rs.getInt(1));
                c.setId_club(rs.getInt(2));
                c.setAbout(rs.getString(3));
                 c.setLocation(rs.getString(4));
                  c.setDuration(rs.getString(5));
                  c.setDateA(rs.getString(6));
                  c.setClubAC(rs.getString(7));
                 
                 
                
               activity.add(c);
            }
        } catch (SQLException ex) {
            
        }
        return activity;
    }
    
    
    
    
    
     @Override
    public boolean updateActivity(activity c) throws SQLException {
        String req = "UPDATE `activity` SET `id`= '"+ c.getId() +"', `id_club`= '"+ c.getId_club() +"',`about`= '"+ c.getAbout()+"',`location`= '"+ c.getLocation()+"',`duration`= '"+ c.getDuration()+"',`dateA`= '"+ c.getDateA()+"',`clubAc`= '"+ c.getClubAC()+"' ";
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
    public void deleteActivitymodified(int id) {
        
        String req = "delete from activity where id =?";
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
    public void addActivitymodify(activity c) throws SQLException {
         try {
 
 
           Connection con =MyConnection.getInstance().getCnx();
            //Excecute la requete et envoie dans ResultSet
 
 
 
            String RequeteAjout = "INSERT INTO `activity`( `id`,`id_club`,`about`, `duration`,`location`,`dateA`,`clubAC`) VALUES ('"+c.getId()+"','"+c.getId_club()+"','"+c.getAbout()+"','"+c.getDuration()+"','"+c.getLocation()+"','"+c.getDateA()+"','"+c.getClubAC()+"')";
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
        pst = cn.prepareStatement("SELECT name FROM club");
       ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            
            String subject = rs.getString("name");
            System.out.println(subject+"vvvvvvvvv");
            arr.add(subject);
        }
        return arr;
    }
       
        
    public ObservableList<String> readAllA() throws SQLException {
        ObservableList<String> arr = FXCollections.observableArrayList();
        pst = cn.prepareStatement("SELECT mail FROM parent");
       ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            
            String subject = rs.getString("mail");
            System.out.println(subject+"vvvvvvvvv");
            arr.add(subject);
        }
        return arr;
    }
    
    
     public int getClubId(String name) throws SQLException {
       int arr = 0;
        pst = cn.prepareStatement( "SELECT * FROM `club` WHERE `name` = '"+name+"'");
       ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            
            return rs.getInt("id");
            
        }
        return arr;
    }
     
     
      @Override
    public List<activity> rechercheActivityClub(String str) {
          List<activity> activity=new ArrayList<activity>();
        String sql = "SELECT * FROM activity WHERE clubAC LIKE ? ";
        PreparedStatement statement;
        
        try {

         statement= cn.prepareStatement(sql);
            statement.setString(1,"%" + str + "%");
            //statement.setString(2, "%" + str + "%");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
               activity c = new activity();
                c.setId(rs.getInt(1));
                c.setId_club(rs.getInt(2));
                c.setAbout(rs.getString(3));
                 c.setLocation(rs.getString(4));
                  c.setDuration(rs.getString(5));
                   c.setDateA(rs.getString(6));
                  c.setClubAC(rs.getString(7));
                 
                
               activity.add(c);
            }
        } catch (SQLException ex) {
            
        }
        return activity;
    }
    
    






}
       
       
    
    

    
   

    
    

