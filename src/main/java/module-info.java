module com.example.project1gui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.project1gui to javafx.fxml;
    exports com.example.project1gui;
}