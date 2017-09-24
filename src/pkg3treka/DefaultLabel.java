package pkg3treka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;

public class DefaultLabel extends Label {
    public DefaultLabel() {
        this("");
    }

    public DefaultLabel(int size) {
        this("", size);
    }

    public DefaultLabel(String text) {
        this(text, 32);
    }

    public DefaultLabel(String text, int size) {
        super(text);
        setTextFill(Paint.valueOf("white"));
        setStyle("-fx-font-size: " + size + "px;");
    }
}