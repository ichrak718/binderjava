/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.gui;

import tn.esprit.binder.Iservices.club.IClubService;
import tn.esprit.binder.Iservices.club.IParticipationService;
import tn.esprit.binder.services.club.ActivityService;
import tn.esprit.binder.services.club.ClubService;
import tn.esprit.binder.services.club.ParticipationService;
import tn.esprit.binder.utils.MyConnection;
import tn.esprit.binder.entities.clubs.classe;
import tn.esprit.binder.entities.clubs.club;
import tn.esprit.binder.entities.clubs.member;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Sam
 */
public class ParticipationController implements Initializable {

    @FXML
    private Button ajouter;
    @FXML
    private ComboBox<String> ClassS;
    @FXML
    private ComboBox<String> ClubC;
    
     public  List<String> listP;
     
      public  List<String> listCL;
    
    
     private IParticipationService annonceService;
     ObservableList<member> oblist = FXCollections.observableArrayList();
     ParticipationService es=new ParticipationService();
    @FXML
    private TextField nameA;
    
     PreparedStatement pst;
     Connection cn = MyConnection.getInstance().getCnx();
      Statement st; //execute la req
     

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        annonceService = new ParticipationService();
       
        
        try {
            listP=  new ParticipationService().readAllPu();
            listCL=  new ParticipationService().readAllCL();
        } catch (SQLException ex) {
            Logger.getLogger(ParticipationController.class.getName()).log(Level.SEVERE, null, ex);
        }
         ClassS.setItems(FXCollections.observableArrayList(listCL));
    
         ClubC.setItems(FXCollections.observableArrayList(listP));
        // TODO
    }    

    @FXML
    private void registerB(ActionEvent event) throws SQLException {
        
        
            
             listP=  new ParticipationService().readAllPu();
               listCL=  new ParticipationService().readAllCL();
           
        
         String name =nameA.getText();
        String classe =ClassS.getValue();
         String club =ClubC.getValue();
          
       
              
        //System.out.println("this is a club" +club);
         ParticipationService sl = new ParticipationService();
         ActivityService al = new ActivityService();
          int clubId = al.getClubId(club);
         System.out.println("this is a club" +clubId);
          //  member l = new member(name,classe,club);
          member l = new member(name, classe, clubId);
          
            sl.addMember(l);
            
           
            
          
    
    }
    
  /*  
     private boolean validateName(){
        Pattern p =Pattern.compile("[a-zA-Z]");
        Matcher m = p.matcher(nameA.getText());
        if(m.find() && m.group().equals(nameA.getText())){
        return true;
                }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("validate your name");
            alert.setHeaderText(null);
            alert.setContentText("please enter a validate name");
            alert.showAndWait();
            return false;
            
        }

    
}*/
}
