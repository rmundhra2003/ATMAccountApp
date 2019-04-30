package com.company;


import java.util.*;

/*
    @ATMAccountApp: An application that will simulate an ATM's operations.

    There must be at least the following classes:

    ATM - contains methods to prompt user and receive input from the user. The only class in which the
    System.out.printtln statements are allowed in is the ATM class. The ATM class does not know any information about
    the user. It simply creates an Account class and prints information from the Account class.

    The ATM class allows the user to make a deposit, make a withdraw or check the balance.The ATM class also
    displays the results of any transaction or inquiry.

    Account class - contains the account number, user name, balance,PIN. Deposits and withdraws updates the balance.

    The main method simply calls the ATM class and the  ATM class interacts with user and with the Account
    class. There is MINIMAL logic in the main method.

    The screen prints out just like the ATMs you've used in real life. It prompts to enter your account
     number (since we can't insert the card) and enter your PIN.

    The ATM class validates the PIN and the Account Number. If the user enters the incorrect PIN three times the
    ATM locks the user out so they can't log in with the correct PIN on the fourth try. Simply hardcoded three
    account numbers and their PINs and used if statements to ensure the user has entered the correct PIN.
 */

public class ATMAccountApp {

    public static void main(String[] args) {
        Atm atm = new Atm();
        atm.AtmOperation();
    }
}
