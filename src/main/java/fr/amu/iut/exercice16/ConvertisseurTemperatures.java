package fr.amu.iut.exercice16;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class ConvertisseurTemperatures extends Application {

    @Override
    public void start(Stage primaryStage) {
        Text celsius = new Text("°C");
        Text fahrenheit = new Text("°F");

        TextField nCelsius = new TextField("0");
        nCelsius.setPrefWidth(50);
        TextField nFahrenheit = new TextField("32");
        nFahrenheit.setPrefWidth(50);

        Slider sliderCelsius = new Slider(0,100,0);
        Slider sliderFahrenheit = new Slider(0,210,32);

        sliderFahrenheit.setShowTickMarks(true);
        sliderFahrenheit.setShowTickLabels(true);
        sliderFahrenheit.setOrientation(Orientation.VERTICAL);
        sliderFahrenheit.setMajorTickUnit(10f);
        sliderFahrenheit.setPrefHeight(400);
        sliderFahrenheit.setPrefWidth(60);

        sliderCelsius.setShowTickMarks(true);
        sliderCelsius.setShowTickLabels(true);
        sliderCelsius.setOrientation(Orientation.VERTICAL);
        sliderCelsius.setMajorTickUnit(10f);
        sliderCelsius.setPrefHeight(400);
        sliderCelsius.setPrefWidth(60);
        Bindings.bindBidirectional(nCelsius.textProperty(), sliderCelsius.valueProperty(), new javafx.util.StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                return String.format("%.2f", object);
            }

            @Override
            public Number fromString(String string) {
                try {
                    return Double.parseDouble(string);
                } catch (NumberFormatException e) {
                    return 0;
                }
            }
        });

        Bindings.bindBidirectional(nFahrenheit.textProperty(), sliderFahrenheit.valueProperty(), new javafx.util.StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                return String.format("%.2f", object);
            }

            @Override
            public Number fromString(String string) {
                try {
                    return Double.parseDouble(string);
                } catch (NumberFormatException e) {
                    return 0;
                }
            }
        });


        sliderCelsius.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                sliderFahrenheit.adjustValue(sliderCelsius.getValue()*1.8+32);
            }
        });

        sliderFahrenheit.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                sliderCelsius.adjustValue((sliderFahrenheit.getValue()-32)/1.8);
            }
        });

        HBox panneauHMesure = new HBox(100,celsius,fahrenheit);
        HBox panneauHSlider = new HBox(50,sliderCelsius,sliderFahrenheit);
        HBox panneauHText = new HBox(60,nCelsius,nFahrenheit);
        VBox panneauCelsius = new VBox(10, panneauHMesure, panneauHSlider,panneauHText);

        HBox root = new HBox(20, panneauCelsius);
        root.setPadding(new Insets(100));



        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}