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
public class Cutting {
    
    public BufferedImage upper_left(BufferedImage original) {
 
        int alpha, red, green, blue;
        int newPixel;
        BufferedImage avg_gray = new BufferedImage(original.getWidth()/4, original.getHeight()/4, original.getType());
        int[] avgLUT = new int[766];
        for(int i=0; i<avgLUT.length; i++) avgLUT[i] = (int) (i / 3);
 
        for(int i=0; i<original.getWidth(); i++) {
            for(int j=0; j<original.getHeight(); j++) {
 
               alpha = new Color(original.getRGB(i, j)).getRGB();
                newPixel = alpha;
 
                // Write pixels into image
                if(i>=original.getWidth()/4 || j>=original.getHeight()/4)
                    continue;
                avg_gray.setRGB(i, j, newPixel);
 
            }
        }
 
        return avg_gray;
 
    }
    
   public BufferedImage upper_right(BufferedImage original) {
 
   int alpha, red, green, blue;
        int newPixel;
        BufferedImage avg_gray = new BufferedImage(original.getWidth()/4, original.getHeight()/4, original.getType());
        int[] avgLUT = new int[766];
        int wm=original.getWidth()/4;
        int hm=original.getHeight()/4;
        for(int i=0; i<avgLUT.length; i++) avgLUT[i] = (int) (i / 3);
        int c1=0;
        for(int i=0; i<original.getWidth(); i++) {
            int c2=0;
            for(int j=0; j<original.getHeight(); j++) {
                // Get pixels by R, G, B
                alpha = new Color(original.getRGB(i, j)).getRGB();
                newPixel = alpha;
 
                // Write pixels into image
                if(j >= hm)
                    continue;
                if(original.getWidth()-i >= wm)
                    continue;
                avg_gray.setRGB(c1, j, newPixel);
 
            }
            if(original.getWidth()-i < wm)
                c1++;
        }
        return avg_gray;
 
    }
    
   
   public BufferedImage lower_left(BufferedImage original) {
 
   int alpha, red, green, blue;
        int newPixel;
        
        BufferedImage avg_gray = new BufferedImage(original.getWidth()/4, original.getHeight()/4, original.getType());
        int[] avgLUT = new int[766];
        int wm=original.getWidth()/4;
        int hm=original.getHeight()/4;
        for(int i=0; i<avgLUT.length; i++) avgLUT[i] = (int) (i / 3);
        int c1=0;
        for(int i=0; i<original.getWidth(); i++) {
            int c2=0;
            for(int j=0; j<original.getHeight(); j++) {
                // Get pixels by R, G, B
                alpha = new Color(original.getRGB(i, j)).getRGB();
                newPixel = alpha;
 
                // Write pixels into image
                if(i >= wm)
                    continue;
                if(original.getHeight()-j>=hm)
                    continue;
                avg_gray.setRGB(i, c2++, newPixel);
            }
            if(original.getWidth()-i < wm)
                c1++;
        }
        return avg_gray;
 
    }
   
   public BufferedImage lower_right(BufferedImage original) {
 
   int alpha, red, green, blue;
        int newPixel;
        BufferedImage avg_gray = new BufferedImage(original.getWidth()/4, original.getHeight()/4, original.getType());
        int[] avgLUT = new int[766];
        int wm=original.getWidth()/4;
        int hm=original.getHeight()/4;
        for(int i=0; i<avgLUT.length; i++) avgLUT[i] = (int) (i / 3);
        int c1=0;
        for(int i=0; i<original.getWidth(); i++) {
            int c2=0;
            for(int j=0; j<original.getHeight(); j++) {
                // Get pixels by R, G, B
                alpha = new Color(original.getRGB(i, j)).getRGB();
                newPixel = alpha;
 
                // Write pixels into image
                if(original.getWidth()-i >= wm || original.getHeight()-j>=hm)
                    continue;
                avg_gray.setRGB(c1, c2++, newPixel);
 
            }
            if(original.getWidth()-i < wm)
                c1++;
        }
        return avg_gray;
 
    }
    
    
}
