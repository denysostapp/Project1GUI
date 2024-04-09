package com.example.project1gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Task2 extends Application {


    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle(50, Color.RED);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(2);

        Rectangle rectangle = new Rectangle(100, 100, Color.RED);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(2);

        Ellipse ellipse = new Ellipse(50,25);
        ellipse.setFill(Color.GREEN);
        ellipse.setStroke(Color.BLACK);
        ellipse.setStrokeWidth(2);

        Polyline polyline = new Polyline(50, 0, 0, 50, 50, 100, 100, 50, 50, 0);
        polyline.setStroke(Color.BLUE);
        polyline.setStrokeWidth(2);

        Text text = new Text("JavaFX Part2Project1");
        text.setFill(Color.WHITE);

        Pane pane = new Pane();
        pane.getChildren().addAll(circle, rectangle, ellipse, polyline, text);

        circle.relocate(50,50);
        rectangle.relocate(200,150);
        ellipse.relocate(400,250);
        pane.setPadding(new Insets(10));

        // HBox layout container
        HBox hBox = new HBox();
        hBox.getChildren().addAll(circle, rectangle, ellipse, polyline, text);
        hBox.setSpacing(10); // Setting spacing between children
        hBox.setAlignment(javafx.geometry.Pos.CENTER); // Aligning children

        // VBox layout container
        VBox vBox = new VBox();
        vBox.getChildren().addAll(circle, rectangle, ellipse, polyline, text);
        vBox.setSpacing(10); // Setting spacing between children
        vBox.setAlignment(javafx.geometry.Pos.CENTER); // Aligning children

        // GridPane layout container
        GridPane gridPane = new GridPane();
        gridPane.add(circle, 0, 0);
        gridPane.add(rectangle, 1, 0);
        gridPane.add(ellipse, 0, 1);
        gridPane.add(polyline, 0, 2);
        gridPane.add(text, 1, 2);
        gridPane.setHgap(10); // Setting horizontal gap
        gridPane.setVgap(10); // Setting vertical gap
        gridPane.setAlignment(javafx.geometry.Pos.CENTER); // Aligning children

        // Applying background color to layout containers
        pane.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        hBox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        gridPane.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        // Creating a root layout container
        VBox root = new VBox();
        root.getChildren().addAll(pane, hBox, vBox,  gridPane);

        Scene scene = new Scene(root, 600, 500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Layout Demo");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
