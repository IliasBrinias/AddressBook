package com.company.unipi.brinias.exercise;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Newcontact extends  Searchname implements Serializable{
    static List<String> contact = new ArrayList<>();
    //load the list and through the scanner get data from the user and add it to the list
     static void Newcontacts(){
            contact = (List<String>) loadcontact();
            String mystring;
            Scanner myscanner=new Scanner(System.in);
            System.out.println("Give me the name\n:");
            mystring = myscanner.nextLine();
            contact.add(mystring);

            String phone = null;
            BigInteger x;
            BigInteger min= new BigInteger("0000000000");
            BigInteger max= new BigInteger("9999999999");
            boolean flag0=false;
            do {
                    System.out.println("Give me the phone:");
                    x = myscanner.nextBigInteger();
                    int temp1=x.compareTo(min);
                    int temp2=x.compareTo(max);
                    if ((temp1==1) && (temp2==-1) ){
                        flag0 = true;
                        phone = String.valueOf(x);
                    } else {
                        System.out.println("invalid number");
                    }
            }while (!flag0);
             contact.add(phone);

             mystring = myscanner.nextLine();
             System.out.println("Give me your email:");
             mystring = myscanner.nextLine();
             contact.add(mystring);

             System.out.println("Give me the address:");
             mystring = myscanner.nextLine();
             contact.add(mystring);
     //in the end I store the list in the archive
             savecontact(contact, "contact_file.dat");
             System.out.println("Contact saved!");
         }
}