/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.gui;

import java.io.IOException;
import static java.lang.Math.abs;
import static java.lang.Math.abs;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
import javafx.collections.ObservableList;
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
import static jdk.nashorn.internal.objects.NativeFunction.function;
import static org.controlsfx.validation.ValidationMessage.error;
import tn.esprit.binder.E.Abscense;
import tn.esprit.binder.S.abscenseService;

/**
 * FXML Controller class
 *
 * @author Rahma
 */
public class AddAbController implements Initializable {

  
   
  
   
    
    @FXML
    private Spinner number;
    
    private Stage stage;
    @FXML
    private Label group;
    @FXML
    private Button btnadd;
    private ModelAbscense abs;
    @FXML
    private Button btnBack;
    @FXML
    private AnchorPane listAbs;
    @FXML
    private ComboBox<String> pp;
    public List<String> pupl;
    @FXML
    private ComboBox<String> sb;
    public List<String> subjectt;

    @FXML
    private ComboBox<String> gr;
    public List<String> grop;
    private abscenseService serAb = new abscenseService();
    public List<String> hrr;
    @FXML
    private ComboBox<String> hr;
    @FXML
    private Label error;
    @FXML
    private DatePicker datee;
   
 
    //ObservableList<ModelAbscense> pupl = FXCollections.observableArrayList();
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO 
        
        SpinnerValueFactory<Integer> nb = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100);
        this.number.setValueFactory(nb);
       try {
        subjectt = new abscenseService().readAllSubjectt();
        pupl = new abscenseService().readAllPupl();
        grop = new abscenseService().readAllGrop();
        hrr = new abscenseService().readAllHrr();
        pp.setItems(FXCollections.observableArrayList(pupl));
        sb.setItems(FXCollections.observableArrayList(subjectt));
        gr.setItems(FXCollections.observableArrayList(grop));
        hr.setItems(FXCollections.observableArrayList(hrr));
      
        } catch (SQLException ex) {
            Logger.getLogger(AddNotController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
   
    
    public void getStage(Stage stage) {
        this.stage = stage;
    }
    
   
    
    @FXML
    private void btnAdd(ActionEvent event) throws IOException {
        
          
      
       abscenseService absService = new abscenseService(); 
        Abscense abs = new Abscense();
        
         
       /* LocalDate localDate = date.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);
        System.out.println(localDate + "\n" + instant + "\n" + date);*/
     
        //abs.setPupl(pp.getValue());
      
        //abs.setDate(date);
        
         String pupl = pp.getValue();
         String groupe = gr.getValue();
         Integer nbr = (Integer) number.getValue();
         String date = datee.getValue().toString();
          String hour = hr.getValue();
         String subject = sb.getValue();
        
        
         
       /* abs.setSubject(sb.getValue());
        abs.setNbr((int) number.getValue());
        abs.setGroupe(group.getText());
        abs.setHour(hr.getValue());*/
        new abscenseService().addabscense(abs);
        serAb.addabscense(abs);
       

     

     
      Parent root;
        root = FXMLLoader.load(getClass().getResource("GAbs.fxml"));
        btnadd.getScene().setRoot(root);
           
           }
       
    
         
    @FXML
    private void btnBAck(ActionEvent event) {
  
    
           try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Retour !");
            alert.setHeaderText("interrompre l'ajout");
            alert.setContentText("voulez vous retourner à la page précédante?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("GAbs.fxml"));
                btnBack.getScene().setRoot(root);
            }
            if (result.get() == ButtonType.CANCEL) {
                alert.close();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

   

