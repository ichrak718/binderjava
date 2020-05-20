/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import tn.esprit.binder.IService.IServiceSubject;
import tn.esprit.binder.entities.Subject;
import tn.esprit.binder.utils.MyConnection;

/**
 *
 * @author wael
 */
public class SubjectService implements IServiceSubject{

    private Connection cnx;
    private Statement st;
    private PreparedStatement pre;

    

    public SubjectService() {
        cnx = MyConnection.getInstance().getCnx();
    }

    

    
    public boolean updateSubject(Subject s) throws SQLException {
        String req = "UPDATE `subjec` SET `name`= '"+ s.getName()+"',`teachers`= '"+ s.getTeachers()+"',`classes`= '"+ s.getClasses()+"' where id= '"+ s.getId()+"' ";
         st = cnx.createStatement();
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
    
    
    
    
    
    public void deleteSubject(int id) {
String req = "delete from subjec where id =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = cnx.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"suppression avec succes");

        } catch (SQLException ex) {
            ex.printStackTrace();
          
        }
                
    }
    
    public List<Subject> searchSubject(String str) {
          List<Subject> subject=new ArrayList<Subject>();
        String sql = "SELECT * FROM subjec WHERE name LIKE "+str;
        PreparedStatement statement;
        
        try {

         statement= cnx.prepareStatement(sql);
            statement.setString(1,"%" + str + "%");
            //statement.setString(2, "%" + str + "%");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
               Subject c = new Subject();
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                 c.setTeachers(rs.getString(3));
                  c.setClasses(rs.getString(4));
               subject.add(c);
            }
        } catch (SQLException ex) {

        }
        return subject;
    }
    
    public void addSubject(Subject s) {

        try {
            String req = "INSERT INTO subjec (name, teachers, classes) VALUES "
                     + "('" + s.getName()+ "', '" + s.getTeachers()+ "', '" + s.getClasses()+ "')";

            st = cnx.createStatement();

            st.executeUpdate(req);

            System.out.println("Insertion Reussie!");

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    
    public List<Subject> showAllSub() {

        List<Subject> listC = new ArrayList<>();

        try {

            String req = "SELECT * FROM subjec";

            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);

            while (res.next()) {
                Subject s = new Subject();

                s.setId(res.getInt("id"));
                s.setName(res.getString("name"));
                s.setTeachers(res.getString("teachers"));
                s.setClasses(res.getString("classes"));

                listC.add(s);
            }
                        System.out.println(listC);


        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return listC;
    }

}