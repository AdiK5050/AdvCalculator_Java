package main.java.test.mock;

import main.java.io.AdiK5050.advCalculator.inputhandling.interfaces.ExpressionChoiceInput;

public class ExpressionChoiceFromValue implements ExpressionChoiceInput {
    private int[] output;
    private int itr = 0;

    public ExpressionChoiceFromValue(int[] output) {
        this.output = output;
    }

    public ExpressionChoiceFromValue(int output) {
        this.output = new int[]{output};
    }

    @Override
    public int getUserInput() {
        if (itr >= output.length) {
            return 0;
        }

        return output[itr++];
    }
}
