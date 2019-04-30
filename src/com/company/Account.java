package com.company;

/*
    Account class - contains the account number, user name, balance,PIN. Deposits and withdraws updates the balance
    This class hardcoded three account numbers with user name, balance and PIN information.
    The ATM class does not know any information about the Account class.

    Updated code to read account information from file "accounts.txt" and after all ATM operations are done write output
    to "accounts.txt'
 */
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.*;

public class Account {
    private int accountNo;
    private String username;
    private String pin;
    private float balance;
    private HashMap<Integer, Account> accountHashMap;

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
        this.balance = balance;
    }
    public float getBalance() {
        return this.balance;
    }
    public String checkBalance(int acNo, String value) {
        String s = "";
        Account a = findAccountAndReturn(acNo, value);
        if(a != null)
            s = "Current balance for account# "+ a.accountNo +" is " +a.balance;
        else
            s = "Account not found\n";

        return s;
    }
    public String displayAcctInfo(int acNo, String value) {
        String s = "";
        Account a = findAccountAndReturn(acNo, value);
        if(a != null) {
            s = "Current balance for account# "+ a.accountNo +" for  "+a.username +" is: $"  +a.balance;
        }
        return s;
    }
    public String makeDeposit(int acNo, String value, float depositAmount) {
        String s = "";
        Account a = findAccountAndReturn(acNo, value);
        if(a != null) {
            a.balance += depositAmount;
            s = "The balance is " +a.balance;
        }
        return s;
    }
    public String makeWithdrawal(int acNo, String value, float amount) {
        String s = "";
        Account a = findAccountAndReturn(acNo, value);
        if(a != null) {
            if (a.balance >= amount) {
                a.balance -= amount;
                s = "The balance is " + a.balance;
            } else {
                s = "Insufficient funds to  process transaction balance is $" + a.balance;
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
            readAccountsFromFile();

    }
    public boolean findAccount(int acNo, String value) {
        boolean found = false;
        Account ac1 = null;

        Set set2 = accountHashMap.entrySet();
        Iterator iterator2 = set2.iterator();

        while (iterator2.hasNext()) {
            Map.Entry mentry2 = (Map.Entry) iterator2.next();
            acNo = (int)mentry2.getKey();
            ac1 = (Account) mentry2.getValue();
            if(ac1.validateAccount(acNo,value )) {
                //Found account
                found = true;
                break;
            }
        }
        return found;
    }
    //@Overloaded method
    public Account findAccountAndReturn(int acNo, String value) {
        Account ac1 = null;

        Set set2 = accountHashMap.entrySet();
        Iterator iterator2 = set2.iterator();

        while (iterator2.hasNext()) {
            Map.Entry mentry2 = (Map.Entry) iterator2.next();
            acNo = (int)mentry2.getKey();
            ac1 = (Account) mentry2.getValue();
            if(ac1.validateAccount(acNo,value )) {
                //Found account
                break;
            }
        }
        return ac1;
    }

    public void readAccountsFromFile() {
        String filename = (System.getProperty("user.dir")+ File.separatorChar+"accounts.txt");
        System.out.println(filename);

        //Read the file
        BufferedReader reader = null;

        accountHashMap = new HashMap<Integer, Account>();
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while(line != null) {
                String[]acctStringAry = line.split(" ");
                //Populate the accounts array list
                Account ac1 = new Account(Integer.valueOf(Integer.parseInt(acctStringAry[0])), acctStringAry[1], acctStringAry[2],
                        Float.valueOf(Float.parseFloat(acctStringAry[3])));
                accountHashMap.put(Integer.parseInt(acctStringAry[0]), ac1);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File does not exist!");
        }
    }
    public void writeAccountsToFile() {
        String filename = (System.getProperty("user.dir")+ File.separatorChar+"accounts.txt");
        System.out.println(filename);
        Set set2 = accountHashMap.entrySet();
        Iterator iterator2 = set2.iterator();


        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new File(filename));
        }catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
        }
        //Writing to file
        while (iterator2.hasNext()) {
            Map.Entry mentry2 = (Map.Entry) iterator2.next();

            Account acct = (Account) mentry2.getValue();
            writer.println(acct.getAccountNo() +" "+acct.getPin() +" " +acct.getUsername() +" " +acct.getBalance());

        }
        writer.close();
    }
}
