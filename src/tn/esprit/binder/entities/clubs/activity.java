/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.entities.clubs;

import java.time.LocalDate;
import javafx.scene.control.TableColumn;

    /**
 *
 * @author Sam
 */
public class activity {
        
 public int id;
  private int id_club;
     public String about;
      public String duration;
       public String location;
      
        public String dateA;
        public String clubAC;

    public activity() {
    }

   

    



    
    public String getClubAC() {
        return clubAC;
    }

    public void setClubAC(String clubAC) {
        this.clubAC = clubAC;
    }

    public activity(int id, int id_club, String about, String duration, String location, String dateA, String clubAC) {
        this.id = id;
        this.id_club = id_club;
        this.about = about;
        this.duration = duration;
        this.location = location;
        this.dateA = dateA;
        this.clubAC = clubAC;
    }

    public activity(int id_club, String about, String duration, String location, String dateA, String clubAC) {
        this.id_club = id_club;
        this.about = about;
        this.duration = duration;
        this.location = location;
        this.dateA = dateA;
        this.clubAC = clubAC;
    }

   

  


    



   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateA() {
        return dateA;
    }

    public void setDateA(String dateA) {
        this.dateA = dateA;
    }

    public int getId_club() {
        return id_club;
    }

    public void setId_club(int id_club) {
        this.id_club = id_club;
    }

    @Override
    public String toString() {
        return "activity{" + "id=" + id + ", id_club=" + id_club + ", about=" + about + ", duration=" + duration + ", location=" + location + ", dateA=" + dateA + ", clubAC=" + clubAC + '}';
    }

    


   
     
      public String message() {
        return  " good evening Sir/Madame , we are pleased to infor you that this event this event is about :  "   + about + " and it lasts " + duration +" hours " + " and it it's located at "+ location + "  and it concerns the club "+clubAC+"  which going to take place at " + dateA +".";
    }


  
}
