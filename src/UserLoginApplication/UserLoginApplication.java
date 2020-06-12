package UserLoginApplication;

import java.util.Scanner;


public class UserLoginApplication {

    public static void main (String[] args) {


        UserService userService = new UserService();
        userService.readFile("data.txt");

        Scanner scanner = new Scanner(System.in);
        boolean successfulLogin = false;
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter your email:");
            String inputUsername = scanner.nextLine();
            System.out.println("Enter your password:");
            String inputPassword = scanner.nextLine();

            if (userService.validateInputs(inputUsername, inputPassword)) {
                successfulLogin = true;
                break;
            } else {
                System.out.println("Invalid login, please try again");
            }
        }

        if (!successfulLogin) {
            System.out.println("Too many failed login attempts, you are now locked out.");
        }


    }
}
