package UserLoginApplication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserService {

    User[] users = new User[4];
    boolean correctUsername = false;
    boolean correctPassword = false;

    public User createUser (String[] userDetails) {
        User user = new User();
        user.setUsername(userDetails[0]);
        user.setPassword(userDetails[1]);
        user.setName(userDetails[2]);

        return user;
    }

    public void readFile (String fileName) {


        int i = 0;

        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(fileName));

            String line;
            while ((line = fileReader.readLine()) != null ) {
                String[] userDetails = line.split(",");
                users[i] = createUser(userDetails);
                i++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("I/O error!");
        }
        finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("I/O error!");
            }
        }
    }

    public boolean validateInputs (String username, String password) {

        for (int i = 0; i < 4; i++) {
            correctUsername = username.equalsIgnoreCase(users[i].getUsername());
            correctPassword = password.equals(users[i].getPassword());
            if (correctUsername && correctPassword) {
                System.out.println("Welcome: " + users[i].getName());
                return true;
            }
        }
        return false;
    }
}
