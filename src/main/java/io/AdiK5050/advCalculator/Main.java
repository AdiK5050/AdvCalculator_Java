package main.java.io.AdiK5050.advCalculator;

import main.java.io.AdiK5050.advCalculator.app.Application;
import main.java.io.AdiK5050.advCalculator.app.ApplicationImpl;
import main.java.io.AdiK5050.advCalculator.inputhandling.ExpressionChoiceInputFromScanner;
import main.java.io.AdiK5050.advCalculator.inputhandling.ExpressionHandlerFromScanner;
import main.java.io.AdiK5050.advCalculator.inputhandling.ExpressionInput;
import main.java.io.AdiK5050.advCalculator.inputhandling.interfaces.ExpressionChoiceInput;
import main.java.io.AdiK5050.advCalculator.inputhandling.interfaces.ExpressionHandler;
import main.java.test.mock.ExpressionHandlerFromArray;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * This class contains the <code>main</code> method for user's choice.
 * <code>main</code> method deals with the user's choice utility to help interact with the calculator with ease.
 *
 * @author Aditya Gupta
 * @version 1.0
 * @since 2025
 */
public class Main {
    /**
     * Users are supposed to input as directed. Integers from 0 to 5 to select calculation method or exit the program.
     *
     * @param args not supported
     * @throws InputMismatchException exception.
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ExpressionChoiceInput expressionChoiceInput = new ExpressionChoiceInputFromScanner(sc);
            ExpressionHandlerFromScanner expressionHandlerFromScanner = new ExpressionHandlerFromScanner(sc);
            Application application = new ApplicationImpl(expressionChoiceInput, expressionHandlerFromScanner);
            System.out.println(application.run());
        }
    }
}