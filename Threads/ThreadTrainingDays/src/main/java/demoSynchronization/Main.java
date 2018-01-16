/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoSynchronization;

import static java.time.Clock.system;
import java.util.Scanner;

/**
 *
 * @author Menja
 */
public class Main {

    public static void main(String[] args) {
        //VOLATILE
        VolatileThreads volThread = new VolatileThreads();
        Scanner scanner = new Scanner(System.in);

        //runnings
        volThread.start();
        System.out.println("Press any key to stop the Thread");
        scanner.nextLine();
        volThread.shutDown();


        //SYNCRONIZATION
        SyncrhonizedThreads syncThread = new SyncrhonizedThreads();
        syncThread.ThreadsToRun();

    }
}
