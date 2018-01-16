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
//Extend Thread(the class become a thread and implements the Runnable class)
public class Thread3 extends Thread {

    //Makes sure this methods is overriding the same method in the superclass
    @Override
    public void run() {
        Long count = 10L;
        while (true) {
            count++;
            System.out.println("T3: " + count);
            if (count == 13) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Thread3.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Thread3.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}
