/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day2;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Menja
 */
public class Counter {

    private int value;
    ReentrantLock lock = new ReentrantLock();
    AtomicInteger ai = new AtomicInteger();

    public void increment() {
        ai.getAndIncrement();
    }
    
    public int getValue(){
    return ai.get();
    }

//    public void increment() {
//        lock.lock();
//        try {
//            int temp = value;
//            temp++;
//            value = temp;
//            //       value++;
//        } finally {
//            lock.unlock();
//        }
//    }
//    public int getValue() {
//        return value;
//    }
}
