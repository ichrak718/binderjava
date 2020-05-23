/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.gui;

import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import tn.esprit.binder.E.Abscense;
import tn.esprit.binder.E.Notification;
import tn.esprit.binder.S.abscenseService;
import tn.esprit.binder.S.notificationService;
import org.controlsfx.control.Notifications;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.net.Authenticator;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javax.mail.MessagingException;
import tn.esprit.binder.utils.Mailtools;
import com.teknikindustries.bulksms.SMS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.*;
import java.io.*;
import javax.mail.internet.MimeBodyPart;


/**
 * FXML Controller class
 *
 * @author Rahma
 */
public class AddNotController implements Initializable {

 

    @FXML
    private TextField content;
    @FXML
    private Button btnadd;
    private ModelNotification not;
    @FXML
    private Button btnback;

    private Stage stage;
    @FXML
    private Button claearr;
    @FXML
    private ComboBox<String> ca;
    public List<String> categoryy;
    @FXML
    private ComboBox<String> sd;
    public List<String> send;
    @FXML
    private ComboBox<String> rc;
    public List<String> rec;
    @FXML
    private Button sms;
    @FXML
    private Label error;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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
    public void getStage(Stage stage) {
        this.stage = stage;
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
    private void btnBack(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("GNot.fxml"));

            Scene tableViewScene = new Scene(root);
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
    }

    @FXML
    private void btnAdd(ActionEvent event) throws IOException, Exception {
        notificationService notService = new notificationService();
        Notification not = new Notification();
         if (content.getText().equals("") 
               ){
            error.setVisible(true);
        }
         else {
       
        
        not.setCategory(ca.getValue());
        not.setSender((String) sd.getValue());
        not.setReceiver((String) rc.getValue());
        not.setContent(content.getText());
        
             // Image img = new Image ("/not.jpg");
        Notifications notificationBuilder = Notifications.create()
                .title("Notification Sent")
                .text("Your message has been sent!")
              //  .graphic(new ImageView(img))
                .hideAfter(Duration.seconds(7))
                .position(Pos.BOTTOM_RIGHT);
                notificationBuilder.darkStyle();
                notificationBuilder.show();
              //Mailtools sendMail = Mailtools.sendMail(not.getUser().getEmail());
              //Mailtools.sendMail("r.line1997@gmail.com");
            
            Mailtools sendmail = new Mailtools();
            Mailtools.sendMail("r.line1997@gmail.com");
           
        new notificationService().addnotification(not);

         Parent root;
        root = FXMLLoader.load(getClass().getResource("GNot.fxml"));
        btnadd.getScene().setRoot(root);
     
    }}


    
    public void setNotification(ModelNotification not) {
        this.not = not;
       // category.setText(not.getCategory());
        //sender.setText(not.getSender());
        ///receiver.setText(not.getReceiver());
        content.setText(not.getContent());
        System.out.println(not);
        
      
    
   
    }



    @FXML
    private void btnc(ActionEvent event) {
     
        content.setText("");
    }

    @FXML
    private void btnsms(ActionEvent event) throws IOException  {

           Parent root = FXMLLoader.load(getClass().getResource("sms.fxml"));

            Scene tableViewScene = new Scene(root);
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();}}

    

    
    


