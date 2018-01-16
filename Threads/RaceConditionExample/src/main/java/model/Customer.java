/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Menja
 */
public class Customer extends Thread {

    private Account account;


    private Random random;

    public Customer(Account account) {
        this.account = account;
        

        random = new Random((long) (Math.random() * 1000));
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                invest();
                sleep(100);
                
                cash();
                sleep(230);
            } catch (InterruptedException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void invest() throws InterruptedException {
        int investment = random.nextInt(700);
        System.out.println("Investment is: " + investment + " dollars");

        int saldo = account.getSaldo();
        System.out.println("The account have: " + saldo + " dollars");

        sleep(2000);

        saldo += investment;
        System.out.println("The new amount at the account is: " + saldo + " dollars");
    }

    public void cash() throws InterruptedException {
        int cash = random.nextInt(700);
        System.out.println(this + " There will be cashed: " + cash + " dollars");

        int saldo = account.getSaldo();
        System.out.println(this + " læser " + saldo + " kr.");

        sleep(2000);

        if (saldo >= cash) {
            saldo -= cash;
            System.out.println(this + " The new amount at the account is: " + saldo + " dollars");
            account.setSaldo(saldo);
        } else {
            System.out.println(this + " There is not enough money");
        }
    }

    public String toString() {
        return "[Customer: " + account + "]";
    }
}
