package com.interware.selfiecam;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import java.nio.file.Paths;


public class App {

    String ruta_recibida;

    public void takePhoto(String ruta_recibida, String webcam_name) {

        String ruta;
        
        ruta = ruta_recibida;
        //Webcam webcam =   Webcam.getDefault();
        ///String name_file = "/selfiewebcam.png";

        Webcam webcam = Webcam.getWebcamByName(webcam_name);

        //Webcam webcam = Webcam.getDefault();
        try {
            webcam.setCustomViewSizes(new Dimension[]{WebcamResolution.FHD.getSize()});
            webcam.setViewSize(WebcamResolution.FHD.getSize());

            // System.out.println("--------------------------");
            if (webcam != null) {
                System.out.println("Webcam name: " + webcam.getName());
            } else {
                System.out.println("No webcam detected");
                return;

            }

            webcam.open(false);

            // get image
            BufferedImage image = webcam.getImage();
            File file = new File(ruta);

            // save image to PNG file
            ImageIO.write(image, "PNG", file);
            image.flush();
            image = null;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            webcam.close();
            //  System.exit(0);
        }
    }

}

/* public static String getUserHomeDir() {
        return Paths.get(System.getProperty("user.home")).toAbsolutePath()
                .toString();
    }*/
