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
        
        
        //System.out.println( "Hello World!" );
         // get default webcam and open it
        Webcam webcam = Webcam.getDefault();
       // webcam.setViewSize(new Dimension(1920, 1080)); //FHD resolution
        
       try {
       webcam.setCustomViewSizes(new Dimension[]{WebcamResolution.FHD.getSize()});
       webcam.setViewSize(WebcamResolution.FHD.getSize());
      
        
        

        // System.out.println("--------------------------");
        if (webcam != null) {
            System.out.println("Webcam name: " + webcam.getName());
        } else {
            System.out.println("No webcam detected");
        }

        webcam.open(false);

        // get image
        BufferedImage image = webcam.getImage();
        File file = new File("test.png");

        // save image to PNG file
        ImageIO.write(image, "PNG", file);
        image.flush();
        image=null;
        
       } catch (Exception e){
           e.printStackTrace();
       } finally {
          
      webcam.close();
      //  System.exit(0);
       }
    }
}
