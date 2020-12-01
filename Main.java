package com.company.unipi.brinias.exercise;

import java.util.Scanner;

public class Main extends Availablecontacts {
    public static void main(String[] args) {
        boolean system = false;
        //The menu and Do while for user data check and repeat procedure
        do {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("<!!~Welcome to Address Book~!!>");
            System.out.println("1. View all available contacts");
            System.out.println("2. Add new contact");
            System.out.println("3. Search for a contact by name");
            System.out.println("4. Search for a contact by phone");
            System.out.println("5. Edit contact by name");
            System.out.println("6. Delete contact by name");
            System.out.println("7. Exit application");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            boolean flag = false;
            Scanner scan = new Scanner(System.in);
            int number = 0;
            int n = 0;
            System.out.print("Put an integer 1-7:");
            System.out.println(" ");
            do {
                if (n!=0){
                    scan.nextLine();
                    System.out.println("Put an integer 1-7:");
                }
                if (scan.hasNextInt()) {
                    number = scan.nextInt();
                    flag = true;
                }
                n++;
            } while ((!flag) || (number > 7));
         //After the user selects the function he calls the corresponding methods that open up to calls
            if (number == 1) {
                showcontacts();
            } else if (number == 2) {
                Newcontacts();
            } else if (number == 3) {
                searchnames();
            } else if (number == 4) {
                searchphones();
            } else if (number == 5) {
                Processingnames();
            } else if (number == 6) {
                Deletenames();
            } else if (number == 7) {
                System.out.println("Thanks for your choice, good luck!");
                system = true;
            }
         //Main is extending Availablecontacts and then Newcontact ... and in the end is Deletename
        } while (!system);
    }
}

