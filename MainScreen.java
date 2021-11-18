/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hfv2;

import static hfv2.MainScreen.HEIGHT;
import static hfv2.MainScreen.WIDTH;
import javax.swing.*;

/**
 *
 * @author JADE
 */
public class MainScreen extends JFrame{

   public static final int WIDTH = 840;
    public static final int HEIGHT = 580;
    MainScreen(){
       
        this.add(new Game());
        this.setVisible(true);
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

    }
}
