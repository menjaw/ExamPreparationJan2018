/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

/**
 *
 * @author Menja
 */
public class Thread1 extends Thread {

    @Override
    public void run() {
        Long sum = 0L;
        for (int i = 0; i < 1e6; i++) {
            sum += i;
        }
        System.out.println("T1: " + sum);

    }
}
