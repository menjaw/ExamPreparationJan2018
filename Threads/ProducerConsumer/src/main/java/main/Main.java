/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.concurrent.ArrayBlockingQueue;
import threads.Consumer;
import threads.Producer;

/**
 *
 * @author Menja
 */
public class Main {

    //Variabler som sendes over til Producer-klassens constructor
    private static ArrayBlockingQueue<Long> startArray = new ArrayBlockingQueue(130);
    private static ArrayBlockingQueue<Long> slutArray = new ArrayBlockingQueue(130);

    public static void main(String[] args) {
        //Tilføj tal til startArray
        addNumbersToArray();
        
        //Opret producere
        Thread producer1 = new Producer("Producer 1:" , startArray, slutArray);
        Thread producer2 = new Producer("Producer 2:" , startArray, slutArray);
        Thread producer3 = new Producer("Producer 3:" , startArray, slutArray);
        Thread producer4 = new Producer("Producer 4:" , startArray, slutArray);
        Thread consumer = new Consumer(slutArray, startArray);
        
        
        //Start producere
        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();
        consumer.start();
    }

    /*Methods*/
    public static void addNumbersToArray() {
        for (long i = 0; i < 130L; i++) {
            startArray.add(i);
        }
    }
}
