/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3treka;

 import java.sql.Connection;  
 import java.sql.DriverManager;  
 import java.sql.SQLException; 
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
/**
 *
 * @author User
 */
public class DBConnection {
   private static Connection conn;  
   private static String url = "jdbc:mysql://localhost:3306/3trekka";  
   private static String user = "root";//Username of database  
   private static String pass = "1115kowar";//Password of database  
   public static Connection connect() throws SQLException{  
     try{  
       Class.forName("com.mysql.jdbc.Driver").newInstance();  
     }catch(ClassNotFoundException cnfe){  
       System.err.println("Error: "+cnfe.getMessage());  
     }catch(InstantiationException ie){  
       System.err.println("Error: "+ie.getMessage());  
     }catch(IllegalAccessException iae){  
       System.err.println("Error: "+iae.getMessage());  
     }  
     conn = DriverManager.getConnection(url,user,pass);  
     return conn;  
   }  
   public static Connection getConnection() throws SQLException, ClassNotFoundException{  
     if(conn !=null && !conn.isClosed())  
       return conn;  
     connect();  
     return conn;  
   }  
       public static void infoBox(String infoMessage, String titleBar, String headerMessage){

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
}
}
