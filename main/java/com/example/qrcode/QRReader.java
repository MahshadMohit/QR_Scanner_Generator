package com.example.qrcode;

import java.io.*;
import javax.imageio.*;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class QRReader {

    public static String readQR(String path) throws FileNotFoundException, IOException,
            NotFoundException {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(path)))));

        Result result = new MultiFormatReader().decode(binaryBitmap);

        return result.getText();
    }


}
