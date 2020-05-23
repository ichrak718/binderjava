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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import tn.esprit.binder.S.abscenseService;
import tn.esprit.binder.S.notificationService;

/**
 * FXML Controller class
 *
 * @author Rahma
 */
public class UpdateAController implements Initializable {

   
    @FXML
    private Spinner<Integer> number;
    @FXML
    private DatePicker date;
    private TextField subject;
    @FXML
    private Button update;

    @FXML
    private Button back;
    private ModelAbscense abs;
    private abscenseService ser = new abscenseService();
    @FXML
    private AnchorPane listA;
    @FXML
    private ComboBox<String> gr;
    public List<String> grop;
    @FXML
    private ComboBox<String> sb;
    public List<String> subjectt;
    @FXML
    private ComboBox<String> pp;
    public List<String> pupl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SpinnerValueFactory<Integer> nb = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100);
        this.number.setValueFactory(nb);
        try {
            subjectt = new abscenseService().readAllSubjectt();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateAController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
             pupl = new abscenseService().readAllPupl();
            grop = new abscenseService().readAllGrop();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateAController.class.getName()).log(Level.SEVERE, null, ex);
        }
        pp.setItems(FXCollections.observableArrayList(pupl));
        sb.setItems(FXCollections.observableArrayList(subjectt));
        gr.setItems(FXCollections.observableArrayList(grop));
        // TODO
    }    
    
       public void redirect (ActionEvent event) throws IOException
    {
         Parent root = FXMLLoader.load(getClass().getResource("GAbs.fxml"));

            Scene tableViewScene = new Scene(root);
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
    }
     
    /*private void btUpdate(ActionEvent event) {
      
    }
    private void btnBack(ActionEvent event) {
      
    }*/
    
        public void setAbscense(ModelAbscense abs) {
        this.abs = abs;
        sb.setValue(abs.getSubject());
        SpinnerValueFactory<Integer> nb = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100);
        this.number.setValueFactory(nb);
         
        gr.setValue(abs.getGroupe());
        pp.setValue(abs.getPupl());
        System.out.println(abs.getDate()+ " " + abs.getGroupe());
      
    }

    @FXML
    private void btnUpdate(ActionEvent event) throws IOException  {
        
        abs.setPupl(pp.getValue());
        abs.setGroupe(gr.getValue());
        abs.setNbr((int) number.getValue());
        LocalDate localDate = date.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);
        System.out.println(localDate + "\n" + instant + "\n" + date);
        //abs.setDate(date);
        abs.setSubject(sb.getValue());
        try {
            ser.updateAbscense(abs);
            //reussi.setText("modifié avec succés.");
        } catch (SQLException ex) {
            Logger.getLogger(UpdateAController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
           Parent root;
      root = FXMLLoader.load(getClass().getResource("GAbs.fxml"));
        update.getScene().setRoot(root);
        
    
    }
    @FXML
    private void btnBack(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("GAbs.fxml"));

            Scene tableViewScene = new Scene(root);
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show(); }
    }

   

    
    

