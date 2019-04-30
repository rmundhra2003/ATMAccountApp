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
        this.balance = balance;
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
                a.balance += depositAmount;
                s = "The balance is " +a.balance;
                break;
            }
        }
        return s;
    }
    public String makeWithdrawal(int acNo, String value, float amount) {
        String s = "";
        for (Account a : accountList) {
            if (a.validateAccount(acNo, value)) {
                if(a.balance >= amount) {
                    a.balance -= amount;
                    s = "The balance is " + a.balance;
                    break;
                }else {
                    s = "Insufficient funds to  process transaction balance is $" +a.balance;
                    break;
                }
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
//        String filename = (System.getProperty("user.dir")+ File.separatorChar+"accounts.txt");
//        System.out.println(filename);
//
//        PrintWriter writer = null;
//        try {
//            writer = new PrintWriter(new File(filename));
//        }catch (FileNotFoundException e) {
//            System.out.println("File does not exist!");
//        }
//        accountList = new ArrayList<Account>();
//        Account ac1 = new Account(12345, "0526", "Yasmin", 25000);
//        accountList.add(ac1);
//        Account ac2 = new Account(12346, "0527", "Zeru", 35000);
//        accountList.add(ac2);
//        Account ac3 = new Account(12347, "0528", "Rekha", 45000);
//        accountList.add(ac3);
//
//        //Writing to file
//        for(Account acct:accountList) {
//            System.out.println("write this line: ");
//            writer.println(acct.getAccountNo() +" "+acct.getPin() +" " +acct.getUsername() +" " +acct.getBalance());
//        }
//        writer.close();
//
//        //Read the file
//        System.out.println("Read from the file");
//        BufferedReader reader = null;
//        try {
//            reader = new BufferedReader(new FileReader(filename));
//            String line = reader.readLine();
//            while(line != null) {
//                String[]acctStringAry = line.split(" ");
//                System.out.println(""+acctStringAry[0] +" " +acctStringAry[1] +" " +acctStringAry[2] +" "
//                        +acctStringAry[3]);
//                line = reader.readLine();
//            }
//            reader.close();
//        } catch (IOException e) {
//            System.out.println("File does not exist!");
//        }
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
    public void readAccountsFromFile() {
        String filename = (System.getProperty("user.dir")+ File.separatorChar+"accounts.txt");
        System.out.println(filename);

        //Read the file
        BufferedReader reader = null;
        accountList = new ArrayList<Account>();
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while(line != null) {
                String[]acctStringAry = line.split(" ");
                //Populate the accounts array list
                Account ac1 = new Account(Integer.valueOf(Integer.parseInt(acctStringAry[0])), acctStringAry[1], acctStringAry[2],
                        Float.valueOf(Float.parseFloat(acctStringAry[3])));
                accountList.add(ac1);
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

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new File(filename));
        }catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
        }
        //Writing to file
        for(Account acct:accountList) {
            writer.println(acct.getAccountNo() +" "+acct.getPin() +" " +acct.getUsername() +" " +acct.getBalance());
        }
        writer.close();
    }
}
