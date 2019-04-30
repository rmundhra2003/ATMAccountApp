package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Atm extends Account{
    private ArrayList <String> operationAry;


    public Atm(int ac, String pin) {

         super.setAccountno(ac);
         super.setPin(pin);
         loadAccounts();
    }

    public Atm (){
        loadAccounts();
        System.out.println("Bank Account");

    }

   // @Override
    public void makeDepositAtm(int acNo, String value) {
        System.out.print("In makeDeposit\n");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the deposit amount in $ ");
        float depositAmount = keyboard.nextFloat();
        System.out.println("" +super.makeDeposit(acNo, value, depositAmount));
    }

    @Override
    public void setUsername(String name) {
        System.out.println("Enter user name");
        super.setUsername(name);
    }

    @Override
    public void setPin(String pin) {
        System.out.println("Enter your account number");
        super.setPin(pin);
    }

    @Override
    public void setAccountno(int ac) {
        System.out.println("Enter your account number");
        super.setAccountno(ac);
    }

    //prompt username and password
    public static HashMap<Integer, String> promptUserInfo() {
        Scanner keyboard = new Scanner(System.in);
        HashMap<Integer, String>hashMap = new HashMap<Integer, String>();
        System.out.print("Enter account#: ");
        int acNo = keyboard.nextInt();
        keyboard.nextLine();
        System.out.print("Enter pin: ");
        String pin = keyboard.nextLine();
        hashMap.put((Integer)acNo, pin);
        return hashMap;
    }
    public  void AtmOperation(int acNo, String value) {
        boolean input = true;
        Scanner keyboard = new Scanner(System.in);

        if(!super.findAccount(acNo,value)) {
            System.out.println("Invalid account no/pin");
            return;
        }

        while(input) {
            System.out.print("Enter the operation: deposit/withdraw/balance/display/exit: " );
            String s = keyboard.nextLine();
            if (s.equalsIgnoreCase("deposit")) {
                System.out.print("Enter the deposit amount in $ ");
                float depositAmount = keyboard.nextFloat();
                System.out.println("" + super.makeDeposit(acNo, value, depositAmount));
            } else if (s.equalsIgnoreCase("withdraw")) {
                System.out.print("Enter the withdrawal amount in $ ");
                float wAmount = keyboard.nextFloat();
                System.out.println("" + super.makeWithdrawal(acNo, value, wAmount));
            } else if (s.equalsIgnoreCase("balance")) {
                System.out.println("" + super.checkBalance(acNo, value));
            } else if (s.equalsIgnoreCase("display")) {
                System.out.println("" + super.displayAcctInfo(acNo, value));
            }
            else if (s.equalsIgnoreCase("exit")) {
                input = false;
            }
            else {
                System.out.println("Invalid input\n");
            }
        }
    }

}
