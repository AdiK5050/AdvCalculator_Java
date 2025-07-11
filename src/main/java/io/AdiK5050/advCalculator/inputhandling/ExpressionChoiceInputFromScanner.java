package main.java.io.AdiK5050.advCalculator.inputhandling;
import main.java.io.AdiK5050.advCalculator.inputhandling.interfaces.ExpressionChoiceInput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExpressionChoiceInputFromScanner implements ExpressionChoiceInput {
    private Scanner sc;
    private static final String MESSAGE_TO_USER = "\n" +
            "Press 1 to Add multiple numbers\n" +
            "Press 2 to Subtract multiple numbers\n" +
            "Press 3 to Divide multiple numbers\n" +
            "Press 4 to Multiply multiple numbers\n" +
            "Press 5 to solve an expression";

    public ExpressionChoiceInputFromScanner(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public int getUserInput(Scanner sc) {
        int choice = 0;
        System.out.println(MESSAGE_TO_USER);

        try {
            choice = sc.nextInt();
            if (choice < 0 || choice > 5) {
                getUserInput(sc);
            }
            //sc.nextLine(); No idea why this is here???
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input!! Enter a valid Integer From 0 to 5...");
            getUserInput(sc);
        }

        return choice;
    }
}
