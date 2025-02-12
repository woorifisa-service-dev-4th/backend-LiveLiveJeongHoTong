package system;

import java.util.Scanner;

public class DefaultUserInputHandler implements  UserInputHandler {

    private final Scanner scanner;
    private final String emailPrompt;
    private final String passwordPrompt;

    public DefaultUserInputHandler(Scanner scanner, String emailPrompt, String passwordPrompt) {
        this.scanner = scanner;
        this.emailPrompt = emailPrompt;
        this.passwordPrompt = passwordPrompt;
    }

    @Override
    public String getEmail() {
        System.out.println(emailPrompt);
        return scanner.nextLine();
    }

    @Override
    public String getPassword() {
        System.out.println(passwordPrompt);
        return scanner.nextLine();
    }
}
