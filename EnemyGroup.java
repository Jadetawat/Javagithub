/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hfv2;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author JADE
 */
public class EnemyGroup {

   private static LinkedList<dragonfly> e = new LinkedList<>();
    private static LinkedList<Bee> b = new LinkedList<>();

    private dragonfly temp1;
    private enemy insect;
    private Bee temp2;
    private Random random = new Random();
    private int r1;

    public EnemyGroup() {

    }

    public void draw(Graphics2D g2d) {

        for (int i = 0; i < e.size(); i++) {
            
            temp1 = e.get(i);
            temp1.draw(g2d);
        }
        for (int i = 0; i < b.size(); i++) {
            temp2 = b.get(i);
            temp2.draw(g2d);
        }
    }

    public void update() {

        for (int i = 0; i < e.size(); i++) {
            temp1 = e.get(i);
            temp1.update();
        }
        for (int i = 0; i < b.size(); i++) {
            temp2 = b.get(i);
            temp2.update();
        }

        if (e.size() < 4) {
            r1 = random.nextInt(250) + 70;
            insect = new dragonfly(0, r1);
            e.add((dragonfly) insect);
        }
        if (b.size() < 2) {
            r1 = random.nextInt(250) + 70;
            insect = new Bee(0, r1);
            b.add((Bee) insect);
        }
    }

    public static LinkedList<Bee> getBbound() {
        return b;
    }

    public static LinkedList<dragonfly> getDbound() {
        return e;
    }

}

abstract class enemy {

    public int x, y;
    public Random random = new Random();
    public int speedx;
 
    public enemy(int x, int y) {
        this.x = x;
        this.y = y;
        this.speedx = random.nextInt(6) + 1 + (30 + Time.count) / 30;
    }

    public abstract void update();
     public abstract Rectangle getBound();

}
