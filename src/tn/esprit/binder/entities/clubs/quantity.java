/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.entities.clubs;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 *
 * @author Sam
 */
public class quantity {
    public final DoubleProperty load = new SimpleDoubleProperty();

    public final Double getLoad() {
        return load.get();
    }
    
     public void setLoad(double Value) {
         load.set(Value);
    }
     public final DoubleProperty loadProperty(){
         return load;
     } 
     
    
   

    
}
