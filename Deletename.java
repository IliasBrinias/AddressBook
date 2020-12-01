package com.company.unipi.brinias.exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Deletename implements Serializable {
    static void Deletenames(){
        List<String> contact = new ArrayList<>();
        contact = (List<String>) loadcontact();
        boolean flag = false;
        //Look for the contact print it and then delete it
        do {
            System.out.println("Give me a name to delete\n");
            String name;
            Scanner myscanner=new Scanner(System.in);
            name = myscanner.nextLine();
            int n=contact.size();
            int x=0;
            for (int i=0; i<n;i=i+4){
                if (name.equals(contact.get(i))) {
                    System.out.println("~> Name: " + contact.get(i) +
                                        ", Phone: " + contact.get(i + 1) +
                                        ", E-mail: " + contact.get(i + 2) +
                                        ", Address " + contact.get(i + 3));
                    System.out.println("Are you sure? (YES / NO)");
                    name = myscanner.nextLine();
                    if (name.equals("YES")||(name.equals("yes"))){
                        for (int y = 0; y<4; y++){
                            contact.remove(i);
                            savecontact(contact, "contact_file.dat");
                            n--;
                        }
                        System.out.println("Contact deleted!!");
                    }
                    x = 1;
                }
            }
            if (x==0){
                System.out.println("!!Contact with this name not found\n!!");
            }
            System.out.println("Do you want to search for another name (to stop: NO)\n");
            name = myscanner.nextLine();
            if (name.equals("NO")||(name.equals("NO"))) flag = true;
        }while (! flag);


    }
    //load and save are in this file because one inherits the other
    //οι load,save ειναι ειναι σε αυτο το αρχειο γιατι η μια κληρονομει την αλλη
    static List loadcontact(){
        List st = null;
        try {
            FileInputStream fis = new FileInputStream("contact_file.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            st = (List) ois.readObject();
            ois.close();
            fis.close();
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (List) st;
    }
    static void savecontact(List contact, String contactfile){
        try {
            FileOutputStream fos = new FileOutputStream(contactfile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(contact);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
