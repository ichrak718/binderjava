/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.gui;

import java.io.IOException;
import static java.lang.Math.abs;
import static java.lang.Math.abs;
import static java.lang.Math.abs;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;


import tn.esprit.binder.S.abscenseService;
import tn.esprit.binder.E.Abscense;
//import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Rahma
 */
public class GAbsController implements Initializable {

    @FXML
    private TableView<ModelAbscense> tableAbscense;
    @FXML
    private TableColumn<ModelAbscense, String> pupil;
    @FXML
    private TableColumn<ModelAbscense, String> group;
    @FXML
    private TableColumn<ModelAbscense, Integer> number;
    @FXML
    private TableColumn<ModelAbscense, Date> date;
    @FXML
    private TableColumn<ModelAbscense, String> subject;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btndelete;
   

public Abscense abs = new Abscense();
 
    public List<Abscense> Abscenses;
    abscenseService serAb = new abscenseService();
    private Stage stage;
   
    ObservableList<ModelAbscense> obListAb = FXCollections.observableArrayList();
   
    @FXML
    private Button btnAdd;
    @FXML
    private Button home;
    
    @FXML
    private Button print;
    @FXML
    private TextField tfRechercher;
  private List<ModelAbscense> Abss;
    @FXML
    private TableColumn<ModelAbscense, String> hr;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        // TODO
        pupil.setCellValueFactory(new PropertyValueFactory<ModelAbscense, String>("pupl"));
        group.setCellValueFactory(new PropertyValueFactory<ModelAbscense, String>("groupe"));
        number.setCellValueFactory(new PropertyValueFactory<ModelAbscense, Integer>("nbr"));
        date.setCellValueFactory(new PropertyValueFactory<ModelAbscense, Date>("date"));
        hr.setCellValueFactory(new PropertyValueFactory<ModelAbscense, String>("hour"));
     
       
        subject.setCellValueFactory(new PropertyValueFactory<ModelAbscense, String>("subject"));
    
        
        obListAb = new abscenseService().getAbscenseList();
        tableAbscense.setItems(obListAb);
               
  
        
        
    }    
    
    public void getStage(Stage stage) {
        this.stage = stage;
    }
    
     public void actualiserTable() {
        tableAbscense.getItems().clear();
        obListAb = new abscenseService().getAbscenseList();
        tableAbscense.setItems(obListAb);
    } 


    @FXML
    private void btnAdd(ActionEvent event)  {
        try {
        Parent root = FXMLLoader.load(getClass().getResource("AddAb.fxml"));

            Scene tableViewScene = new Scene(root);
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
            } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
 

     @FXML
    private void btnDelete(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
           alert.setTitle("Delete Abscense");
           alert.setHeaderText("delete" + abs.getId());
           alert.setContentText("Delete That? " + tableAbscense.getSelectionModel().getSelectedItem().getId() + "?");
           Optional<ButtonType> result = alert.showAndWait();
           if (result.get() == ButtonType.OK) {
               new abscenseService().deleteabscense(tableAbscense.getSelectionModel().getSelectedItem().getId());
               actualiserTable();
        
           }
           if (result.get() == ButtonType.CANCEL) {
               alert.close();
    
           }    
        
    }

    @FXML
    private void btnUpdate(ActionEvent event) {
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Update abscense");
        alert.setHeaderText("Updating" + abs.getId());
        alert.setContentText("Would you like to update that? " + tableAbscense.getSelectionModel().getSelectedItem().getId()+ "?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            try {
                ModelAbscense abs = tableAbscense.getSelectionModel().getSelectedItem();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("updateA.fxml"));
                Parent root = loader.load();
                UpdateAController ugc = loader.getController();
                ugc.setAbscense(abs);
                tableAbscense.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        if (result.get() == ButtonType.CANCEL) {
            alert.close();
        }
    }

    @FXML
    private void btnhome(ActionEvent event) throws IOException {
               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Home");
        alert.setHeaderText("Home.");
        alert.setContentText("you want go to home ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("homeBinder.fxml"));
                home.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        if (result.get() == ButtonType.CANCEL) {
            alert.close();
        }

}

  
    @FXML
    private void btnprint(ActionEvent event) {
         final PrinterJob printerJob = PrinterJob.createPrinterJob();
        if (printerJob.showPrintDialog(tableAbscense.getScene().getWindow())) {
            if (printerJob.printPage(tableAbscense)) {
                printerJob.endJob();
            }
        }
    }



    @FXML
    private void tfRechecherOnKeyReleased(KeyEvent event) {
    
        tableAbscense.getItems().clear();
        obListAb = new abscenseService().rechercheActivity(tfRechercher.getText());
        tableAbscense.setItems(obListAb);
    }
}
        
    

   
    
    

