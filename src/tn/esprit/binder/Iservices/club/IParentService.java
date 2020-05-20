/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.Iservices.club;

import tn.esprit.binder.entities.clubs.parent;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Sam
 */
public interface IParentService {
    
      public void addParent(parent p) throws SQLException;
      public void deleteParent(int id);
        public boolean updateParent(parent p) throws SQLException;
         public List<parent> getAll();
       public List<parent> rechercheParent(String str);
       public void deleteParentmodified(int id);
        public void addParentmodify(parent p) throws SQLException;
    
    
}
