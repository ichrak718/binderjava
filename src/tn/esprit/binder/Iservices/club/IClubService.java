/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.Iservices.club;

import tn.esprit.binder.entities.clubs.club;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Sam
 */
public interface IClubService {
     public void addClub(club a) throws SQLException;
      public void deleteClub(int id);
        public boolean updateClub(club c) throws SQLException;
         public List<club> getAll();
       public List<club> rechercheClub(String str);
       public void deleteClubmodified(int id);
        public void addClubmodify(club c) throws SQLException;
       
    
}
