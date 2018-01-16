package demoSynchronization;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Menja
 */
public class SyncrhonizedThreads {

    private int count;

    //Without the this method, the counter will not always return the correctly number
    public synchronized void increment() {
        count++;
    }

    public void ThreadsToRun() {
        try {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 5000; i++) {
                        try {
                            System.out.println("Hi! I am thread number 1");
                            Thread.sleep(0);
                            increment();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(SyncrhonizedThreads.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 5000; i++) {
                        try {
                            System.out.println("Hi! I am thread number TWO");
                            Thread.sleep(0);
                            increment();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(SyncrhonizedThreads.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            });

            t1.start();
            t2.start();

            //without the join the count-variable will be printet out before the for-loop is finish (counting not stopped at that time)
            t1.join();
            t2.join();

            //The join method will make sure that sout first will be printet af the threads is finish 
            System.out.println("Count is: " + count);
        } catch (InterruptedException ex) {
            Logger.getLogger(SyncrhonizedThreads.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
