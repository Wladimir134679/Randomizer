package com.wdeath.randomaizer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class Launcher extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainApp.fxml"));
            loader.load();
            root = loader.getRoot();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(root == null)
            return;


        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Randomizer");
        primaryStage.sizeToScene();

        primaryStage.show();
    }

    public static void main(String[] args) {
        Database.getInstance().load();
        launch(args);
    }
}
