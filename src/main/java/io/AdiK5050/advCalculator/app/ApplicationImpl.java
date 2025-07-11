package main.java.io.AdiK5050.advCalculator.app;

import main.java.io.AdiK5050.advCalculator.inputhandling.MultiplicationInput;
import main.java.io.AdiK5050.advCalculator.inputhandling.interfaces.ExpressionChoiceInput;
import main.java.io.AdiK5050.advCalculator.operators.*;
import main.java.io.AdiK5050.advCalculator.utilities.ApplicationException;

import java.util.Scanner;

public class ApplicationImpl implements Application {
    private final ExpressionChoiceInput expressionChoiceInput;

    public ApplicationImpl(ExpressionChoiceInput expressionChoiceInput,  ExpressionHandler expressionHandler) {
        this.expressionChoiceInput = expressionChoiceInput;
    }

    @Override
    public void run() {
        try (Scanner sc = new Scanner(System.in)) {
            MultiplicationInput objIn = new MultiplicationInput(sc);
            int choice;

            do {
                choice = expressionChoiceInput.getUserInput(sc);
                try {
                    switch (choice) {
                        case 1:
                            Addition objAdd = new Addition();
                            preformExpressionGetResult(objIn, objAdd);
                            break;

                        case 2:
                            Subtraction objSub = new Subtraction();
                            preformExpressionGetResult(objIn, objSub);
                            break;

                        case 3:
                            Division objDiv = new Division();
                            preformExpressionGetResult(objIn, objDiv);
                            break;

                        case 4:
                            Multiplication objMul = new Multiplication();
                            preformExpressionGetResult(objIn, objMul);
                            break;

                        case 5:
                            ExpressionInputEvaluation objPostfixEvaluation = new ExpressionInputEvaluation(sc);
                            objPostfixEvaluation.inputExpression();
                            objPostfixEvaluation.toPostfix();
                            System.out.println("\nResult: " + objPostfixEvaluation.evaluateExpression());
                            break;

                        case 0:
                            break;

                        default:
                            throw new IllegalStateException("Unexpected value: " + choice);
                    }
                } catch (ApplicationException e) {
                    e.printStackTrace();
                }
            } while (choice != 0);
        }
    }

    private void preformExpressionGetResult(MultiplicationInput objIn, Expression expression) throws ApplicationException {
        objIn.addElements();
        objIn.getToArr();
        System.out.println(expression.preform(objIn.arr));
    }
}
