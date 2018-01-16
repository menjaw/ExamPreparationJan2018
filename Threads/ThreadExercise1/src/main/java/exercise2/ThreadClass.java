/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

/**
 *
 * @author Menja
 */
public class ThreadClass extends Thread {

    Even even;

    public ThreadClass(Even even) {
        this.even = even;
    }

    @Override
    public void run() {
        printEvenNumbers();
    }

    public void printEvenNumbers() {
        for (int i = 0; i < 1e9; i++) {
            int result = even.next();
            if (result % 2 != 0) {
                System.out.println("This is not an even number: " + result);
            } else {
                System.out.println("Even: " + even.getN());
            }
        }
    }
}
