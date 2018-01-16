/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoStartingThreads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Menja
 */
//Implement Runnable
public class PersonRunningTime_26 implements Runnable {

    //Make variables
    private String name;
    private int time;
    private int sum;
    private Random ran = new Random();
    private List<Integer> runningTimes = new ArrayList();

    //CMake a onstructor
    public PersonRunningTime_26(String name) {
        this.name = name;
        time = ran.nextInt();
    }

    Long start = System.currentTimeMillis();

    //Implement the run-method from the Runnable-class
    @Override
    public void run() {
        //Everytime a thread is startet the run()-method are being called and executed
        try {
            System.out.printf("%s hat a runningtime at %d\n", name, time);
            Thread.sleep(time);
            System.out.printf("%s is now done\n", name);
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }
    Long end = System.currentTimeMillis();

}
