package com.company;

public class Account {
    private int accountNo;
    private String username;
    private String pin;
    private int balance;

    public Account() {

    }
    //overloaded constructor
    public Account(int acNo, String uname, String pin, int balance) {
        this.accountNo = acNo;
        this.username = uname;
        this.pin = pin;
        this.balance = balance;
    }

    public void makeDeposit(int depositAmount) {
        this.balance += depositAmount;

    }
    public String makeWithdrawal(int amount) {
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
