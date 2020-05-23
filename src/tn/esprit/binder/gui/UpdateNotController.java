/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import tn.esprit.binder.S.notificationService;

/**
 * FXML Controller class
 *
 * @author Rahma
 */
public class UpdateNotController implements Initializable {

    private TextField category;
    private TextField sender;
    private TextField receiver;
    @FXML
    private TextField content;
    @FXML
    private Button update;
  
    @FXML
    private Button back;
    private ModelNotification not;
    private notificationService ser = new notificationService();
    @FXML
    private AnchorPane list;
    @FXML
    private ComboBox<String> ca;
    public List<String> categoryy;
    @FXML
    private ComboBox<String> sd;
     public List<String> send;
    @FXML
    private ComboBox<String> rc;
     public List<String> rec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          try {
            //
            categoryy = new notificationService().readAllCategoryy();
            ca.setItems(FXCollections.observableArrayList(categoryy));
            rec = new notificationService().readAllRec();
            rc.setItems(FXCollections.observableArrayList(rec));
            send = new notificationService().readAllSend();
            sd.setItems(FXCollections.observableArrayList(send));
        } catch (SQLException ex) {
            Logger.getLogger(AddNotController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    

        public void redirect (ActionEvent event) throws IOException
    {
         Parent root = FXMLLoader.load(getClass().getResource("GNot.fxml"));

            Scene tableViewScene = new Scene(root);
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
    }
    
   

    @FXML
    private void btnUpdate(ActionEvent event) throws IOException  {
    
             
        not.setCategory(ca.getValue());
        not.setSender(sd.getValue());
        not.setReceiver(rc.getValue());
        not.setContent(content.getText());
        try {
            ser.updateNotification(not);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateNotController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
           Parent root;
      root = FXMLLoader.load(getClass().getResource("GNot.fxml"));
        update.getScene().setRoot(root);
   
    }
    

    public void setNotification(ModelNotification not) {
        this.not = not;
        ca.setValue(not.getCategory());
        sd.setValue(not.getSender());
        rc.setValue(not.getReceiver());
        content.setText(not.getContent());
        System.out.println(not);

}
   @FXML
    private void btnBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GNot.fxml"));

            Scene tableViewScene = new Scene(root);
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();  }
}
