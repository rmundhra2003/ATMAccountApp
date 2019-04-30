package com.company;


import java.util.*;

public class ATMAccountApp {

    public static void main(String[] args) {

       Scanner keyboard = new Scanner(System.in);
       Atm atm = new Atm();

       //Input the account# and pin
        HashMap<Integer, String> hashMap = atm.promptUserInfo();
        Set set2 = hashMap.entrySet();
        Iterator iterator2 = set2.iterator();
        int acNo = 0;
        String value = "";
        while(iterator2.hasNext()) {
            Map.Entry mentry2 = (Map.Entry)iterator2.next();
            acNo = (int)mentry2.getKey();
            value = (String)mentry2.getValue();
        }
        atm.AtmOperation(acNo, value);
    }
}
