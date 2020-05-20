/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.Iservices.club;

import tn.esprit.binder.entities.clubs.member;
import java.sql.SQLException;

/**
 *
 * @author Sam
 */
public interface IParticipationService {
     public void addMember( member m) throws SQLException;
    
}
