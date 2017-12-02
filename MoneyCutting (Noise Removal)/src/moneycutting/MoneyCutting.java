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
public class MoneyCutting {

    /**
     * @param args the command line arguments
     */
    private static BufferedImage original, grayscale,temp,tempnoise;
 
    public static void main(String[] args) throws IOException {
        
        String name="E:\\Google Drive\\phase-3\\Academics\\3-2\\Project-300\\MoneyCutting\\money samples\\3";
        String name2="E:\\Google Drive\\phase-3\\Academics\\3-2\\Project-300\\MoneyCutting\\Outputs\\1";
        
        File original_f = new File(name+".jpg");
        String output_f = name2+"_bw";
        original = ImageIO.read(original_f);
        ResizeClass getResize = new ResizeClass();
        grayscale = getResize.resize(original,500,300);
        writeImage(output_f+"to_resize");
        ConvertGray getGray = new ConvertGray();
        grayscale = getGray.GoGray(grayscale);
        writeImage(output_f+"to_gray");
        
        NoiseRemoval removeNoise = new NoiseRemoval();
        tempnoise = removeNoise.GoNoise(grayscale);
        writeImage3(output_f+"to_gray2");
        
        Cutting goCut = new Cutting();
        temp=goCut.upper_left(grayscale);
        writeImage2(output_f + "_upper_left");
  
        temp=goCut.lower_right(grayscale);
        writeImage2(output_f + "_lower_right");
        
        
        temp=goCut.lower_left(grayscale);
        writeImage2(output_f + "_lower_left");
        
        
        temp=goCut.upper_right(grayscale);
        writeImage2(output_f + "_upper_right");
        
        temp=goCut.upper_left(tempnoise);
        writeImage2(output_f + "_upper_left2");
  
        temp=goCut.lower_right(tempnoise);
        writeImage2(output_f + "_lower_right2");
        
        
        temp=goCut.lower_left(tempnoise);
        writeImage2(output_f + "_lower_left2");
        
        
        temp=goCut.upper_right(tempnoise);
        writeImage2(output_f + "_upper_right2");
        
        
    }
    
    private static void writeImage(String output) throws IOException {
        File file = new File(output+".jpg");
        ImageIO.write(grayscale, "jpg", file);
    }
    private static void writeImage2(String output) throws IOException {
        File file = new File(output+".jpg");
        ImageIO.write(temp, "jpg", file);
    }
    
    
    private static void writeImage3(String output) throws IOException {
        File file = new File(output+".jpg");
        ImageIO.write(tempnoise, "jpg", file);
    }
}
