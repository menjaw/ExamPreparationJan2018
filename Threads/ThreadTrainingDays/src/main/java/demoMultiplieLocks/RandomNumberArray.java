/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoMultiplieLocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Menja
 */
public class RandomNumberArray {

    private Random random = new Random();
    private Object lock1 = new Object();
    private Object lock2 = new Object();
    private List<Integer> randomNumberList1 = new ArrayList();
    private List<Integer> randomNumberList2 = new ArrayList();

    public void process() {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    /**
     * Two threads can run this method at the same time, but if one thread
     * already has entered the synchronized block the second thread has to wait
     * until the first one leave the block.
     */
    public void stageOne() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(RandomNumberArray.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        randomNumberList1.add(random.nextInt(200));
    }

    /**
     * Two threads can run this method at the same time, but if one thread
     * already has entered the synchronized block the second thread has to wait
     * until the first one leave the block.
     */
    public void stageTwo() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(RandomNumberArray.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        randomNumberList2.add(random.nextInt(2000));
    }

    public void main() {

        try {
            System.out.println("Starting the process.....");
            long start = System.currentTimeMillis();

            //ONE WAY
            //process();
            /*ANOTHER WAY*/
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    process();
                }
            });
            t1.start();
            t1.join();

            long end = System.currentTimeMillis();

            //Prints the run-time out
            System.out.println("Time was: " + (end - start));
            //Prints the size of the array
            System.out.println("First list contains: " + randomNumberList1.size() + " items");
            System.out.println("Second list contains: " + randomNumberList2.size() + " items");
            //Prints all the numbers out
            System.out.println(randomNumberList1);
            System.out.println(randomNumberList2);

        } catch (InterruptedException ex) {
            Logger.getLogger(RandomNumberArray.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
