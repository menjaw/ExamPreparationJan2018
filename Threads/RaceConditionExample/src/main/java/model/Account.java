/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Menja
 */
public class Account {
     private int amount;
  
  public Account( int amount ) {
    setSaldo( amount );
  }
  
  public void setSaldo( int amount ) {
    this.amount = amount;
    
    System.out.println( "New amount at the account: " + amount );
  }
  
  public int getSaldo() {
    return amount;}
  
}
