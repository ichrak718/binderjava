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
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.esprit.binder.Iservices.IservicesFOS;
import tn.esprit.binder.entities.FOSUser;
import tn.esprit.binder.utils.MyConnection;

public class ServicesFOS implements IservicesFOS<FOSUser> {

    private Connection c;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet res;

    public ServicesFOS() {
        c = MyConnection.getInstance().getCnx();

    }

    @Override
    public void ajouterUser(FOSUser p) {
        PreparedStatement pt;

      /*  try {
            ste = c.createStatement();
            String req = "INSERT INTO fos_user (username,username_canonical,email,email_canonical,enabled,salt,password,last_login,confirmation_token,password_requested_at,roles)VALUES ('"
                    + p.getUserName() + "','"
                    + p.getUserNameCanonical() + "','"
                    + p.getEmail() + "','"
                    + p.getEmailCanonical() + "','"
                    + p.getEnabled() + "','"
                    + p.getSalt() + "','"
                    + p.getPassword() + "','"
                    + p.getLastLogin() + "','"
                    + p.getConfirmationToken() + "','"
                    + p.getPasswordReq() + "','"
                    + p.getRole() + "')";
            ste.executeUpdate(req);
            System.out.println(p);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }*/
        // PreparedStatement pt = c.prepareStatement("insert into fos_user values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        
        /* PreparedStatement pt = c.prepareStatement("insert into fos_user values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        pt.setString(1, u.getUserName());
        pt.setString(2, u.getUserNameCanonical());
        pt.setString(3, u.getEmail());
        pt.setString(4, u.getEmailCanonical());
        pt.setByte(5, u.getEnabled());
        pt.setString(6, u.getSalt());
        pt.setString(7, u.getPassword());
        pt.setDate(8, u.getLastLogin());
        pt.setString(9, u.getConfirmationToken());
        pt.setDate(10, u.getPasswordReq());
        pt.setString(11, u.getRole());
        
    }
        
*/
        try {
            pt = c.prepareStatement("INSERT INTO fos_user VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
pt.setInt(1, p.getId());
            pt.setString(2, p.getUserName());
            pt.setString(3,p.getUserNameCanonical());
            pt.setString(4, p.getEmail());
            pt.setString(5, p.getEmailCanonical());
            pt.setByte(6, p.getEnabled());
            pt.setString(7, p.getSalt());
            pt.setString(8, p.getPassword());
            pt.setDate(9, p.getLastLogin());
            pt.setString(10, p.getConfirmationToken());
            pt.setDate(11, p.getPasswordReq());
            pt.setString(12, p.getRole());
            pt.executeUpdate();
        } catch (SQLException ex) {
              System.out.println(ex.getMessage());
        }
    }
    @Override
    public FOSUser getUserByUsername(String username) {
        try {
            PreparedStatement pt = c.prepareStatement("select * from fos_user where username = ?");
            pt.setString(1, username);
            ResultSet rs = pt.executeQuery();
            if (rs.next()) {
                FOSUser u = new FOSUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getByte(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getString(10), rs.getDate(11), rs.getString(12));
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesFOS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

 
    public void deleteUser(int i) throws SQLException {
        try {
            String req = "DELETE FROM fos_user WHERE id=" + i;
            PreparedStatement pt;
            pt = c.prepareStatement(req);
            pt.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    
    }
    }


