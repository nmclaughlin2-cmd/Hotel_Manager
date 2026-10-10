import java.util.Scanner;

public class Main {

    public static void displayCatalog(int[][] hotel, Scanner scnr) {

        System.out.println("What would you like to do?");
        System.out.println("1. See available rooms");
        System.out.println("2. Make a reservation");
        System.out.println("3. Cancel a reservation");
        System.out.println("4. Check a specific room's availability");
        System.out.println("5. Check total available rooms");
        System.out.println("6. Quit");

        int userInput = scnr.nextInt();
        int emptyCount = 0;

        if (userInput == 1) {
            System.out.println("Available rooms: ");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 6; j++) {
                    if (hotel[i][j] == 0) {
                        System.out.println((i + 1) + "0" + (j + 1));
                    }
                }
            }
            displayCatalog(hotel, scnr);
        } else if (userInput == 2) {
            System.out.println("Which floor? (1-3)");
            int f = (scnr.nextInt() - 1);
            System.out.println("Which room? (1-6)");
            int r = (scnr.nextInt() - 1);
            if (hotel[f][r] == 0) {
                hotel[f][r] = 1;
                System.out.println("Room reserved!");
            } else {
                System.out.println("That room is currently unavailable.");
            }
            displayCatalog(hotel, scnr);
        } else if (userInput == 3) {
            System.out.println("Which floor? (1-3)");
            int f = scnr.nextInt() - 1;
            System.out.println("Which room? (1-6)");
            int r = scnr.nextInt() - 1;
            if (hotel[f][r] == 1) {
                hotel[f][r] = 0;
                System.out.println("Reservation canceled.");
            } else {
                System.out.println("That room is not currently reserved.");
            }
            displayCatalog(hotel, scnr);
        } else if (userInput == 4) {
            System.out.println("Which floor? (1-3)");
            int f = scnr.nextInt() - 1;
            System.out.println("Which room? (1-6)");
            int r = scnr.nextInt() - 1;
            if (hotel[f][r] == 0) {
                System.out.println("Available.");
            } else {
                System.out.println("Unavailable.");
            }
            displayCatalog(hotel, scnr);
        } else if (userInput == 5) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 6; j++) {
                    if (hotel[i][j] == 1) {
                        emptyCount += 1;
                    }
                }
            }
            System.out.println("There are currently " + emptyCount + " available rooms.");
            displayCatalog(hotel, scnr);
        } else {
            System.exit(0);
        }

    }
    public static void main(String args[]) {
        // This hotel has 3 floors and 6 rooms per floor.
        // For ease of set-up, specific floors will be booked by default.
        // You are the administrator. It is not strange for you to cancel other people's rooms.
        Scanner scnr = new Scanner(System.in);
        int[][] hotelArray = {
                {1, 1, 0, 1, 1, 1},
                {0, 0, 0, 0, 1, 1},
                {1, 0, 1, 0, 1, 0}
        };
        displayCatalog(hotelArray, scnr);







    }
}
