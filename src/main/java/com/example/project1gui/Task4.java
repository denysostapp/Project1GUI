package com.example.project1gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Task4 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("AUK Bachelor's Program Application");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(30, 30, 30, 30));
        grid.setVgap(10);
        grid.setHgap(30);
        grid.setBorder(new Border(new BorderStroke(Color.DARKBLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5.0))));

        Label titleLabel = new Label("AUK Bachelor's Program Application");
        titleLabel.setFont(Font.font("Arial", 14));
        GridPane.setConstraints(titleLabel, 0, 0, 2, 1);

        // Personal Information Section
        Label personalInfoLabel = new Label("Personal Information:");
        personalInfoLabel.setFont(Font.font("Arial", 12));
        GridPane.setConstraints(personalInfoLabel, 0, 1, 2, 1);

        TextField fullNameField = new TextField();
        fullNameField.setPromptText("Full Name");
        GridPane.setConstraints(fullNameField, 0, 2);

        DatePicker dobPicker = new DatePicker();
        dobPicker.setPromptText("Date of Birth");
        GridPane.setConstraints(dobPicker, 1, 2);

        TextField nationalityField = new TextField();
        nationalityField.setPromptText("Nationality");
        GridPane.setConstraints(nationalityField, 0, 3);

        TextField emailField = new TextField();
        emailField.setPromptText("Email Address");
        GridPane.setConstraints(emailField, 1, 3);

        // Program of Interest Section
        Label programInterestLabel = new Label("Program of Interest:");
        programInterestLabel.setFont(Font.font("Arial", 12));
        GridPane.setConstraints(programInterestLabel, 0, 4, 2, 1);

        ComboBox<String> programComboBox = new ComboBox<>();
        programComboBox.getItems().addAll("Global Management", "Business Administration", "Marketing Science", "Software Engeneering", "Data Science and AI");
        programComboBox.setPromptText("Select Program");
        GridPane.setConstraints(programComboBox, 0, 5, 2, 1);

        Label englishProfiencyLabel = new Label("English Profiency Test:");
        englishProfiencyLabel.setFont(Font.font("Arial", 12));
        GridPane.setConstraints(englishProfiencyLabel, 0, 6, 2, 1);

        ComboBox<String> EnglishProfiency = new ComboBox<>();
        EnglishProfiency.getItems().addAll("TOEFL", "IELTS", "Duolingo", "NMT");
        EnglishProfiency.setPromptText("Select English Test: ");
        GridPane.setConstraints(EnglishProfiency, 0, 7, 2, 1);

        Label schoolLabel = new Label("Name of The School:"); //School
        TextField schoolTextField = new TextField();
        schoolTextField.setPromptText("Enter the name of your school");
        GridPane.setConstraints(schoolLabel, 1, 6);
        GridPane.setConstraints(schoolTextField, 1, 7);

        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: #ff0000;");
        GridPane.setConstraints(errorLabel, 0, 8, 2, 1);



        // Submit Button
        Button submitButton = new Button("Submit");
        GridPane.setConstraints(submitButton, 0,9 );

        // Applicant Information Overall
        TextArea applicantInfo = new TextArea();
        applicantInfo.setEditable(false);
        GridPane.setConstraints(applicantInfo, 0, 10, 2, 1);

        submitButton.setOnAction(event -> {
            // Check for errors and submit the form
            if (!fullNameField.getText().isEmpty() && dobPicker.getValue() != null && !nationalityField.getText().isEmpty() && !emailField.getText().isEmpty() && programComboBox.getValue() != null && EnglishProfiency.getValue() != null){
                errorLabel.setText("Application Submitted Successfully!");
                errorLabel.setStyle("-fx-text-fill: #3fa934;");

                // Update the TextArea
                applicantInfo.setText("Full Name: " + fullNameField.getText() + "\n"
                        + "Date of Birth: " + dobPicker.getValue() + "\n"
                        + "Nationality: " + nationalityField.getText() + "\n"
                        + "Email: " + emailField.getText() + "\n"
                        + "Program: " + programComboBox.getValue());

                // You can process the form data here
            } else {
                errorLabel.setText("Please fill out all fields correctly.");
            }
        });

        Button saveToFile = new Button("Save to File");
        GridPane.setConstraints(saveToFile, 1, 9);
        saveToFile.setOnAction(event -> {
            // Save the form data to a file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("application.txt"))) {
                writer.write("Full Name: " + fullNameField.getText() + "\n");
                writer.write("Date of Birth: " + dobPicker.getValue() + "\n");
                writer.write("Nationality:" + nationalityField.getText() + "\n");
                writer.write("Email: " + emailField.getText() + "\n");
                writer.write("Program: " + programComboBox.getValue() + "\n");
                writer.write("English Profiency Test: " + EnglishProfiency.getValue() + "\n");
                writer.write("School: " + schoolTextField.getText() + "\n");
                writer.write("Application Status: " + errorLabel.getText() + "\n");
        } catch (IOException e) {
                System.out.println("Error:"+ e.getMessage());
            }});

        grid.getChildren().addAll(titleLabel, personalInfoLabel, fullNameField, dobPicker, nationalityField, emailField,
                programInterestLabel, programComboBox,englishProfiencyLabel,EnglishProfiency ,schoolLabel,schoolTextField,
                submitButton,saveToFile, errorLabel, applicantInfo);

        Scene scene = new Scene(grid, 800, 700);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
