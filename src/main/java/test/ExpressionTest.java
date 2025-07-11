package main.java.test;

import main.java.io.AdiK5050.advCalculator.app.Application;
import main.java.io.AdiK5050.advCalculator.app.ApplicationImpl;
import main.java.io.AdiK5050.advCalculator.inputhandling.interfaces.ExpressionChoiceInput;
import main.java.test.mock.ExpressionChoiceFromValue;
import main.java.test.mock.ExpressionHandlerFromArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExpressionTest {

    @Test
    public void AdditionTestOne() {
        ExpressionChoiceInput expressionChoiceInput = new ExpressionChoiceFromValue(1);

        double[] arr = {5,5,5};
        ExpressionHandlerFromArray expressionHandlerFromScanner = new ExpressionHandlerFromArray(arr);
        Application application = new ApplicationImpl(expressionChoiceInput, expressionHandlerFromScanner);
        Assertions.assertEquals(15, application.run());
    }

    @Test
    public void SubtractionTestOne() {
        ExpressionChoiceInput expressionChoiceInput = new ExpressionChoiceFromValue(2);

        double[] arr = {10,2};
        ExpressionHandlerFromArray expressionHandlerFromScanner = new ExpressionHandlerFromArray(arr);
        Application application = new ApplicationImpl(expressionChoiceInput, expressionHandlerFromScanner);
        Assertions.assertEquals(8, application.run());
    }

    @Test
    public void DivideTestOne() {
        ExpressionChoiceInput expressionChoiceInput = new ExpressionChoiceFromValue(3);

        double[] arr = {10,2};
        ExpressionHandlerFromArray expressionHandlerFromScanner = new ExpressionHandlerFromArray(arr);
        Application application = new ApplicationImpl(expressionChoiceInput, expressionHandlerFromScanner);
        Assertions.assertEquals(5, application.run());
    }

    @Test
    public void MultiplyTestOne() {
        ExpressionChoiceInput expressionChoiceInput = new ExpressionChoiceFromValue(4);

        double[] arr = {10,2};
        ExpressionHandlerFromArray expressionHandlerFromScanner = new ExpressionHandlerFromArray(arr);
        Application application = new ApplicationImpl(expressionChoiceInput, expressionHandlerFromScanner);
        Assertions.assertEquals(20, application.run());
    }
}
