/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hfv2;

/**
 *
 * @author JADE
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author JADE
 */
public class dragonfly extends enemy{


    private BufferedImage image;
   
     private Texture texture = new Texture();

    public dragonfly(int x, int y) {
        super(x,y);
        this.image = texture.getImage(2);
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.red);
       g2d.drawImage(image, x - 5, y - 25, 80, 80, null);
       //g2d.draw(getBound ());
    }

    @Override
    public void update() {
        x += speedx;
        if (x >= MainScreen.WIDTH - 48) {    
            x = 0;
        }
    }
    @Override
    public Rectangle getBound() {
        return new Rectangle(x, y, 52, 32);
    }


}
