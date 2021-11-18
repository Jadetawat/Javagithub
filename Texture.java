/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hfv2;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author JADE
 */
public class Texture {
    private BufferedImage img00;
    private BufferedImage img01;
    private BufferedImage img02;
 
    private static LinkedList<BufferedImage> img = new LinkedList<>();
    Texture() {
        try {
         
            this.img00 = ImageIO.read(getClass().getResourceAsStream("frog.png"));img.add(img00);
            this.img01 = ImageIO.read(getClass().getResourceAsStream("bee.png"));img.add(img01);
            this.img02 = ImageIO.read(getClass().getResourceAsStream("insect1.png"));img.add(img02);
          
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public BufferedImage getImage(int i){
        
        return img.get(i);
    }
}
