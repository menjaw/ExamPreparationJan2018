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
public class ExtendThread extends Thread {

    //1: Start to extend the Thread-class
    //2: The Thread-class have a method that is called run
    //3: Make the run method and override it so it not use the one in the Superclass
    //4: The code in the run-method say what kind of things the Thread runs
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("I am an Extended Thread: " + i);

                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                Logger.getLogger(ExtendThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args) {
        
    }
}
