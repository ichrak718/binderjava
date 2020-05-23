/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.S;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import tn.esprit.binder.E.Notification;
import tn.esprit.binder.gui.ModelNotification;
import tn.esprit.binder.utils.MyConnection;

/**
 *
 * @author Rahma
 */
public class notificationService {
        
         private Connection cnx;
         private Statement ste;

    public notificationService() {
        cnx = MyConnection.getInstance().getCnx();
    
}
    
     public boolean addnotification(Notification n) {
       /* try {

            String req = "INSERT INTO notification(category, sender, receiver, content) VALUES (?,?,?,?)";
            PreparedStatement pre = cnx.prepareStatement(req);
            pre.setString(1, n.getCategory());
            pre.setString(2, n.getSender());
            pre.setString(3, n.getReceiver());
            pre.setString(4, n.getContent());
            pre.executeUpdate();
            System.out.println("Insertion2 Reussie!");
            cnx.close();
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }*/
              try {
            String req = "INSERT INTO notification(category,sender,receiver,content)"
                    + " VALUES (?,?,?,?)";
            PreparedStatement pre = cnx.prepareStatement(req);
            pre.setString(1, n.getCategory());
            pre.setString(2, n.getSender());
            pre.setString(3, n.getReceiver());
            
            pre.setString(4, n.getContent());
               
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        
    }

         return false;
        }

          
          public ObservableList<ModelNotification> getNotificationList() {

        ObservableList<ModelNotification> obListN = FXCollections.observableArrayList();
        String req = "Select * From notification";
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);
            while (res.next()) {

                obListN.add(new ModelNotification(
                res.getInt("id"),
                res.getString("category"),
                res.getString("sender"),
                res.getString("receiver"),
                res.getString("content")));
            }
            System.out.println(obListN);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return obListN;

    }
          
    public void deletenotifiation(int i) {
        try {
            String req = "DELETE FROM notification WHERE id=" + i;
            PreparedStatement pt;
            pt = cnx.prepareStatement(req);
            pt.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
   public void updateNotification(ModelNotification n) throws SQLException {
        ste = cnx.createStatement();
        String req = "update notification set category = '"
                
                + n.getCategory()
                + "',sender='"
                + n.getSender()
                + "',receiver='"
                + n.getReceiver()
                + "',content='"
                + n.getContent()
                + "' where id = '"
                + n.getId() + "'";
        if (ste.executeUpdate(req) == 1) {
            System.out.println("Done!");
        } 
    }

   

    public List<String> readAllCategoryy() throws SQLException {
     ObservableList<String> obListN = FXCollections.observableArrayList();
         
      
        ste = cnx.createStatement();
        ResultSet res = ste.executeQuery("SELECT * FROM categoryy");
        while (res.next()) {
            int id = res.getInt(1);
            String subject = res.getString("type");
            obListN.add(subject);
        }
        return obListN;
    }

   

    public List<String> readAllRec() throws SQLException {
          ObservableList<String> obListN = FXCollections.observableArrayList();
         
      
        ste = cnx.createStatement();
        ResultSet res = ste.executeQuery("SELECT * FROM parent");
        while (res.next()) {
            int id = res.getInt(1);
            String subject = res.getString("name");
            obListN.add(subject);
        }
        return obListN;
    }

    public List<String> readAllSend() throws SQLException {
          ObservableList<String> obListN = FXCollections.observableArrayList();
         
      
        ste = cnx.createStatement();
        ResultSet res = ste.executeQuery("SELECT * FROM teacher");
        while (res.next()) {
            int id = res.getInt(1);
            String subject = res.getString("fullname");
            obListN.add(subject);
        }
        return obListN;
    }
    


    public List<String> readAllNbrr() throws SQLException {
       ObservableList<String> obListN = FXCollections.observableArrayList();
         
      
        ste = cnx.createStatement();
        ResultSet res = ste.executeQuery("SELECT * FROM numéro");
        while (res.next()) {
            int id = res.getInt(1);
            String subject = res.getString("num");
            obListN.add(subject);
        }
        return obListN;
    }
    }

    
  


          
 
    
      
    
