/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hfv2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

/**
 *
 * @author JADE
 */
public class Player {

    private int x;
    private int y;
    private int speedx = 0;
    private BufferedImage image;
   private LinkedList<bullet> cb = ControlBullet.getBulletBound();
    private Texture texture= new Texture();

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.image = texture.getImage(0);
   
    }

    public void draw(Graphics2D g2d) {

        g2d.setColor(Color.red);
        g2d.drawImage(image, x - 60, y - 56, 150, 150, null);
        //g2d.draw(getBound ());
  
    }

    public void update() {

        x += speedx;
        if (x <= 80) {
            x = MainScreen.WIDTH - 158;
        }
        if (x >= MainScreen.WIDTH - 108) {
            x = 120;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_D) {
            speedx = 5;
        }
        if (key == KeyEvent.VK_A) {
            speedx = -5;
        }
        if (speedx != 0 && cb.size() >= 1) {
            cb.remove();
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_D) {
            speedx = 0;
        }
        if (key == KeyEvent.VK_A) {
            speedx = 0;
        }
    }

    public void mousePressed(MouseEvent e) {
        if (cb.size() < 1 && speedx == 0 && MouseInput.y < y) {
            cb.add(new bullet(x, y, 15));
        }

    }
    public Rectangle getBound() {
        return new Rectangle(x, y, 32, 32);
    }


}
