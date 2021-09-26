package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    static int roomNum;    // declare variables for methods.
    static String roomName;

    public static void main(String[] args) {

            String[] hotel = new String[8];  // creating  arrays
            String[] firstName = new String[8];
            String[] surName = new String[8];
            int[]  creditNum = new int[8];
            int[] guestNum =new int[8];

            initialise(hotel,firstName,surName,creditNum,guestNum);  //initialise methods

            while (true) {
                System.out.println("----------Menu----------");
                System.out.println("A: Add customer rooms.");
                System.out.println("V: View all Rooms.");
                System.out.println("E: Display Empty Rooms.");
                System.out.println("D: Delete customer from room.");
                System.out.println("F: Find room from customer name.");
                System.out.println("S: Store program data in to file.");
                System.out.println("L: Load program data from file.");
                System.out.println("Q: View guests Ordered alphabetically by name.");
                System.out.println("------------------------");


                System.out.println();
                Scanner scn = new Scanner(System.in);
                System.out.println("Enter the suggestion from menu : ");
                String menu = scn.nextLine();
                menu = menu.toUpperCase();  // changing letters to uppercase

                switch (menu) {
                    case "A":
                        add(hotel,firstName,surName,creditNum,guestNum);  // adding customer rooms

                        break;
                    case "V":
                        view(hotel,firstName,surName,creditNum,guestNum);

                        break;
                    case "E":
                        emptyroom(hotel);

                        break;
                    case "D":
                        delete_customer(hotel,firstName,surName,creditNum,guestNum);

                        break;
                    case "F":
                        find_customer(hotel);

                        break;
                    case "S":
                        storedata(hotel,firstName,surName,creditNum,guestNum);

                        break;
                    case "L":
                        loaddata();

                        break;
                    case "Q":
                        guests_alpha(hotel);

                        break;
                    default:
                        System.out.println("Invalid Suggestion");

                }
            }
        }

        private static void   initialise(String[] surName, String[] hotel, String[] firstName, int[] creditNum, int[] guestNum){   //  getting the empty array

            for (int i = 0; i < 8; i++ ){
                hotel[i] = "empty";
                firstName[i]="empty";
                surName[i]="empty";
                creditNum[i]=0;
                guestNum[i]=0;

            }

        }

        private static void add(String[] hotel, String[] firstName, String[] surName, int[] creditNum, int[] guestNum) {    // adding customer rooms
            Scanner scn = new Scanner(System.in);
            System.out.println("Enter room number (0-7) or 8 to stop:");
            roomNum = scn.nextInt();

            System.out.println("Enter name for room " + roomNum + " :");
            String roomName = scn.next();
            hotel[roomNum]=roomName;

            System.out.println("Enter the first name: ");
            String fName = scn.next();
            firstName[roomNum]=fName;

            System.out.println("Enter the surname: ");
            String sName = scn.next();
            surName[roomNum]=sName;

            System.out.println("Enter the credit card number: ");
            int cNum=scn.nextInt();
            creditNum[roomNum]=cNum;

            System.out.println("Enter the number of guest: ");
            int gNum=scn.nextInt();
            guestNum[roomNum]=gNum;


        }

        private static void view(String[] hotel, String[] firstName, String[] surName, int[] creditNum, int[] guestNum) {      //  viewing the data
            for (int i = 0; i < 8; i++) {
                System.out.println("room " + i + " occupied by " + hotel[i]);
                System.out.println(firstName[i]);
                System.out.println(surName[i]);
                System.out.println(creditNum[i]);
                System.out.println(guestNum[i]);
            }
        }

        private static void emptyroom(String[] hotel) {    //getting the empty array
            for (int i = 0; i < 8; i++ )
            {
                if (hotel[i] == "empty") {
                    System.out.println("room " + i + " is empty");
                }
            }

        }

        private static void delete_customer(String[] hotel, String[] firstName, String[] surName, int[] creditNum, int[] guestNum) {    // deleting the data from the array
            Scanner scn = new Scanner(System.in);
            System.out.println("Enter room number to delete(1-8):");
            roomNum = scn.nextInt() ;
            hotel[roomNum]= "empty";
            firstName[roomNum]="empty";
            surName[roomNum]="empty";
            creditNum[roomNum]=0;
            guestNum[roomNum]=0;

            System.out.println("Room Deleted");
        }

        private static void find_customer(String[] hotel) {   // finding the matching customer name
            Scanner scn= new Scanner(System.in);
            System.out.println("Enter the name: ");
            roomName= scn.nextLine();
            boolean finding= false;
            for (int i=0; i<8;i++) {
                if (roomName.equals(hotel[i])) {
                    System.out.println("Name matched with the customer");
                    finding = true;
                }
            }
            if(finding==false) {
                System.out.println("there's no room book with that name");
            }
        }

        private static void storedata(String[] hotel, String[] firstName, String[] surName, int[] creditNum, int[] guestNum) {    //storing data
            try (PrintWriter get = new PrintWriter(new FileWriter("E:\\CW\\sd2\\task_3(array)\\store.txt"))) {   //path for store data

                for (int i = 0; i < 8; i++) {
                    get.println("Name and Room number is: " + hotel[i] + " at: " + i);
                    get.println("First name is: " + firstName[i]);
                    get.println(" Surname is: " + surName[i] );
                    get.println(" Credit card number is: " + creditNum[i]);
                    get.println("Number of guests is: " +  guestNum[i]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("All data updated.");

        }

        private static void loaddata() {    //loading data
            try {
                File myObj = new File("E:\\CW\\sd2\\task_3(array)\\store.txt");  //path for load data
                Scanner scn = new Scanner(myObj);
                while (scn.hasNextLine()) {
                    String load = scn.nextLine();
                    System.out.println(load);
                }
                scn.close();
            }
            catch (FileNotFoundException e) {
                System.out.println(" Error .");
                e.printStackTrace();
            }
        }

        private static void guests_alpha(String[] hotel) {   //finding the alphabetical oder of names
            String[] guest = new String[hotel.length];
            for (int a=0;a< hotel.length;a++){
                guest[a]=hotel[a];
            }
            for (int i = 0; i <8; i++) {

                for (int j = i + 1; j <8; j++) {    // using two for loops for checking

                    if (guest[i].compareTo(guest[j]) > 0) {

                        String get = guest[i];
                        guest[i] = guest[j];
                        guest[j] = get;
                    }
                }
            }


            System.out.println("guests names in alphabetical order: ");
            for (int i = 0; i <8; i++) {
                System.out.println(hotel[i]);
            }
        }

}



