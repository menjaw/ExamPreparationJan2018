/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import model.Account;
import model.Customer;

/**
 *
 * @author Menja
 */
public class Main {
    public static void main(String[] args) {
        Account account = new Account(250);
        
        Customer customer1 = new Customer(account);
        Customer customer2 = new Customer(account);
        Customer customer3 = new Customer(account);
        Customer customer4 = new Customer(account);
        
        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();
        
    }
}
