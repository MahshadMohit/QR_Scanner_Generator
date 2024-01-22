package com.example.qrcode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class QRApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(QRApplication.class.getResource("FirstPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),853.0 ,573.0 );
        stage.setTitle("QR-Press");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}