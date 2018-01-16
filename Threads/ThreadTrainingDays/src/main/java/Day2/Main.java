/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Menja
 */
public class Main {
    public static void main(String[] args) {
        try {
            int MAX = 1000;
            Counter sharedCounter = new Counter();
            CountRunnable countRunnable = new CountRunnable(sharedCounter, MAX);
            
            Thread t1 = new Thread(countRunnable);
            Thread t2 = new Thread(countRunnable);
            Thread t3 = new Thread(countRunnable);
            
            t1.start();
            t2.start();
            t3.start();
            
            t1.join();
            t2.join();
            t3.join();
            
            System.out.println("Result: " + sharedCounter.getValue());
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
