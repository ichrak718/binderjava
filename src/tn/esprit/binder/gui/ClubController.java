/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.gui;

import tn.esprit.binder.Iservices.club.IClubService;

import tn.esprit.binder.services.club.ClubService;
import tn.esprit.binder.utils.MyConnection;
import tn.esprit.binder.entities.clubs.club;
import tn.esprit.binder.entities.clubs.pupil;
import tn.esprit.binder.entities.clubs.quantity;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * FXML Controller class
 *
 * @author Sam
 */
public class ClubController implements Initializable {
    

    @FXML
    private TableView<club> tab;
  
    @FXML
    private TableColumn<club, String> nameC;
    @FXML
    private TableColumn<club, String> specialtyC;
    @FXML
    private TableColumn<club, String> responsibleC;
    private TableColumn<club, String> membersC;
    public  List<String> listT;
    
    
     private IClubService annonceService;
     ObservableList<club> oblist = FXCollections.observableArrayList();
     ClubService es=new ClubService();
     
    @FXML
    private TextField nameAJ;
    private TextField specialtyAJ;
   
   
    @FXML
    private TextField rechercheBar;
    
     PreparedStatement pst;
     Connection cn = MyConnection.getInstance().getCnx();
      Statement st; //execute la req
   @FXML
    private AnchorPane comboOptions;
    //@FXML
    //public ComboBox<String> comboBox;
  /* ObservableList <String>  list = FXCollections.observableArrayList();
   ComboBox comboBox = new ComboBox(list);
    private ComboBox<String> combo;*/
    
    
    @FXML
    private Button update;
     ObservableList <String>  list = FXCollections.observableArrayList("music","sports","IT","lecture","arts","science");
    @FXML
    private ComboBox<String> specialtyCom;
    @FXML
    private ComboBox<String> teacherC;
    @FXML
    private Label counter;
    @FXML
    private ProgressIndicator pi;
    private quantity q = new quantity();
    @FXML
    private Button export;
        

    
    
    
    
    
    
            
            
    
     
     
    
           

    
    
    
   
   

   
       /*private void modifierEval(club e){ 
          if(e != null){
                nameAJ.setText(e.getName());
                 specialtyAJ.setText(e.getSpecialty());
                  teacherC.setValue(e.getValue());
                   membersAJ.setText(e.getMembers());
         
          }
       }
    

    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
         q.setLoad(0);
                q.loadProperty().addListener(new ChangeListener<Object>(){
                    @Override
                    public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
                        pi.progressProperty().bind(q.loadProperty());//unidirectional bnding
                    }
                    
                    
                });
         specialtyCom.setItems(list); 
        
      
        try {
                
          annonceService = new ClubService();
       oblist = FXCollections.observableArrayList(es.getAll());

        ObservableList observableList = FXCollections.observableArrayList(oblist);
        tab.setItems(observableList);
       // idC.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameC.setCellValueFactory(new PropertyValueFactory<>("name"));
        specialtyC.setCellValueFactory(new PropertyValueFactory<>("specialty"));
        responsibleC.setCellValueFactory(new PropertyValueFactory<>("responsible"));
           listT=  new ClubService().readAllT();
           
            teacherC.setItems(FXCollections.observableArrayList(listT));
        } catch (Exception e) {
        }
           
            
       
        
         
    
      
        
        // TODO
    }    
    


    @FXML
    private void supprimer(ActionEvent event) {
        es= new ClubService();
        int index = tab.getSelectionModel().getSelectedItem().getId();
        //System.out.println(index);
        es.deleteClub(index);
       AfficherAll();
    }
    
    
    private void AfficherAll() {

        annonceService = new ClubService();
        oblist = FXCollections.observableArrayList(es.getAll());

        ObservableList observableList = FXCollections.observableArrayList(oblist);
        tab.setItems(observableList);
       // idC.setCellValueFactory(new PropertyValueFactory<>("id"));
        specialtyC.setCellValueFactory(new PropertyValueFactory<>("specialty"));
        responsibleC.setCellValueFactory(new PropertyValueFactory<>("responsible"));
       
         nameC.setCellValueFactory(new PropertyValueFactory<>("name"));
     
        

      
       

}

    @FXML
    private void ajouter(ActionEvent event) throws SQLException {
        if(validateName()){
        
         String name =nameAJ.getText();
        String specialty =specialtyCom.getValue();
         String responsible =teacherC.getValue();
         
          
       
              
       
         ClubService sl = new ClubService();
            club l = new club(name,specialty,responsible);
            sl.addClub(l);
            AfficherAll();
            
            q.setLoad(q.getLoad() + 0.01);//means 10%
    }
    }

    @FXML
    private void rechercher(ActionEvent event) {
        
         if (!rechercheBar.getText().isEmpty()) {
            tab.setVisible(true);
            annonceService = new ClubService();
            List<club> myList = annonceService.rechercheClub(rechercheBar.getText());
            ObservableList<club> observableList = FXCollections.observableArrayList();

            //idC.setCellValueFactory(new PropertyValueFactory<>("id"));
            nameC.setCellValueFactory(new PropertyValueFactory<>("name"));
             specialtyC.setCellValueFactory(new PropertyValueFactory<>("specialty"));
             responsibleC.setCellValueFactory(new PropertyValueFactory<>("responsible"));
            



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
    private void modifier(ActionEvent event) {
         
        
        
        annonceService = new ClubService();
         try {
             club aa = tab.getSelectionModel().getSelectedItem();
              System.out.println(aa.getId()+"551");
           //  int id_c1 = Integer.parseInt(aa.getId_c());
                         
        int id=aa.getId();
            String name = nameAJ.getText();
          
            String specialty = specialtyCom.getValue();
            String responsible = teacherC.getValue();
            
             
            
           club a = new club(id,name, specialty, responsible);
            ClubService s2 = new ClubService();
            ClubService s3 = new ClubService();
            
            club l = new club(name,specialty,responsible);
            s3.deleteClubmodified(id);
            s2.addClubmodify(l);
             AfficherAll();
            
            
            
            
            
            
            try {
            Connection con =(Connection) MyConnection.getInstance().getCnx();
            
            ResultSet rs = con.createStatement().executeQuery("select * from club");
          while(rs.next()){
          oblist.add(new club(rs.getInt("id"),rs.getString("name"),rs.getString("specialty"),rs.getString("responsible")));}
        } catch (SQLException ex) {
            Logger.getLogger(ClubController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
            tab.setItems(oblist);
           
           
            
            
        }
            
           
         catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         
         
}

    /*@FXML
    private void comboOptions(ActionEvent event) throws SQLException {
        try{
      Connection con =(Connection) ConnectionBase.getInstance().getConnection();
            
            ResultSet rs = con.createStatement().executeQuery("select name from pupil");
        
          while(rs.next()){
                      

             
          }
              }
        
        
    catch (SQLException ex) {
            Logger.getLogger(ClubController.class.getName()).log(Level.SEVERE, null, ex);
        }
}*/
    
    
    
    
 
    


   /*@FXML
    private void fillComboBox(ActionEvent event) {
        combo.setItems(list);
        
        try {
           
            String query;
            query = "select name from pupil";
            pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                list.add(rs.getString("name"));
            }
            pst.close();
            rs.close();
                
            }
        catch (SQLException ex) {
            Logger.getLogger(ClubController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }*/

    @FXML
    private void specialtySelection(ActionEvent event) {
        
        String choice;
        choice = specialtyCom.getValue();
        

    }
    
    private boolean validateName(){
        Pattern p =Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(nameAJ.getText());
        if(m.find() && m.group().equals(nameAJ.getText())){
        return true;
                }
        else{
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("validate your name");
            alert.setHeaderText(null);
            alert.setContentText("please enter a validate name");
            alert.showAndWait();
            return false;
            
        }
       
                }

    @FXML
    private void exportToXL(ActionEvent event) throws SQLException, FileNotFoundException, IOException {
        try{
            String query ="Select * from club";
           PreparedStatement statement;
            statement= cn.prepareStatement(query);
            pst = cn.prepareStatement(query);
          //  st = (Statement) pst.executeQuery();
            ResultSet st = pst.executeQuery();
            // ResultSet st = statement.executeQuery();
            //st =  (Statement) pst.executeQuery();
            
            
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet("club details");
            XSSFRow header = sheet.createRow(0);
            header.createCell(0).setCellValue("id");
            header.createCell(1).setCellValue("name");
            header.createCell(2).setCellValue("specialty");
            header.createCell(3).setCellValue("responsible");
            
            
            sheet.autoSizeColumn(1);
             sheet.autoSizeColumn(2);
              sheet.setColumnWidth(3, 256*25);
               sheet.setColumnWidth(4, 256*75);
              sheet.setZoom(150);
            
            
            

           // ResultSet st = statement.executeQuery();
            
            int index = 1;
            while(st.next()){
                XSSFRow row = sheet.createRow(index);
                row.createCell(0).setCellValue(st.getString("id"));
                 row.createCell(1).setCellValue(st.getString("name"));
                  row.createCell(2).setCellValue(st.getString("specialty"));
                   row.createCell(3).setCellValue(st.getString("responsible"));
                   
                    index++;
                 
            }
                    
            FileOutputStream fileout = new FileOutputStream("clubdetails.xlsx");
            wb.write(fileout);
            fileout.close();
            
             Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("database details");
            alert.setHeaderText(null);
            alert.setContentText("club details exported");
            alert.showAndWait();
            
            pst.close();
            st.close();
            
            
            
        }
        catch(SQLException ex){
            
        }
    }
    
    
    
     
    
    
    
    
}

    
        

          
            
           
        
        
       
        
        
    

   
    
