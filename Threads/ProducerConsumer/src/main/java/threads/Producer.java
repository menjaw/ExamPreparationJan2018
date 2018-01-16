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
public class Producer extends Thread {

    //The ArrayBlockingQueue(Array-Blokerings-Kø) "bestiller" elementerne efter princippet FIFO (first-in-first-out) 
    //Køen 'head' er de ældste elementer og de de elementer som har ventet kortest tid er 'tail' (nye elementer sættes på tail
    //The queue retrieval operations (køhentningsoperatørene) får elementerne fra 'head'
    private static String producername;
    private static ArrayBlockingQueue<Long> startArray;
    private static ArrayBlockingQueue<Long> consumerArray;

    //Constructor (speciel metode til at initialisere og bestemme objektet)
    public Producer(String producername, ArrayBlockingQueue startArray, ArrayBlockingQueue consumerArray) {
        this.producername = producername;
        this.startArray = startArray;
        this.consumerArray = consumerArray;
    }

    //run-metoden kører tråde og nedarves fra Runnable interfacet der bruges til tråde
    @Override
    public void run() {
        System.out.println("StartArray indeholder følgende: " + startArray);
        while (!startArray.isEmpty()) {
            Long temp = startArray.poll();//tager første element ud af array og gemmer i midlertidig variabel (returnerer null if empty)

            //put værdien fra midlertidig variabel i consumerArray og lad fibonacci udregne det inden
            consumerArray.add(fib(temp));
            try {
                sleep(12000);//tråden sover
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            }
        }
        System.out.printf("%s : \n ", producername + "Consumer Array: " + consumerArray);
    }

    /*METHODS*/
    private long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

}
