package com.interware;

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
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
         // get default webcam and open it
        Webcam webcam = Webcam.getDefault();
       // webcam.setViewSize(new Dimension(1920, 1080)); //FHD resolution
        
        webcam.setCustomViewSizes(new Dimension[]{WebcamResolution.FHD.getSize()});
        webcam.setViewSize(WebcamResolution.FHD.getSize());
        
        
        

        // System.out.println("--------------------------");
        if (webcam != null) {
            System.out.println("Webcam: " + webcam.getName());
        } else {
            System.out.println("No webcam detected");
        }

        webcam.open(true);

        // get image
        BufferedImage image = webcam.getImage();

        // save image to PNG file
        ImageIO.write(image, "PNG", new File("test.png"));
        webcam.close();
    }
}
