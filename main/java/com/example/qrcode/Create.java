package com.example.qrcode;

import com.google.zxing.WriterException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Create {

    @FXML
    private ImageView back;

    @FXML
    private Button go;

    @FXML
    private TextField tf;


    protected Alert createAlert(){
        Alert alert = new Alert(Alert.AlertType.NONE);

        alert.initModality(Modality.APPLICATION_MODAL);
        alert.getDialogPane().setContentText("this is your QR code");

        DialogPane dialogPane = alert.getDialogPane();
        GridPane grid = new GridPane();
        ColumnConstraints graphicColumn = new ColumnConstraints();
        graphicColumn.setFillWidth(false);
        graphicColumn.setHgrow(Priority.NEVER);
        ColumnConstraints textColumn = new ColumnConstraints();
        textColumn.setFillWidth(true);
        textColumn.setHgrow(Priority.ALWAYS);
        grid.getColumnConstraints().setAll(graphicColumn, textColumn);
        grid.setPadding(new Insets(5));

        Image image1 = new Image("C:\\Users\\asus\\IdeaProjects\\QRCode\\src.demo.png");
        ImageView imageView = new ImageView(image1);
        imageView.setFitWidth(64);
        imageView.setFitHeight(64);
        StackPane stackPane = new StackPane(imageView);
        stackPane.setAlignment(Pos.CENTER);
        grid.add(stackPane, 0, 0);

        Label headerLabel = new Label("Warning");
        headerLabel.setWrapText(true);
        headerLabel.setAlignment(Pos.CENTER_RIGHT);
        headerLabel.setMaxWidth(Double.MAX_VALUE);
        headerLabel.setMaxHeight(Double.MAX_VALUE);
        grid.add(headerLabel, 1, 0);

        dialogPane.setHeader(grid);
        dialogPane.setGraphic(null);

        alert.showAndWait()
                .filter(response -> response == ButtonType.OK)
                .ifPresent(response -> System.out.println("The alert was approved"));

        return alert;
    }

    @FXML
    void setBack(MouseEvent e) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(QRApplication.class.getResource("firstPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void setGo() throws IOException, WriterException {
        String path = "C:\\Users\\asus\\IdeaProjects\\QRCode\\src.demo.png";
        QrGenerator.createQR(tf.getText(),path);
        Alert alert = createAlert();
        alert.showAndWait();
    }

}
