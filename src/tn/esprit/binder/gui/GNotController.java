/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import static javafx.beans.binding.Bindings.not;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import tn.esprit.binder.S.abscenseService;
import tn.esprit.binder.S.notificationService;
import org.controlsfx.control.Notifications;
import tn.esprit.binder.E.Notification;
//import tn.esprit.pidev.utils.Mailtools;


/**
 * FXML Controller class
 *
 * @author Rahma
 */
public class GNotController implements Initializable {

    private Stage stage;
    @FXML
    private TableView<ModelNotification> tablenotification;
    
    @FXML
    private TableColumn<ModelNotification, String> category;
    @FXML
    private TableColumn<ModelNotification, String> sender;
    @FXML
    private TableColumn<ModelNotification, String> receiver;
    @FXML
    private TableColumn<ModelNotification, String> content;
    public Notification not = new Notification();
    public List<Notification> Notification;
    ObservableList<ModelNotification> obListN = FXCollections.observableArrayList();
    @FXML
    private Button btnadd;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btndelete;
    @FXML
    private Button home;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        category.setCellValueFactory(new PropertyValueFactory<ModelNotification, String>("category"));
        sender.setCellValueFactory(new PropertyValueFactory<ModelNotification, String>("sender"));
        receiver.setCellValueFactory(new PropertyValueFactory<ModelNotification, String>("receiver"));
     
        content.setCellValueFactory(new PropertyValueFactory<ModelNotification, String>("content"));
                
        ObservableList<ModelNotification> obList = new notificationService().getNotificationList();
        tablenotification.setItems((ObservableList<ModelNotification>) obList);
    }    
        // TODO
  
     public void getStage(Stage stage) {
        this.stage = stage;
    }
        public void actualiserTableN() {
        tablenotification.getItems().clear();
        obListN = new notificationService().getNotificationList();
        tablenotification.setItems(obListN);
       
    } 
    
    
    
    @FXML
    private void btnhome(ActionEvent event) {
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
    private void btnDelete(ActionEvent event) {
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
           alert.setTitle("Delete Notification");
           //alert.setHeaderText("delete" + not.getId());
           alert.setContentText("you want to delete that notification? " + tablenotification.getSelectionModel().getSelectedItem().getId() + "?");
           Optional<ButtonType> result = alert.showAndWait();
           if (result.get() == ButtonType.OK) {
               new notificationService().deletenotifiation(tablenotification.getSelectionModel().getSelectedItem().getId());
               actualiserTableN();
              // Image img = new Image ("/sup.jpg");
        Notifications notificationBuilder = Notifications.create()
                .title("Notification Deleted")
                .text("Done!")
               // .graphic(new ImageView(img))
                .hideAfter(Duration.seconds(7))
                .position(Pos.BOTTOM_RIGHT);
                notificationBuilder.darkStyle();
                notificationBuilder.show();
           }
           if (result.get() == ButtonType.CANCEL) {
               alert.close();
           }    
        
    }

    @FXML
    private void btnUpdate(ActionEvent event) throws Exception {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Update abscense");
       // alert.setHeaderText("Updating" + not.getId());
        alert.setContentText("Would you like to update that? " + tablenotification.getSelectionModel().getSelectedItem().getId()+ "?");
       // alert.setContentText("Would you like to update That? " + tablenotification.getSelectionModel().getSelectedItem().getId()+ "?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            try {
                ModelNotification not = tablenotification.getSelectionModel().getSelectedItem();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("updateNot.fxml"));
                Parent root = loader.load();
                UpdateNotController ugc = loader.getController();
                ugc.setNotification(not);
                tablenotification.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
           // Mailtools sendMail = Mailtools.sendMail(not.getSender().getEmail());
           // Mailtools.sendMail("r.line1997@gmail.com");
             
        }
        if (result.get() == ButtonType.CANCEL) {
            alert.close();
                
        }
    }

    @FXML
    private void btnAdd(ActionEvent event) throws IOException {
        
           Parent root = FXMLLoader.load(getClass().getResource("AddNot.fxml"));

            Scene tableViewScene = new Scene(root);
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
    }




}

 
        
    

