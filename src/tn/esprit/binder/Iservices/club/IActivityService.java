package tn.esprit.binder.Iservices.club;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import tn.esprit.binder.entities.clubs.activity;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Sam
 */
public interface IActivityService {
    public void addActivity(activity a) throws SQLException;
      public void deleteActivity(int id);
        public boolean updateActivity(activity c) throws SQLException;
         public List<activity> getAll();
        public List<activity> rechercheActivity(String str);
      public void deleteActivitymodified(int id);
        public void addActivitymodify(activity c) throws SQLException;
        public List<activity> rechercheActivityClub(String str);
}
