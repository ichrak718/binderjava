/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.IService;

import java.sql.SQLException;
import java.util.List;
import tn.esprit.binder.entities.Course;

/**
 *
 * @author wael
 */
public interface IServiceCourse {
    public void addCourse(Course c);
    public List<Course> showAll();
    public boolean updateCourse(Course c) throws SQLException;

    public List<Course> searchCourse(String text);
}
