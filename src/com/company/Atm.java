package com.company;

import java.util.*;

/*
    @ATM class - contains methods to prompt user and receive input from the user. The only class in which the
    System.out.printtln statements are allowed in is the ATM class. The ATM class does not know any information about
    the user. It simply creates an Account class and prints information from the Account class.

    The ATM class allows the user to make a deposit, make a withdraw or check the balance.The ATM class also
    displays the results of any transaction or inquiry.

    The screen prints out just like the ATMs you've used in real life. It prompts to enter your account
     number (since we can't insert the card) and enter your PIN.

    The ATM class validates the PIN and the Account Number. If the user enters the incorrect PIN three times the
    ATM locks the user out so they can't log in with the correct PIN on the fourth try. Simply hardcoded three
    account numbers and their PINs and used if statements to ensure the user has entered the correct PIN.

 */

public class Atm extends Account{
    private ArrayList <String> operationAry;


    public Atm(int ac, String pin) {
         super.setAccountno(ac);
         super.setPin(pin);
         //Calls parent class Account to load information
         loadAccounts();
    }

    public Atm (){
        loadAccounts();
        System.out.println("Bank Account");

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
    //Workhorse which mimics ATM and creates an Account class and interacts with Account class
    public  void AtmOperation() {
        boolean input = true;
        Scanner keyboard = new Scanner(System.in);
        int counter = 1;
        int acNo = 0;
        String value = "";

        //Input the account# and pin
        while(counter <= 3) {
            HashMap<Integer, String> hashMap = this.promptUserInfo();
            Set set2 = hashMap.entrySet();
            Iterator iterator2 = set2.iterator();

            while (iterator2.hasNext()) {
                Map.Entry mentry2 = (Map.Entry) iterator2.next();
                acNo = (int) mentry2.getKey();
                value = (String) mentry2.getValue();
            }
            if (!super.findAccount(acNo, value)) {
                System.out.println("Invalid account no/pin");
                if(counter == 3 ) {
                    System.out.println("Maximum attempts reached");
                    return;
                }
            } else {
                //Found the account
                break;
            }
            counter++;
        }
        //Acccount found now process user input and interact with Account class
        while(input) {
            System.out.print("Enter the operation: deposit/withdraw/balance/display/exit: " );
            String s = keyboard.nextLine();
            if (s.equalsIgnoreCase("deposit")) {
                System.out.print("Enter the deposit amount in $ ");
                float depositAmount = keyboard.nextFloat();
                keyboard.nextLine();
                System.out.println("" + super.makeDeposit(acNo, value, depositAmount));
            } else if (s.equalsIgnoreCase("withdraw")) {
                System.out.print("Enter the withdrawal amount in $ ");
                float wAmount = keyboard.nextFloat();
                keyboard.nextLine();
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
        //Write the updated accounts to file
        writeAccountsToFile();
    }

}
