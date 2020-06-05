package org.jabref.L3info;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import org.jabref.gui.DialogService;
import org.jabref.gui.JabRefFrame;
import org.jabref.gui.StateManager;
import org.jabref.gui.duplicationFinder.DuplicateSearch;

public class Union extends Application {

    File selectedFilea = null;
    File selectedFileb = null;

    JabRefFrame frame;
    DialogService dialogService;
    StateManager stateManager;

    public Union(JabRefFrame frame, DialogService dialogService, StateManager stateManager) {
        this.frame = frame;
        this.dialogService = dialogService;
        this.stateManager = stateManager;

    }

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
            //On commence par la selection des fichiers
            if ((selectedFilea == null) || (selectedFileb == null)) {// ne rien faire
            }
            // concaténer les deux fichiers
            Scanner sc;
            File fab = new File("Unionab");
            PrintWriter writer = null;
            try {
                writer = new PrintWriter(fab);
            } catch (FileNotFoundException e2) {
                // TODO Auto-generated catch block
                e2.printStackTrace();
            }
            try {
                sc = new Scanner(selectedFilea);
                String str;
                while (sc.hasNext()) {
                    str = sc.nextLine();

                    writer.println(str);

                }
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            try {
                sc = new Scanner(selectedFileb);
                String str;
                while (sc.hasNext()) {
                    str = sc.nextLine();

                    writer.println(str);

                writer.close();
            }
        } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            //On creer ensuite la database

            // On fini par la recerche de clé dupliqué
            new DuplicateSearch(frame, dialogService, stateManager);
            primaryStage.close();
        });

        VBox vBox = new VBox(buttona, buttonb);
        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }




}
