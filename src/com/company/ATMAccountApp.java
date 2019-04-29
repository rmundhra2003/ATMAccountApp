package com.company;


import java.util.*;

public class ATMAccountApp {

    public static void main(String[] args) {

        boolean found = false;
        Scanner keyboard = new Scanner(System.in);
        //Account a;

	// write your code here
        ArrayList <Account> accountList = new ArrayList<Account>();
        Account ac1 = new Account(12345, "0526");
        ac1.setUsername("Yasmin");
        ac1.setBalance(25000);
        accountList.add(ac1);
        Account ac2 = new Account(12346, "0527");
        ac2.setUsername("Zeru");
        ac2.setBalance(35000);
        accountList.add(ac2);
        Account ac3 = new Account(12347, "0528");
        ac3.setUsername("Rekha");
        ac3.setBalance(45000);
        accountList.add(ac3);

        //Input the account# and pin
        Atm temp = new Atm();
        HashMap<Integer, String> hashMap = temp.promptUserInfo();
        Set set2 = hashMap.entrySet();
        Iterator iterator2 = set2.iterator();
        int acNo = 0;
        String value = "";
        while(iterator2.hasNext()) {
            Map.Entry mentry2 = (Map.Entry)iterator2.next();
            acNo = (int)mentry2.getKey();
            value = (String)mentry2.getValue();
            System.out.print("Key is: "+mentry2.getKey() + " & Value is: ");
            System.out.println(mentry2.getValue());
        }

        for(Account a :accountList) {
            if(a.validateAccount(acNo, value)) {
                found = true;
                break;
            }
        }
        //If account found
        if(true) {
            System.out.println("Account# " +acNo +" " +value);

            Atm atm= new Atm(acNo, value);
            System.out.println("Balance " +atm.getBalance());
            atm.AtmOperation();

        }




        //set account
        //Create an ATM object
        //Atm atm = new Atm(ac1.getUsername(), ac1.getPin());



        //System.out.
    }
}
