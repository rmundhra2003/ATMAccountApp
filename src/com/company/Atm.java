package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Atm extends Account{
    private ArrayList <String> operationAry;


    public Atm(int ac, String pin) {
         super(ac, pin);
    }

    public Atm (){
        System.out.println("Bank Account");

    }

   // @Override
    public void makeDepositAtm() {
        System.out.print("In makeDeposit\n");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the deposit amount in $ ");
        float depositAmount = keyboard.nextFloat();
        System.out.println("" +super.makeDeposit(depositAmount));
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
    public  void AtmOperation() {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<String> operationAry = new ArrayList<String>();
        //String s = new String("deposit");
        operationAry.add("deposit");
        operationAry.add("withdraw");
        operationAry.add("balance");
        operationAry.add("display");

        System.out.print("Enter the operation: deposit/withdrawal/balance/display account info" );
        String s = keyboard.nextLine();

        if(s.equalsIgnoreCase("deposit")) {
            makeDepositAtm();
        }


        //System.out.print("What is t")

    }

}
