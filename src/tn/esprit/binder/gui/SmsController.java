/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.gui;

import com.teknikindustries.bulksms.SMS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import tn.esprit.binder.S.notificationService;
import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


import org.controlsfx.control.Notifications;

import tn.esprit.binder.S.notificationService;




import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.*;
import java.io.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Rahma
 */
public class SmsController implements Initializable {

    @FXML
    private Button snd;
    
    @FXML
    private TextField message;
    @FXML
    private ComboBox<String> nb;
    public List<String> nbrr;
    @FXML
    private Button cancel;

    /**
     * Initializes the controller class.
     */
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            nbrr = new notificationService().readAllNbrr();
        } catch (SQLException ex) {
            Logger.getLogger(SmsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        nb.setItems(FXCollections.observableArrayList(nbrr));
    }    

    @FXML
    private void btnsend(ActionEvent event) {
        
       SMS send = new SMS();
        send.SendSMS("rahma_belhadj", "Ramabh97", message.getText(), nb.getValue(), "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
        JOptionPane.showMessageDialog(null, " Done!");
        
    }

    @FXML
    private void btnback(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddNot.fxml"));

            Scene tableViewScene = new Scene(root);
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
    }
}

   		 
		/*try {
			 SMS sms=new SMS();
			 sms.SendSMS("rahma_belhadj ", "Ramabh97", "Hello", "51790910", "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
			
			
			
		} catch (Exception e2) {
			System.out.println(e2);
			
		}
	}
	 
	 private String user = "r.le1997@gmail.com";
	    private String pass= "Rahmabh97";
    
    
	
    }*/