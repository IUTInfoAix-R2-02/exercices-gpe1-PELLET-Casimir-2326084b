package fr.amu.iut.exercice1;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
            // Création du conteneur principal
            BorderPane root = new BorderPane();

            // Création du conteneur correspondant à la ligne de contrôle haut dessus du tableau
            Menu file = new Menu("File");
            Menu options = new Menu("Options");
            Menu help = new Menu("Help");
            MenuItem fileNew = new MenuItem("New");
            MenuItem fileOpen = new MenuItem("Open");
            MenuItem fileSave = new MenuItem("Save");
            MenuItem fileClose = new MenuItem("Close");
            MenuItem optionsCut = new MenuItem("Cut");
            MenuItem optionsCopy = new MenuItem("Copy");
            MenuItem optionsPaste = new MenuItem("Paste");

            file.getItems().addAll(fileNew, fileOpen, fileSave, fileClose);
            options.getItems().addAll(optionsCut, optionsCopy, optionsPaste);

            MenuBar menuBar = new MenuBar(file, options, help);
            root.setTop(menuBar);

            // Création du tableau avec les deux colonnes
            TableView<Object> tblCustomers = new TableView<>();
            TableColumn<Object, String> lastNameCol = new TableColumn<>("Last Name");
            TableColumn<Object, String> firstNameCol = new TableColumn<>("First Name");
            tblCustomers.getColumns().addAll( lastNameCol, firstNameCol );

            // Création de la ligne de séparation
            Separator hSep = new Separator();
            Separator vSep = new Separator();
            vSep.setOrientation(Orientation.VERTICAL);

            // Création du bandeau gauche de la fenêtre
            HBox hGauche = new HBox();
            VBox vGauche = new VBox();
            Label labBoutons = new Label("Boutons :");
            Button bouton1 = new Button("Bouton 1");
            Button bouton2 = new Button("Bouton 2");
            Button bouton3 = new Button("Bouton 3");
            vGauche.setAlignment(Pos.CENTER);
            vGauche.getChildren().addAll( labBoutons, bouton1, bouton2, bouton3 );
            vGauche.setSpacing(10);
            hGauche.getChildren().addAll(vGauche, vSep);
            root.setLeft(hGauche);

            // Création du bandeau principal de la fenêtre
            HBox hCentre = new HBox();
            VBox vCentre = new VBox();
            GridPane tab = new GridPane ();
            TextField nameChamp = new TextField();
            TextField emailChamp = new TextField();
            TextField passwordChamp = new TextField();
            Label name = new Label("Name :");
            Label email = new Label("Email :");
            Label password = new Label("Password :");
            Button submit = new Button("Submit");
            Button cancel = new Button("Cancel");
            tab.addRow(0 , name , nameChamp);
            tab.addRow(1 , email , emailChamp);
            tab.addRow(2 , password , passwordChamp);
            hCentre.getChildren().addAll( submit, cancel );
            hCentre.setSpacing(10);
            vCentre.setSpacing(10);
            tab.setAlignment(Pos.CENTER);
            tab.setVgap(10);
            tab.setHgap(10);
            vCentre.getChildren().addAll( tab, hCentre);
            hCentre.setAlignment(Pos.CENTER);
            vCentre.setAlignment(Pos.CENTER);

            root.setCenter(vCentre);

            // Création du bandeau en bas de la fenêtre
            VBox basPage = new VBox();
            Label etiquette = new Label("Ceci est un label textuel");
            basPage.setAlignment(Pos.CENTER);
            basPage.getChildren().addAll( hSep, etiquette );
            root.setBottom(basPage);



            // Ajout du conteneur à la scene
            Scene scene = new Scene(root );

            // Ajout de la scene à la fenêtre et changement de ses paramètres (dimensions et titre)
            primaryStage.setScene( scene );
            primaryStage.setWidth( 800 );
            primaryStage.setHeight( 600 );
            primaryStage.setTitle("Premier exemple manipulant les conteneurs");

            // Affichage de la fenêtre
            primaryStage.show();
        }
    public static void main(String[] args) {
        launch(args);

    }
}

