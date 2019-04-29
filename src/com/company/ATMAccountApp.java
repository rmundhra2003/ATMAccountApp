package com.company;


import java.util.ArrayList;

public class ATMAccountApp {

    public static void main(String[] args) {
	// write your code here
        ArrayList <Account> accountList = new ArrayList<Account>();
        Account ac1 = new Account(12345, "Yasmin", "0526", 25000);
        accountList.add(ac1);
        Account ac2 = new Account(12346, "Zeru", "0527", 35000);
        accountList.add(ac2);
        Account ac3 = new Account(12347, "Rekha", "0528", 45000);
        accountList.add(ac3);
    }
}
