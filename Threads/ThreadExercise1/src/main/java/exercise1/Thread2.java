/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Menja
 */
public class Thread2 extends Thread {

    @Override
    @SuppressWarnings("SleepWhileInLoop")
    public void run() {
        for (int i = 1; i < 6; i++) {
            try {
                sleep(2000);
                System.out.println("T2: " + i);
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
