/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoStartingThreads;

/**
 *
 * @author Menja
 */
public class Threads_26 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new PersonRunningTime_26("Thread number 1"));
        Thread t2 = new Thread(new PersonRunningTime_26("Thread number 2"));
        Thread t3 = new Thread(new PersonRunningTime_26("Thread number 3"));
        Thread t4 = new Thread(new PersonRunningTime_26("Thread number 4"));
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
    
}
