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
    public double run() {
        try (Scanner sc = new Scanner(System.in)) {
            MultiplicationInput objIn = new MultiplicationInput(sc);
            int choice;

            do {
                choice = expressionChoiceInput.getUserInput();
                try {
                    switch (choice) {
                        case 1:
                            Addition objAdd = new Addition();
                            return preformExpressionGetResult(expressionHandler, objAdd);

                        case 2:
                            Subtraction objSub = new Subtraction();
                            return preformExpressionGetResult(expressionHandler, objSub);

                        case 3:
                            Division objDiv = new Division();
                            return preformExpressionGetResult(expressionHandler, objDiv);

                        case 4:
                            Multiplication objMul = new Multiplication();
                            return preformExpressionGetResult(expressionHandler, objMul);

                        case 5:
                            ExpressionInputEvaluation objPostfixEvaluation = new ExpressionInputEvaluation(sc);
                            objPostfixEvaluation.inputExpression();
                            objPostfixEvaluation.toPostfix();
                            return objPostfixEvaluation.evaluateExpression();

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

    private double preformExpressionGetResult(ExpressionHandler objIn, Expression expression) throws ApplicationException {
        objIn.addElements();
        objIn.getToArr();
        return expression.preform(objIn.getArr());
    }
}
