package com.company;

import java.util.ArrayList;

public class Account {
    private int accountNo;
    private String username;
    private String pin;
    private float balance;
    private ArrayList<Account> accountList;

    public Account() {

    }
    //overloaded constructor
    public Account (int acNo, String pin, String uname, float balance) {
        this.accountNo = acNo;
        this.username = uname;
        this.pin = pin;
        this.balance = balance;
    }

    //Define getters and setters for class members
    public void setAccountno(int ac) {
        this.accountNo = ac;
    }
    public int getAccountNo() {
        return this.accountNo;
    }
    public void setUsername(String name) {
        this.username = name;
    }
    public String getUsername() {
        return this.username;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }
    public String getPin() {
        return this.pin;
    }
    public void setBalance(float balance) {
        System.out.println("Setting balnace "+balance);
        this.balance = balance;
        System.out.println("Setting balnace "+this.balance);
    }
    public float getBalance() {
        return this.balance;
    }
    public String checkBalance(int acNo, String value) {
        String s = "";
        for (Account a : accountList) {
            if (a.validateAccount(acNo, value)) {
                s = "Current balance for account# "+ a.accountNo +" is " +a.balance;
                break;
            }
        }
        return s;
    }
    public String displayAcctInfo(int acNo, String value) {
        String s = "";
        for (Account a : accountList) {
            if (a.validateAccount(acNo, value)) {
                s = "Current balance for account# "+ a.accountNo +" for  "+a.username +" is: $"  +a.balance;
                break;
            }
        }
        return s;
    }
    public String makeDeposit(int acNo, String value, float depositAmount) {
        String s = "";
        for (Account a : accountList) {
            if (a.validateAccount(acNo, value)) {
                System.out.println("current depost " +a.balance);
                a.balance += depositAmount;
                s = "The balance is " +a.balance;
                //found = true;
                break;
            }
        }

        return s;


    }
    public String makeWithdrawal(int acNo, String value, float amount) {
        String s = "";
        for (Account a : accountList) {
            if (a.validateAccount(acNo, value)) {
                System.out.println("current depost " +a.balance);
                if(a.balance >= amount)
                a.balance -= amount;
                s = "The balance is " +a.balance;
                break;
            }
            else {
                s = "Insufficient funds to  process transaction\n";
                break;
            }
        }
        return s;
    }

    public boolean validateAccount( int accountNo, String pin) {
        boolean result = false;
        if(this.accountNo == accountNo && this.pin.equalsIgnoreCase(pin))
            result = true;
        return result;
    }
    public void loadAccounts() {
        // write your code here
        accountList = new ArrayList<Account>();
        Account ac1 = new Account(12345, "0526", "Yasmin", 25000);
        accountList.add(ac1);
        Account ac2 = new Account(12346, "0527", "Zeru", 35000);
        accountList.add(ac2);
        Account ac3 = new Account(12347, "0528", "Rekha", 45000);
        accountList.add(ac3);
    }
    public boolean findAccount(int acNo, String value) {
        boolean found = false;
        for (Account a : accountList) {
            if (a.validateAccount(acNo, value)) {
                found = true;
                break;
            }
        }
        return found;
    }
}
