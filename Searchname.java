package com.company.unipi.brinias.exercise;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Searchname extends Searchphone implements Serializable {
    static void searchnames(){
        List<String> contact = new ArrayList<>();
        contact = (List<String>) loadcontact();
        //
        //load the list and do it while repeating to check if the user wants to search for another name
        boolean flag = false;
        do {
            System.out.println("Give me a name to search\n");
            String name;
            Scanner myscanner=new Scanner(System.in);
            name = myscanner.nextLine();
            int n=contact.size();
            int x=0;
            for (int i=0; i<n;i=i+4){
                //When he gives the name he is searching every 4 positions (the name is i) and when he finds the name, it shows the next 3 positions
                if (name.equals(contact.get(i))) {
                    System.out.println("~> Name: " + contact.get(i) +
                            ", Phone: " + contact.get(i + 1) +
                            ", E-mail: " + contact.get(i + 2) +
                            ", Address " + contact.get(i + 3));
                    x = 1;
                }
            }
            if (x==0){
                System.out.println("!!Contact with this name not found\n!!");
            }
            System.out.println("Do you want to search for another name (to stop: NO)\n");
            name = myscanner.nextLine();
            if (name.equals("NO")||(name.equals("no"))) flag = true;
        }while (! flag);

    }
}
