/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hfv2;

import java.awt.Graphics2D;
import java.util.LinkedList;

/**
 *
 * @author JADE
 */
public class ControlBullet {

    private static LinkedList<bullet> b = new LinkedList<>();
    private bullet temp;
    public ControlBullet() {
    
    }

    public void draw(Graphics2D g2d) {
        for (int i = 0; i < b.size(); i++) {
            temp = b.get(i);
            temp.draw(g2d);
        }
   
    }

    public void update() {
        for (int i = 0; i < b.size(); i++) {
            temp = b.get(i);
            temp.update();
        }

       
    }

    public static LinkedList<bullet> getBulletBound() {
        return b;
    }
 
}
