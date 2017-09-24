/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3treka;

import com.mysql.jdbc.ResultSet;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static pkg3treka.DBConnection.getConnection;

/**
 *
 * @author User
 */
public class FXMLDocumentController implements Initializable {
    
//    @FXML
//    private Button button;

//    @FXML
//    private Label label;
//    
//    @FXML
//    private TextField textField;
//
//    @FXML
//    void handleButtonAction(ActionEvent event) {
//        try {
//        FXMLLoader fxmlLoader = new FXMLLoader();
//        fxmlLoader.setLocation(getClass().getResource("NewUserView.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 787, 693);//next page size
//        Stage stage = new Stage();
//        stage.setTitle("New Window");
//        stage.setScene(scene);
//        stage.show();
//    } catch (IOException e) {
//        Logger logger = Logger.getLogger(getClass().getName());
//        logger.log(Level.SEVERE, "Failed to create new Window.", e);
//    }
//       
      
//       label.setText(textField.getText()+"here we go");

//    }
    
    
    
    @FXML
    private Button button;

    @FXML
    private Label label;

    @FXML
    private TextField textField;

    @FXML
    private TextField textPassword;


    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
 
   
    public FXMLDocumentController() throws SQLException {
        try {
           connection = DBConnection.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @FXML
    void handleButtonAction(ActionEvent event) {

        String username = textField.getText().toString();
        String password = textPassword.getText().toString();
 
        String sql = "SELECT * FROM Users WHERE U_username = ? and U_password = ?";
 
    try{

        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        resultSet = (ResultSet) preparedStatement.executeQuery();
        
        if(!resultSet.next()){
        DBConnection.infoBox("Enter Correct Email and Password", "Failed", null);
          }else{
         //DBConnection.infoBox("Login Successfull", "Success", null);

         // make page disapper
//         Node source = (Node) event.getSource();
//         dialogStage = (Stage) source.getScene().getWindow();
//         dialogStage.close();
//         scene = new Scene(FXMLLoader.load(getClass().getResource("FXMLMenu.fxml")));
//         dialogStage.setScene(scene);
//         dialogStage.show();

        try {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("AdminView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());//next page size
        stage.setTitle("Create Employee");
        stage.setScene(scene);
        stage.show();
        
    } catch (IOException e) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.log(Level.SEVERE, "Failed to create new Window.", e);
    }
}
 
}catch(Exception e){
e.printStackTrace();
}
        
    }
    

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            if(DBConnection.getConnection() == null){
                label.setText("Status: DATABASE NOT CONNECTED!");
            }
            else {
                label.setText("Status: DATABASE CONNECTED!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ;

    }    
    
}
