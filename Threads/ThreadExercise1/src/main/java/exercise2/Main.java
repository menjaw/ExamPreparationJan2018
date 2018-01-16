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
public class Main {

    public static void main(String[] args) {
        Even even = new Even();
        ThreadClass t1 = new ThreadClass(even);
        ThreadClass t2 = new ThreadClass(even);
        ThreadClass t3 = new ThreadClass(even);
        ThreadClass t4 = new ThreadClass(even);

    
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
