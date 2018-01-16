/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Menja
 */
public class Consumer extends Thread {
    //The ArrayBlockingQueue(Array-Blokerings-Kø) "bestiller" elementerne efter princippet FIFO (first-in-first-out) 
    //Køen 'head' er de ældste elementer og de de elementer som har ventet kortest tid er 'tail' (nye elementer sættes på tail
    //The queue retrieval operations (køhentningsoperatørene) får elementerne fra 'head'

    private static ArrayBlockingQueue<Long> producerArray;
    private static ArrayBlockingQueue<Long> consumerArray;

    //Constructor (speciel metode til at initialisere og bestemme objektet)
    public Consumer(ArrayBlockingQueue producerArray, ArrayBlockingQueue consumerArray) {
        this.producerArray = producerArray;
        this.consumerArray = consumerArray;
    }

    @Override
    public void run() {//metode som kører tråde og nedarves fra Runnable interfacet der bruges til tråde
        long sum = 0;
        while (!consumerArray.isEmpty()) {
            try {
                long temp = consumerArray.take();//tager første element ud af array og gemmer i midlertidig variabel (venter indtil element er tilgængeligt )               
                sum += temp;

                System.out.println("Slut Array: " + sum);
            } catch (InterruptedException ex) {
                Logger.getLogger(ex.getMessage());
            }
        }
    }

}
