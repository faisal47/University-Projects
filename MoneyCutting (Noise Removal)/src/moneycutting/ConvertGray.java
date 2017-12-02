package moneycutting;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class ConvertGray {
    
    public BufferedImage GoGray(BufferedImage original) {
 
    int alpha, red, green, blue;
    int newPixel;
 
    BufferedImage avg_gray = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());
    int[] avgLUT = new int[766];
    for(int i=0; i<avgLUT.length; i++) avgLUT[i] = (int) (i / 3);
 
    for(int i=0; i<original.getWidth(); i++) {
        for(int j=0; j<original.getHeight(); j++) {
 
            // Get pixels by R, G, B
            alpha = new Color(original.getRGB(i, j)).getAlpha();
            red = new Color(original.getRGB(i, j)).getRed();
            green = new Color(original.getRGB(i, j)).getGreen();
            blue = new Color(original.getRGB(i, j)).getBlue();
 
            newPixel = red + green + blue;
            newPixel = avgLUT[newPixel];
            // Return back to original format
            newPixel = colorToRGB(alpha, newPixel, newPixel, newPixel);
 
            // Write pixels into image
            avg_gray.setRGB(i, j, newPixel);
 
        }
    }
 
    return avg_gray;
 
}
    
    public int colorToRGB(int alpha, int red, int green, int blue) {
 
        int newPixel = 0;
        newPixel += alpha;
        newPixel = newPixel << 8;
        newPixel += red; newPixel = newPixel << 8;
        newPixel += green; newPixel = newPixel << 8;
        newPixel += blue;
 
        return newPixel;
 
    }
    
    
    public BufferedImage luminosity(BufferedImage original) {
 
        int alpha, red, green, blue;
        int newPixel;
 
        BufferedImage lum = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());
 
        for(int i=0; i<original.getWidth(); i++) {
            for(int j=0; j<original.getHeight(); j++) {
 
                // Get pixels by R, G, B
                alpha = new Color(original.getRGB(i, j)).getAlpha();
                red = new Color(original.getRGB(i, j)).getRed();
                green = new Color(original.getRGB(i, j)).getGreen();
                blue = new Color(original.getRGB(i, j)).getBlue();
 
                red = (int) (0.21 * red + 0.71 * green + 0.07 * blue);
                // Return back to original format
                 newPixel = colorToRGB(alpha, red, red, red);
 
                // Write pixels into image
                lum.setRGB(i, j, newPixel);
 
            }
        }
 
        return lum;
 
    }    
 
    // The desaturation method
     public BufferedImage desaturation(BufferedImage original) {
 
        int alpha, red, green, blue;
        int newPixel;
 
        int[] pixel = new int[3];
 
        BufferedImage des = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());
        int[] desLUT = new int[511];
        for(int i=0; i<desLUT.length; i++) desLUT[i] = (int) (i / 2);
 
        for(int i=0; i<original.getWidth(); i++) {
            for(int j=0; j<original.getHeight(); j++) {
 
                // Get pixels by R, G, B
                alpha = new Color(original.getRGB(i, j)).getAlpha();
                red = new Color(original.getRGB(i, j)).getRed();
                green = new Color(original.getRGB(i, j)).getGreen();
                blue = new Color(original.getRGB(i, j)).getBlue();
 
                pixel[0] = red;
                pixel[1] = green;
                pixel[2] = blue;
 
                int newval = (int) (findMax(pixel) + findMin(pixel));
                newval = desLUT[newval];
 
                // Return back to original format
                newPixel = colorToRGB(alpha, newval, newval, newval);
 
                // Write pixels into image
                des.setRGB(i, j, newPixel);
 
            }
        }
 
        return des;
 
    }    
 
    // The minimal decomposition method
    public BufferedImage decompMin(BufferedImage original) {
 
        int alpha, red, green, blue;
        int newPixel;
 
        int[] pixel = new int[3];
 
        BufferedImage decomp = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());
 
        for(int i=0; i<original.getWidth(); i++) {
            for(int j=0; j<original.getHeight(); j++) {
 
                // Get pixels by R, G, B
                alpha = new Color(original.getRGB(i, j)).getAlpha();
                red = new Color(original.getRGB(i, j)).getRed();
                green = new Color(original.getRGB(i, j)).getGreen();
                blue = new Color(original.getRGB(i, j)).getBlue();
 
                pixel[0] = red;
                pixel[1] = green;
                pixel[2] = blue;
 
                int newval = findMin(pixel);
 
                // Return back to original format
                newPixel = colorToRGB(alpha, newval, newval, newval);
 
                // Write pixels into image
                decomp.setRGB(i, j, newPixel);
 
            }
        }
 
        return decomp;
 
    }    
 
    // The maximum decomposition method
    public BufferedImage decompMax(BufferedImage original) {
 
        int alpha, red, green, blue;
        int newPixel;
 
        int[] pixel = new int[3];
 
        BufferedImage decomp = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());
 
        for(int i=0; i<original.getWidth(); i++) {
            for(int j=0; j<original.getHeight(); j++) {
 
                // Get pixels by R, G, B
                alpha = new Color(original.getRGB(i, j)).getAlpha();
                red = new Color(original.getRGB(i, j)).getRed();
                green = new Color(original.getRGB(i, j)).getGreen();
                blue = new Color(original.getRGB(i, j)).getBlue();
 
                pixel[0] = red;
                pixel[1] = green;
                pixel[2] = blue;
 
                int newval = findMax(pixel);
 
                // Return back to original format
                newPixel = colorToRGB(alpha, newval, newval, newval);
 
                // Write pixels into image
                decomp.setRGB(i, j, newPixel);
 
            }
 
        }
 
        return decomp;
 
    }    
 
    // The "pick the color" method
    public BufferedImage rgb(BufferedImage original, int color) {
 
        int alpha, red, green, blue;
        int newPixel;
 
        int[] pixel = new int[3];
 
        BufferedImage rgb = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());
 
        for(int i=0; i<original.getWidth(); i++) {
            for(int j=0; j<original.getHeight(); j++) {
 
                // Get pixels by R, G, B
                alpha = new Color(original.getRGB(i, j)).getAlpha();
                red = new Color(original.getRGB(i, j)).getRed();
                green = new Color(original.getRGB(i, j)).getGreen();
                blue = new Color(original.getRGB(i, j)).getBlue();
 
                pixel[0] = red;
                pixel[1] = green;
                pixel[2] = blue;
 
                int newval = pixel[color];
 
                // Return back to original format
                newPixel = colorToRGB(alpha, newval, newval, newval);
 
                // Write pixels into image
                rgb.setRGB(i, j, newPixel);
 
            }
 
        }
 
        return rgb;        
 
    }
 
    // The simplest way to convert in Java
    public static BufferedImage javaWay(BufferedImage source) {
        BufferedImageOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
        return op.filter(source, null);
    }
    
    private static int findMin(int[] pixel) {
 
        int min = pixel[0];
 
        for(int i=0; i<pixel.length; i++) {
            if(pixel[i] < min)
                    min = pixel[i];
        }
 
        return min;
 
    }
 
    private static int findMax(int[] pixel) {
 
        int max = pixel[0];
 
        for(int i=0; i<pixel.length; i++) {
            if(pixel[i] > max)
                    max = pixel[i];
        }
 
        return max;
 
    }
 
    
    
 
}
