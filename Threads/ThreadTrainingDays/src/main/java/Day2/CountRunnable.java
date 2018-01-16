/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day2;

/**
 *
 * @author Menja
 */
public class CountRunnable implements Runnable {

    //In this class we will count a sharing object
    Counter counter;
    int numberOfCounts;

    //Constructors
    public CountRunnable() {
    }

    public CountRunnable(Counter counter, int numberOfCounts) {
        this.counter = counter;
        this.numberOfCounts = numberOfCounts;
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfCounts; i++) {
            counter.increment();
        }
    }

}
