/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hfv2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author JADE
 */
public class KeyInput extends KeyAdapter {

    Player p;

    public KeyInput(Player p) {
        this.p = p;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        p.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        p.keyReleased(e);
    }

}
