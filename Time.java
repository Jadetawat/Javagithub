/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hfv2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * /**
 *
 * @author JADE
 */
public class Time implements ActionListener {

   Timer time;
    public static int count = 0;
    public static int countdown = 30;

    Time() {
        time = new javax.swing.Timer(1000, this);
        time.start();
    }

    public void actionPerformed(ActionEvent e) {
        count += 1;
        countdown -= 1;
       // System.out.println(count);
    }

}
