/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Menja
 */
public class Even {

    private int n = 0;

    public synchronized int next() {
        try {
            n++;
            Thread.sleep(2000);
            n++;
        } catch (InterruptedException ex) {
            Logger.getLogger(Even.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int getN() {
        return n;
    }

}
