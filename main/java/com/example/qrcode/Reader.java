package com.example.qrcode;

import com.google.zxing.NotFoundException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Reader {

    @FXML
    private ImageView back;

    @FXML
    private ImageView image;

    @FXML
    private Button scan;
    String str;

    public void setImage(){
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            Image image1 = new Image(file.toURI().toString());
            image.setImage(image1);
        }
    }



    public void setScan(javafx.event.ActionEvent actionEvent) throws NotFoundException, IOException {
        str = QRReader.readQR(image.getImage().getUrl());

        if (str!=null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Scan done");
            alert.setHeaderText("Look, this is your QR code");
            alert.setContentText(str);

            alert.showAndWait();
        }else{
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Error!");
            alert1.showAndWait();
        }

    }

    public void setBack(MouseEvent e) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(QRApplication.class.getResource("FirstPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
