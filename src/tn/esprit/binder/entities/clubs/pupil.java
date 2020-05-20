/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.entities.clubs;

/**
 *
 * @author Sam
 */
public class pupil {
     public int id;
     public String name;
      public int grade;
       public String mail;

    public pupil(int aInt, String string, String string0, String string1, String string2, String string3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "pupil{" + "id=" + id + ", name=" + name + ", grade=" + grade + ", mail=" + mail + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public pupil(int id, String name, int grade, String mail) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.mail = mail;
    }
}
