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
public class AnonymousClass {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        System.out.println("I am an anonymous thread" + i);
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AnonymousClass.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        
            
        });
        t1.start();
    }
}
