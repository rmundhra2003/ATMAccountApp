package com.company;

public class Account {
    private int accountNo;
    private String username;
    private String pin;
    private float balance;

    public Account() {

    }
    //overloaded constructor
    public Account(int acNo, String uname, String pin, float balance) {
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
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public float getBalance() {
        return this.balance;
    }
    public void makeDeposit(int depositAmount) {
        this.balance += depositAmount;

    }
    public String makeWithdrawal(float amount) {
        String msg;
        if(amount <= this.balance) {
            this.balance -= amount;
            msg = ""+amount +"has been withdrawn and balance is "+this.balance;
        }
        else {
            msg = "Insufficient funds to process transaction";
        }
        return msg;
    }
    public String checkBalance() {
        return ("Account " +this.accountNo +" balance is " + this.balance);
    }
    public boolean validateAccount( int accountNo, String pin) {
        boolean result = false;
        if(this.accountNo == accountNo && this.pin == pin)
            result = true;
        return result;
    }
}
