package com.interware.selfiecam;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) 
            
            
    {
        Webcam webcam = Webcam.getDefault();
        String ruta;
        //ruta="/home/pbautista/foto.png";

        if (args.length > 1) { //si hay más de 1 parámetro
            System.out.println("Hay demasiados parámetros. Especificar ruta para guardar.");
        } else if (args.length == 0) { //si no hay parámetros      
            System.out.println("Especifique ruta para guardar");
        } else {
            ruta=args[0];
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
}
