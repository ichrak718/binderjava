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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import tn.esprit.binder.IService.IServiceCourse;
import tn.esprit.binder.entities.Course;
import tn.esprit.binder.utils.MyConnection;

/**
 *
 * @author wael
 */
public class CourseService implements IServiceCourse{

    private Connection cnx;
    private Statement st;
    private PreparedStatement pre;

    public CourseService() {
        cnx = MyConnection.getInstance().getCnx();
    }

    
    
    
    public boolean updateCourse(Course c) throws SQLException {
        String req = "UPDATE `course` SET `subject`= '"+ c.getSubject()+"',`content`= '"+ c.getContent()+"',`teacher`= '"+ c.getTeacher()+"' where id= '"+ c.getId()+"' ";
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
    
    
    
    public List<Course> searchCourse(String str) {
          List<Course> course=new ArrayList<Course>();
        String sql = "SELECT * FROM course WHERE subject LIKE "+str;
        PreparedStatement statement;
        
        try {

         statement= cnx.prepareStatement(sql);
            statement.setString(1,"%" + str + "%");
            //statement.setString(2, "%" + str + "%");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
               Course c = new Course();
                c.setId(rs.getInt(1));
                c.setSubject(rs.getString(2));
                 c.setContent(rs.getString(3));
                  c.setTeacher(rs.getString(4));
               course.add(c);
            }
        } catch (SQLException ex) {

        }
        return course;
    }
    
    
    
    public void deleteCourse(int id) {
String req = "delete from course where id =?";
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
    
    
    
    public void addCourse(Course c) {

        try {
            String req = "INSERT INTO course (subject, content, teacher) VALUES "
                    + "('" + c.getSubject() + "', '" + c.getContent() + "', '" + c.getTeacher() + "')";

            st = cnx.createStatement();

            st.executeUpdate(req);

            System.out.println("Insertion Reussie!");

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    
    public List<Course> showAll() {

        List<Course> listC = new ArrayList<>();

        try {

            String req = "SELECT * FROM course";

            st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);

            while (res.next()) {
                Course c = new Course();

                c.setId(res.getInt("id"));
                c.setSubject(res.getString("subject"));
                c.setContent(res.getString("content"));
                c.setTeacher(res.getString("teacher"));

                listC.add(c);
            }
            
            System.out.println(listC);

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return listC;
    }

    public ObservableList<String> readAllSubject() throws SQLException {
        ObservableList<String> arr = FXCollections.observableArrayList();
        pre = cnx.prepareStatement("SELECT * FROM subjec");
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);
            String subject = rs.getString("name");
            arr.add(subject);
        }
        return arr;
    }

}