package main.java.test;

import main.java.io.AdiK5050.advCalculator.inputhandling.ExpressionChoiceInputFromScanner;
import main.java.io.AdiK5050.advCalculator.inputhandling.interfaces.ExpressionChoiceInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class ExpressionChoiceTest {

    @Test
    public void expressionChoiceOneTest(){
        Scanner sc = new Scanner("0\n");

        ExpressionChoiceInput expressionChoiceInputFromScanner = new ExpressionChoiceInputFromScanner(sc);
        int choice = expressionChoiceInputFromScanner.getUserInput();

        Assertions.assertEquals(0, choice);
    }

    @Test
    public void expressionChoiceTwoTest(){
        Scanner sc = new Scanner("3\n");

        ExpressionChoiceInput expressionChoiceInputFromScanner = new ExpressionChoiceInputFromScanner(sc);
        int choice = expressionChoiceInputFromScanner.getUserInput();

        Assertions.assertEquals(3, choice);
    }
}
