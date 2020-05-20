/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.gui;

import tn.esprit.binder.Iservices.club.IActivityService;
import tn.esprit.binder.services.club.ActivityService;
import tn.esprit.binder.entities.clubs.activity;
import tn.esprit.binder.utils.MyConnection;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Sam
 */
public class ClubFrontController implements Initializable {

    @FXML
    private TableView<activity> tab;
    @FXML
    private TableColumn<activity, String> aboutA;
    @FXML
    private TableColumn<activity, String> durationA;
    @FXML
    private TableColumn<activity, String> locationA;
    @FXML
    private TableColumn<activity, String> dateA;
    @FXML
    private TableColumn<activity, String> clubA;
    
      private IActivityService annonceService;
     ObservableList<activity> oblist = FXCollections.observableArrayList();
     ActivityService es=new ActivityService();
    @FXML
    private TextField rechercheBar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            try {
         annonceService = new ActivityService();
       oblist = FXCollections.observableArrayList(es.getAll());

        ObservableList observableList = FXCollections.observableArrayList(oblist);
        tab.setItems(observableList);
        //idA.setCellValueFactory(new PropertyValueFactory<>("id"));
        aboutA.setCellValueFactory(new PropertyValueFactory<>("about"));
        durationA.setCellValueFactory(new PropertyValueFactory<>("duration"));
        locationA.setCellValueFactory(new PropertyValueFactory<>("location"));
        
         dateA.setCellValueFactory(new PropertyValueFactory<>("dateA"));
         clubA.setCellValueFactory(new PropertyValueFactory<>("clubAC"));
        
           } catch (Exception e) {
        }
      
       
        // TODO
    }    
    
    
    
    private void AfficherAll() {

        annonceService = new ActivityService();
        oblist = FXCollections.observableArrayList(es.getAll());

        ObservableList observableList = FXCollections.observableArrayList(oblist);
        tab.setItems(observableList);
        //idA.setCellValueFactory(new PropertyValueFactory<>("id"));
        aboutA.setCellValueFactory(new PropertyValueFactory<>("about"));
       
        locationA.setCellValueFactory(new PropertyValueFactory<>("location"));
          System.out.println(locationA.toString()) ;
        
         durationA.setCellValueFactory(new PropertyValueFactory<>("duration"));
         clubA.setCellValueFactory(new PropertyValueFactory<>("clubAC"));
         dateA.setCellValueFactory(new PropertyValueFactory<>("dateA"));
        
     
        
    
}

    @FXML
    private void rechercher(ActionEvent event) {
         
        if (!rechercheBar.getText().isEmpty()) {
            tab.setVisible(true);
            annonceService = new ActivityService();
            List<activity> myList = annonceService.rechercheActivityClub(rechercheBar.getText());
            ObservableList<activity> observableList = FXCollections.observableArrayList();

           // idA.setCellValueFactory(new PropertyValueFactory<>("id"));
            aboutA.setCellValueFactory(new PropertyValueFactory<>("about"));
             locationA.setCellValueFactory(new PropertyValueFactory<>("location"));
             durationA.setCellValueFactory(new PropertyValueFactory<>("duration"));
            
             dateA.setCellValueFactory(new PropertyValueFactory<>("dateA"));
             clubA.setCellValueFactory(new PropertyValueFactory<>("clubAC"));


            myList.forEach(e -> {

                observableList.add(e);
                // System.out.println(observableList);
            });
            tab.setItems(observableList);
        } else {
            if (rechercheBar.getText().isEmpty()) {
                tab.getItems().clear();
                tab.getItems().addAll(annonceService.getAll());
            }

        }
    }
    
    
    
    
    
    
    
}
