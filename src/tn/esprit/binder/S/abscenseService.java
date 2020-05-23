/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.S;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.esprit.binder.E.Abscense;

import tn.esprit.binder.gui.ModelAbscense;
import tn.esprit.binder.gui.ModelNotification;
import tn.esprit.binder.utils.MyConnection;

/**
 *
 * @author Rahma
 */
public class abscenseService {
    
    
     private Connection cnx;
      private Statement ste;

    public abscenseService() {
        cnx = MyConnection.getInstance().getCnx();
    
}

   
        public void addabscense(Abscense a) {
         /*try {

           String req = "INSERT INTO abscense(pupl, nbr, date, subject, groupe, hour) VALUES (?,?,?,?,?,?)";
            PreparedStatement pre = cnx.prepareStatement(req);
            pre.setString(1, a.getPupl());
            pre.setFloat(2, a.getNbr());
            //pre.setDate(3, new java.sql.Date( a.getDate().getTime()));
            pre.setString(3, a.getDate());
            pre.setString(4, a.getSubject());
            
            pre.setString(5, "3A");
            pre.setString(6, a.getHour());
            
            pre.executeUpdate();
            System.out.println("Insertion2 Reussie!");
            cnx.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }*/
           /*try {
            String req = "INSERT INTO abscense(pupl,groupe,nbr,date,hour,subject)"
                    + " VALUES (?,?,?,?,?,?)";
            PreparedStatement pre = cnx.prepareStatement(req);
            pre.setString(1, "Asma Hatira");
            //pre.setString(2, a.getGroupe());
            pre.setString(2, "3A");
            //pre.setInt(3, a.getNbr());
            pre.setInt(3, 4);
            //pre.setString(4, a.getDate());
            pre.setString(4, "02/20/2020");
            //pre.setDate(4, new java.sql.Date( a.getDate().getTime()));
           // pre.setString(5, a.getHour());
           pre.setString(5, "10:00->11:00");
           // pre.setString(6, a.getSubject());
            pre.setString(6, "francais");
               
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        
    }

         return false;*/
               try {
            ste = cnx.createStatement();
            String req = "INSERT INTO abscense VALUES (NULL, '" + a.getPupl() + "','" + a.getGroupe() + "','" + a.getNbr() + "','" + a.getDate() + "','" + a.getHour() + "','" + a.getSubject() + "','" + "')";
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        }
       public ObservableList<ModelAbscense> getAbscenseList() {

        ObservableList<ModelAbscense> obListAb = FXCollections.observableArrayList();
        String req = "Select * From abscense";
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);
            while (res.next()) {

                obListAb.add(new ModelAbscense(
                res.getInt("id"),
                res.getString("pupl"),
                res.getString("groupe"),
                res.getInt("nbr"),
                res.getString("date"),
                res.getString("subject"),
                res.getString("hour")));
            
           
                        }
            System.out.println(obListAb);
           // obList.add(a);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return obListAb;

    }
         public void updateAbscense(ModelAbscense a) throws SQLException {
        ste = cnx.createStatement();
        String req = "update abscense set pupl='"
                + a.getPupl()
                + "',groupe='"
                 + a.getGroupe()
                + "',nbr='"
                + a.getNbr()
                + "',date='"
                //+ new java.sql.Date( a.getDate().getTime())
                +a.getDate()
                + "',subject='"
                + a.getSubject()
                + "' where id = '"
                + a.getId() + "'"
                ;
        
         System.out.println(a.getId());
   
        if (ste.executeUpdate(req) == 1) {
            System.out.println("Done!");
        } 
    }
         
     
            
            
           public void deleteabscense(int i) {
        try {
            String req = "DELETE FROM abscense WHERE id=" + i;
            PreparedStatement pt;
            pt = cnx.prepareStatement(req);
            pt.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
           }
           
 
    public List<String> readAllSubjectt() throws SQLException {
        ObservableList<String> obListAb = FXCollections.observableArrayList();
         
        //ste = cnx.prepareStatement();
        //statement= cnx.prepareStatement("SELECT * FROM subjectt");
       // ResultSet res = ste.executeQuery();
        ste = cnx.createStatement();
        ResultSet res = ste.executeQuery("SELECT * FROM subject");
        while (res.next()) {
            int id = res.getInt(1);
            String subject = res.getString("subjectName");
            obListAb.add(subject);
        }
        return obListAb;
    }

   public List<String> readAllPupl() throws SQLException {
            ObservableList<String> obListAb = FXCollections.observableArrayList();
         
      
        ste = cnx.createStatement();
        ResultSet res = ste.executeQuery("SELECT * FROM pupils");
        while (res.next()) {
            int id = res.getInt(1);
            String subject = res.getString("fullname");
            obListAb.add(subject);
        }
        return obListAb;
    }

    public List<String> readAllGrop() throws SQLException {
            ObservableList<String> obListAb = FXCollections.observableArrayList();
         
      
        ste = cnx.createStatement();
        ResultSet res = ste.executeQuery("SELECT * FROM classes");
        while (res.next()) {
            int id = res.getInt(1);
            String subject = res.getString("name");
            obListAb.add(subject);
        }
        return obListAb;
    }
    

       
    public ObservableList<ModelAbscense> rechercheActivity(String str) {
          ObservableList<ModelAbscense> obListAb = FXCollections.observableArrayList();
        String sql = "SELECT * FROM abscense WHERE pupl LIKE ? ";
        PreparedStatement statement;
        
        try {

         statement= cnx.prepareStatement(sql);
            statement.setString(1,"%" + str + "%");
            //statement.setString(2, "%" + str + "%");
            ResultSet res = statement.executeQuery();

           while (res.next()) {

                obListAb.add(new ModelAbscense(
                res.getInt("id"),
                res.getString("pupl"),
                res.getString("groupe"),
                res.getInt("nbr"),
                res.getString("date"),
                res.getString("subject"),
                res.getString("hour")));
            }
        } catch (SQLException ex) {
            
        }
        return obListAb;
    }

    public List<String> readAllHrr() throws SQLException {
 ObservableList<String> obList = FXCollections.observableArrayList();
         
        //ste = cnx.prepareStatement();
        //statement= cnx.prepareStatement("SELECT * FROM subjectt");
       // ResultSet res = ste.executeQuery();
        ste = cnx.createStatement();
        ResultSet res = ste.executeQuery("SELECT * FROM seance");
        while (res.next()) {
            int id = res.getInt(1);
            String subject = res.getString("heure");
            obList.add(subject);
        }
        return obList;    }

}
           
    
