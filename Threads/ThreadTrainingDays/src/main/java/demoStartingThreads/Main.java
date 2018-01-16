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
public class Main {

    public static void main(String[] args) {
        //Threads initilized from the ExtendedThread
        ExtendThread thread1 = new ExtendThread();
        ExtendThread thread2 = new ExtendThread();

        //Threads initilized from the ImplementRunnable
        Thread thread3 = new Thread(new ImplementRunnable());
        Thread thread4 = new Thread(new ImplementRunnable());

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
