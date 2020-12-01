package com.company.unipi.brinias.exercise;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Availablecontacts extends Newcontact implements Serializable {
    static void showcontacts(){

        //After loading the list with for, display the list elements by 4: 1.Name 2. Phone 3.E-mail 4.Address

        List<String> contact = new ArrayList<>();
        contact = (List<String>) loadcontact();
        int n=contact.size();
        for (int i=0; i<n;i=i+4){
            System.out.println( i/4+"~> Name: "+contact.get(i)+
                                ", Phone: "+contact.get(i+1)+
                                ", E-mail: "+contact.get(i+2)+
                                ", Address: "+contact.get(i+3));
        }

    }


}
