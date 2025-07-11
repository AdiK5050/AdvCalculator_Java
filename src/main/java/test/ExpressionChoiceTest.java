package main.java.test;

import main.java.io.AdiK5050.advCalculator.inputhandling.ExpressionChoiceInputFromScanner;
import main.java.io.AdiK5050.advCalculator.inputhandling.interfaces.ExpressionChoiceInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class ExpressionChoiceTest {

    @Test
    public void expressionChoiceTest(){
        Scanner sc = new Scanner("0");

        ExpressionChoiceInput expressionChoiceInputFromScanner = new ExpressionChoiceInputFromScanner();
        int choice = expressionChoiceInputFromScanner.getUserInput(sc);

        Assertions.assertEquals(0, choice);
    }
}
