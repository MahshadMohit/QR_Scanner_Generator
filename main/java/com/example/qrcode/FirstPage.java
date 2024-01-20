package com.example.qrcode;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class FirstPage {

    @FXML
    private Text creat;

    @FXML
    private ImageView createPic;



    @FXML
    private Text proccess;

    @FXML
    private Text scan;

    @FXML
    private ImageView scanPic;

    public void setEffect(Node node){
        DropShadow ds = new DropShadow();
        ds.setWidth(32.68);
        ds.setHeight(21.0);
        ds.setRadius(10);
        ds.setOffsetX(0);
        ds.setOffsetY(0);
        ds.setSpread(0);
        ds.setColor(Color.color(217,171,0));
        node.setEffect(ds);
    }
    public void removeEffect(Node node){
        node.setEffect(null);
    }
    public void setScan(){
        setEffect(scan);
    }
    public void setScanNo(){
        removeEffect(scan);
    }
    public void setCreat(){
        setEffect(creat);
    }
    public void setCreatNo(){
        removeEffect(creat);
    }
    public void setProccess(){
        setEffect(proccess);
    }
    public void setProccessNo(){
        removeEffect(proccess);
    }
    public void setScanPic(MouseEvent e) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(QRApplication.class.getResource("reader.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void setCreatePic(MouseEvent e) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(QRApplication.class.getResource("create.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }




}
