module com.example.qrcode {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    requires com.google.zxing;
    requires com.google.zxing.javase;


    opens com.example.qrcode to javafx.fxml;
    exports com.example.qrcode;
}