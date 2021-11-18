/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hfv2;

import static hfv2.Game.score;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.util.LinkedList;

/**
 *
 * @author JADE
 */
public class bullet {

    private int x, y, X1, Y1, X0, Y0;
    private int speed = 0;
    private int speedx, speedy;

    private LinkedList<dragonfly> e = EnemyGroup.getDbound();
    private LinkedList<bullet> cb = ControlBullet.getBulletBound();
   
    private LinkedList<Bee> b = EnemyGroup.getBbound();

    public bullet(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.X0 = x;
        this.Y0 = y;
        this.X1 = MouseInput.x;
        this.Y1 = MouseInput.y;
        this.speed = speed;
    
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.pink);
        Stroke stk = new BasicStroke(10f);
        g2d.setStroke(stk);
        g2d.drawLine(X0 + 16, Y0 + 16, x + 16, y + 16);
        //g2d.draw(getBound ());
    }

    public void update() {
    
        if (Math.sqrt(Math.pow((double) (X1 - X0), 2) + Math.pow((double) (Y0 - Y1), 2)) != 0) {
            speedx = (int) (speed * (X1 - X0) / (Math.sqrt(Math.pow((double) (X1 - X0), 2) + Math.pow((double) (Y0 - Y1), 2))));
            speedy = (int) (speed * (Y0 - Y1) / (Math.sqrt(Math.pow((double) (X1 - X0), 2) + Math.pow((double) (Y0 - Y1), 2))));
        }
        y -= speedy;
        x += speedx;
        if (y <= Y1 - 20 || x <= 30 || x >= MainScreen.WIDTH - 58) {
            cb.remove(this);
         
        }
        colision();
    }

    public Rectangle getBound() {
        return new Rectangle(x, y, 32, 32);
    }
   
    public void colision() {
        
        for (int i = 0; i < e.size(); i++) {
            if (getBound().intersects(e.get(i).getBound())) {

                e.remove(i);
                Time.countdown += 1;

                score++;
            }
        }
        for (int i = 0; i < b.size(); i++) {
            if (getBound().intersects(b.get(i).getBound())) {

                b.remove(i);
                Time.countdown -= 3;

            }
        }
    }

}
