/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.IService;

import java.sql.SQLException;
import java.util.List;
import tn.esprit.binder.entities.Subject;

/**
 *
 * @author wael
 */
public interface IServiceSubject {
    public void addSubject(Subject s);
    public List<Subject> showAllSub();
    public boolean updateSubject(Subject s) throws SQLException;

    public List<Subject> searchSubject(String text);
    
}
