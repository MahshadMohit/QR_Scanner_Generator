module com.example.qrcode {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires core;
    requires javase;


    opens com.example.qrcode to javafx.fxml;
    exports com.example.qrcode;
}