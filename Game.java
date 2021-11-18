/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hfv2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author JADE
 */
public class Game extends JPanel implements ActionListener {

    private Timer loop;
    private Player player;
    private EnemyGroup ce;
    private ControlBullet cb;
    private BufferedImage bg1;
    private BufferedImage bg2;
    private BufferedImage over;
    public static int score = 0;
  

    public Game() {
        Time t = new Time();
        try {
            System.out.println("bg loaded");
            this.bg1 = ImageIO.read(getClass().getResourceAsStream("bg1.png"));
            this.bg2 = ImageIO.read(getClass().getResourceAsStream("bg2.png"));
            this.over = ImageIO.read(getClass().getResourceAsStream("OVER.png"));
        
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        loop = new Timer(10, this);
        loop.start();

        ce = new EnemyGroup();
        cb = new ControlBullet();
        player = new Player(400, 450);
        addKeyListener(new KeyInput(player));
        addMouseListener(new MouseInput(player));
        setFocusable(true); 
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, MainScreen.WIDTH, MainScreen.HEIGHT);
        if (Time.count <= 60) {
            g2d.drawImage(bg1, 0, 0, MainScreen.WIDTH, MainScreen.HEIGHT, null);
        } else {
            g2d.drawImage(bg2, 0, 0, MainScreen.WIDTH, MainScreen.HEIGHT, null);
        }
        if (Time.countdown <= 0) {
            g2d.drawImage(over, 220, 70, 400, 400, null);;
        }
        ce.draw(g2d);
        player.draw(g2d);
        cb.draw(g2d);
        g2d.setColor(Color.black);
        g2d.drawString("SCORE: " + score, 10, 20);
        g2d.drawString("" + Time.countdown, 790, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ce.update();
        cb.update();
        player.update();
        if (Time.countdown <= 0) {
            loop.stop();
        }
        repaint();
    }
}
