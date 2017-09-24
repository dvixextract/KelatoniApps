/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3treka;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * FXML Controller class
 *
 * @author User
 */
public class TimerController extends DefaultLabel implements Initializable  {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label days;

    @FXML
    private Label hours;

    @FXML
    private Label mins;

    @FXML
    private Button pause;

    @FXML
    private Button stop;
//
//    
//       private int max;
//    private int seconds;
//    private Timeline timeline;
//
//    public TimerController(int maxSeconds) {
//        super(128);
//        seconds = max = maxSeconds;
//        timeline = new Timeline();
//        timeline.setCycleCount(Animation.INDEFINITE);
//        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), event -> {
//            seconds--;
//            updateText();
//            if(seconds <= 0) {
//                stop();
//                onComplete();
//            }
//        }));
//        updateText();
//        start();
//    }
//
//    protected void onComplete() {}
//
//    private void updateText() {
//        setText(String.format("%d:%02d", seconds/60, seconds%60));
//    }
//
//    public void start() {
//        timeline.play();
//    }
//
//    public void stop() {
//        timeline.stop();
//    }
//
//    public void reset() {
//        seconds = max;
//    }
//    
//    
    @FXML
    void handlePauseAction(ActionEvent event) {

//     timeline.play();
    }
    
    
    @FXML
    void handleStopAction(ActionEvent event) {

                try {
        Stage stage = (Stage) stop.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("ReminderView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());//next page size
        stage.setTitle("Create Employee");
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
