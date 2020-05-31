package com.wdeath.randomaizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class MainAppController implements Initializable {

    @FXML
    private TextField field;
    @FXML
    private VBox panel;
    @FXML
    private Label message;

    public void clickAdd(ActionEvent event){
        if(!field.getText().equals("")) {
            String action = field.getText();
            Database.getInstance().addAction(action);
            field.setText("");

            createLabel(action);
        }
    }

    public void clickSave(ActionEvent event){
        Database.getInstance().save();
    }

    public void clickGenerate(ActionEvent event){
        ArrayList<String> list = (ArrayList<String>) Database.getInstance().getList();
        Random random = new Random();
        int element = random.nextInt(list.size());

        String action = list.get(element);

        String messageStr = "Вам выпало: \n" + action;
        message.setText(messageStr);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> list = (ArrayList<String>) Database.getInstance().getList();
        for (String str : list){
            createLabel(str);
        }
    }

    private void createLabel(String str){
        HBox hBox = new HBox();

        Label label = new Label(str);
        label.setPrefWidth(190);

        Button button = new Button("Remove");
        button.setOnMouseClicked(event -> {
            panel.getChildren().remove(hBox);
            Database.getInstance().remove(label.getText());
        });

        hBox.getChildren().addAll(label, button);

        panel.getChildren().add(hBox);
    }
}
