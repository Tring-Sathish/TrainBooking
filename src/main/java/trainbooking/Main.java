package trainbooking;

import java.util.*;
import admin.*;
import user.*;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Admin admin = new Admin();
        User user = new User();
        int choice;
        System.out.print("\n\n\tTrain Booking\n");
        System.out.print("\n1. ADMIN \n2. USER \n3. EXIT \n\nEnter Your Choice : ");
        choice = input.nextInt();
        input.close();
        while (true) {
            switch (choice) {
                case 1:
                    System.out.print("\n\tSIGN IN\n");
                    admin.signIn();
                    break;

                case 2:
                    user.user();
                    break;

                case 3:
                    System.exit(0);
                    break;

                default:
                    System.out.print("\nInvalid Choice\n");
                    break;
            }
        }
    }
}
