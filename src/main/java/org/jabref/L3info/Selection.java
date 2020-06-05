package org.jabref.L3info;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Selection extends Application {

    File selectedFilea;
    File selectedFileb;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("projetL3in ");

        FileChooser fileChoosera = new FileChooser();

        Button buttona = new Button("selectionner un fichier A");
        buttona.setOnAction(e -> {
            File selectedFilea = fileChoosera.showOpenDialog(primaryStage);
        });

        FileChooser fileChooserb = new FileChooser();

        Button buttonb = new Button("selectionner un fichier B");
        buttonb.setOnAction(e -> {
            File selectedFileb = fileChooserb.showOpenDialog(primaryStage);
        });

        Button buttons = new Button("suivant");
        buttonb.setOnAction(e -> {
            primaryStage.close();
        });

        VBox vBox = new VBox(buttona, buttonb);
        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}