/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.gui;

import tn.esprit.binder.Iservices.club.IActivityService;
import tn.esprit.binder.services.club.ActivityService;
import static com.sun.jmx.mbeanserver.Util.cast;
import com.sun.org.apache.xerces.internal.xs.StringList;
import tn.esprit.binder.utils.MyConnection;
import tn.esprit.binder.entities.clubs.activity;
import tn.esprit.binder.entities.clubs.teacher;
import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
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
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import java.net.Authenticator;
import javax.mail.MessagingException;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
//import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



/**
 * FXML Controller class
 *
 * @author Sam
 */
public class ActivityController implements Initializable {

    @FXML
    private TableView<activity> tab;
   
    @FXML
    private TableColumn<activity, String> aboutA;
    @FXML
    private TableColumn<activity, String> durationA;
    @FXML
    private TableColumn<activity, String> locationA;

    
     private IActivityService annonceService;
     ObservableList<activity> oblist = FXCollections.observableArrayList();
     ActivityService es=new ActivityService();
    @FXML
    private TextField aboutAJ;
    @FXML
    private TextField locationAJ;
    @FXML
    private TextField durationAJ;
    @FXML
    private TextField rechercheBar;
    @FXML
    private TableColumn<activity, String> clubA;
    public  List<String> listA;
    @FXML
    private ComboBox<String> clubAJ;
    @FXML
    private DatePicker dp;
    @FXML
    private TableColumn<activity, String> dateA;
    public  List<String> listAD;
    
    
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
         listA=  new ActivityService().readAllT();
         clubAJ.setItems(FXCollections.observableArrayList(listA));
           } catch (Exception e) {
        }
      
       
        // TODO
    }    

    @FXML
    private void supprimer(ActionEvent event) {
        
        es= new ActivityService();
        int index = tab.getSelectionModel().getSelectedItem().getId();
        //System.out.println(index);
        es.deleteActivity(index);
       AfficherAll();
        
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
        
         dateA.setCellValueFactory(new PropertyValueFactory<>("dateA"));
         clubA.setCellValueFactory(new PropertyValueFactory<>("clubAC"));
     
        

      
       

}

    @FXML
    private void ajouter(ActionEvent event) throws SQLException {
        if(validateDuration()){
        
         String about = aboutAJ.getText();
        
        String duration =durationAJ.getText();
         String location =locationAJ.getText();
        
          
          LocalDate date =dp.getValue();
          // String name =clubAJ.getValue();
          String name = clubAJ.getValue();
           
           
              
       
         ActivityService sl = new ActivityService();
         //int clubId ;
         int clubId = sl.getClubId(name);
            System.out.println(name);
           
           activity l = new activity(clubId,about,duration,location,date.toString(),name);
           sl.addActivity(l);
             AfficherAll();
            
            
         
    

            
            listAD=  new ActivityService().readAllA();
      // List <String> listAD=  new ActivityService().readAllA();
     // List<String> to = new ActivityService().readAllA();

        
            
      // Recipient's email ID needs to be mentioned. private static final String EMAIL_TO = "jberisamar2@gmail.com, binderschools@gmail.com";
    
      
       //final String to ="jberisamar2@gmail.com";
      // Sender's email ID needs to be mentioned
      String from = "binderschools@gmail.com";//change accordingly
      final String username = "binder";//change accordingly
      final String password = "binder123";//change accordingly
      //final String EMAIL_TO = "jberisamar2@gmail.com, binderschools@gmail.com";
      String emails="";
      
      for(String mail : listAD ){
        emails+=mail+",";
    }
      System.out.println(emails);
      
      emails = emails.substring(0,emails.length()-2);
   
   
    
      
      

      // Assuming you are sending email through relay.jangosmtp.net
      String host = "smtp.gmail.com";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

      // Get the Session object.
       Session session= Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(from, password);
            }          
        });

      try {
          
          
         // Create a default MimeMessage object.
         Message message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emails, false));
         // Set Subject: header field
         message.setSubject("Testing Subject");

         // Now set the actual message
         message.setText(l.message());

         // Send message
         Transport.send(message);
          

         System.out.println("Sent message successfully....");

      } catch (MessagingException e) {
            throw new RuntimeException(e);
      }
         
        }
         
    }
    

   
    

    @FXML
    private void rechercher(ActionEvent event) {
        
        if (!rechercheBar.getText().isEmpty()) {
            tab.setVisible(true);
            annonceService = new ActivityService();
            List<activity> myList = annonceService.rechercheActivity(rechercheBar.getText());
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
    
    
    @FXML
    private void modifier(ActionEvent actionEvent) {
       
        annonceService = new ActivityService();
         try {
             activity aa = tab.getSelectionModel().getSelectedItem();
              System.out.println(aa.getId()+"551");
           //  int id_c1 = Integer.parseInt(aa.getId_c());
                         
        int id=aa.getId();
            String about = aboutAJ.getText();
            
            String duration = durationAJ.getText();
            String location = locationAJ.getText();
                       // String club = clubAJ.getValue();
             String name =clubAJ.getValue();
                        
            LocalDate date = dp.getValue();
            
             ActivityService sl = new ActivityService();
             
             int clubId = sl.getClubId(name);


            
            
           activity a = new activity(id,clubId,about,duration,location,date.toString(),name);
           ActivityService s2 = new ActivityService();
            ActivityService s3 = new ActivityService();
            
            activity l = new activity(clubId,about,duration,location,date.toString(),name);
            s3.deleteActivitymodified(id);
            s2.addActivitymodify(l);
             AfficherAll();
            
            
            
            
            try {
            Connection con =(Connection) MyConnection.getInstance().getCnx();
            
            ResultSet rs = con.createStatement().executeQuery("select * from activity");
          while(rs.next()){
          oblist.add(new activity(rs.getInt("id"),rs.getInt("id_club"),rs.getString("about"),rs.getString("duration"),rs.getString("location"),rs.getString("dateA"),rs.getString("clubAC")));}
        } catch (SQLException ex) {
            Logger.getLogger(ActivityController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
            tab.setItems(oblist);
            
            
        }
            
           
         catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         
         
       
    }
    /*
     private void modifierEval(activity e){ 
          if(e != null){
                aboutAJ.setText(e.getAbout());
                 durationAJ.setText(e.getDuration());
                  locationAJ.setText(e.getLocation());
}
     }*/

    @FXML
    private void addC(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Club.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }

    @FXML
    private void showDate(ActionEvent event) {
    }
/*
    @FXML
    private void mailA(ActionEvent event )  throws Exception {
        
        
              
      // Recipient's email ID needs to be mentioned.
        String to = "jberisamar2@gmail.com";
      // Sender's email ID needs to be mentioned
      String from = "binderschools@gmail.com";//change accordingly
      final String username = "binder";//change accordingly
      final String password = "binder123";//change accordingly

      // Assuming you are sending email through relay.jangosmtp.net
      String host = "smtp.gmail.com";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

      // Get the Session object.
       Session session= Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(from, password);
            }          
        });

      try {
         // MimeMessage object. 
            MimeMessage message = new MimeMessage(session); 
      
            // Set From Field: adding senders email to from field. 
            message.setFrom(new InternetAddress(from)); 
      
            // Set To Field: adding recipient's email to from field. 
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); 
      
            // Set Subject: subject of the email 
            message.setSubject("This is Suject"); 
              
            // creating first MimeBodyPart object 
            BodyPart messageBodyPart1 = new MimeBodyPart();  
            messageBodyPart1.setText("This is body of the mail"); 
              
            // creating second MimeBodyPart object 
            BodyPart messageBodyPart2 = new MimeBodyPart();  
            String filename = "../files/file.jpg";
            DataSource source = new FileDataSource(filename);   
            messageBodyPart2.setDataHandler(new DataHandler(source));   
            messageBodyPart2.setFileName(filename);   
              
            // creating MultiPart object 
            Multipart multipartObject = new MimeMultipart();   
            multipartObject.addBodyPart(messageBodyPart1);   
            multipartObject.addBodyPart(messageBodyPart2); 
      
      
      
            // set body of the email. 
            message.setContent(multipartObject); 
      
            // Send email. 
            Transport.send(message); 
            System.out.println("Mail successfully sent");

      } catch (MessagingException e) {
            throw new RuntimeException(e);
      }
    }*/
    
        
        
        
        
      private boolean validateDuration(){
        Pattern p =Pattern.compile("[0-9]+");
        Matcher m = p.matcher(durationAJ.getText());
        if(m.find() && m.group().equals(durationAJ.getText())){
        return true;
                }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("validate the duration");
            alert.setHeaderText(null);
            alert.setContentText("please enter a validate duration");
            alert.showAndWait();
            return false;
            
        }
       
                }
       
                }
        
        
        
        
    
        
        
    

    

        
    
    
    


   
    
    
    
    
