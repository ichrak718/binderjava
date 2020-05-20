/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.entities;

import java.sql.Date;


/**
 *
 * @author Asus
 */
public class FOSUser {
    
    int id;
    String userName;
    String userNameCanonical;
    String email;
    String emailCanonical;
    byte enabled;
    String salt;
    String password;
    Date  lastLogin;
    String confirmationToken;
    Date passwordReq;
    String role;

    public FOSUser(int id, String userName, String userNameCanonical, String email, String emailCanonical, byte enabled, String salt, String password, Date lastLogin, String confirmationToken, Date passwordReq, String role) {
        this.id = id;
        this.userName = userName;
        this.userNameCanonical = userNameCanonical;
        this.email = email;
        this.emailCanonical = emailCanonical;
        this.enabled = enabled;
        this.salt = salt;
        this.password = password;
        this.lastLogin = lastLogin;
        this.confirmationToken = confirmationToken;
        this.passwordReq = passwordReq;
        this.role = role;
    }

    public FOSUser(String userName, String userNameCanonical, String email, String emailCanonical, byte enabled, String salt, String password, Date lastLogin, String confirmationToken, Date passwordReq, String role) {
        this.userName = userName;
        this.userNameCanonical = userNameCanonical;
        this.email = email;
        this.emailCanonical = emailCanonical;
        this.enabled = enabled;
        this.salt = salt;
        this.password = password;
        this.lastLogin = lastLogin;
        this.confirmationToken = confirmationToken;
        this.passwordReq = passwordReq;
        this.role = role;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNameCanonical() {
        return userNameCanonical;
    }

    public void setUserNameCanonical(String userNameCanonical) {
        this.userNameCanonical = userNameCanonical;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailCanonical() {
        return emailCanonical;
    }

    public void setEmailCanonical(String emailCanonical) {
        this.emailCanonical = emailCanonical;
    }

    public byte getEnabled() {
        return enabled;
    }

    public void setEnabled(byte enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Date getPasswordReq() {
        return passwordReq;
    }

    public void setPasswordReq(Date passwordReq) {
        this.passwordReq = passwordReq;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "FOSUser{" + "id=" + id + ", userName=" + userName + ", userNameCanonical=" + userNameCanonical + ", email=" + email + ", emailCanonical=" + emailCanonical + ", enabled=" + enabled + ", salt=" + salt + ", password=" + password + ", lastLogin=" + lastLogin + ", confirmationToken=" + confirmationToken + ", passwordReq=" + passwordReq + ", role=" + role + '}';
    }

    
    
    
    
    
}
