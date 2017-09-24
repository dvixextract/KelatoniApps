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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ReminderViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtPassword;

    @FXML
    private Button submit;

    @FXML
    private Button start;

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    public ReminderViewController() throws SQLException {
        try {
           connection = DBConnection.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @FXML
    void handleSubmitEvent(ActionEvent event) {

        String username = txtUserName.getText().toString();
        String password = txtPassword.getText().toString();
 
        String sql = "SELECT * FROM Users WHERE U_username = ? and U_password = ?";
 
    try{

        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        resultSet = (ResultSet) preparedStatement.executeQuery();
        
        if(!resultSet.next()){
        DBConnection.infoBox("Enter Correct Email and Password", "Failed", null);
          }else{


        try {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("NewUserView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 787, 693);//next page size
        Stage stage = new Stage();
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


    @FXML
    void handleStartEvent(ActionEvent event) {

    try {
        Stage stage = (Stage) start.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Timer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());//next page size
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX(primScreenBounds.getMinX() + primScreenBounds.getWidth() - 100); //might cause problems in different screens
        stage.setY(primScreenBounds.getMinY() + primScreenBounds.getHeight() );
        stage.setTitle("Time");
        stage.setScene(scene);
        stage.show();
        
    } catch (IOException e) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.log(Level.SEVERE, "Failed to create new Window.", e);
    }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
}
