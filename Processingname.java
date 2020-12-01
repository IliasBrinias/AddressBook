package com.company.unipi.brinias.exercise;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Processingname extends Deletename implements Serializable {
    static void Processingnames(){
        List<String> contact = new ArrayList<>();
        contact = (List<String>) loadcontact();
        //load the list and with do while check if the user wants to search for another name
        boolean flag = false;
        do {
            System.out.println("Give me a name to search");
            String name;
            Scanner myscanner=new Scanner(System.in);
            name = myscanner.nextLine();
            int n=contact.size();
            int x=0;
            for (int i=0; i<n;i=i+4){
                //Shows the contact and asks if he wants to edit it
                if (name.equals(contact.get(i))) {
                    System.out.println(" Όνομα: " + contact.get(i) +
                            ", Τηλέφωνο: " + contact.get(i + 1) +
                            ", E-mail: " + contact.get(i + 2) +
                            ", Διεύθυνση " + contact.get(i + 3));
                    x = 1;
                    //menu for editing the contact
                    System.out.println("Which field would you like to change\n?");
                    System.out.println("0.Name");
                    System.out.println("1.Phone");
                    System.out.println("2.E-mail");
                    System.out.println("3.Address");
                    boolean flag1 = false;
                    Scanner scan = new Scanner(System.in);
                    int number1 = 0;
                    int n1 = 0;
                    System.out.print("Put an integer 1-3:");
                    //depending on the choice edit the contact
                    do {
                        if (n1!=0){
                            scan.nextLine();
                            System.out.println("Βάλε εναν ακεραιο 1-3:");
                        }
                        if (scan.hasNextInt()) {
                            number1 = scan.nextInt();
                            flag1 = true;
                            if (number1==0){
                                System.out.println("Δώσε μου το όνομα:");
                                name = myscanner.nextLine();
                                contact.set(i+number1,name);
                            }else if (number1==1){
                                String phone = null;
                                BigInteger x1;
                                BigInteger min= new BigInteger("0000000000");
                                BigInteger max= new BigInteger("9999999999");
                                boolean flag0=false;
                                do {
                                    System.out.println("Give me the phone:");
                                    x1 = myscanner.nextBigInteger();
                                    int temp1=x1.compareTo(min);
                                    int temp2=x1.compareTo(max);
                                    if ((temp1==1) && (temp2==-1) ){
                                        flag0 = true;
                                        phone = String.valueOf(x1);
                                    } else {
                                        System.out.println("invalid number");
                                    }
                                }while (!flag0);
                                contact.set(i+number1,phone);

                                x=1;
                            }else if (number1==2){
                                System.out.println("Give me your email:");
                                name = myscanner.nextLine();
                                contact.set(i+number1,name);
                                x=1;
                            }else if (number1==3){
                                System.out.println("Give me the address:");
                                name = myscanner.nextLine();
                                contact.set(i+number1,name);
                                x=1;
                            }
                        }
                        n1++;
                    } while ((!flag1) || (number1 > 3));
                }
            }
            if (x==0){
                System.out.println("!!Give me the address!!");
            }
            System.out.println("Do you want to change another name? (To stop: NO)");
            name = myscanner.nextLine();
            if (name.equals("NO")||(name.equals("no"))) flag = true;
        }while (! flag);
        savecontact(contact, "contact_file.dat");
        System.out.println("Contact saved!");
    }
}
