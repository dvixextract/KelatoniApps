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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AdminViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableColumn<Projects, String>  duration;
    
    @FXML
    private TableView<Projects> AllProjectsTable;
    
    @FXML
    private TableColumn<Projects, String> Project_Name;

    @FXML
    private TableColumn<Projects, String> Project_Code;

    @FXML
    private TableColumn<Projects, String> NumberOF_Sprints;

    @FXML
    private TableColumn<Projects, String> Num_Tasks;

    @FXML
    private TableColumn<Projects, String> TM_Assgn;

    @FXML
    private TableColumn<Projects, String> Project_Desc;

    @FXML
    private TextField ProjectSearch;

    @FXML
    private TableView<User> ListAllEmployees;

    @FXML
    private TableColumn<User, String> E_name;

    @FXML
    private TableColumn<User, String> E_surname;

    @FXML
    private TableColumn<User, String> E_type;

    @FXML
    private TableColumn<User, String> Acc_level;

    @FXML
    private TableColumn<User, String> R_ole;

    @FXML
    private TableColumn<User, String> P_hone;

    @FXML
    private TableColumn<User, String>E_mail;

    @FXML
    private TextField searchEmployee;

    @FXML
    private TextField teamname;

    @FXML
    private Button saveTeam;
    @FXML
    private TableView<User> Employees;
    
    @FXML
    private TableColumn<User, String> EID;

    @FXML
    private TableColumn<User, String> Ename;

    @FXML
    private TableColumn<User, String> Erole;
    
    @FXML
    private Button createEmployee;
    
    @FXML
    private TableColumn<User, String> AccessLvl;
    
    @FXML
    private ListView<String> listvw;

     @FXML
    private TextField Projectname;

    @FXML
    private TextField TasksNumber;

    @FXML
    private TextField ProjectCode;

    @FXML
    private TextField SprintsNumber;
    
    @FXML
    private TextField CompleteProject;


    @FXML
    private ComboBox<String> AssignTeam;

    @FXML
    private TextArea ProjectDescription;

    @FXML
    private Button saveNewProject;


    @FXML
    private Label label;


    
    private String mmber;
    
    private ObservableList<User> masterData = FXCollections.observableArrayList();
    private ObservableList<User> AllUserData = FXCollections.observableArrayList();
     private ObservableList<Projects> AllProjectsData = FXCollections.observableArrayList();
    private ObservableList<User> filteredData = FXCollections.observableArrayList();
    private ObservableList<String> masterData3;
    ArrayList<String> Team_Members = new ArrayList<String>();
    ObservableList TeamList = FXCollections.observableArrayList();
    
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;


        public AdminViewController() {
            
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

//    
        masterData.add(new User("Dennis", "Masha","Director","Tier 3"));//test data
        
                // Initially add all data to filtered data
        filteredData.addAll(masterData);

        // Listen for changes in master data.
        // Whenever the master data changes we must also update the filtered data.
        masterData.addListener(new ListChangeListener<User>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends User> change) {
                updateFilteredData();
            }
        });
        
    }
    
    @FXML
    void handleSaveNewProjectAction(ActionEvent event) {
     CreateProject();
    }
    
    @FXML
    void handleButtonAction(ActionEvent event) {

        String TmNmae = teamname.getText().toString();
        String sql = " insert into Teams (Teamname, Members)"
        + " values (?, ?)";
 
    try{

        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, TmNmae);
        preparedStatement.setString(2, getMember());
        try{
        preparedStatement.execute();
        DBConnection.infoBox("Team created Successfull", "Success", null);
        }catch(Exception e){
        DBConnection.infoBox("Error Saving Data", "Fail", null);
        e.printStackTrace();
        }
}catch(Exception e){
        DBConnection.infoBox("Error Saving Data", "Fail", null);
        e.printStackTrace();
}
        
    }
    
   @FXML
    void handleCreateEmployee(ActionEvent event) {
        
            try{

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("NewUserView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());//next page size
        Stage stage = new Stage();
        stage.setTitle("Creaate Employee");
        stage.setScene(scene);
        stage.show();

}catch(Exception e){
        DBConnection.infoBox("Error Saving Data", "Fail", null);
        e.printStackTrace();
}

    }   
    
    public void setMember(String mmber){
    
       this.mmber = mmber;
    }
    
    public String getMember(){
    
       return mmber;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         // Initialize the person table

          setCellTable();
          setAllUserInfoCellTable();
          setAllProjectsInfoCellTable();
          loadDataFromDatabase();
          loadTeamsDataFromDatabase();
          loadAllUserInformation();
          loadAllProjectsInformation();
          //AssignTeam.setItems(TeamList);
          
        // Add filtered data to the table
        Employees.setItems(filteredData);

        // Listen for text changes in the filter text field
        searchEmployee.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {

                updateFilteredData();
            }
        });   
       

        start();
        
    }   

    public void start(){
    
     Employees.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
          
               System.out.println(Employees.getSelectionModel().getSelectedItem().getName());
               System.out.println(Employees.getSelectionModel().getSelectedItem().getSurName());
               System.out.println(Employees.getSelectionModel().getSelectedItem().getROLE());
               Team_Members.add(Employees.getSelectionModel().getSelectedItem().getName());
               setMember(Employees.getSelectionModel().getSelectedItem().getName());
               //listvw.setItems(Employees.getSelectionModel().getSelectedItem().getName());
            }
                    
        });

    }
    
         

// public void startArra() {
//
//for(int i=0;i<Team_Members.size();i++){
//    System.out.println(Team_Members.get(i));
//} 
//}
//     
 

public String onEdit() {
    // check the table's selected item and get selected item
    String sur_name = "";
    String na_me = "" ;
    String full_name ="";
    if (Employees.getSelectionModel().getSelectedItem() != null) {
        User selectedPerson = Employees.getSelectionModel().getSelectedItem();
         na_me = (selectedPerson.getName());
         sur_name = (selectedPerson.getSurName());
         
         full_name = na_me+"_"+sur_name;
    }
    else{
        full_name="";
    }
    return full_name;
}
    
    public void setCellTable(){
    
        EID.setCellValueFactory(new PropertyValueFactory<User, String>("surName"));
        Ename.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        Erole.setCellValueFactory(new PropertyValueFactory<User, String>("ROLE"));
        AccessLvl.setCellValueFactory(new PropertyValueFactory<User, String>("ACCESSLEVEL"));
    }
    
    public void loadDataFromDatabase(){
    
        try {
            String sql = "SELECT * FROM Users";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = (ResultSet) preparedStatement.executeQuery();
            while(resultSet.next()){
            
                masterData.add(new User(""+resultSet.getString(4),""+resultSet.getString(3),""+resultSet.getString(8),""+resultSet.getString(9)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Employees.setItems(masterData);
    }
    
    
   public void setAllUserInfoCellTable(){
    
        E_name.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        E_surname.setCellValueFactory(new PropertyValueFactory<User, String>("surName"));
        E_type.setCellValueFactory(new PropertyValueFactory<User, String>("EMPLOYEETYPE"));
        Acc_level.setCellValueFactory(new PropertyValueFactory<User, String>("ACCESSLEVEL"));
        R_ole.setCellValueFactory(new PropertyValueFactory<User, String>("ROLE"));
        P_hone.setCellValueFactory(new PropertyValueFactory<User, String>("PHone"));
        E_mail.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
    }

    public void loadAllUserInformation(){
    
    try {
            String sql = "SELECT * FROM Users";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = (ResultSet) preparedStatement.executeQuery();
            while(resultSet.next()){
 
                //AllUserData.add(new User (resultSet.getString(3),""+resultSet.getString(5),""+resultSet.getString(6),""+resultSet.getString(8) ));
               AllUserData.add(new User(resultSet.getString(3),resultSet.getString(4),""+resultSet.getString(10),""+resultSet.getString(9),""+resultSet.getString(8),""+resultSet.getString(6),""+resultSet.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ListAllEmployees.setItems(AllUserData);
    }
    
    
       public void setAllProjectsInfoCellTable(){
    

        Project_Name.setCellValueFactory(new PropertyValueFactory<Projects, String>("ProjName"));
        Project_Code.setCellValueFactory(new PropertyValueFactory<Projects, String>("ProjCode"));
        NumberOF_Sprints.setCellValueFactory(new PropertyValueFactory<Projects, String>("ProjNumOfSprints"));
        Num_Tasks.setCellValueFactory(new PropertyValueFactory<Projects, String>("ProjNumOfTasks"));
        TM_Assgn.setCellValueFactory(new PropertyValueFactory<Projects, String>("ProjTeam"));
        Project_Desc.setCellValueFactory(new PropertyValueFactory<Projects, String>("ProjDescriptions"));
        duration.setCellValueFactory(new PropertyValueFactory<Projects, String>("ProjDuration"));
        
    }

    public void loadAllProjectsInformation(){
    
    try {
            String sql = "SELECT * FROM Project";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = (ResultSet) preparedStatement.executeQuery();
            while(resultSet.next()){
 
               AllProjectsData.add(new Projects(resultSet.getString(1),resultSet.getString(2),""+resultSet.getString(3),""+resultSet.getString(4),""+resultSet.getString(5),""+resultSet.getString(6),""+resultSet.getString(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        AllProjectsTable.setItems(AllProjectsData);
    }
    
    
    
    
        public void loadTeamsDataFromDatabase(){
    
        try {
            String sql = "SELECT * FROM Teams ";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = (ResultSet) preparedStatement.executeQuery();
            while(resultSet.next()){

                AssignTeam.getItems().add(resultSet.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        
    public void CreateProject(){
    
    
        String textProjectName = Projectname.getText().toString();
        int textProjectCode = Integer.parseInt(SprintsNumber.getText());
        int textNumberOfSprints = Integer.parseInt(SprintsNumber.getText());
        int textNumerOfTasks= Integer.parseInt(TasksNumber.getText());
        String textProjectDescription = ProjectDescription.getText().toString();
        String textProjectTimeToComplete = CompleteProject.getText().toString();
        String assignTeam = AssignTeam.getValue();

        
        String sql = " insert into Project (P_code, P_name, P_timespan, NumTasks, NumSprints, P_Desc,P_AsgnTeam)"
        + " values (?, ?, ?, ?, ?,?,?)";
 
    try{

        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, textProjectCode);
        preparedStatement.setString(2, textProjectName);
        preparedStatement.setString(3, textProjectTimeToComplete);
        preparedStatement.setInt(4, textNumerOfTasks);
        preparedStatement.setInt(5, textNumberOfSprints);
        preparedStatement.setString(6, textProjectDescription);
        preparedStatement.setString(7, assignTeam);
        try{
        preparedStatement.execute();
        DBConnection.infoBox("Project created Successfull", "Success", null);
        }catch(Exception e){
        DBConnection.infoBox("Error Saving Data", "Fail", null);
        e.printStackTrace();
        }

}catch(Exception e){
        DBConnection.infoBox("Error Saving Data", "Fail", null);
        e.printStackTrace();
}
    
    }
    
    /**
     * Updates the filteredData to contain all data from the masterData that
     * matches the current filter.
     */
    private void updateFilteredData() {
        filteredData.clear();

        for (User p : masterData) {
            if (matchesFilter(p)) {
                filteredData.add(p);
            }
        }

        // Must re-sort table after items changed
        reapplyTableSortOrder();
    }

    /**
     * Returns true if the person matches the current filter. Lower/Upper case
     * is ignored.
     * 
     * @param person
     * @return
     */
    private boolean matchesFilter(User person) {
        String filterString = searchEmployee.getText();
        if (filterString == null || filterString.isEmpty()) {
            // No filter --> Add all.
            return true;
        }

        String lowerCaseFilterString = filterString.toLowerCase();

        if (person.getName().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
            return true;
        } else if (person.getSurName().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
            return true;
        }

        return false; // Does not match
    }

    private void reapplyTableSortOrder() {
        ArrayList<TableColumn<User, ?>> sortOrder = new ArrayList<>(Employees.getSortOrder());
        Employees.getSortOrder().clear();
        Employees.getSortOrder().addAll(sortOrder);
    }
    

    
}
    

