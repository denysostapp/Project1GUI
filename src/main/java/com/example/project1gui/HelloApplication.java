package com.example.project1gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage){
        VBox nameBox = new VBox(40);
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();
        Button copyButton = new Button("Copy");
        Button copyButton2 = new Button("Copy");
        Button copyButton3 = new Button("Copy");
        Label label = new Label();
        label.setFont(new Font(30));
        copyButton.setOnAction(e -> textField2.setText(textField1.getText()));
        textField2.setOnAction(e -> label.setText("Text: " + textField2.getText()));
        copyButton2.setOnAction(e -> textField3.setText(label.getText()));
        copyButton3.setOnAction(e -> textField1.setText(textField3.getText()));

        nameBox.getChildren().addAll(textField1, copyButton, textField2, label, copyButton2, textField3, copyButton3);
        nameBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(nameBox, 1000, 900);
        stage.setScene(scene);
        stage.setTitle("Project 1 Part 1");
        stage.show();



    }

    public static void main(String[] args) {
        launch();
    }
}