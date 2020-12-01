package com.company.unipi.brinias.exercise;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Searchphone extends Processingname implements Serializable {
    static void searchphones(){
        List<String> contact = new ArrayList<>();
        contact = (List<String>) loadcontact();
        boolean flag = false;
        //load the list and with do while check if the user wants to search for another phone
        do {
            System.out.println("Give me a phone to search\n");
            String name;
            Scanner myscanner=new Scanner(System.in);
            name = myscanner.nextLine();
            int n=contact.size();
            int x=0;
            for (int i=0; i<n;i=i+4){
                //when he gives the name search by 4 starting from 1 and not from 0 because the number is there and when it finds it shows all 4 positions
                if (name.equals(contact.get(i+1))) {
                    System.out.println("~> Name: " + contact.get(i) +
                            ", Phone: " + contact.get(i + 1) +
                            ", E-mail: " + contact.get(i + 2) +
                            ", Address " + contact.get(i + 3));
                    x = 1;
                }
            }
            //if not found it(x==0), then prints the appropriate message
            if (x==0){
                System.out.println("!!Contact with this name not found!!");
            }
            System.out.println("Want to search for another phone? (To stop: NO)");
            name = myscanner.nextLine();
            if (name.equals("NO")||(name.equals("no"))) flag = true;
        }while (! flag);
    }

}
