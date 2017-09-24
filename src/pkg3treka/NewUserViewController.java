/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3treka;


import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author User
 */
public class NewUserViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private TextField name;

    @FXML
    private TextField surname;

    @FXML
    private TextField email;

    @FXML
    private Button save;

    @FXML
    private Button cancel;

    @FXML
    private Label label;

    @FXML
    private TextField id;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private TextField phone;
    
    @FXML
    private ComboBox<String> role;

    @FXML
    private ComboBox<String> Access;

    @FXML
    private ComboBox<String> Etype;

    
    
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    com.mysql.jdbc.ResultSet resultSet = null;
    
    ObservableList<String> Roles = FXCollections.observableArrayList(
            "Team Lead", "Intern", "Manager" ,"Scrum Master","Junior Engineer", "Intermediate Engineer","Senior Engineer"
            );
    ObservableList<String> EmployeeType = FXCollections.observableArrayList(
            "Contract", "Permanent"
            );
    ObservableList<String> AccessLevel = FXCollections.observableArrayList(
            "Tier 1", "Tier 2", "Tier 3" 
            );
    

   
    public NewUserViewController() throws SQLException {
        try {
           connection = DBConnection.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    cancel.setOnAction(new EventHandler<ActionEvent>() {
//    @Override public void handle(ActionEvent e) {
//        label.setText("Accepted");
//    }
//});
    
    @FXML
    void handleCancelAction(ActionEvent event) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }
    @FXML
    void handleButtonAction(ActionEvent event) {

        String textFieldName = name.getText().toString();
        String textFieldUsername = username.getText().toString();
        String textFieldEmail = email.getText().toString();
        int textFieldPhone = Integer.parseInt(phone.getText());
        String textFieldpassword = password.getText().toString();
        String textFieldsurname = surname.getText().toString();
        String userRole = role.getValue();
        String Accesslev = Access.getValue();
        String employType = Etype.getValue();
        

        
        
        String sql = " insert into Users (U_name, U_username, U_email, U_phone, U_password, U_surname,Role,accessLevel,employeeType)"
        + " values (?, ?, ?, ?, ?,?,?,?,?)";
 
    try{

        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, textFieldName);
        preparedStatement.setString(2, textFieldUsername);
        preparedStatement.setString(3, textFieldEmail);
        preparedStatement.setInt(4, textFieldPhone);
        preparedStatement.setString(5, textFieldpassword);
        preparedStatement.setString(6, textFieldsurname);
        preparedStatement.setString(7, userRole);
        preparedStatement.setString(8, Accesslev);
        preparedStatement.setString(9, employType);
        try{
        preparedStatement.execute();
        DBConnection.infoBox("User created Successfull", "Success", null);
        }catch(Exception e){
        DBConnection.infoBox("Error Saving Data", "Fail", null);
        e.printStackTrace();
        }


}catch(Exception e){
        DBConnection.infoBox("Error Saving Data", "Fail", null);
        e.printStackTrace();
}
        
    }
    
    
    
    
    
    
    
    
    
    
//    public Connection getConnection(){
//    Connection con;
//    try{
//    
//        con = DriverManager.getConnection("jdbc:mysql://localhost/3trekka", "root", "1115kowar");
//        return con;
//        
//    }catch(SQLException e){
//    
//        e.printStackTrace();
//        return null;
//    }
//    }
//    
//    public ArrayList<User> userList(){
//    
//        ArrayList<User> usersList = new ArrayList<User>();
//        Connection connection = getConnection();
//        
//        String query = "SELECT * FROM Users";
//        Statement st;
//        ResultSet rs;
//        
//        try {
//        
//            st = connection.createStatement();
//           rs = st.executeQuery(query);
//            User user;
//            while(rs.next()){
//            
//                user = new User(rs.getInt("U_id"),rs.getString("U_username"),rs.getString("U_name"),rs.getString("U_surname"),rs.getString("U_email"),rs.getInt("U_phone"),rs.getString("U_password"));
//                usersList.add(user);
//            }
//            
//        }catch(Exception e){
//        
//            e.printStackTrace();
//        }
//        return usersList;
//    }
//    
//    public NewUserViewController() {
//      Connection connection = getConnection();
//    }
//    
//        @FXML
//    void handleButtonAction(ActionEvent event) {
//        
//        try {
//       
//        String query =" INSERT INTO `Users`( `U_username`, `U_name`, `U_surname`, `U_email`, `U_phone`, `U_password`) VALUES ("+username.getText()+","+name.getText()+","+surname.getText()+","+email.getText()+","+phone.getText()+","+password.getText()+")";
//        executeSQlQuery(query,"Ïnserted");
//	Statement statement = getConnection().createStatement();
//	statement.executeUpdate(query);
//	} catch (Exception e2) {
//	  System.out.println(e2);
//	}
//        
//    }
//    private void SaveButton_InsertActionPerformed(java.awt.event.ActionEvent evt){
//    
//        String query =" INSERT INTO `Users`(`U_id`, `U_username`, `U_name`, `U_surname`, `U_email`, `U_phone`, `U_password`) VALUES ("+id.getText()+","+username.getText()+","+name.getText()+","+surname.getText()+","+email.getText()+","+phone.getText()+","+password.getText()+")";
//        executeSQlQuery(query,"Ïnserted");
//    }
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        role.setItems(Roles);
        Etype.setItems(EmployeeType);
        Access.setItems(AccessLevel);
        
    }    
 
}