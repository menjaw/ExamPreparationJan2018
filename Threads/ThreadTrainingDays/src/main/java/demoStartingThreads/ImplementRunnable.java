/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoStartingThreads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Menja
 */
public class ImplementRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 10; i < 100; i++) {
            try {
                System.out.println("I am an Implemented Thread: " + i);
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ImplementRunnable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //Implements Runnable: Runnable is an Interface 
    //By default this class is not abstract and does not override the run()-Method in the Runnable-class
    //Implement all the abstract methods from the interface

}
