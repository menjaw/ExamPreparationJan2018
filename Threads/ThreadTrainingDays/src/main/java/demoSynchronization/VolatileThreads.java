/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoSynchronization;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Menja
 */
public class VolatileThreads extends Thread {
    //This boolean can be cachet and the while-loop can stop checking the state of it and remains true all the time
    //To provent threads to cache, we add 'volatile' keyword to it
    //Now the code works with garanty
    private boolean running = true;

    @Override
    public void run() {
        while (running) {
            try {
                System.out.println("Hallo from the processor");
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(VolatileThreads.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void shutDown() {
        running = false;
        System.out.println("You have stopped the Thread");
    }
}
