package fr.amu.iut.exercice7;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CounterController implements Initializable {

    int counter = 0;

    @FXML
    public void increment() {
        counter += 1;
        counterLabel.setText(counter + "");
    }
    @FXML
    public void decrement() {
        counter -= 1;
        counterLabel.setText(counter + "");
    }

    @FXML
    Label counterLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initializing CounterController...");
   }
}
