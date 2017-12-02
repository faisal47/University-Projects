/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package moneycutting;

import java.awt.Color;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author faisal47
 */
public class NoiseRemoval {
    
     public BufferedImage GoNoise(BufferedImage original) {
 
    int newPixel;
 
    BufferedImage avg_gray = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());
    int[] avgLUT = new int[766];
    int mini,maxi;
    int minip,maxip;
    mini=1000000000;
    maxi=0;
    minip=maxip=0;
    for(int i=0; i<avgLUT.length; i++) avgLUT[i] = (int) (i / 3);
 
    for(int i=0; i<original.getWidth(); i++) {
        for(int j=0; j<original.getHeight(); j++) {
            
            newPixel = new Color(original.getRGB(i, j)).getRGB();
            newPixel=(newPixel & 0x00ff0000)>>16;
            mini=Integer.min(mini,newPixel);
            maxi=Integer.max(maxi,newPixel);
            if(mini == newPixel)
                minip=new Color(original.getRGB(i, j)).getRGB();
            else if(maxi == newPixel)
                maxip = new Color(original.getRGB(i, j)).getRGB();
            // Write pixels into image
            
        }
    }
    int avg_value=(mini + maxi)/2,bitval;
    for(int i=0; i<original.getWidth(); i++) {
        for(int j=0; j<original.getHeight(); j++) {
            
            newPixel = new Color(original.getRGB(i, j)).getRGB();
            bitval=(newPixel & 0x00ff0000)>>16;
            if(bitval >= 100 && bitval <=150)
                newPixel=maxip;
            // Write pixels into image
            avg_gray.setRGB(i, j, newPixel);
            
        }
    }
    
    System.out.println(mini);
    
    System.out.println(maxi);
    
    return avg_gray;
    }
    
}
