import java.io.*;
import java.util.Scanner;

public class Hotel {
    static int roomNum;     // declare variables for methods.
    static String roomName;
    public static void main(String[] args) {
        Room[] hotel = new Room[8];  // creating the array
        hotel[0] = new Room();     //adding elements to array
        hotel[1] = new Room();
        hotel[2] = new Room();
        hotel[3] = new Room();
        hotel[4] = new Room();
        hotel[5] = new Room();
        hotel[6] = new Room();
        hotel[7] = new Room();
        initialise(hotel);

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

            switch (menu) {     // using switch for menu
                case "A":
                    add(hotel);  // adding customer rooms

                    break;
                case "V":
                    view(hotel);

                    break;
                case "E":
                    emptyroom(hotel);

                    break;
                case "D":
                    delete_customer(hotel);

                    break;
                case "F":
                    find_customer(hotel);

                    break;
                case "S":
                    storedata(hotel);

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

    private static void   initialise(Room[] hotelRef){   //  getting the empty array

        for (int i = 0; i < 8; i++ ){
            hotelRef[i].setName("empty");
            hotelRef[i].setFirst_name("empty");
            hotelRef[i].setSurName("empty");
            hotelRef[i].setCredit_num(0);
            hotelRef[i].setNum_of_guests(0);

        }
    }

    private static void add(Room[] hotelref) {   // adding customer rooms
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter room number (0-7) or 8 to stop:");
        roomNum = scn.nextInt();

        System.out.println("Enter name for room " + roomNum + " :");
        String roomName = scn.next();
        hotelref[roomNum].setName(roomName);

        System.out.println("Enter the first name: ");
        String fName = scn.next();
        hotelref[roomNum].setFirst_name(fName);

        System.out.println("Enter the surname: ");
        String sName = scn.next();
        hotelref[roomNum].setSurName(sName);

        System.out.println("Enter the credit card number: ");
        int cNum=scn.nextInt();
        hotelref[roomNum].setCredit_num(cNum);

        System.out.println("Enter the number of guest: ");
        int gNum=scn.nextInt();
        hotelref[roomNum].setNum_of_guests(gNum);


    }

    private static void view(Room[] hotelref) {        //  viewing the data
        for (int i = 0; i < 8; i++) {
            System.out.println("room " + i + " occupied by " + hotelref[i].getName());
            System.out.println(hotelref[i].getFirst_name());
            System.out.println(hotelref[i].getSurName());
            System.out.println(hotelref[i].getCredit_num());
            System.out.println(hotelref[i].getNum_of_guests());
        }
    }

    private static void emptyroom(Room[] hotelref) {   //getting the empty array
        for (int i = 0; i < 8; i++ )
        {
            if (hotelref[i].getName().equals("empty")){
                System.out.println("room " + i + " is empty");}
        }

    }

    private static void delete_customer(Room[] hotelref) {  // deleting the data from the array
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter room number to delete(1-8):");
        roomNum = scn.nextInt() ;
        hotelref[roomNum].setName("empty");
        hotelref[roomNum].setFirst_name("empty");
        hotelref[roomNum].setSurName("empty");
        hotelref[roomNum].setCredit_num(0);
        hotelref[roomNum].setNum_of_guests(0);
        System.out.println("Room Deleted");
    }

    private static void find_customer(Room[] hotelref) {    // finding the matching customer name
        Scanner scn= new Scanner(System.in);
        System.out.println("Enter the name: ");
        roomName= scn.nextLine();
        boolean finding= false;
        for (int i=0; i<8;i++) {
            if (roomName.equals(hotelref[i].getName())) {
                System.out.println("Name matched with the customer");
                finding = true;
            }
        }
        if(finding==false) {
            System.out.println("there's no room book with that name");
        }
    }

    private static void storedata(Room[] hotelref) {      //storing data
        try (PrintWriter get = new PrintWriter(new FileWriter("E:\\CW\\sd2\\task_3\\store.txt"))) {  //path for store

            for (int i = 0; i < 8; i++) {
                get.println("Name and Room number is: " + hotelref[i].getName() + " at: " + i);
                get.println("First name is: " + hotelref[i].getFirst_name());
                get.println("Surname is: " + hotelref[i].getSurName());
                get.println("Credit card number is: " + hotelref[i].getCredit_num());
                get.println("Number of guests is: " + hotelref[i].getNum_of_guests());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("All data updated. ");

    }

    private static void loaddata() {  //loading data
        try {
            File myObj = new File("E:\\CW\\sd2\\task_3\\store.txt");   //path for load data
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

    private static void guests_alpha(Room[] hotelRef) {  //finding the alphabetical oder of names
        Room[] guest = new Room[8];
        for (int a=0;a< hotelRef.length;a++){
            guest[a]=hotelRef[a];
        }
        for (int i = 0; i <8; i++) {     // using two for loops for checking

            for (int j = i + 1; j <8; j++) {

                if (guest[i].getName().compareTo(guest[j].getName()) > 0) {

                    String get = guest[i].getName();
                    guest[i].setName(guest[j].getName());
                    guest[j].setName(get);
                }
            }
        }


        System.out.println("guests names in alphabetical order: ");
        for (int i = 0; i <8; i++) {
            System.out.println(hotelRef[i].getName());
        }
    }
}
