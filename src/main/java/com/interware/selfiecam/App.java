package com.interware.selfiecam;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import java.nio.file.Paths;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        String[] webcam_names;
        int count = 0;
        webcam_names = new String[10];
        String ruta;
        String ruta_default = Paths.get(System.getProperty("user.home")).toAbsolutePath().toString() + "/selfiewebcam.png";

        //Webcam webcam = Webcam.getDefault();
        ///String name_file = "/selfiewebcam.png";
        if (args.length > 0) { //si hay más de 1 parámetro
            // System.out.println("Hay demasiados parámetros. Especificar ruta para guardar.");
            ruta = args[0];

        } //else if (args.length == 0) { //si no hay parámetros      
        //System.out.println("Especifique ruta para guardar");
        //}
        else {

            ruta = ruta_default;
            //System.out.println("RUTA:"+ruta);
        }

        for (Webcam webcam : Webcam.getWebcams()) {
            System.out.println("Webcam detected: " + webcam.getName());
            webcam_names[count] = webcam.getName();
            count++;
        }

        Webcam webcam = Webcam.getWebcamByName(webcam_names[1]);
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
