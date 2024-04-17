package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Création du conteneur principal
        root = new BorderPane();

        // Création des 3 boutons
        bas = new HBox();
        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");
        bas.getChildren().addAll( vert, rouge, bleu );
        bas.setSpacing(10);
        bas.setPadding(new Insets(10));
        bas.setAlignment(Pos.CENTER);
        root.setBottom(bas);

        // Création de la banière haut
        label = new Label("");
        label.setFont(new Font("Serif", 20));
        root.setTop(label);
        root.setStyle("-fx-background-color: #eeeeee");
        BorderPane.setAlignment(label, Pos.CENTER);

        // Création du banière pane pour couleur
        panneau = new Pane();
        panneau.setStyle("-fx-background-color: #eeeeee");
        root.setCenter(panneau);

        // Changement du texte et couleur après un clic sur le bouton
        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, clikVert);
        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, clikRouge);
        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, clikBleu);
        primaryStage.setTitle("Hello application");
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.show();

        // Ajout du conteneur à la scene
        Scene scene = new Scene(root );

        // Ajout de la scene à la fenêtre et changement de ses paramètres (dimensions et titre)
        primaryStage.setScene( scene );
        primaryStage.setWidth( 800 );
        primaryStage.setHeight( 600 );

        // Affichage de la fenêtre
        primaryStage.show();
    }
    EventHandler<MouseEvent> clikVert = actionEvent -> {
        ++nbVert;
        panneau.setStyle("-fx-background-color: #00" + (10*nbVert)%100 + "00");
        label.setText( "Vert choisi "+nbVert+ " fois" );
    };
    EventHandler<MouseEvent> clikRouge = actionEvent -> {
        ++nbRouge;
        panneau.setStyle("-fx-background-color: #" + (10*nbRouge)%100 + "0000");
        label.setText( "Rouge choisi "+nbRouge+ " fois" );
    };
    EventHandler<MouseEvent> clikBleu = actionEvent -> {
        ++nbBleu;
        panneau.setStyle("-fx-background-color: #0000" + (10*nbBleu)%100 );
        label.setText( "Bleu choisi "+nbBleu+ " fois" );
    };

}

